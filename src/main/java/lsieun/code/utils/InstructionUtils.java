package lsieun.code.utils;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.opcode.*;

@SuppressWarnings("Duplicates")
public class InstructionUtils {

    public static Instruction getInstruction(int opcode) {
        Instruction obj = null;

        switch (opcode) {
            // region switch
            case OpcodeConst.NOP:
                obj = new NOP();
                break;
            case OpcodeConst.ACONST_NULL:
                obj = new ACONST_NULL();
                break;
            case OpcodeConst.ICONST_M1:
                obj = new ICONST_M1();
                break;
            case OpcodeConst.ICONST_0:
                obj = new ICONST_0();
                break;
            case OpcodeConst.ICONST_1:
                obj = new ICONST_1();
                break;
            case OpcodeConst.ICONST_2:
                obj = new ICONST_2();
                break;
            case OpcodeConst.ICONST_3:
                obj = new ICONST_3();
                break;
            case OpcodeConst.ICONST_4:
                obj = new ICONST_4();
                break;
            case OpcodeConst.ICONST_5:
                obj = new ICONST_5();
                break;
            case OpcodeConst.LCONST_0:
                obj = new LCONST_0();
                break;
            case OpcodeConst.LCONST_1:
                obj = new LCONST_1();
                break;
            case OpcodeConst.FCONST_0:
                obj = new FCONST_0();
                break;
            case OpcodeConst.FCONST_1:
                obj = new FCONST_1();
                break;
            case OpcodeConst.FCONST_2:
                obj = new FCONST_2();
                break;
            case OpcodeConst.DCONST_0:
                obj = new DCONST_0();
                break;
            case OpcodeConst.DCONST_1:
                obj = new DCONST_1();
                break;
            case OpcodeConst.BIPUSH:
                obj = new BIPUSH();
                break;
            case OpcodeConst.SIPUSH:
                obj = new SIPUSH();
                break;
            case OpcodeConst.LDC:
                obj = new LDC();
                break;
            case OpcodeConst.LDC_W:
                obj = new LDC_W();
                break;
            case OpcodeConst.LDC2_W:
                obj = new LDC2_W();
                break;
            case OpcodeConst.ILOAD:
                obj = new ILOAD();
                break;
            case OpcodeConst.LLOAD:
                obj = new LLOAD();
                break;
            case OpcodeConst.FLOAD:
                obj = new FLOAD();
                break;
            case OpcodeConst.DLOAD:
                obj = new DLOAD();
                break;
            case OpcodeConst.ALOAD:
                obj = new ALOAD();
                break;
            case OpcodeConst.ILOAD_0:
                obj = new ILOAD_0();
                break;
            case OpcodeConst.ILOAD_1:
                obj = new ILOAD_1();
                break;
            case OpcodeConst.ILOAD_2:
                obj = new ILOAD_2();
                break;
            case OpcodeConst.ILOAD_3:
                obj = new ILOAD_3();
                break;
            case OpcodeConst.LLOAD_0:
                obj = new LLOAD_0();
                break;
            case OpcodeConst.LLOAD_1:
                obj = new LLOAD_1();
                break;
            case OpcodeConst.LLOAD_2:
                obj = new LLOAD_2();
                break;
            case OpcodeConst.LLOAD_3:
                obj = new LLOAD_3();
                break;
            case OpcodeConst.FLOAD_0:
                obj = new FLOAD_0();
                break;
            case OpcodeConst.FLOAD_1:
                obj = new FLOAD_1();
                break;
            case OpcodeConst.FLOAD_2:
                obj = new FLOAD_2();
                break;
            case OpcodeConst.FLOAD_3:
                obj = new FLOAD_3();
                break;
            case OpcodeConst.DLOAD_0:
                obj = new DLOAD_0();
                break;
            case OpcodeConst.DLOAD_1:
                obj = new DLOAD_1();
                break;
            case OpcodeConst.DLOAD_2:
                obj = new DLOAD_2();
                break;
            case OpcodeConst.DLOAD_3:
                obj = new DLOAD_3();
                break;
            case OpcodeConst.ALOAD_0:
                obj = new ALOAD_0();
                break;
            case OpcodeConst.ALOAD_1:
                obj = new ALOAD_1();
                break;
            case OpcodeConst.ALOAD_2:
                obj = new ALOAD_2();
                break;
            case OpcodeConst.ALOAD_3:
                obj = new ALOAD_3();
                break;
            case OpcodeConst.IALOAD:
                obj = new IALOAD();
                break;
            case OpcodeConst.LALOAD:
                obj = new LALOAD();
                break;
            case OpcodeConst.FALOAD:
                obj = new FALOAD();
                break;
            case OpcodeConst.DALOAD:
                obj = new DALOAD();
                break;
            case OpcodeConst.AALOAD:
                obj = new AALOAD();
                break;
            case OpcodeConst.BALOAD:
                obj = new BALOAD();
                break;
            case OpcodeConst.CALOAD:
                obj = new CALOAD();
                break;
            case OpcodeConst.SALOAD:
                obj = new SALOAD();
                break;
            case OpcodeConst.ISTORE:
                obj = new ISTORE();
                break;
            case OpcodeConst.LSTORE:
                obj = new LSTORE();
                break;
            case OpcodeConst.FSTORE:
                obj = new FSTORE();
                break;
            case OpcodeConst.DSTORE:
                obj = new DSTORE();
                break;
            case OpcodeConst.ASTORE:
                obj = new ASTORE();
                break;
            case OpcodeConst.ISTORE_0:
                obj = new ISTORE_0();
                break;
            case OpcodeConst.ISTORE_1:
                obj = new ISTORE_1();
                break;
            case OpcodeConst.ISTORE_2:
                obj = new ISTORE_2();
                break;
            case OpcodeConst.ISTORE_3:
                obj = new ISTORE_3();
                break;
            case OpcodeConst.LSTORE_0:
                obj = new LSTORE_0();
                break;
            case OpcodeConst.LSTORE_1:
                obj = new LSTORE_1();
                break;
            case OpcodeConst.LSTORE_2:
                obj = new LSTORE_2();
                break;
            case OpcodeConst.LSTORE_3:
                obj = new LSTORE_3();
                break;
            case OpcodeConst.FSTORE_0:
                obj = new FSTORE_0();
                break;
            case OpcodeConst.FSTORE_1:
                obj = new FSTORE_1();
                break;
            case OpcodeConst.FSTORE_2:
                obj = new FSTORE_2();
                break;
            case OpcodeConst.FSTORE_3:
                obj = new FSTORE_3();
                break;
            case OpcodeConst.DSTORE_0:
                obj = new DSTORE_0();
                break;
            case OpcodeConst.DSTORE_1:
                obj = new DSTORE_1();
                break;
            case OpcodeConst.DSTORE_2:
                obj = new DSTORE_2();
                break;
            case OpcodeConst.DSTORE_3:
                obj = new DSTORE_3();
                break;
            case OpcodeConst.ASTORE_0:
                obj = new ASTORE_0();
                break;
            case OpcodeConst.ASTORE_1:
                obj = new ASTORE_1();
                break;
            case OpcodeConst.ASTORE_2:
                obj = new ASTORE_2();
                break;
            case OpcodeConst.ASTORE_3:
                obj = new ASTORE_3();
                break;
            case OpcodeConst.IASTORE:
                obj = new IASTORE();
                break;
            case OpcodeConst.LASTORE:
                obj = new LASTORE();
                break;
            case OpcodeConst.FASTORE:
                obj = new FASTORE();
                break;
            case OpcodeConst.DASTORE:
                obj = new DASTORE();
                break;
            case OpcodeConst.AASTORE:
                obj = new AASTORE();
                break;
            case OpcodeConst.BASTORE:
                obj = new BASTORE();
                break;
            case OpcodeConst.CASTORE:
                obj = new CASTORE();
                break;
            case OpcodeConst.SASTORE:
                obj = new SASTORE();
                break;
            case OpcodeConst.POP:
                obj = new POP();
                break;
            case OpcodeConst.POP2:
                obj = new POP2();
                break;
            case OpcodeConst.DUP:
                obj = new DUP();
                break;
            case OpcodeConst.DUP_X1:
                obj = new DUP_X1();
                break;
            case OpcodeConst.DUP_X2:
                obj = new DUP_X2();
                break;
            case OpcodeConst.DUP2:
                obj = new DUP2();
                break;
            case OpcodeConst.DUP2_X1:
                obj = new DUP2_X1();
                break;
            case OpcodeConst.DUP2_X2:
                obj = new DUP2_X2();
                break;
            case OpcodeConst.SWAP:
                obj = new SWAP();
                break;
            case OpcodeConst.IADD:
                obj = new IADD();
                break;
            case OpcodeConst.LADD:
                obj = new LADD();
                break;
            case OpcodeConst.FADD:
                obj = new FADD();
                break;
            case OpcodeConst.DADD:
                obj = new DADD();
                break;
            case OpcodeConst.ISUB:
                obj = new ISUB();
                break;
            case OpcodeConst.LSUB:
                obj = new LSUB();
                break;
            case OpcodeConst.FSUB:
                obj = new FSUB();
                break;
            case OpcodeConst.DSUB:
                obj = new DSUB();
                break;
            case OpcodeConst.IMUL:
                obj = new IMUL();
                break;
            case OpcodeConst.LMUL:
                obj = new LMUL();
                break;
            case OpcodeConst.FMUL:
                obj = new FMUL();
                break;
            case OpcodeConst.DMUL:
                obj = new DMUL();
                break;
            case OpcodeConst.IDIV:
                obj = new IDIV();
                break;
            case OpcodeConst.LDIV:
                obj = new LDIV();
                break;
            case OpcodeConst.FDIV:
                obj = new FDIV();
                break;
            case OpcodeConst.DDIV:
                obj = new DDIV();
                break;
            case OpcodeConst.IREM:
                obj = new IREM();
                break;
            case OpcodeConst.LREM:
                obj = new LREM();
                break;
            case OpcodeConst.FREM:
                obj = new FREM();
                break;
            case OpcodeConst.DREM:
                obj = new DREM();
                break;
            case OpcodeConst.INEG:
                obj = new INEG();
                break;
            case OpcodeConst.LNEG:
                obj = new LNEG();
                break;
            case OpcodeConst.FNEG:
                obj = new FNEG();
                break;
            case OpcodeConst.DNEG:
                obj = new DNEG();
                break;
            case OpcodeConst.ISHL:
                obj = new ISHL();
                break;
            case OpcodeConst.LSHL:
                obj = new LSHL();
                break;
            case OpcodeConst.ISHR:
                obj = new ISHR();
                break;
            case OpcodeConst.LSHR:
                obj = new LSHR();
                break;
            case OpcodeConst.IUSHR:
                obj = new IUSHR();
                break;
            case OpcodeConst.LUSHR:
                obj = new LUSHR();
                break;
            case OpcodeConst.IAND:
                obj = new IAND();
                break;
            case OpcodeConst.LAND:
                obj = new LAND();
                break;
            case OpcodeConst.IOR:
                obj = new IOR();
                break;
            case OpcodeConst.LOR:
                obj = new LOR();
                break;
            case OpcodeConst.IXOR:
                obj = new IXOR();
                break;
            case OpcodeConst.LXOR:
                obj = new LXOR();
                break;
            case OpcodeConst.IINC:
                obj = new IINC();
                break;
            case OpcodeConst.I2L:
                obj = new I2L();
                break;
            case OpcodeConst.I2F:
                obj = new I2F();
                break;
            case OpcodeConst.I2D:
                obj = new I2D();
                break;
            case OpcodeConst.L2I:
                obj = new L2I();
                break;
            case OpcodeConst.L2F:
                obj = new L2F();
                break;
            case OpcodeConst.L2D:
                obj = new L2D();
                break;
            case OpcodeConst.F2I:
                obj = new F2I();
                break;
            case OpcodeConst.F2L:
                obj = new F2L();
                break;
            case OpcodeConst.F2D:
                obj = new F2D();
                break;
            case OpcodeConst.D2I:
                obj = new D2I();
                break;
            case OpcodeConst.D2L:
                obj = new D2L();
                break;
            case OpcodeConst.D2F:
                obj = new D2F();
                break;
            case OpcodeConst.I2B:
                obj = new I2B();
                break;
            case OpcodeConst.I2C:
                obj = new I2C();
                break;
            case OpcodeConst.I2S:
                obj = new I2S();
                break;
            case OpcodeConst.LCMP:
                obj = new LCMP();
                break;
            case OpcodeConst.FCMPL:
                obj = new FCMPL();
                break;
            case OpcodeConst.FCMPG:
                obj = new FCMPG();
                break;
            case OpcodeConst.DCMPL:
                obj = new DCMPL();
                break;
            case OpcodeConst.DCMPG:
                obj = new DCMPG();
                break;
            case OpcodeConst.IFEQ:
                obj = new IFEQ();
                break;
            case OpcodeConst.IFNE:
                obj = new IFNE();
                break;
            case OpcodeConst.IFLT:
                obj = new IFLT();
                break;
            case OpcodeConst.IFGE:
                obj = new IFGE();
                break;
            case OpcodeConst.IFGT:
                obj = new IFGT();
                break;
            case OpcodeConst.IFLE:
                obj = new IFLE();
                break;
            case OpcodeConst.IF_ICMPEQ:
                obj = new IF_ICMPEQ();
                break;
            case OpcodeConst.IF_ICMPNE:
                obj = new IF_ICMPNE();
                break;
            case OpcodeConst.IF_ICMPLT:
                obj = new IF_ICMPLT();
                break;
            case OpcodeConst.IF_ICMPGE:
                obj = new IF_ICMPGE();
                break;
            case OpcodeConst.IF_ICMPGT:
                obj = new IF_ICMPGT();
                break;
            case OpcodeConst.IF_ICMPLE:
                obj = new IF_ICMPLE();
                break;
            case OpcodeConst.IF_ACMPEQ:
                obj = new IF_ACMPEQ();
                break;
            case OpcodeConst.IF_ACMPNE:
                obj = new IF_ACMPNE();
                break;
            case OpcodeConst.GOTO:
                obj = new GOTO();
                break;
            case OpcodeConst.JSR:
                obj = new JSR();
                break;
            case OpcodeConst.RET:
                obj = new RET();
                break;
            case OpcodeConst.TABLESWITCH:
                obj = new TABLESWITCH();
                break;
            case OpcodeConst.LOOKUPSWITCH:
                obj = new LOOKUPSWITCH();
                break;
            case OpcodeConst.IRETURN:
                obj = new IRETURN();
                break;
            case OpcodeConst.LRETURN:
                obj = new LRETURN();
                break;
            case OpcodeConst.FRETURN:
                obj = new FRETURN();
                break;
            case OpcodeConst.DRETURN:
                obj = new DRETURN();
                break;
            case OpcodeConst.ARETURN:
                obj = new ARETURN();
                break;
            case OpcodeConst.RETURN:
                obj = new RETURN();
                break;
            case OpcodeConst.GETSTATIC:
                obj = new GETSTATIC();
                break;
            case OpcodeConst.PUTSTATIC:
                obj = new PUTSTATIC();
                break;
            case OpcodeConst.GETFIELD:
                obj = new GETFIELD();
                break;
            case OpcodeConst.PUTFIELD:
                obj = new PUTFIELD();
                break;
            case OpcodeConst.INVOKEVIRTUAL:
                obj = new INVOKEVIRTUAL();
                break;
            case OpcodeConst.INVOKESPECIAL:
                obj = new INVOKESPECIAL();
                break;
            case OpcodeConst.INVOKESTATIC:
                obj = new INVOKESTATIC();
                break;
            case OpcodeConst.INVOKEINTERFACE:
                obj = new INVOKEINTERFACE();
                break;
            case OpcodeConst.INVOKEDYNAMIC:
                obj = new INVOKEDYNAMIC();
                break;
            case OpcodeConst.NEW:
                obj = new NEW();
                break;
            case OpcodeConst.NEWARRAY:
                obj = new NEWARRAY();
                break;
            case OpcodeConst.ANEWARRAY:
                obj = new ANEWARRAY();
                break;
            case OpcodeConst.ARRAYLENGTH:
                obj = new ARRAYLENGTH();
                break;
            case OpcodeConst.ATHROW:
                obj = new ATHROW();
                break;
            case OpcodeConst.CHECKCAST:
                obj = new CHECKCAST();
                break;
            case OpcodeConst.INSTANCEOF:
                obj = new INSTANCEOF();
                break;
            case OpcodeConst.MONITORENTER:
                obj = new MONITORENTER();
                break;
            case OpcodeConst.MONITOREXIT:
                obj = new MONITOREXIT();
                break;
            case OpcodeConst.WIDE:
                obj = new WIDE();
                break;
            case OpcodeConst.MULTIANEWARRAY:
                obj = new MULTIANEWARRAY();
                break;
            case OpcodeConst.IFNULL:
                obj = new IFNULL();
                break;
            case OpcodeConst.IFNONNULL:
                obj = new IFNONNULL();
                break;
            case OpcodeConst.GOTO_W:
                obj = new GOTO_W();
                break;
            case OpcodeConst.JSR_W:
                obj = new JSR_W();
                break;
            case OpcodeConst.BREAKPOINT:
                obj = new BREAKPOINT();
                break;
            case OpcodeConst.IMPDEP1:
                obj = new IMPDEP1();
                break;
            case OpcodeConst.IMPDEP2:
                obj = new IMPDEP2();
                break;
            default:
                throw new RuntimeException("Illegal opcode detected: " + opcode);
                // endregion
        }

        return obj;
    }

}
