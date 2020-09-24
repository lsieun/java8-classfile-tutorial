package lsieun.code.type;

import lsieun.cst.JVMConst;
import lsieun.cst.TypeConst;
import lsieun.code.utils.TypeUtils;

/**
 * Denotes array type, such as int[][]
 */
public class ArrayType extends ReferenceType {
    private int dimensions;
    private Type basic_type;

    /**
     * Convenience constructor for array type, e.g. int[]
     *
     * @param type array type, e.g. T_INT
     */
    public ArrayType(final byte type, final int dimensions) {
        this(TypeUtils.getType(type), dimensions);
    }

    /**
     * Convenience constructor for reference array type, e.g. Object[]
     *
     * @param class_name complete name of class (java.lang.String, e.g.)
     */
    public ArrayType(final String class_name, final int dimensions) {
        this(TypeUtils.getInstance(class_name), dimensions);
    }

    /**
     * Constructor for array of given type
     *
     * @param type type of array (may be an array itself)
     */
    public ArrayType(final Type type, final int dimensions) {
        super(TypeConst.T_ARRAY, "<dummy>");
        if ((dimensions < 1) || (dimensions > JVMConst.MAX_BYTE)) {
            throw new RuntimeException("Invalid number of dimensions: " + dimensions);
        }
        switch (type.getType()) {
            case TypeConst.T_ARRAY:
                final ArrayType array = (ArrayType) type;
                this.dimensions = dimensions + array.dimensions;
                basic_type = array.basic_type;
                break;
            case TypeConst.T_VOID:
                throw new RuntimeException("Invalid type: void[]");
            default: // Basic type or reference
                this.dimensions = dimensions;
                basic_type = type;
                break;
        }
        final StringBuilder buf = new StringBuilder();
        for (int i = 0; i < this.dimensions; i++) {
            buf.append('[');
        }
        buf.append(basic_type.getSignature());
        super.setSignature(buf.toString());
    }

    /** @return number of dimensions of array
     */
    public int getDimensions() {
        return dimensions;
    }

    /**
     * @return basic type of array, i.e., for int[][][] the basic type is int
     */
    public Type getBasicType() {
        return basic_type;
    }

    /**
     * @return element type of array, i.e., for int[][][] the element type is int[][]
     */
    public Type getElementType() {
        if (dimensions == 1) {
            return basic_type;
        }
        return new ArrayType(basic_type, dimensions - 1);
    }
}
