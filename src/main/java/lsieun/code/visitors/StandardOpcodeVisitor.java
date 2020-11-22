package lsieun.code.visitors;

import lsieun.classfile.ConstantPool;
import lsieun.code.Instruction;
import lsieun.code.opcode.*;
import lsieun.code.type.Type;
import lsieun.code.utils.TypeUtils;
import lsieun.cst.OpcodeConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.HexUtils;

public class StandardOpcodeVisitor implements OpcodeVisitor {
    private static final String NO_ARG_FORMAT = "%04d: %-20s // %s%n";
    private static final String ONE_ARG_FORMAT = "%04d: %-15s %-4s // %s%n";
    private static final String TWO_ARG_FORMAT = "%04d: %-10s %-4s %-4s // %s%n";
    private static final String NEW_ARRAY_FORMAT = "%04d: %-15s %-4s // %-10s || %s%n";
    private static final String CP_INS_FORMAT = "%04d: %-15s #%-3s // %-10s || %s%n";

    private final byte[] code_bytes;
    private final ConstantPool constant_pool;

    public StandardOpcodeVisitor(ConstantPool constant_pool, byte[] code_bytes) {
        this.constant_pool = constant_pool;
        this.code_bytes = code_bytes;
    }

    @Override
    public void visitNOP(final NOP obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitAALOAD(final AALOAD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitAASTORE(final AASTORE obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitACONST_NULL(final ACONST_NULL obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitICONST_M1(ICONST_M1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitICONST_0(ICONST_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitICONST_1(ICONST_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitICONST_2(ICONST_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitICONST_3(ICONST_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitICONST_4(ICONST_4 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitICONST_5(ICONST_5 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLCONST_0(LCONST_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLCONST_1(LCONST_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFCONST_0(FCONST_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFCONST_1(FCONST_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFCONST_2(FCONST_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDCONST_0(DCONST_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDCONST_1(DCONST_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitALOAD(final ALOAD obj) {
        visitONEARGIns(obj, String.valueOf(obj.index));
    }

    @Override
    public void visitILOAD_0(ILOAD_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitILOAD_1(ILOAD_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitILOAD_2(ILOAD_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitILOAD_3(ILOAD_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLLOAD_0(LLOAD_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLLOAD_1(LLOAD_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLLOAD_2(LLOAD_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLLOAD_3(LLOAD_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFLOAD_0(FLOAD_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFLOAD_1(FLOAD_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFLOAD_2(FLOAD_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFLOAD_3(FLOAD_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDLOAD_0(DLOAD_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDLOAD_1(DLOAD_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDLOAD_2(DLOAD_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDLOAD_3(DLOAD_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitALOAD_0(ALOAD_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitALOAD_1(ALOAD_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitALOAD_2(ALOAD_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitALOAD_3(ALOAD_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitANEWARRAY(final ANEWARRAY obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitARETURN(final ARETURN obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitARRAYLENGTH(final ARRAYLENGTH obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitASTORE(final ASTORE obj) {
        visitONEARGIns(obj, String.valueOf(obj.index));
    }

    @Override
    public void visitISTORE_0(ISTORE_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitISTORE_1(ISTORE_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitISTORE_2(ISTORE_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitISTORE_3(ISTORE_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLSTORE_0(LSTORE_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLSTORE_1(LSTORE_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLSTORE_2(LSTORE_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLSTORE_3(LSTORE_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFSTORE_0(FSTORE_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFSTORE_1(FSTORE_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFSTORE_2(FSTORE_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFSTORE_3(FSTORE_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDSTORE_0(DSTORE_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDSTORE_1(DSTORE_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDSTORE_2(DSTORE_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDSTORE_3(DSTORE_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitASTORE_0(ASTORE_0 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitASTORE_1(ASTORE_1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitASTORE_2(ASTORE_2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitASTORE_3(ASTORE_3 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitATHROW(final ATHROW obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitBALOAD(final BALOAD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitBASTORE(final BASTORE obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitBIPUSH(final BIPUSH obj) {
        Number value = obj.getValue();
        visitONEARGIns(obj, String.valueOf(value));
    }

    @Override
    public void visitCALOAD(final CALOAD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitCASTORE(final CASTORE obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitCHECKCAST(final CHECKCAST obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitD2F(final D2F obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitD2I(final D2I obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitD2L(final D2L obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDADD(final DADD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDALOAD(final DALOAD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDASTORE(final DASTORE obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDCMPG(final DCMPG obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDCMPL(final DCMPL obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDDIV(final DDIV obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDLOAD(final DLOAD obj) {
        visitONEARGIns(obj, String.valueOf(obj.index));
    }

    @Override
    public void visitDMUL(final DMUL obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDNEG(final DNEG obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDREM(final DREM obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDRETURN(final DRETURN obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDSTORE(final DSTORE obj) {
        visitONEARGIns(obj, String.valueOf(obj.index));
    }

    @Override
    public void visitDSUB(final DSUB obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDUP(final DUP obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDUP_X1(final DUP_X1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDUP_X2(final DUP_X2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDUP2(final DUP2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDUP2_X1(final DUP2_X1 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitDUP2_X2(final DUP2_X2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitF2D(final F2D obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitF2I(final F2I obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitF2L(final F2L obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFADD(final FADD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFALOAD(final FALOAD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFASTORE(final FASTORE obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFCMPG(final FCMPG obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFCMPL(final FCMPL obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFDIV(final FDIV obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFLOAD(final FLOAD obj) {
        visitONEARGIns(obj, String.valueOf(obj.index));
    }

    @Override
    public void visitFMUL(final FMUL obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFNEG(final FNEG obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFREM(final FREM obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFRETURN(final FRETURN obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitFSTORE(final FSTORE obj) {
        visitONEARGIns(obj, String.valueOf(obj.index));
    }

    @Override
    public void visitFSUB(final FSUB obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitGETFIELD(final GETFIELD obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitGETSTATIC(final GETSTATIC obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitGOTO(final GOTO obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitGOTO_W(final GOTO_W obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitI2B(final I2B obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitI2C(final I2C obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitI2D(final I2D obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitI2F(final I2F obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitI2L(final I2L obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitI2S(final I2S obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitIADD(final IADD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitIALOAD(final IALOAD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitIAND(final IAND obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitIASTORE(final IASTORE obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitIDIV(final IDIV obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitIF_ACMPEQ(final IF_ACMPEQ obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIF_ACMPNE(final IF_ACMPNE obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIF_ICMPEQ(final IF_ICMPEQ obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIF_ICMPGE(final IF_ICMPGE obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIF_ICMPGT(final IF_ICMPGT obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIF_ICMPLE(final IF_ICMPLE obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIF_ICMPLT(final IF_ICMPLT obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIF_ICMPNE(final IF_ICMPNE obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIFEQ(final IFEQ obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIFGE(final IFGE obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIFGT(final IFGT obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIFLE(final IFLE obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIFLT(final IFLT obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIFNE(final IFNE obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIFNONNULL(final IFNONNULL obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIFNULL(final IFNULL obj) {
        visitONEARGIns(obj, String.valueOf(obj.branch));
    }

    @Override
    public void visitIINC(final IINC obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);

        String hexCode = getHexCode(obj);
        System.out.printf(TWO_ARG_FORMAT, obj.pos, name, obj.index, obj.constValue, hexCode);
    }

    @Override
    public void visitILOAD(final ILOAD obj) {
        visitONEARGIns(obj, String.valueOf(obj.index));
    }

    @Override
    public void visitIMUL(final IMUL obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitINEG(final INEG obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitINSTANCEOF(final INSTANCEOF obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitINVOKEDYNAMIC(final INVOKEDYNAMIC obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitINVOKEINTERFACE(final INVOKEINTERFACE obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        String format = "%04d: %-15s #%s %s %s // %-10s || %s%n";
        System.out.printf(format, obj.pos, name, cpIndex, obj.count, 0, hexCode, cpValue);
    }

    @Override
    public void visitINVOKESPECIAL(INVOKESPECIAL obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitINVOKESTATIC(INVOKESTATIC obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitINVOKEVIRTUAL(INVOKEVIRTUAL obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitIOR(final IOR obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitIREM(final IREM obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitIRETURN(final IRETURN obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitISHL(final ISHL obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitISHR(final ISHR obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitISTORE(final ISTORE obj) {
        visitONEARGIns(obj, String.valueOf(obj.index));
    }

    @Override
    public void visitISUB(final ISUB obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitIUSHR(final IUSHR obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitIXOR(final IXOR obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitJSR(final JSR obj) {
        //Type type = new ReturnaddressType(obj.physicalSuccessor());
        throw new RuntimeException("Unsupported opcode: " + obj);
    }

    @Override
    public void visitJSR_W(final JSR_W obj) {
        //Type type = new ReturnaddressType(obj.physicalSuccessor());
        throw new RuntimeException("Unsupported opcode: " + obj);
    }

    @Override
    public void visitL2D(final L2D obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitL2F(final L2F obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitL2I(final L2I obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLADD(final LADD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLALOAD(final LALOAD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLAND(final LAND obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLASTORE(final LASTORE obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLCMP(final LCMP obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLDC(final LDC obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    public void visitLDC_W(final LDC_W obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitLDC2_W(final LDC2_W obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitLDIV(final LDIV obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLLOAD(final LLOAD obj) {
        visitONEARGIns(obj, String.valueOf(obj.index));
    }

    @Override
    public void visitLMUL(final LMUL obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLNEG(final LNEG obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLOOKUPSWITCH(final LOOKUPSWITCH obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int branch_offset = obj.default_branch;
        String hexCode = getHexCode(obj);
        System.out.printf(ONE_ARG_FORMAT, obj.pos, name, branch_offset, hexCode);
        int match_length = obj.npairs;
        int[] matches = obj.matches;
        int[] offsets = obj.offsets;
        String prefix = "      ";
        System.out.println(prefix + "{");
        for (int i = 0; i < match_length; i++) {
            String format = "%9s: %s";
            String line = String.format(format, matches[i], offsets[i]);
            System.out.println(prefix + line);
        }
        System.out.println(prefix + "  default: " + branch_offset);
        System.out.println(prefix + "}");
    }

    @Override
    public void visitLOR(final LOR obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLREM(final LREM obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLRETURN(final LRETURN obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLSHL(final LSHL obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLSHR(final LSHR obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLSTORE(final LSTORE obj) {
        visitONEARGIns(obj, String.valueOf(obj.index));
    }

    @Override
    public void visitLSUB(final LSUB obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLUSHR(final LUSHR obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitLXOR(final LXOR obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitMONITORENTER(final MONITORENTER obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitMONITOREXIT(final MONITOREXIT obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitWIDE(WIDE obj) {
        visitNOARGIns(obj);
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
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitNEW(final NEW obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitNEWARRAY(final NEWARRAY obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        byte atype = obj.atype;
        String hexCode = getHexCode(obj);
        Type type = TypeUtils.getType(atype);
        System.out.printf(NEW_ARRAY_FORMAT, obj.pos, name, atype, hexCode, type);
    }

    @Override
    public void visitPOP(final POP obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitPOP2(final POP2 obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitPUTFIELD(final PUTFIELD obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitPUTSTATIC(final PUTSTATIC obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int cpIndex = obj.index;
        String cpValue = this.constant_pool.getConstant(cpIndex).value;
        String hexCode = getHexCode(obj);

        System.out.printf(CP_INS_FORMAT, obj.pos, name, cpIndex, hexCode, cpValue);
    }

    @Override
    public void visitRET(final RET obj) {
        // do nothing, return address
        // is in in the local variables.
        throw new RuntimeException("Unsupported opcode: " + obj);
    }

    @Override
    public void visitRETURN(final RETURN obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitSALOAD(final SALOAD obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitSASTORE(final SASTORE obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitSIPUSH(final SIPUSH obj) {
        Number value = obj.getValue();
        visitONEARGIns(obj, String.valueOf(value));
    }

    @Override
    public void visitSWAP(final SWAP obj) {
        visitNOARGIns(obj);
    }

    @Override
    public void visitTABLESWITCH(final TABLESWITCH obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        int branch_offset = obj.default_branch;
        String hexCode = getHexCode(obj);
        System.out.printf(ONE_ARG_FORMAT, obj.pos, name, branch_offset, hexCode);
        int match_length = obj.high - obj.low + 1;
        int[] matches = obj.matches;
        int[] offsets = obj.offsets;
        String prefix = "      ";
        System.out.println(prefix + "{");
        for (int i = 0; i < match_length; i++) {
            String format = "%9s: %s";
            String line = String.format(format, matches[i], offsets[i]);
            System.out.println(prefix + line);
        }
        System.out.println(prefix + "  default: " + branch_offset);
        System.out.println(prefix + "}");
    }


    // region auxiliary
    private void visitNOARGIns(Instruction obj) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        String hexCode = getHexCode(obj);
        System.out.printf(NO_ARG_FORMAT, obj.pos, name, hexCode);
    }

    private void visitONEARGIns(Instruction obj, String firstArg) {
        String name = OpcodeConst.getOpcodeName(obj.opcode);
        String hexCode = getHexCode(obj);
        System.out.printf(ONE_ARG_FORMAT, obj.pos, name, firstArg, hexCode);
    }

    private String getHexCode(Instruction obj) {
        int length = obj.length;
        byte[] bytes = ByteDashboard.readBytes(code_bytes, obj.pos, length);
        return HexUtils.toHex(bytes);
    }
    // endregion
}
