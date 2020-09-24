package lsieun.cst;

public final class JVMConst {
    /**
     * Java class file format Magic number (0xCAFEBABE)
     */
    public static final int JVM_CLASSFILE_MAGIC = 0xCAFEBABE;

    /** The name of the static initializer, also called &quot;class
     *  initialization d_method&quot; or &quot;interface initialization
     *   d_method&quot;. This is &quot;&lt;clinit&gt;&quot;.
     */
    public static final String STATIC_INITIALIZER_NAME = "<clinit>";

    /** The name of every constructor d_method in a class, also called
     * &quot;instance initialization d_method&quot;. This is &quot;&lt;init&gt;&quot;.
     */
    public static final String CONSTRUCTOR_NAME = "<init>";

    /** Maximum value for an unsigned short.
     */
    public static final int MAX_SHORT = 65535; // 2^16 - 1

    /** Maximum value for an unsigned byte.
     */
    public static final int MAX_BYTE  = 255; // 2^8 - 1

    /**
     * Maximum Constant Pool entries.
     * One of the limitations of the Java Virtual Machine.
     */
    public static final int MAX_CP_ENTRIES     = 65535;

    /**
     * Maximum code size (plus one; the code size must be LESS than this)
     * One of the limitations of the Java Virtual Machine.
     */
    public static final int MAX_CODE_SIZE      = 65536; //bytes

    /**
     * The maximum number of dimensions in an array ({@value}).
     * One of the limitations of the Java Virtual Machine.
     */
    public static final int MAX_ARRAY_DIMENSIONS = 255;

    /**
     * Check if the value can fit in a byte (signed)
     *
     * @param value the value to check
     * @return true if the value is in range
     */
    public static boolean isValidByte(final int value) {
        return value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE;
    }

    /**
     * Check if the value can fit in a short (signed)
     *
     * @param value the value to check
     * @return true if the value is in range
     */
    public static boolean isValidShort(final int value) {
        return value >= Short.MIN_VALUE && value <= Short.MAX_VALUE;
    }
}
