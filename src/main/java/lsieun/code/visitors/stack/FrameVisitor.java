package lsieun.code.visitors.stack;

import lsieun.classfile.ClassFile;
import lsieun.classfile.ConstantPool;
import lsieun.classfile.MethodInfo;
import lsieun.classfile.attrs.*;
import lsieun.classfile.cp.*;
import lsieun.code.Instruction;
import lsieun.code.facet.BranchInstruction;
import lsieun.code.facet.SelectInstruction;
import lsieun.code.opcode.*;
import lsieun.code.type.ArrayType;
import lsieun.code.type.ObjectType;
import lsieun.code.type.Type;
import lsieun.code.type.UninitializedObjectType;
import lsieun.code.utils.AdvancedTypeUtils;
import lsieun.code.utils.TypeUtils;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.cst.CPConst;
import lsieun.cst.JVMConst;
import lsieun.utils.AccessFlagUtils;
import lsieun.utils.AttributeUtils;
import lsieun.utils.MethodUtils;

import java.util.ArrayList;
import java.util.List;

//[local variable][operand stack]
public class FrameVisitor implements OpcodeVisitor {
    private final ConstantPool constant_pool;
    private final Type this_class_type;
    private final Type super_class_type;

    // method_info
    private final String current_method_name;
    private final String current_method_descriptor;
    private final ExceptionTable[] exception_table_array;
    private final LocalVariableTable local_variable_table;

    // Frame
    public final Frame frame;
    //    private final Map<Integer, State> state_map = new HashMap<>();
    private final List<State> pre_opcode_frame_list = new ArrayList<>();
    private final List<State> post_opcode_frame_list = new ArrayList<>();
    private final List<State> exception_table_frame_list = new ArrayList<>();


    public FrameVisitor(ClassFile classfile, String name_and_type) {
        // 第一部分信息，从classfile中获取信息
        this.constant_pool = classfile.constant_pool;
        int this_class_index = classfile.class_info.this_class;
        int super_class_index = classfile.class_info.super_class;
        this.this_class_type = AdvancedTypeUtils.getConstantClass(this_class_index, constant_pool);
        this.super_class_type = AdvancedTypeUtils.getConstantClass(super_class_index, constant_pool);
        MethodInfo method_info = MethodUtils.findMethod(classfile, name_and_type);

        //第二部分信息，从method_info中获取信息
        int access_flags = method_info.access_flags;
        int name_index = method_info.name_index;
        this.current_method_name = constant_pool.getConstantString(name_index, CPConst.CONSTANT_Utf8);
        int descriptor_index = method_info.descriptor_index;
        this.current_method_descriptor = constant_pool.getConstantString(descriptor_index, CPConst.CONSTANT_Utf8);
        Code code_attr = AttributeUtils.findCodeAttribute(method_info);

        //第三部分信息，从code_attr中获取信息
        int max_stack = code_attr.max_stack;
        int max_locals = code_attr.max_locals;
        int exception_table_length = code_attr.exception_table_length;
        ExceptionTable[] exception_table_array = code_attr.exception_table_array;
        this.exception_table_array = exception_table_array;
        this.local_variable_table = (LocalVariableTable) AttributeUtils.findAttribute(code_attr.attributes, "LocalVariableTable");

        //第四部分信息，为local_variable和operand_stack分配空间。
        this.frame = new Frame(max_locals, max_stack);
        init_locals(access_flags, current_method_descriptor);
        if (exception_table_length > 0) {
            init_exception_tables(exception_table_array);
        }
    }

    private void init_locals(int access_flags, String method_descriptor) {
        boolean is_static_method = AccessFlagUtils.isStatic(access_flags);
        int slot_index = 0;
        if (!is_static_method) {
            if (JVMConst.CONSTRUCTOR_NAME.equals(current_method_name)) {
                frame.locals.set(0, TypeUtils.UninitializedThis);
            } else {
                frame.locals.set(0, TypeUtils.THIS);
            }
            slot_index++;
        }

        Type[] argument_types = TypeUtils.getArgumentTypes(method_descriptor);
        for (Type t : argument_types) {
            frame.locals.set(slot_index, t);
            slot_index += t.getSize();
        }

        Frame f = frame.getClone();
        State s = new State(0, f);
        s.from_pos_list.add(current_method_descriptor);
        add_pre_state(0, s);
    }

