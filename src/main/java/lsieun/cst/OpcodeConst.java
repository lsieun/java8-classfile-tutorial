package lsieun.cst;

public class OpcodeConst {
    /** Illegal opcode. */
    public static final short  UNDEFINED      = -1;

    /** Illegal opcode. */
    public static final short  UNPREDICTABLE  = -2;

    /** Illegal opcode. */
    public static final short  RESERVED       = -3;

    /** Mnemonic for an illegal opcode. */
    public static final String ILLEGAL_OPCODE = "<illegal opcode>";

    // region 第零认知，opcode常量
    public static final short NOP              = 0;
    public static final short ACONST_NULL      = 1;
    public static final short ICONST_M1        = 2;
    public static final short ICONST_0         = 3;
    public static final short ICONST_1         = 4;
    public static final short ICONST_2         = 5;
    public static final short ICONST_3         = 6;
    public static final short ICONST_4         = 7;
    public static final short ICONST_5         = 8;
    public static final short LCONST_0         = 9;
    public static final short LCONST_1         = 10;
    public static final short FCONST_0         = 11;
    public static final short FCONST_1         = 12;
    public static final short FCONST_2         = 13;
    public static final short DCONST_0         = 14;
    public static final short DCONST_1         = 15;
    public static final short BIPUSH           = 16;
    public static final short SIPUSH           = 17;
    public static final short LDC              = 18;
    public static final short LDC_W            = 19;
    public static final short LDC2_W           = 20;
    public static final short ILOAD            = 21;
    public static final short LLOAD            = 22;
    public static final short FLOAD            = 23;
    public static final short DLOAD            = 24;
    public static final short ALOAD            = 25;
    public static final short ILOAD_0          = 26;
    public static final short ILOAD_1          = 27;
    public static final short ILOAD_2          = 28;
    public static final short ILOAD_3          = 29;
    public static final short LLOAD_0          = 30;
    public static final short LLOAD_1          = 31;
    public static final short LLOAD_2          = 32;
    public static final short LLOAD_3          = 33;
    public static final short FLOAD_0          = 34;
    public static final short FLOAD_1          = 35;
    public static final short FLOAD_2          = 36;
    public static final short FLOAD_3          = 37;
    public static final short DLOAD_0          = 38;
    public static final short DLOAD_1          = 39;
    public static final short DLOAD_2          = 40;
    public static final short DLOAD_3          = 41;
    public static final short ALOAD_0          = 42;
    public static final short ALOAD_1          = 43;
    public static final short ALOAD_2          = 44;
    public static final short ALOAD_3          = 45;
    public static final short IALOAD           = 46;
    public static final short LALOAD           = 47;
    public static final short FALOAD           = 48;
    public static final short DALOAD           = 49;
    public static final short AALOAD           = 50;
    public static final short BALOAD           = 51;
    public static final short CALOAD           = 52;
    public static final short SALOAD           = 53;
    public static final short ISTORE           = 54;
    public static final short LSTORE           = 55;
    public static final short FSTORE           = 56;
    public static final short DSTORE           = 57;
    public static final short ASTORE           = 58;
    public static final short ISTORE_0         = 59;
    public static final short ISTORE_1         = 60;
    public static final short ISTORE_2         = 61;
    public static final short ISTORE_3         = 62;
    public static final short LSTORE_0         = 63;
    public static final short LSTORE_1         = 64;
    public static final short LSTORE_2         = 65;
    public static final short LSTORE_3         = 66;
    public static final short FSTORE_0         = 67;
    public static final short FSTORE_1         = 68;
    public static final short FSTORE_2         = 69;
    public static final short FSTORE_3         = 70;
    public static final short DSTORE_0         = 71;
    public static final short DSTORE_1         = 72;
    public static final short DSTORE_2         = 73;
    public static final short DSTORE_3         = 74;
    public static final short ASTORE_0         = 75;
    public static final short ASTORE_1         = 76;
    public static final short ASTORE_2         = 77;
    public static final short ASTORE_3         = 78;
    public static final short IASTORE          = 79;
    public static final short LASTORE          = 80;
    public static final short FASTORE          = 81;
    public static final short DASTORE          = 82;
    public static final short AASTORE          = 83;
    public static final short BASTORE          = 84;
    public static final short CASTORE          = 85;
    public static final short SASTORE          = 86;
    public static final short POP              = 87;
    public static final short POP2             = 88;
    public static final short DUP              = 89;
    public static final short DUP_X1           = 90;
    public static final short DUP_X2           = 91;
    public static final short DUP2             = 92;
    public static final short DUP2_X1          = 93;
    public static final short DUP2_X2          = 94;
    public static final short SWAP             = 95;
    public static final short IADD             = 96;
    public static final short LADD             = 97;
    public static final short FADD             = 98;
    public static final short DADD             = 99;
    public static final short ISUB             = 100;
    public static final short LSUB             = 101;
    public static final short FSUB             = 102;
    public static final short DSUB             = 103;
    public static final short IMUL             = 104;
    public static final short LMUL             = 105;
    public static final short FMUL             = 106;
    public static final short DMUL             = 107;
    public static final short IDIV             = 108;
    public static final short LDIV             = 109;
    public static final short FDIV             = 110;
    public static final short DDIV             = 111;
    public static final short IREM             = 112;
    public static final short LREM             = 113;
    public static final short FREM             = 114;
    public static final short DREM             = 115;
    public static final short INEG             = 116;
    public static final short LNEG             = 117;
    public static final short FNEG             = 118;
    public static final short DNEG             = 119;
    public static final short ISHL             = 120;
    public static final short LSHL             = 121;
    public static final short ISHR             = 122;
    public static final short LSHR             = 123;
    public static final short IUSHR            = 124;
    public static final short LUSHR            = 125;
    public static final short IAND             = 126;
    public static final short LAND             = 127;
    public static final short IOR              = 128;
    public static final short LOR              = 129;
    public static final short IXOR             = 130;
    public static final short LXOR             = 131;
    public static final short IINC             = 132;
    public static final short I2L              = 133;
    public static final short I2F              = 134;
    public static final short I2D              = 135;
    public static final short L2I              = 136;
    public static final short L2F              = 137;
    public static final short L2D              = 138;
    public static final short F2I              = 139;
    public static final short F2L              = 140;
    public static final short F2D              = 141;
    public static final short D2I              = 142;
    public static final short D2L              = 143;
    public static final short D2F              = 144;
    public static final short I2B              = 145;
    public static final short INT2BYTE         = 145; // Old notation
    public static final short I2C              = 146;
    public static final short INT2CHAR         = 146; // Old notation
    public static final short I2S              = 147;
    public static final short INT2SHORT        = 147; // Old notation
    public static final short LCMP             = 148;
    public static final short FCMPL            = 149;
    public static final short FCMPG            = 150;
    public static final short DCMPL            = 151;
    public static final short DCMPG            = 152;
    public static final short IFEQ             = 153;
    public static final short IFNE             = 154;
    public static final short IFLT             = 155;
    public static final short IFGE             = 156;
    public static final short IFGT             = 157;
    public static final short IFLE             = 158;
    public static final short IF_ICMPEQ        = 159;
    public static final short IF_ICMPNE        = 160;
    public static final short IF_ICMPLT        = 161;
    public static final short IF_ICMPGE        = 162;
    public static final short IF_ICMPGT        = 163;
    public static final short IF_ICMPLE        = 164;
    public static final short IF_ACMPEQ        = 165;
    public static final short IF_ACMPNE        = 166;
    public static final short GOTO             = 167;
    public static final short JSR              = 168;
    public static final short RET              = 169;
    public static final short TABLESWITCH      = 170;
    public static final short LOOKUPSWITCH     = 171;
    public static final short IRETURN          = 172;
    public static final short LRETURN          = 173;
    public static final short FRETURN          = 174;
    public static final short DRETURN          = 175;
    public static final short ARETURN          = 176;
    public static final short RETURN           = 177;
    public static final short GETSTATIC        = 178;
    public static final short PUTSTATIC        = 179;
    public static final short GETFIELD         = 180;
    public static final short PUTFIELD         = 181;
    public static final short INVOKEVIRTUAL    = 182;
    public static final short INVOKESPECIAL    = 183;
    public static final short INVOKENONVIRTUAL = 183; // Old name in JDK 1.0
    public static final short INVOKESTATIC     = 184;
    public static final short INVOKEINTERFACE  = 185;
    public static final short INVOKEDYNAMIC    = 186;
    public static final short NEW              = 187;
    public static final short NEWARRAY         = 188;
    public static final short ANEWARRAY        = 189;
    public static final short ARRAYLENGTH      = 190;
    public static final short ATHROW           = 191;
    public static final short CHECKCAST        = 192;
    public static final short INSTANCEOF       = 193;
    public static final short MONITORENTER     = 194;
    public static final short MONITOREXIT      = 195;
    public static final short WIDE             = 196;
    public static final short MULTIANEWARRAY   = 197;
    public static final short IFNULL           = 198;
    public static final short IFNONNULL        = 199;
    public static final short GOTO_W           = 200;
    public static final short JSR_W            = 201;
    public static final short BREAKPOINT                = 202;
    public static final short IMPDEP1                   = 254;
    public static final short IMPDEP2                   = 255;
    // endregion

