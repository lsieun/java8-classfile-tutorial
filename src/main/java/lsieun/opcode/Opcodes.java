package lsieun.opcode;

public class Opcodes {
    /**
     * Illegal opcode.
     */
    public static final short UNDEFINED = -1;

    /**
     * Illegal opcode.
     */
    public static final short UNPREDICTABLE = -2;

    /**
     * Illegal opcode.
     */
    public static final short RESERVED = -3;

    private static final String ILLEGAL_OPCODE = "ILLEGAL_OPCODE";

    public static boolean isValid(Opcode opcode) {
        return !opcode.name().startsWith(ILLEGAL_OPCODE);
    }

    public static String getName(Opcode opcode) {
        return !isValid(opcode) ? "" : opcode.name().toLowerCase();
    }

    private static final short[] NO_OF_OPERANDS = {
            // region Number of byte code operands
            0/*nop*/, 0/*aconst_null*/, 0/*iconst_m1*/, 0/*iconst_0*/,
            0/*iconst_1*/, 0/*iconst_2*/, 0/*iconst_3*/, 0/*iconst_4*/,
            0/*iconst_5*/, 0/*lconst_0*/, 0/*lconst_1*/, 0/*fconst_0*/,
            0/*fconst_1*/, 0/*fconst_2*/, 0/*dconst_0*/, 0/*dconst_1*/,
            1/*bipush*/, 2/*sipush*/, 1/*ldc*/, 2/*ldc_w*/, 2/*ldc2_w*/,
            1/*iload*/, 1/*lload*/, 1/*fload*/, 1/*dload*/, 1/*aload*/,
            0/*iload_0*/, 0/*iload_1*/, 0/*iload_2*/, 0/*iload_3*/,
            0/*lload_0*/, 0/*lload_1*/, 0/*lload_2*/, 0/*lload_3*/,
            0/*fload_0*/, 0/*fload_1*/, 0/*fload_2*/, 0/*fload_3*/,
            0/*dload_0*/, 0/*dload_1*/, 0/*dload_2*/, 0/*dload_3*/,
            0/*aload_0*/, 0/*aload_1*/, 0/*aload_2*/, 0/*aload_3*/,
            0/*iaload*/, 0/*laload*/, 0/*faload*/, 0/*daload*/,
            0/*aaload*/, 0/*baload*/, 0/*caload*/, 0/*saload*/,
            1/*istore*/, 1/*lstore*/, 1/*fstore*/, 1/*dstore*/,
            1/*astore*/, 0/*istore_0*/, 0/*istore_1*/, 0/*istore_2*/,
            0/*istore_3*/, 0/*lstore_0*/, 0/*lstore_1*/, 0/*lstore_2*/,
            0/*lstore_3*/, 0/*fstore_0*/, 0/*fstore_1*/, 0/*fstore_2*/,
            0/*fstore_3*/, 0/*dstore_0*/, 0/*dstore_1*/, 0/*dstore_2*/,
            0/*dstore_3*/, 0/*astore_0*/, 0/*astore_1*/, 0/*astore_2*/,
            0/*astore_3*/, 0/*iastore*/, 0/*lastore*/, 0/*fastore*/,
            0/*dastore*/, 0/*aastore*/, 0/*bastore*/, 0/*castore*/,
            0/*sastore*/, 0/*pop*/, 0/*pop2*/, 0/*dup*/, 0/*dup_x1*/,
            0/*dup_x2*/, 0/*dup2*/, 0/*dup2_x1*/, 0/*dup2_x2*/, 0/*swap*/,
            0/*iadd*/, 0/*ladd*/, 0/*fadd*/, 0/*dadd*/, 0/*isub*/,
            0/*lsub*/, 0/*fsub*/, 0/*dsub*/, 0/*imul*/, 0/*lmul*/,
            0/*fmul*/, 0/*dmul*/, 0/*idiv*/, 0/*ldiv*/, 0/*fdiv*/,
            0/*ddiv*/, 0/*irem*/, 0/*lrem*/, 0/*frem*/, 0/*drem*/,
            0/*ineg*/, 0/*lneg*/, 0/*fneg*/, 0/*dneg*/, 0/*ishl*/,
            0/*lshl*/, 0/*ishr*/, 0/*lshr*/, 0/*iushr*/, 0/*lushr*/,
            0/*iand*/, 0/*land*/, 0/*ior*/, 0/*lor*/, 0/*ixor*/, 0/*lxor*/,
            2/*iinc*/, 0/*i2l*/, 0/*i2f*/, 0/*i2d*/, 0/*l2i*/, 0/*l2f*/,
            0/*l2d*/, 0/*f2i*/, 0/*f2l*/, 0/*f2d*/, 0/*d2i*/, 0/*d2l*/,
            0/*d2f*/, 0/*i2b*/, 0/*i2c*/, 0/*i2s*/, 0/*lcmp*/, 0/*fcmpl*/,
            0/*fcmpg*/, 0/*dcmpl*/, 0/*dcmpg*/, 2/*ifeq*/, 2/*ifne*/,
            2/*iflt*/, 2/*ifge*/, 2/*ifgt*/, 2/*ifle*/, 2/*if_icmpeq*/,
            2/*if_icmpne*/, 2/*if_icmplt*/, 2/*if_icmpge*/, 2/*if_icmpgt*/,
            2/*if_icmple*/, 2/*if_acmpeq*/, 2/*if_acmpne*/, 2/*goto*/,
            2/*jsr*/, 1/*ret*/, UNPREDICTABLE/*tableswitch*/, UNPREDICTABLE/*lookupswitch*/,
            0/*ireturn*/, 0/*lreturn*/, 0/*freturn*/,
            0/*dreturn*/, 0/*areturn*/, 0/*return*/,
            2/*getstatic*/, 2/*putstatic*/, 2/*getfield*/,
            2/*putfield*/, 2/*invokevirtual*/, 2/*invokespecial*/, 2/*invokestatic*/,
            4/*invokeinterface*/, 4/*invokedynamic*/, 2/*new*/,
            1/*newarray*/, 2/*anewarray*/,
            0/*arraylength*/, 0/*athrow*/, 2/*checkcast*/,
            2/*instanceof*/, 0/*monitorenter*/,
            0/*monitorexit*/, UNPREDICTABLE/*wide*/, 3/*multianewarray*/,
            2/*ifnull*/, 2/*ifnonnull*/, 4/*goto_w*/,
            4/*jsr_w*/, 0/*breakpoint*/, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, RESERVED/*impdep1*/, RESERVED/*impdep2*/
            // endregion
    };

    public static short getNoOfOperands(Opcode opcode) {
        return NO_OF_OPERANDS[opcode.val];
    }
}