    private void init_exception_tables(ExceptionTable[] exception_table_array) {
        for (ExceptionTable item : exception_table_array) {
            int start_pc = item.start_pc;
            int end_pc = item.end_pc;
            int handler_pc = item.handler_pc;
            int catch_type = item.catch_type;

            String range = String.format("@%d~@%d", start_pc, end_pc);
            Frame f = frame.getClone();
            f.stack.clear();
            Type exception_type = catch_type == 0 ? TypeUtils.THROWABLE : AdvancedTypeUtils.getConstantClass(catch_type, constant_pool);
            f.stack.push(exception_type);

            State state = new State(handler_pc, f);
            state.add_from_range(range);
            add_exception_state(state);
        }
    }

    private void add_pre_state(int from_pos, State s) {
        int pos = s.pos;
        if (has_pre_state(pos)) {
            State existing_state = get_pre_state(pos);
            existing_state.add_from_pos(from_pos);
        } else {
            add_state(pre_opcode_frame_list, s);
        }
    }

    private void add_post_state(State s) {
        add_state(post_opcode_frame_list, s);
    }

    private void add_exception_state(State s) {
        add_state(exception_table_frame_list, s);
    }

    private void add_state(List<State> list, State s) {
        // FIXME: 我原来以为，它的有效性与local variable的有效区间有关系，可能我想的不对
//        int max_locals = s.frame.locals.max_locals();
//        int pos = s.pos;
//        for (int i = 0; i < max_locals; i++) {
//            Type t = s.frame.locals.get(i);
//            if (t == TypeUtils.UNKNOWN || t == TypeUtils.TOP) {
//                continue;
//            }
//            if (!is_valid_slot_index(pos, i)) {
//                s.frame.locals.set(i, TypeUtils.UNKNOWN);
//            }
//        }
        list.add(s);
    }

    public boolean has_pre_state(int pos) {
        return has_state(pre_opcode_frame_list, pos);
    }

    private boolean has_state(List<State> list, int pos) {
        for (State item : list) {
            if (item.pos == pos) {
                return true;
            }
        }
        return false;
    }

    public State get_pre_state(int pos) {
        return get_state(pre_opcode_frame_list, pos);
    }

    public State get_post_state(int pos) {
        return get_state(post_opcode_frame_list, pos);
    }

    public State get_post_state_before_pos(int pos) {
        State target = pre_opcode_frame_list.get(0);
        for (State item : post_opcode_frame_list) {
            if (item.pos < pos) {
                target = item;
            } else {
                break;
            }
        }
        return target;
    }

    public State get_exception_state(int pos) {
        return get_state(exception_table_frame_list, pos);
    }

    private State get_state(List<State> list, int pos) {
        for (State item : list) {
            if (item.pos == pos) {
                return item;
            }
        }
        return null;
    }

    private void restore_pre_state(int pos) {
        State s = get_pre_state(pos);
        if (s != null) {
            restore_state(s);
        }
    }

    private void restore_state(State s) {
        // 设置locals
        int max_locals = frame.locals.max_locals();
        for (int i = 0; i < max_locals; i++) {
            Type t = s.frame.locals.get(i);
            frame.locals.set(i, t);
        }
        // 设置stack
        frame.stack.clear();
        for (Type item : s.frame.stack.stack) {
            frame.stack.push(item);
        }
    }

    private boolean is_exception_handler(int pos) {
        for (ExceptionTable item : exception_table_array) {
            if (item.handler_pc == pos) {
                return true;
            }
        }
        return false;
    }

    private ExceptionTable get_exception_table(int pos) {
        for (ExceptionTable item : exception_table_array) {
            if (item.handler_pc == pos) {
                return item;
            }
        }
        return null;
    }

    private boolean is_valid_slot_index(int pos, int slot_index) {
        if (local_variable_table == null) return true;
        LocalVariable[] entries = local_variable_table.entries;
        List<LocalVariable> list = new ArrayList<>();
        for (LocalVariable entry : entries) {
            if (slot_index == entry.index) {
                list.add(entry);
            }

        }
        if (list.size() < 1) {
            return true;
        }
        for (LocalVariable item : list) {
            if (pos >= item.start_pc && pos < (item.start_pc + item.length)) {
                return true;
            }
        }
        return false;
    }