    // region 第一认知，opcode的名字

    /**
     * Names of opcodes.  Indexed by opcode.  OPCODE_NAMES[ALOAD] = "aload".
     */
    private static final String[] OPCODE_NAMES = {
            // region opcode names
            "nop", "aconst_null", "iconst_m1", "iconst_0", "iconst_1",
            "iconst_2", "iconst_3", "iconst_4", "iconst_5", "lconst_0",
            "lconst_1", "fconst_0", "fconst_1", "fconst_2", "dconst_0",
            "dconst_1", "bipush", "sipush", "ldc", "ldc_w", "ldc2_w", "iload",
            "lload", "fload", "dload", "aload", "iload_0", "iload_1", "iload_2",
            "iload_3", "lload_0", "lload_1", "lload_2", "lload_3", "fload_0",
            "fload_1", "fload_2", "fload_3", "dload_0", "dload_1", "dload_2",
            "dload_3", "aload_0", "aload_1", "aload_2", "aload_3", "iaload",
            "laload", "faload", "daload", "aaload", "baload", "caload", "saload",
            "istore", "lstore", "fstore", "dstore", "astore", "istore_0",
            "istore_1", "istore_2", "istore_3", "lstore_0", "lstore_1",
            "lstore_2", "lstore_3", "fstore_0", "fstore_1", "fstore_2",
            "fstore_3", "dstore_0", "dstore_1", "dstore_2", "dstore_3",
            "astore_0", "astore_1", "astore_2", "astore_3", "iastore", "lastore",
            "fastore", "dastore", "aastore", "bastore", "castore", "sastore",
            "pop", "pop2", "dup", "dup_x1", "dup_x2", "dup2", "dup2_x1",
            "dup2_x2", "swap", "iadd", "ladd", "fadd", "dadd", "isub", "lsub",
            "fsub", "dsub", "imul", "lmul", "fmul", "dmul", "idiv", "ldiv",
            "fdiv", "ddiv", "irem", "lrem", "frem", "drem", "ineg", "lneg",
            "fneg", "dneg", "ishl", "lshl", "ishr", "lshr", "iushr", "lushr",
            "iand", "land", "ior", "lor", "ixor", "lxor", "iinc", "i2l", "i2f",
            "i2d", "l2i", "l2f", "l2d", "f2i", "f2l", "f2d", "d2i", "d2l", "d2f",
            "i2b", "i2c", "i2s", "lcmp", "fcmpl", "fcmpg",
            "dcmpl", "dcmpg", "ifeq", "ifne", "iflt", "ifge", "ifgt", "ifle",
            "if_icmpeq", "if_icmpne", "if_icmplt", "if_icmpge", "if_icmpgt",
            "if_icmple", "if_acmpeq", "if_acmpne", "goto", "jsr", "ret",
            "tableswitch", "lookupswitch", "ireturn", "lreturn", "freturn",
            "dreturn", "areturn", "return", "getstatic", "putstatic", "getfield",
            "putfield", "invokevirtual", "invokespecial", "invokestatic",
            "invokeinterface", "invokedynamic", "new", "newarray", "anewarray",
            "arraylength", "athrow", "checkcast", "instanceof", "monitorenter",
            "monitorexit", "wide", "multianewarray", "ifnull", "ifnonnull",
            "goto_w", "jsr_w", "breakpoint", ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE, ILLEGAL_OPCODE,
            ILLEGAL_OPCODE, "impdep1", "impdep2"
            // endregion
    };

