package lsieun.code.visitors;

import lsieun.code.Instruction;
import lsieun.code.opcode.*;
import lsieun.code.utils.InstructionChain;
import lsieun.code.utils.InstructionUtils;
import lsieun.utils.ByteDashboard;

@SuppressWarnings("Duplicates")
public class OpcodeReadVisitor extends EmptyVisitor {

    // region static member
    private static final ThreadLocal<Boolean> wide_state =
            new ThreadLocal<Boolean>() {
                @Override
                protected Boolean initialValue() {
                    return false;
                }
            };

    public static boolean wide() {
        return wide_state.get();
    }

    public static void wide(boolean flag) {
        wide_state.set(flag);
    }
    // endregion

    private ByteDashboard bd;

    public OpcodeReadVisitor(byte[] code_bytes) {
        bd = new ByteDashboard(code_bytes);
    }

    public InstructionChain getInstructionChain() {

        InstructionChain chain = new InstructionChain();

        while (bd.hasNext()) {
            // Remember byte offset and associate it with the opcode
            int offset = bd.getIndex();

            int opcode = bd.readUnsignedByte();
            Instruction ins = InstructionUtils.getInstruction(opcode);
            ins.pos = offset;

            // wide
            if(ins instanceof WIDE) {
                wide(true);
            }

            // Read Fully
            ins.accept(this);

            // Add to List
            chain.append(ins);
        }

        return chain;
    }

    @Override
    public void visitBIPUSH(BIPUSH obj) {
        obj.value = bd.readByte();
    }

    @Override
    public void visitSIPUSH(SIPUSH obj) {
        obj.length = 3;
        obj.value = bd.readShort();
    }

    @Override
    public void visitLDC(LDC obj) {
        obj.index = bd.readUnsignedByte();
    }