    public void visitInstruction(Instruction ins) {
        int pos = ins.pos;
        if (has_pre_state(pos)) {
            restore_pre_state(pos);
        } else if (is_exception_handler(pos)) {
            ExceptionTable exception_table = get_exception_table(pos);
            int start_pc = exception_table.start_pc;
            State before_pos_state = get_post_state_before_pos(start_pc);
            State exception_state = get_exception_state(pos);

            int max_locals = exception_state.frame.locals.max_locals();
            for (int i = 0; i < max_locals; i++) {
                Type t = before_pos_state.frame.locals.get(i);
                exception_state.frame.locals.set(i, t);
            }

            add_pre_state(start_pc, exception_state);
            restore_state(exception_state);
        }

        // (2)处理当前的instruction
        ins.accept(this);
        {
            Frame f = frame.getClone();
            State s = new State(pos, f);
            add_post_state(s);
        }

        // （3）如果当前指令是跳转指令，那么需要存储当前指令处理后的状态，以便在第（1）处恢复
        if (ins instanceof BranchInstruction) {
            BranchInstruction branchIns = (BranchInstruction) ins;
            int default_branch = branchIns.getDefaultBranch();
            {
                int to_pos = ins.pos + default_branch;
                Frame f = frame.getClone();
                State s = new State(to_pos, f);
                s.add_from_pos(ins.pos);
                add_pre_state(ins.pos, s);
            }

            if (ins instanceof SelectInstruction) {
                SelectInstruction selectIns = (SelectInstruction) ins;
                int[] indices = selectIns.getOffsets();
                for (int delta : indices) {
                    int to_pos = ins.pos + delta;
                    Frame f = frame.getClone();
                    State s = new State(to_pos, f);
                    s.add_from_pos(ins.pos);
                    add_pre_state(ins.pos, s);
                }
            }
        }
    }


    @Override
    public void visitAALOAD(final AALOAD obj) {
        frame.stack.pop();
        Type type = frame.stack.pop();
        ArrayType at = (ArrayType) type;
        frame.stack.push(at.getElementType());
    }

    @Override
    public void visitAASTORE(final AASTORE obj) {
        frame.stack.pop(3);
    }

    @Override
    public void visitACONST_NULL(final ACONST_NULL obj) {
        frame.stack.push(TypeUtils.NULL);
    }