    public static final int OPCODE_NAMES_LENGTH = OPCODE_NAMES.length;

    public static String getOpcodeName(final int index) {
        return OPCODE_NAMES[index];
    }
    // endregion

    // region 第二认知，opcode的参数有多少个

    /**
     * Number of byte code operands for each opcode, i.e., number of bytes after the tag byte
     * itself.  Indexed by opcode, so NO_OF_OPERANDS[BIPUSH] = the number of operands for a bipush
     * opcode.
     */
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

    /**
     *
     * @param index
     * @return Number of byte code operands
     */
    public static short getNoOfOperands(final int index) {
        return NO_OF_OPERANDS[index];
    }

    // endregion

    // region 第三认知，opcode的每个参数是什么类型

    /**
     * How the byte code operands are to be interpreted for each opcode.
     * Indexed by opcode.  TYPE_OF_OPERANDS[ILOAD] = an array of shorts
     * describing the data types for the opcode.
     */
    private static final short[][] TYPE_OF_OPERANDS = {
            // region type of operand
            {}/*nop*/, {}/*aconst_null*/, {}/*iconst_m1*/, {}/*iconst_0*/,
            {}/*iconst_1*/, {}/*iconst_2*/, {}/*iconst_3*/, {}/*iconst_4*/,
            {}/*iconst_5*/, {}/*lconst_0*/, {}/*lconst_1*/, {}/*fconst_0*/,
            {}/*fconst_1*/, {}/*fconst_2*/, {}/*dconst_0*/, {}/*dconst_1*/,
            {TypeConst.T_BYTE}/*bipush*/, {TypeConst.T_SHORT}/*sipush*/, {TypeConst.T_BYTE}/*ldc*/,
            {TypeConst.T_SHORT}/*ldc_w*/, {TypeConst.T_SHORT}/*ldc2_w*/,
            {TypeConst.T_BYTE}/*iload*/, {TypeConst.T_BYTE}/*lload*/, {TypeConst.T_BYTE}/*fload*/,
            {TypeConst.T_BYTE}/*dload*/, {TypeConst.T_BYTE}/*aload*/, {}/*iload_0*/,
            {}/*iload_1*/, {}/*iload_2*/, {}/*iload_3*/, {}/*lload_0*/,
            {}/*lload_1*/, {}/*lload_2*/, {}/*lload_3*/, {}/*fload_0*/,
            {}/*fload_1*/, {}/*fload_2*/, {}/*fload_3*/, {}/*dload_0*/,
            {}/*dload_1*/, {}/*dload_2*/, {}/*dload_3*/, {}/*aload_0*/,
            {}/*aload_1*/, {}/*aload_2*/, {}/*aload_3*/, {}/*iaload*/,
            {}/*laload*/, {}/*faload*/, {}/*daload*/, {}/*aaload*/,
            {}/*baload*/, {}/*caload*/, {}/*saload*/, {TypeConst.T_BYTE}/*istore*/,
            {TypeConst.T_BYTE}/*lstore*/, {TypeConst.T_BYTE}/*fstore*/, {TypeConst.T_BYTE}/*dstore*/,
            {TypeConst.T_BYTE}/*astore*/, {}/*istore_0*/, {}/*istore_1*/,
            {}/*istore_2*/, {}/*istore_3*/, {}/*lstore_0*/, {}/*lstore_1*/,
            {}/*lstore_2*/, {}/*lstore_3*/, {}/*fstore_0*/, {}/*fstore_1*/,
            {}/*fstore_2*/, {}/*fstore_3*/, {}/*dstore_0*/, {}/*dstore_1*/,
            {}/*dstore_2*/, {}/*dstore_3*/, {}/*astore_0*/, {}/*astore_1*/,
            {}/*astore_2*/, {}/*astore_3*/, {}/*iastore*/, {}/*lastore*/,
            {}/*fastore*/, {}/*dastore*/, {}/*aastore*/, {}/*bastore*/,
            {}/*castore*/, {}/*sastore*/, {}/*pop*/, {}/*pop2*/, {}/*dup*/,
            {}/*dup_x1*/, {}/*dup_x2*/, {}/*dup2*/, {}/*dup2_x1*/,
            {}/*dup2_x2*/, {}/*swap*/, {}/*iadd*/, {}/*ladd*/, {}/*fadd*/,
            {}/*dadd*/, {}/*isub*/, {}/*lsub*/, {}/*fsub*/, {}/*dsub*/,
            {}/*imul*/, {}/*lmul*/, {}/*fmul*/, {}/*dmul*/, {}/*idiv*/,
            {}/*ldiv*/, {}/*fdiv*/, {}/*ddiv*/, {}/*irem*/, {}/*lrem*/,
            {}/*frem*/, {}/*drem*/, {}/*ineg*/, {}/*lneg*/, {}/*fneg*/,
            {}/*dneg*/, {}/*ishl*/, {}/*lshl*/, {}/*ishr*/, {}/*lshr*/,
            {}/*iushr*/, {}/*lushr*/, {}/*iand*/, {}/*land*/, {}/*ior*/,
            {}/*lor*/, {}/*ixor*/, {}/*lxor*/, {TypeConst.T_BYTE, TypeConst.T_BYTE}/*iinc*/,
            {}/*i2l*/, {}/*i2f*/, {}/*i2d*/, {}/*l2i*/, {}/*l2f*/, {}/*l2d*/,
            {}/*f2i*/, {}/*f2l*/, {}/*f2d*/, {}/*d2i*/, {}/*d2l*/, {}/*d2f*/,
            {}/*i2b*/, {}/*i2c*/, {}/*i2s*/, {}/*lcmp*/, {}/*fcmpl*/,
            {}/*fcmpg*/, {}/*dcmpl*/, {}/*dcmpg*/, {TypeConst.T_SHORT}/*ifeq*/,
            {TypeConst.T_SHORT}/*ifne*/, {TypeConst.T_SHORT}/*iflt*/, {TypeConst.T_SHORT}/*ifge*/,
            {TypeConst.T_SHORT}/*ifgt*/, {TypeConst.T_SHORT}/*ifle*/, {TypeConst.T_SHORT}/*if_icmpeq*/,
            {TypeConst.T_SHORT}/*if_icmpne*/, {TypeConst.T_SHORT}/*if_icmplt*/,
            {TypeConst.T_SHORT}/*if_icmpge*/, {TypeConst.T_SHORT}/*if_icmpgt*/,
            {TypeConst.T_SHORT}/*if_icmple*/, {TypeConst.T_SHORT}/*if_acmpeq*/,
            {TypeConst.T_SHORT}/*if_acmpne*/, {TypeConst.T_SHORT}/*goto*/, {TypeConst.T_SHORT}/*jsr*/,
            {TypeConst.T_BYTE}/*ret*/, {}/*tableswitch*/, {}/*lookupswitch*/,
            {}/*ireturn*/, {}/*lreturn*/, {}/*freturn*/, {}/*dreturn*/,
            {}/*areturn*/, {}/*return*/, {TypeConst.T_SHORT}/*getstatic*/,
            {TypeConst.T_SHORT}/*putstatic*/, {TypeConst.T_SHORT}/*getfield*/,
            {TypeConst.T_SHORT}/*putfield*/, {TypeConst.T_SHORT}/*invokevirtual*/,
            {TypeConst.T_SHORT}/*invokespecial*/, {TypeConst.T_SHORT}/*invokestatic*/,
            {TypeConst.T_SHORT, TypeConst.T_BYTE, TypeConst.T_BYTE}/*invokeinterface*/, {TypeConst.T_SHORT, TypeConst.T_BYTE, TypeConst.T_BYTE}/*invokedynamic*/,
            {TypeConst.T_SHORT}/*new*/, {TypeConst.T_BYTE}/*newarray*/,
            {TypeConst.T_SHORT}/*anewarray*/, {}/*arraylength*/, {}/*athrow*/,
            {TypeConst.T_SHORT}/*checkcast*/, {TypeConst.T_SHORT}/*instanceof*/,
            {}/*monitorenter*/, {}/*monitorexit*/, {TypeConst.T_BYTE}/*wide*/,
            {TypeConst.T_SHORT, TypeConst.T_BYTE}/*multianewarray*/, {TypeConst.T_SHORT}/*ifnull*/,
            {TypeConst.T_SHORT}/*ifnonnull*/, {TypeConst.T_INT}/*goto_w*/, {TypeConst.T_INT}/*jsr_w*/,
            {}/*breakpoint*/, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
            {}/*impdep1*/, {}/*impdep2*/
            // endregion
    };