    @Override
    public void visitLDC_W(LDC_W obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitLDC2_W(LDC2_W obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitILOAD(ILOAD obj) {
        boolean wide = wide();
        if(wide) {
            obj.length = 3;
            obj.index = bd.readUnsignedShort();
            wide(false);
        }
        else {
            obj.index = bd.readUnsignedByte();
        }
    }

    @Override
    public void visitLLOAD(LLOAD obj) {
        boolean wide = wide();
        if(wide) {
            obj.length = 3;
            obj.index = bd.readUnsignedShort();
            wide(false);
        }
        else {
            obj.index = bd.readUnsignedByte();
        }
    }

    @Override
    public void visitFLOAD(FLOAD obj) {
        boolean wide = wide();
        if(wide) {
            obj.length = 3;
            obj.index = bd.readUnsignedShort();
            wide(false);
        }
        else {
            obj.index = bd.readUnsignedByte();
        }
    }

    @Override
    public void visitDLOAD(DLOAD obj) {
        boolean wide = wide();
        if(wide) {
            obj.length = 3;
            obj.index = bd.readUnsignedShort();
            wide(false);
        }
        else {
            obj.index = bd.readUnsignedByte();
        }
    }

    @Override
    public void visitALOAD(ALOAD obj) {
        boolean wide = wide();
        if(wide) {
            obj.length = 3;
            obj.index = bd.readUnsignedShort();
            wide(false);
        }
        else {
            obj.index = bd.readUnsignedByte();
        }
    }

    @Override
    public void visitISTORE(ISTORE obj) {
        boolean wide = wide();
        if(wide) {
            obj.length = 3;
            obj.index = bd.readUnsignedShort();
            wide(false);
        }
        else {
            obj.index = bd.readUnsignedByte();
        }
    }

    @Override
    public void visitLSTORE(LSTORE obj) {
        boolean wide = wide();
        if(wide) {
            obj.length = 3;
            obj.index = bd.readUnsignedShort();
            wide(false);
        }
        else {
            obj.index = bd.readUnsignedByte();
        }
    }

    @Override
    public void visitFSTORE(FSTORE obj) {
        boolean wide = wide();
        if(wide) {
            obj.length = 3;
            obj.index = bd.readUnsignedShort();
            wide(false);
        }
        else {
            obj.index = bd.readUnsignedByte();
        }
    }

    @Override
    public void visitDSTORE(DSTORE obj) {
        boolean wide = wide();
        if(wide) {
            obj.length = 3;
            obj.index = bd.readUnsignedShort();
            wide(false);
        }
        else {
            obj.index = bd.readUnsignedByte();
        }
    }

    @Override
    public void visitASTORE(ASTORE obj) {
        boolean wide = wide();
        if(wide) {
            obj.length = 3;
            obj.index = bd.readUnsignedShort();
            wide(false);
        }
        else {
            obj.index = bd.readUnsignedByte();
        }
    }

    @Override
    public void visitIINC(IINC obj) {
        boolean wide = wide();
        if (wide) {
            obj.length = 5;
            obj.index = bd.readUnsignedShort();
            obj.constValue = bd.readShort();
            wide(false);
        } else {
            obj.length = 3;
            obj.index = bd.readUnsignedByte();
            obj.constValue = bd.readByte();
        }
    }

    @Override
    public void visitIFEQ(IFEQ obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIFNE(IFNE obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIFLT(IFLT obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIFGE(IFGE obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIFGT(IFGT obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIFLE(IFLE obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIF_ICMPEQ(IF_ICMPEQ obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIF_ICMPNE(IF_ICMPNE obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIF_ICMPLT(IF_ICMPLT obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIF_ICMPGE(IF_ICMPGE obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIF_ICMPGT(IF_ICMPGT obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIF_ICMPLE(IF_ICMPLE obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIF_ACMPEQ(IF_ACMPEQ obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIF_ACMPNE(IF_ACMPNE obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIFNULL(IFNULL obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitIFNONNULL(IFNONNULL obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitGOTO(GOTO obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitGOTO_W(GOTO_W obj) {
        obj.branch = bd.readInt();
    }

    @Override
    public void visitJSR(JSR obj) {
        obj.branch = bd.readShort();
    }

    @Override
    public void visitJSR_W(JSR_W obj) {
        obj.branch = bd.readInt();
    }

    @Override
    public void visitRET(RET obj) {
        boolean wide = wide();
        if (wide) {
            obj.length = 4;
            obj.index = bd.readInt();
            wide(false);
        } else {
            obj.length = 2;
            obj.index = bd.readShort();
        }
    }

    @Override
    public void visitTABLESWITCH(TABLESWITCH obj) {
        int padding = obj.padding = (4 - (bd.getIndex() % 4)) % 4; // Compute number of pad bytes

        for (int i = 0; i < padding; i++) {
            bd.readByte();
        }

        // Default branch target clazz for both cases (TABLESWITCH, LOOKUPSWITCH)
        obj.default_branch = bd.readInt();

        int low = obj.low = bd.readInt();
        int high = obj.high = bd.readInt();
        int match_length = high - low + 1;
        int fixed_length = obj.fix_length = (short) (13 + match_length * 4);
        obj.length = fixed_length + obj.padding;
        obj.matches = new int[match_length];
        obj.offsets = new int[match_length];

        for (int i = 0; i < match_length; i++) {
            obj.matches[i] = low + i;
            obj.offsets[i] = bd.readInt();
        }

    }

    @Override
    public void visitLOOKUPSWITCH(LOOKUPSWITCH obj) {
        int padding = obj.padding = (4 - (bd.getIndex() % 4)) % 4; // Compute number of pad bytes

        for (int i = 0; i < padding; i++) {
            bd.readByte();
        }

        // Default branch target clazz for both cases (TABLESWITCH, LOOKUPSWITCH)
        obj.default_branch = bd.readInt();

        int npairs = obj.npairs = bd.readInt();
        int fixed_length = obj.fix_length = (short) (9 + npairs * 8);
        obj.length = (short) (fixed_length + obj.padding);
        obj.matches = new int[npairs];
        obj.offsets = new int[npairs];

        for (int i = 0; i < npairs; i++) {
            obj.matches[i] = bd.readInt();
            obj.offsets[i] = bd.readInt();
        }
    }

    @Override
    public void visitGETSTATIC(GETSTATIC obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitPUTSTATIC(PUTSTATIC obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitGETFIELD(GETFIELD obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitPUTFIELD(PUTFIELD obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitINVOKEVIRTUAL(INVOKEVIRTUAL obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitINVOKESPECIAL(INVOKESPECIAL obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitINVOKESTATIC(INVOKESTATIC obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitINVOKEINTERFACE(INVOKEINTERFACE obj) {
        obj.index = bd.readUnsignedShort();
        obj.count = bd.readUnsignedByte();
        bd.readByte(); // Skip the byte whose value is 0.
    }

    @Override
    public void visitINVOKEDYNAMIC(INVOKEDYNAMIC obj) {
        obj.index = bd.readUnsignedShort();
        bd.readUnsignedShort();
    }

    @Override
    public void visitNEW(NEW obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitNEWARRAY(NEWARRAY obj) {
        obj.atype = bd.readByte();
        obj.length = 2;
    }

    @Override
    public void visitANEWARRAY(ANEWARRAY obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitMULTIANEWARRAY(MULTIANEWARRAY obj) {
        obj.length = 4;
        obj.index = bd.readUnsignedShort();
        obj.dimensions = bd.readUnsignedByte();
    }

    @Override
    public void visitCHECKCAST(CHECKCAST obj) {
        obj.index = bd.readUnsignedShort();
    }

    @Override
    public void visitINSTANCEOF(INSTANCEOF obj) {
        obj.index = bd.readUnsignedShort();
    }
}