    @Override
    public void visitICONST_M1(ICONST_M1 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitICONST_0(ICONST_0 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitICONST_1(ICONST_1 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitICONST_2(ICONST_2 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitICONST_3(ICONST_3 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitICONST_4(ICONST_4 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitICONST_5(ICONST_5 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitLCONST_0(LCONST_0 obj) {
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLCONST_1(LCONST_1 obj) {
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitFCONST_0(FCONST_0 obj) {
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFCONST_1(FCONST_1 obj) {
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFCONST_2(FCONST_2 obj) {
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitDCONST_0(DCONST_0 obj) {
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDCONST_1(DCONST_1 obj) {
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitALOAD(final ALOAD obj) {
        int index = obj.index;
        Type type = frame.locals.get(index);
        frame.stack.push(type);
    }

    @Override
    public void visitILOAD_0(ILOAD_0 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitILOAD_1(ILOAD_1 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitILOAD_2(ILOAD_2 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitILOAD_3(ILOAD_3 obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitLLOAD_0(LLOAD_0 obj) {
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLLOAD_1(LLOAD_1 obj) {
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLLOAD_2(LLOAD_2 obj) {
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLLOAD_3(LLOAD_3 obj) {
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitFLOAD_0(FLOAD_0 obj) {
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFLOAD_1(FLOAD_1 obj) {
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFLOAD_2(FLOAD_2 obj) {
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFLOAD_3(FLOAD_3 obj) {
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitDLOAD_0(DLOAD_0 obj) {
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDLOAD_1(DLOAD_1 obj) {
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDLOAD_2(DLOAD_2 obj) {
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDLOAD_3(DLOAD_3 obj) {
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitALOAD_0(ALOAD_0 obj) {
        Type type = frame.locals.get(0);
        frame.stack.push(type);
    }

    @Override
    public void visitALOAD_1(ALOAD_1 obj) {
        Type type = frame.locals.get(1);
        frame.stack.push(type);
    }

    @Override
    public void visitALOAD_2(ALOAD_2 obj) {
        Type type = frame.locals.get(2);
        frame.stack.push(type);
    }

    @Override
    public void visitALOAD_3(ALOAD_3 obj) {
        Type type = frame.locals.get(3);
        frame.stack.push(type);
    }

    @Override
    public void visitANEWARRAY(final ANEWARRAY obj) {
        frame.stack.pop();
        Type type = AdvancedTypeUtils.getANEWARRAY(obj, constant_pool);
        ArrayType at = new ArrayType(type, 1);
        frame.stack.push(at);
    }

    @Override
    public void visitARETURN(final ARETURN obj) {
        frame.stack.clear();
    }

    @Override
    public void visitARRAYLENGTH(final ARRAYLENGTH obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitASTORE(final ASTORE obj) {
        int index = obj.index;
        Type type = frame.stack.pop();
        frame.locals.set(index, type);
    }

    @Override
    public void visitISTORE_0(ISTORE_0 obj) {
        frame.stack.pop();
        frame.locals.set(0, TypeUtils.INT);
    }

    @Override
    public void visitISTORE_1(ISTORE_1 obj) {
        frame.stack.pop();
        frame.locals.set(1, TypeUtils.INT);
    }

    @Override
    public void visitISTORE_2(ISTORE_2 obj) {
        frame.stack.pop();
        frame.locals.set(2, TypeUtils.INT);
    }

    @Override
    public void visitISTORE_3(ISTORE_3 obj) {
        frame.stack.pop();
        frame.locals.set(3, TypeUtils.INT);
    }

    @Override
    public void visitLSTORE_0(LSTORE_0 obj) {
        frame.stack.pop();
        frame.locals.set(0, TypeUtils.LONG);
    }

    @Override
    public void visitLSTORE_1(LSTORE_1 obj) {
        frame.stack.pop();
        frame.locals.set(1, TypeUtils.LONG);
    }

    @Override
    public void visitLSTORE_2(LSTORE_2 obj) {
        frame.stack.pop();
        frame.locals.set(2, TypeUtils.LONG);
    }

    @Override
    public void visitLSTORE_3(LSTORE_3 obj) {
        frame.stack.pop();
        frame.locals.set(3, TypeUtils.LONG);
    }

    @Override
    public void visitFSTORE_0(FSTORE_0 obj) {
        frame.stack.pop();
        frame.locals.set(0, TypeUtils.FLOAT);
    }

    @Override
    public void visitFSTORE_1(FSTORE_1 obj) {
        frame.stack.pop();
        frame.locals.set(1, TypeUtils.FLOAT);
    }

    @Override
    public void visitFSTORE_2(FSTORE_2 obj) {
        frame.stack.pop();
        frame.locals.set(2, TypeUtils.FLOAT);
    }

    @Override
    public void visitFSTORE_3(FSTORE_3 obj) {
        frame.stack.pop();
        frame.locals.set(3, TypeUtils.FLOAT);
    }

    @Override
    public void visitDSTORE_0(DSTORE_0 obj) {
        frame.stack.pop();
        frame.locals.set(0, TypeUtils.DOUBLE);
    }

    @Override
    public void visitDSTORE_1(DSTORE_1 obj) {
        frame.stack.pop();
        frame.locals.set(1, TypeUtils.DOUBLE);
    }

    @Override
    public void visitDSTORE_2(DSTORE_2 obj) {
        frame.stack.pop();
        frame.locals.set(2, TypeUtils.DOUBLE);
    }

    @Override
    public void visitDSTORE_3(DSTORE_3 obj) {
        frame.stack.pop();
        frame.locals.set(3, TypeUtils.DOUBLE);
    }

    @Override
    public void visitASTORE_0(ASTORE_0 obj) {
        Type type = frame.stack.pop();
        frame.locals.set(0, type);
    }

    @Override
    public void visitASTORE_1(ASTORE_1 obj) {
        Type type = frame.stack.pop();
        frame.locals.set(1, type);
    }

    @Override
    public void visitASTORE_2(ASTORE_2 obj) {
        Type type = frame.stack.pop();
        frame.locals.set(2, type);
    }

    @Override
    public void visitASTORE_3(ASTORE_3 obj) {
        Type type = frame.stack.pop();
        frame.locals.set(3, type);
    }

    @Override
    public void visitATHROW(final ATHROW obj) {
        Type type = frame.stack.pop();
        frame.stack.clear();
        frame.stack.push(type);
    }

    @Override
    public void visitBALOAD(final BALOAD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitBASTORE(final BASTORE obj) {
        frame.stack.pop(3);
    }

    @Override
    public void visitBIPUSH(final BIPUSH obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitCALOAD(final CALOAD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitCASTORE(final CASTORE obj) {
        frame.stack.pop(3);
    }

    @Override
    public void visitCHECKCAST(final CHECKCAST obj) {
        frame.stack.pop();
        Type type = AdvancedTypeUtils.getCHECKCAST(obj, constant_pool);
        frame.stack.push(type);
    }

    @Override
    public void visitD2F(final D2F obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitD2I(final D2I obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitD2L(final D2L obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitDADD(final DADD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDALOAD(final DALOAD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDASTORE(final DASTORE obj) {
        frame.stack.pop(3);
    }

    @Override
    public void visitDCMPG(final DCMPG obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitDCMPL(final DCMPL obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitDDIV(final DDIV obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDLOAD(final DLOAD obj) {
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDMUL(final DMUL obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDNEG(final DNEG obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDREM(final DREM obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDRETURN(final DRETURN obj) {
        frame.stack.clear();
    }

    @Override
    public void visitDSTORE(final DSTORE obj) {
        int index = obj.index;
        frame.stack.pop();
        frame.locals.set(index, TypeUtils.DOUBLE);
    }

    @Override
    public void visitDSUB(final DSUB obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitDUP(final DUP obj) {
        if (frame.stack.match(1)) {
            Type type = frame.stack.pop();
            frame.stack.push(type);
            frame.stack.push(type);
        } else {
            throw new RuntimeException("dup is illegal");
        }
    }

    @Override
    public void visitDUP_X1(final DUP_X1 obj) {
        if (frame.stack.match(1, 1)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            frame.stack.push(t1);
            frame.stack.push(t2);
            frame.stack.push(t1);
        } else {
            throw new RuntimeException("dup_x1 is illegal");
        }
    }

    @Override
    public void visitDUP_X2(final DUP_X2 obj) {
        if (frame.stack.match(1, 1, 1)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            Type t3 = frame.stack.pop();
            frame.stack.push(t1);
            frame.stack.push(t3);
            frame.stack.push(t2);
            frame.stack.push(t1);
        } else if (frame.stack.match(1, 2)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            frame.stack.push(t1);
            frame.stack.push(t2);
            frame.stack.push(t1);
        } else {
            throw new RuntimeException("dup_x2 is illegal");
        }
    }

    @Override
    public void visitDUP2(final DUP2 obj) {
        if (frame.stack.match(1, 1)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            frame.stack.push(t2);
            frame.stack.push(t1);
            frame.stack.push(t2);
            frame.stack.push(t1);
        } else if (frame.stack.match(2)) {
            Type t1 = frame.stack.pop();
            frame.stack.push(t1);
            frame.stack.push(t1);
        } else {
            throw new RuntimeException("dup2 is illegal");
        }
    }

    @Override
    public void visitDUP2_X1(final DUP2_X1 obj) {
        if (frame.stack.match(1, 1, 1)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            Type t3 = frame.stack.pop();
            frame.stack.push(t2);
            frame.stack.push(t1);
            frame.stack.push(t3);
            frame.stack.push(t2);
            frame.stack.push(t1);
        } else if (frame.stack.match(2, 1)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            frame.stack.push(t1);
            frame.stack.push(t2);
            frame.stack.push(t1);
        } else {
            throw new RuntimeException("dup2_x1 is illegal");
        }
    }

    @Override
    public void visitDUP2_X2(final DUP2_X2 obj) {
        if (frame.stack.match(1, 1, 1, 1)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            Type t3 = frame.stack.pop();
            Type t4 = frame.stack.pop();
            frame.stack.push(t2);
            frame.stack.push(t1);
            frame.stack.push(t4);
            frame.stack.push(t3);
            frame.stack.push(t2);
            frame.stack.push(t1);
        } else if (frame.stack.match(2, 1, 1)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            Type t3 = frame.stack.pop();
            frame.stack.push(t1);
            frame.stack.push(t3);
            frame.stack.push(t2);
            frame.stack.push(t1);
        } else if (frame.stack.match(1, 1, 2)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            Type t3 = frame.stack.pop();
            frame.stack.push(t2);
            frame.stack.push(t1);
            frame.stack.push(t3);
            frame.stack.push(t2);
            frame.stack.push(t1);
        } else if (frame.stack.match(2, 2)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            frame.stack.push(t1);
            frame.stack.push(t2);
            frame.stack.push(t1);
        } else {
            throw new RuntimeException("dup2_x2 is illegal");
        }
    }

    @Override
    public void visitF2D(final F2D obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitF2I(final F2I obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitF2L(final F2L obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitFADD(final FADD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFALOAD(final FALOAD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFASTORE(final FASTORE obj) {
        frame.stack.pop(3);
    }

    @Override
    public void visitFCMPG(final FCMPG obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitFCMPL(final FCMPL obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitFDIV(final FDIV obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFLOAD(final FLOAD obj) {
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFMUL(final FMUL obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFNEG(final FNEG obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFREM(final FREM obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitFRETURN(final FRETURN obj) {
        frame.stack.clear();
    }

    @Override
    public void visitFSTORE(final FSTORE obj) {
        frame.stack.pop();
        int index = obj.index;
        frame.locals.set(index, TypeUtils.FLOAT);
    }

    @Override
    public void visitFSUB(final FSUB obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitGETFIELD(final GETFIELD obj) {
        frame.stack.pop();
        Type type = AdvancedTypeUtils.getGETFIELD(obj, constant_pool);
        frame.stack.push(type);
    }

    @Override
    public void visitGETSTATIC(final GETSTATIC obj) {
        Type type = AdvancedTypeUtils.getGETSTATIC(obj, constant_pool);
        frame.stack.push(type);
    }

    @Override
    public void visitGOTO(final GOTO obj) {
        // no f_stack changes.
    }

    @Override
    public void visitGOTO_W(final GOTO_W obj) {
        // no f_stack changes.
    }

    @Override
    public void visitI2B(final I2B obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitI2C(final I2C obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitI2D(final I2D obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitI2F(final I2F obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitI2L(final I2L obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitI2S(final I2S obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitIADD(final IADD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitIALOAD(final IALOAD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitIAND(final IAND obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitIASTORE(final IASTORE obj) {
        frame.stack.pop(3);
    }

    @Override
    public void visitIDIV(final IDIV obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitIF_ACMPEQ(final IF_ACMPEQ obj) {
        frame.stack.pop(2);
    }

    @Override
    public void visitIF_ACMPNE(final IF_ACMPNE obj) {
        frame.stack.pop(2);
    }

    @Override
    public void visitIF_ICMPEQ(final IF_ICMPEQ obj) {
        frame.stack.pop(2);
    }

    @Override
    public void visitIF_ICMPGE(final IF_ICMPGE obj) {
        frame.stack.pop(2);
    }

    @Override
    public void visitIF_ICMPGT(final IF_ICMPGT obj) {
        frame.stack.pop(2);
    }

    @Override
    public void visitIF_ICMPLE(final IF_ICMPLE obj) {
        frame.stack.pop(2);
    }

    @Override
    public void visitIF_ICMPLT(final IF_ICMPLT obj) {
        frame.stack.pop(2);
    }

    @Override
    public void visitIF_ICMPNE(final IF_ICMPNE obj) {
        frame.stack.pop(2);
    }

    @Override
    public void visitIFEQ(final IFEQ obj) {
        frame.stack.pop();
    }

    @Override
    public void visitIFGE(final IFGE obj) {
        frame.stack.pop();
    }

    @Override
    public void visitIFGT(final IFGT obj) {
        frame.stack.pop();
    }

    @Override
    public void visitIFLE(final IFLE obj) {
        frame.stack.pop();
    }

    @Override
    public void visitIFLT(final IFLT obj) {
        frame.stack.pop();
    }

    @Override
    public void visitIFNE(final IFNE obj) {
        frame.stack.pop();
    }

    @Override
    public void visitIFNONNULL(final IFNONNULL obj) {
        frame.stack.pop();
    }

    @Override
    public void visitIFNULL(final IFNULL obj) {
        frame.stack.pop();
    }

    @Override
    public void visitIINC(final IINC obj) {
        // f_stack is not changed.
    }

    @Override
    public void visitILOAD(final ILOAD obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitIMUL(final IMUL obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitINEG(final INEG obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitINSTANCEOF(final INSTANCEOF obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitINVOKEDYNAMIC(final INVOKEDYNAMIC obj) {
        int n = AdvancedTypeUtils.getArgumentTypes(obj, constant_pool).length;
        frame.stack.pop(n);

        Type returnType = AdvancedTypeUtils.getReturnType(obj, constant_pool);
        if (returnType != TypeUtils.VOID) {
            frame.stack.push(returnType);
        }
    }

    @Override
    public void visitINVOKEINTERFACE(final INVOKEINTERFACE obj) {
        int n = AdvancedTypeUtils.getArgumentTypes(obj, constant_pool).length;
        frame.stack.pop(n);
        frame.stack.pop();

        Type returnType = AdvancedTypeUtils.getReturnType(obj, constant_pool);
        if (returnType != TypeUtils.VOID) {
            frame.stack.push(returnType);
        }
    }

    @Override
    public void visitINVOKESPECIAL(INVOKESPECIAL obj) {
        // TODO: 这里init的判断逻辑，我考虑的还并不成熟，
        //  至少有两种情况：（1）在自己的调用自己的构造函数或调用父类的构造函数；（2）创建别的对象
        int n = AdvancedTypeUtils.getArgumentTypes(obj, constant_pool).length;
        frame.stack.pop(n);
        frame.stack.pop();

        String target_method_name = AdvancedTypeUtils.getMethodName(obj, constant_pool);
        Type target_method_class = AdvancedTypeUtils.getMethodClass(obj, constant_pool);

        if (JVMConst.CONSTRUCTOR_NAME.equals(target_method_name)) {
            if (JVMConst.CONSTRUCTOR_NAME.equals(current_method_name) && (this_class_type.equals(target_method_class) || super_class_type.equals(target_method_class))) {
                frame.locals.set(0, TypeUtils.THIS);
            } else if (!frame.stack.isEmpty()) {
                Type type = frame.stack.peek();
                if (type instanceof UninitializedObjectType) {
                    UninitializedObjectType t = (UninitializedObjectType) type;
                    ObjectType objectType = t.getInitialized();
                    frame.stack.pop();
                    frame.stack.push(objectType);
                }
            }
        }


        Type returnType = AdvancedTypeUtils.getReturnType(obj, constant_pool);
        if (returnType != TypeUtils.VOID) {
            frame.stack.push(returnType);
        }
    }

    @Override
    public void visitINVOKESTATIC(INVOKESTATIC obj) {
        int n = AdvancedTypeUtils.getArgumentTypes(obj, constant_pool).length;
        frame.stack.pop(n);

        Type returnType = AdvancedTypeUtils.getReturnType(obj, constant_pool);
        if (returnType != TypeUtils.VOID) {
            frame.stack.push(returnType);
        }
    }

    @Override
    public void visitINVOKEVIRTUAL(INVOKEVIRTUAL obj) {
        int n = AdvancedTypeUtils.getArgumentTypes(obj, constant_pool).length;
        frame.stack.pop(n);
        frame.stack.pop();

        Type returnType = AdvancedTypeUtils.getReturnType(obj, constant_pool);
        if (returnType != TypeUtils.VOID) {
            frame.stack.push(returnType);
        }
    }

    @Override
    public void visitIOR(final IOR obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitIREM(final IREM obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitIRETURN(final IRETURN obj) {
        frame.stack.clear();
    }

    @Override
    public void visitISHL(final ISHL obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitISHR(final ISHR obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitISTORE(final ISTORE obj) {
        frame.stack.pop();
        int index = obj.index;
        frame.locals.set(index, TypeUtils.INT);
    }

    @Override
    public void visitISUB(final ISUB obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitIUSHR(final IUSHR obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitIXOR(final IXOR obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitJSR(final JSR obj) {
        throw new RuntimeException("Unsupported opcode: " + obj);
    }

    @Override
    public void visitJSR_W(final JSR_W obj) {
        throw new RuntimeException("Unsupported opcode: " + obj);
    }

    @Override
    public void visitL2D(final L2D obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.DOUBLE);
    }

    @Override
    public void visitL2F(final L2F obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.FLOAT);
    }

    @Override
    public void visitL2I(final L2I obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitLADD(final LADD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLALOAD(final LALOAD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLAND(final LAND obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLASTORE(final LASTORE obj) {
        frame.stack.pop(3);
    }

    @Override
    public void visitLCMP(final LCMP obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitLDC(final LDC obj) {
        final Constant c = constant_pool.getConstant(obj.getIndex());
        if (c instanceof ConstantInteger) {
            frame.stack.push(TypeUtils.INT);
        }
        if (c instanceof ConstantFloat) {
            frame.stack.push(TypeUtils.FLOAT);
        }
        if (c instanceof ConstantString) {
            frame.stack.push(TypeUtils.STRING);
        }
        if (c instanceof ConstantClass) {
            frame.stack.push(TypeUtils.CLASS);
        }
    }

    public void visitLDC_W(final LDC_W obj) {
        final Constant c = constant_pool.getConstant(obj.getIndex());
        if (c instanceof ConstantInteger) {
            frame.stack.push(TypeUtils.INT);
        }
        if (c instanceof ConstantFloat) {
            frame.stack.push(TypeUtils.FLOAT);
        }
        if (c instanceof ConstantString) {
            frame.stack.push(TypeUtils.STRING);
        }
        if (c instanceof ConstantClass) {
            frame.stack.push(TypeUtils.CLASS);
        }
    }

    @Override
    public void visitLDC2_W(final LDC2_W obj) {
        final Constant c = constant_pool.getConstant(obj.getIndex());
        if (c instanceof ConstantLong) {
            frame.stack.push(TypeUtils.LONG);
        }
        if (c instanceof ConstantDouble) {
            frame.stack.push(TypeUtils.DOUBLE);
        }
    }

    @Override
    public void visitLDIV(final LDIV obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLLOAD(final LLOAD obj) {
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLMUL(final LMUL obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLNEG(final LNEG obj) {
        frame.stack.pop();
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLOOKUPSWITCH(final LOOKUPSWITCH obj) {
        frame.stack.pop();
    }

    @Override
    public void visitLOR(final LOR obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLREM(final LREM obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLRETURN(final LRETURN obj) {
        frame.stack.clear();
    }

    @Override
    public void visitLSHL(final LSHL obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLSHR(final LSHR obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLSTORE(final LSTORE obj) {
        frame.stack.pop();
        int index = obj.index;
        frame.locals.set(index, TypeUtils.LONG);
    }

    @Override
    public void visitLSUB(final LSUB obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLUSHR(final LUSHR obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitLXOR(final LXOR obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.LONG);
    }

    @Override
    public void visitMONITORENTER(final MONITORENTER obj) {
        frame.stack.pop();
    }

    @Override
    public void visitMONITOREXIT(final MONITOREXIT obj) {
        frame.stack.pop();
    }

    @Override
    public void visitWIDE(WIDE obj) {
        // do nothing
    }

    @Override
    public void visitBREAKPOINT(BREAKPOINT obj) {
        throw new RuntimeException("Unsupported opcode: " + obj);
    }

    @Override
    public void visitIMPDEP1(IMPDEP1 obj) {
        throw new RuntimeException("Unsupported opcode: " + obj);
    }

    @Override
    public void visitIMPDEP2(IMPDEP2 obj) {
        throw new RuntimeException("Unsupported opcode: " + obj);
    }

    @Override
    public void visitMULTIANEWARRAY(final MULTIANEWARRAY obj) {
        for (int i = 0; i < obj.dimensions; i++) {
            frame.stack.pop();
        }
        Type type = AdvancedTypeUtils.getMULTIANEWARRAY(obj, constant_pool);
        frame.stack.push(type);
    }

    @Override
    public void visitNEW(final NEW obj) {
        Type type = AdvancedTypeUtils.getNEW(obj, constant_pool);
        frame.stack.push(new UninitializedObjectType((ObjectType) (type)));
    }

    @Override
    public void visitNEWARRAY(final NEWARRAY obj) {
        byte atype = obj.atype;
        Type type = new ArrayType(atype, 1);
        frame.stack.pop();
        frame.stack.push(type);
    }

    @Override
    public void visitNOP(final NOP obj) {
        // do nothing
    }

    @Override
    public void visitPOP(final POP obj) {
        if (frame.stack.match(1)) {
            frame.stack.pop();
        } else {
            throw new RuntimeException("pop is illegal");
        }
    }

    @Override
    public void visitPOP2(final POP2 obj) {
        if (frame.stack.match(1, 1)) {
            frame.stack.pop(2);
        } else if (frame.stack.match(2)) {
            frame.stack.pop();
        } else {
            throw new RuntimeException("pop is illegal");
        }
    }

    @Override
    public void visitPUTFIELD(final PUTFIELD obj) {
        frame.stack.pop(2);
    }

    @Override
    public void visitPUTSTATIC(final PUTSTATIC obj) {
        frame.stack.pop();
    }

    @Override
    public void visitRET(final RET obj) {
        // do nothing, return address
        // is in in the local variables.
        throw new RuntimeException("Unsupported opcode: " + obj);
    }

    @Override
    public void visitRETURN(final RETURN obj) {
        frame.stack.clear();
    }

    @Override
    public void visitSALOAD(final SALOAD obj) {
        frame.stack.pop(2);
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitSASTORE(final SASTORE obj) {
        frame.stack.pop(3);
    }

    @Override
    public void visitSIPUSH(final SIPUSH obj) {
        frame.stack.push(TypeUtils.INT);
    }

    @Override
    public void visitSWAP(final SWAP obj) {
        if (frame.stack.match(1, 1)) {
            Type t1 = frame.stack.pop();
            Type t2 = frame.stack.pop();
            frame.stack.push(t1);
            frame.stack.push(t2);
        }
    }

    @Override
    public void visitTABLESWITCH(final TABLESWITCH obj) {
        frame.stack.pop();
    }
}