    public static short getOperandType(final int opcode, final int index) {
        return TYPE_OF_OPERANDS[opcode][index];
    }


    public static long getOperandTypeCount(final int opcode) {
        return TYPE_OF_OPERANDS[opcode].length;
    }

    // endregion

    // region 第四认知，opcode对于Stack的影响
    /**
     * Number of words consumed on operand f_stack by instructions.
     * Indexed by opcode.  CONSUME_STACK[FALOAD] = number of words
     * consumed from the f_stack by a faload opcode.
     */
    private static final int[] CONSUME_STACK = {
            // region CONSUME_STACK
            0/*nop*/, 0/*aconst_null*/, 0/*iconst_m1*/, 0/*iconst_0*/, 0/*iconst_1*/,
            0/*iconst_2*/, 0/*iconst_3*/, 0/*iconst_4*/, 0/*iconst_5*/, 0/*lconst_0*/,
            0/*lconst_1*/, 0/*fconst_0*/, 0/*fconst_1*/, 0/*fconst_2*/, 0/*dconst_0*/,
            0/*dconst_1*/, 0/*bipush*/, 0/*sipush*/, 0/*ldc*/, 0/*ldc_w*/, 0/*ldc2_w*/, 0/*iload*/,
            0/*lload*/, 0/*fload*/, 0/*dload*/, 0/*aload*/, 0/*iload_0*/, 0/*iload_1*/, 0/*iload_2*/,
            0/*iload_3*/, 0/*lload_0*/, 0/*lload_1*/, 0/*lload_2*/, 0/*lload_3*/, 0/*fload_0*/,
            0/*fload_1*/, 0/*fload_2*/, 0/*fload_3*/, 0/*dload_0*/, 0/*dload_1*/, 0/*dload_2*/,
            0/*dload_3*/, 0/*aload_0*/, 0/*aload_1*/, 0/*aload_2*/, 0/*aload_3*/, 2/*iaload*/,
            2/*laload*/, 2/*faload*/, 2/*daload*/, 2/*aaload*/, 2/*baload*/, 2/*caload*/, 2/*saload*/,
            1/*istore*/, 2/*lstore*/, 1/*fstore*/, 2/*dstore*/, 1/*astore*/, 1/*istore_0*/,
            1/*istore_1*/, 1/*istore_2*/, 1/*istore_3*/, 2/*lstore_0*/, 2/*lstore_1*/,
            2/*lstore_2*/, 2/*lstore_3*/, 1/*fstore_0*/, 1/*fstore_1*/, 1/*fstore_2*/,
            1/*fstore_3*/, 2/*dstore_0*/, 2/*dstore_1*/, 2/*dstore_2*/, 2/*dstore_3*/,
            1/*astore_0*/, 1/*astore_1*/, 1/*astore_2*/, 1/*astore_3*/, 3/*iastore*/, 4/*lastore*/,
            3/*fastore*/, 4/*dastore*/, 3/*aastore*/, 3/*bastore*/, 3/*castore*/, 3/*sastore*/,
            1/*pop*/, 2/*pop2*/, 1/*dup*/, 2/*dup_x1*/, 3/*dup_x2*/, 2/*dup2*/, 3/*dup2_x1*/,
            4/*dup2_x2*/, 2/*swap*/, 2/*iadd*/, 4/*ladd*/, 2/*fadd*/, 4/*dadd*/, 2/*isub*/, 4/*lsub*/,
            2/*fsub*/, 4/*dsub*/, 2/*imul*/, 4/*lmul*/, 2/*fmul*/, 4/*dmul*/, 2/*idiv*/, 4/*ldiv*/,
            2/*fdiv*/, 4/*ddiv*/, 2/*irem*/, 4/*lrem*/, 2/*frem*/, 4/*drem*/, 1/*ineg*/, 2/*lneg*/,
            1/*fneg*/, 2/*dneg*/, 2/*ishl*/, 3/*lshl*/, 2/*ishr*/, 3/*lshr*/, 2/*iushr*/, 3/*lushr*/,
            2/*iand*/, 4/*land*/, 2/*ior*/, 4/*lor*/, 2/*ixor*/, 4/*lxor*/, 0/*iinc*/,
            1/*i2l*/, 1/*i2f*/, 1/*i2d*/, 2/*l2i*/, 2/*l2f*/, 2/*l2d*/, 1/*f2i*/, 1/*f2l*/,
            1/*f2d*/, 2/*d2i*/, 2/*d2l*/, 2/*d2f*/, 1/*i2b*/, 1/*i2c*/, 1/*i2s*/,
            4/*lcmp*/, 2/*fcmpl*/, 2/*fcmpg*/, 4/*dcmpl*/, 4/*dcmpg*/, 1/*ifeq*/, 1/*ifne*/,
            1/*iflt*/, 1/*ifge*/, 1/*ifgt*/, 1/*ifle*/, 2/*if_icmpeq*/, 2/*if_icmpne*/, 2/*if_icmplt*/,
            2 /*if_icmpge*/, 2/*if_icmpgt*/, 2/*if_icmple*/, 2/*if_acmpeq*/, 2/*if_acmpne*/,
            0/*goto*/, 0/*jsr*/, 0/*ret*/, 1/*tableswitch*/, 1/*lookupswitch*/, 1/*ireturn*/,
            2/*lreturn*/, 1/*freturn*/, 2/*dreturn*/, 1/*areturn*/, 0/*return*/, 0/*getstatic*/,
            UNPREDICTABLE/*putstatic*/, 1/*getfield*/, UNPREDICTABLE/*putfield*/,
            UNPREDICTABLE/*invokevirtual*/, UNPREDICTABLE/*invokespecial*/,
            UNPREDICTABLE/*invokestatic*/,
            UNPREDICTABLE/*invokeinterface*/, UNPREDICTABLE/*invokedynamic*/, 0/*new*/, 1/*newarray*/, 1/*anewarray*/,
            1/*arraylength*/, 1/*athrow*/, 1/*checkcast*/, 1/*instanceof*/, 1/*monitorenter*/,
            1/*monitorexit*/, 0/*wide*/, UNPREDICTABLE/*multianewarray*/, 1/*ifnull*/, 1/*ifnonnull*/,
            0/*goto_w*/, 0/*jsr_w*/, 0/*breakpoint*/, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNPREDICTABLE/*impdep1*/, UNPREDICTABLE/*impdep2*/
            // endregion
    };

