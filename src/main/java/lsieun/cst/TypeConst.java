package lsieun.cst;

public class TypeConst {
    /** Mnemonic for an illegal type. */
    public static final String ILLEGAL_TYPE   = "<illegal type>";

    public static final byte T_BOOLEAN = 4;
    public static final byte T_CHAR    = 5;
    public static final byte T_FLOAT   = 6;
    public static final byte T_DOUBLE  = 7;
    public static final byte T_BYTE    = 8;
    public static final byte T_SHORT   = 9;
    public static final byte T_INT     = 10;
    public static final byte T_LONG    = 11;
    public static final byte T_VOID      = 12; // Non-standard
    public static final byte T_ARRAY     = 13;
    public static final byte T_OBJECT    = 14;

    /** Unknown data type. */
    public static final byte T_UNKNOWN   = 15;

    /** Address data type. */
    public static final byte T_ADDRESS   = 16;

    /** The primitive type names corresponding to the T_XX constants,
     * e.g., TYPE_NAMES[T_INT] = "int"
     */
    private static final String[] TYPE_NAMES = {
            ILLEGAL_TYPE, ILLEGAL_TYPE,  ILLEGAL_TYPE, ILLEGAL_TYPE,
            "boolean", "char", "float", "double", "byte", "short", "int", "long",
            "void", "array", "object", "unknown", "address"
    };

    /**
     * The primitive type names corresponding to the T_XX constants,
     * e.g., TYPE_NAMES[T_INT] = "int"
     * @param index
     * @return the type name
     */
    public static String getTypeName(final int index) {
        return TYPE_NAMES[index];
    }

    /** The primitive class names corresponding to the T_XX constants,
     * e.g., CLASS_TYPE_NAMES[T_INT] = "java.lang.Integer"
     */
    private static final String[] CLASS_TYPE_NAMES = {
            ILLEGAL_TYPE, ILLEGAL_TYPE,  ILLEGAL_TYPE, ILLEGAL_TYPE,
            "java.lang.Boolean", "java.lang.Character", "java.lang.Float",
            "java.lang.Double", "java.lang.Byte", "java.lang.Short",
            "java.lang.Integer", "java.lang.Long", "java.lang.Void",
            ILLEGAL_TYPE, ILLEGAL_TYPE,  ILLEGAL_TYPE,  ILLEGAL_TYPE
    };

    /**
     * The primitive class names corresponding to the T_XX constants,
     * e.g., CLASS_TYPE_NAMES[T_INT] = "java.lang.Integer"
     * @param index
     * @return the class name
     */
    public static String getClassTypeName(final int index) {
        return CLASS_TYPE_NAMES[index];
    }

    /** The signature characters corresponding to primitive types,
     * e.g., SHORT_TYPE_NAMES[T_INT] = "I"
     */
    private static final String[] SHORT_TYPE_NAMES = {
            ILLEGAL_TYPE, ILLEGAL_TYPE,  ILLEGAL_TYPE, ILLEGAL_TYPE,
            "Z", "C", "F", "D", "B", "S", "I", "J",
            "V", ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE
    };

    /**
     *
     * @param index
     * @return the short type name
     */
    public static String getShortTypeName(final int index) {
        return SHORT_TYPE_NAMES[index];
    }
}
