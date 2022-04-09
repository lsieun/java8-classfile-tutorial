package lsieun.cst;

public class CPConst {
    public static final byte CONSTANT_Utf8               = 1;
    public static final byte CONSTANT_Integer            = 3;
    public static final byte CONSTANT_Float              = 4;
    public static final byte CONSTANT_Long               = 5;
    public static final byte CONSTANT_Double             = 6;
    public static final byte CONSTANT_Class              = 7;
    public static final byte CONSTANT_Fieldref           = 9;
    public static final byte CONSTANT_String             = 8;
    public static final byte CONSTANT_Methodref          = 10;
    public static final byte CONSTANT_InterfaceMethodref = 11;
    public static final byte CONSTANT_NameAndType        = 12;
    public static final byte CONSTANT_MethodHandle       = 15;
    public static final byte CONSTANT_MethodType         = 16;
    public static final byte CONSTANT_Dynamic            = 17;
    public static final byte CONSTANT_InvokeDynamic      = 18;
    public static final byte CONSTANT_Module             = 19;
    public static final byte CONSTANT_Package            = 20;

    /**
     * The names of the types of entries in a constant pool.
     * Use getConstantName instead
     */
    private static final String[] CONSTANT_NAMES = {
            "", "CONSTANT_Utf8", "", "CONSTANT_Integer",
            "CONSTANT_Float", "CONSTANT_Long", "CONSTANT_Double",
            "CONSTANT_Class", "CONSTANT_String", "CONSTANT_Fieldref",
            "CONSTANT_Methodref", "CONSTANT_InterfaceMethodref",
            "CONSTANT_NameAndType", "", "", "CONSTANT_MethodHandle",
            "CONSTANT_MethodType", "CONSTANT_Dynamic", "CONSTANT_InvokeDynamic",
            "CONSTANT_Module", "CONSTANT_Package"};

    /**
     *
     * @param index
     * @return the CONSTANT_NAMES entry at the given index
     */
    public static String getConstantName(final int index) {
        return CONSTANT_NAMES[index];
    }
}