    /**
     *
     * @param index
     * @return Number of words consumed on operand f_stack
     */
    public static int getConsumeStack(final int index) {
        return CONSUME_STACK[index];
    }

    /**
     * Number of words produced onto operand f_stack by instructions.
     * Indexed by opcode.  CONSUME_STACK[DALOAD] = number of words
     * consumed from the f_stack by a daload opcode.
     */
    private static final int[] PRODUCE_STACK = {
            // region PRODUCE_STACK
            0/*nop*/, 1/*aconst_null*/, 1/*iconst_m1*/, 1/*iconst_0*/, 1/*iconst_1*/,
            1/*iconst_2*/, 1/*iconst_3*/, 1/*iconst_4*/, 1/*iconst_5*/, 2/*lconst_0*/,
            2/*lconst_1*/, 1/*fconst_0*/, 1/*fconst_1*/, 1/*fconst_2*/, 2/*dconst_0*/,
            2/*dconst_1*/, 1/*bipush*/, 1/*sipush*/, 1/*ldc*/, 1/*ldc_w*/, 2/*ldc2_w*/, 1/*iload*/,
            2/*lload*/, 1/*fload*/, 2/*dload*/, 1/*aload*/, 1/*iload_0*/, 1/*iload_1*/, 1/*iload_2*/,
            1/*iload_3*/, 2/*lload_0*/, 2/*lload_1*/, 2/*lload_2*/, 2/*lload_3*/, 1/*fload_0*/,
            1/*fload_1*/, 1/*fload_2*/, 1/*fload_3*/, 2/*dload_0*/, 2/*dload_1*/, 2/*dload_2*/,
            2/*dload_3*/, 1/*aload_0*/, 1/*aload_1*/, 1/*aload_2*/, 1/*aload_3*/, 1/*iaload*/,
            2/*laload*/, 1/*faload*/, 2/*daload*/, 1/*aaload*/, 1/*baload*/, 1/*caload*/, 1/*saload*/,
            0/*istore*/, 0/*lstore*/, 0/*fstore*/, 0/*dstore*/, 0/*astore*/, 0/*istore_0*/,
            0/*istore_1*/, 0/*istore_2*/, 0/*istore_3*/, 0/*lstore_0*/, 0/*lstore_1*/,
            0/*lstore_2*/, 0/*lstore_3*/, 0/*fstore_0*/, 0/*fstore_1*/, 0/*fstore_2*/,
            0/*fstore_3*/, 0/*dstore_0*/, 0/*dstore_1*/, 0/*dstore_2*/, 0/*dstore_3*/,
            0/*astore_0*/, 0/*astore_1*/, 0/*astore_2*/, 0/*astore_3*/, 0/*iastore*/, 0/*lastore*/,
            0/*fastore*/, 0/*dastore*/, 0/*aastore*/, 0/*bastore*/, 0/*castore*/, 0/*sastore*/,
            0/*pop*/, 0/*pop2*/, 2/*dup*/, 3/*dup_x1*/, 4/*dup_x2*/, 4/*dup2*/, 5/*dup2_x1*/,
            6/*dup2_x2*/, 2/*swap*/, 1/*iadd*/, 2/*ladd*/, 1/*fadd*/, 2/*dadd*/, 1/*isub*/, 2/*lsub*/,
            1/*fsub*/, 2/*dsub*/, 1/*imul*/, 2/*lmul*/, 1/*fmul*/, 2/*dmul*/, 1/*idiv*/, 2/*ldiv*/,
            1/*fdiv*/, 2/*ddiv*/, 1/*irem*/, 2/*lrem*/, 1/*frem*/, 2/*drem*/, 1/*ineg*/, 2/*lneg*/,
            1/*fneg*/, 2/*dneg*/, 1/*ishl*/, 2/*lshl*/, 1/*ishr*/, 2/*lshr*/, 1/*iushr*/, 2/*lushr*/,
            1/*iand*/, 2/*land*/, 1/*ior*/, 2/*lor*/, 1/*ixor*/, 2/*lxor*/,
            0/*iinc*/, 2/*i2l*/, 1/*i2f*/, 2/*i2d*/, 1/*l2i*/, 1/*l2f*/, 2/*l2d*/, 1/*f2i*/,
            2/*f2l*/, 2/*f2d*/, 1/*d2i*/, 2/*d2l*/, 1/*d2f*/,
            1/*i2b*/, 1/*i2c*/, 1/*i2s*/, 1/*lcmp*/, 1/*fcmpl*/, 1/*fcmpg*/,
            1/*dcmpl*/, 1/*dcmpg*/, 0/*ifeq*/, 0/*ifne*/, 0/*iflt*/, 0/*ifge*/, 0/*ifgt*/, 0/*ifle*/,
            0/*if_icmpeq*/, 0/*if_icmpne*/, 0/*if_icmplt*/, 0/*if_icmpge*/, 0/*if_icmpgt*/,
            0/*if_icmple*/, 0/*if_acmpeq*/, 0/*if_acmpne*/, 0/*goto*/, 1/*jsr*/, 0/*ret*/,
            0/*tableswitch*/, 0/*lookupswitch*/, 0/*ireturn*/, 0/*lreturn*/, 0/*freturn*/,
            0/*dreturn*/, 0/*areturn*/, 0/*return*/, UNPREDICTABLE/*getstatic*/, 0/*putstatic*/,
            UNPREDICTABLE/*getfield*/, 0/*putfield*/, UNPREDICTABLE/*invokevirtual*/,
            UNPREDICTABLE/*invokespecial*/, UNPREDICTABLE/*invokestatic*/,
            UNPREDICTABLE/*invokeinterface*/, UNPREDICTABLE/*invokedynamic*/, 1/*new*/, 1/*newarray*/, 1/*anewarray*/,
            1/*arraylength*/, 1/*athrow*/, 1/*checkcast*/, 1/*instanceof*/, 0/*monitorenter*/,
            0/*monitorexit*/, 0/*wide*/, 1/*multianewarray*/, 0/*ifnull*/, 0/*ifnonnull*/,
            0/*goto_w*/, 1/*jsr_w*/, 0/*breakpoint*/, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNPREDICTABLE/*impdep1*/, UNPREDICTABLE/*impdep2*/
            // endregion
    };

    /**
     *
     * @param index
     * @return Number of words produced onto operand f_stack
     */
    public static int getProduceStack(final int index) {
        return PRODUCE_STACK[index];
    }
    // endregion
}
