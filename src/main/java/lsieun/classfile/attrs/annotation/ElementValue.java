package lsieun.classfile.attrs.annotation;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public abstract class ElementValue {
    public static final byte STRING = 's';
    public static final byte ENUM_CONSTANT = 'e';
    public static final byte CLASS = 'c';
    public static final byte ANNOTATION = '@';
    public static final byte ARRAY = '[';
    public static final byte PRIMITIVE_INT = 'I';
    public static final byte PRIMITIVE_BYTE = 'B';
    public static final byte PRIMITIVE_CHAR = 'C';
    public static final byte PRIMITIVE_DOUBLE = 'D';
    public static final byte PRIMITIVE_FLOAT = 'F';
    public static final byte PRIMITIVE_LONG = 'J';
    public static final byte PRIMITIVE_SHORT = 'S';
    public static final byte PRIMITIVE_BOOLEAN = 'Z';

    public final int type;
    public String value;

    public ElementValue(final ByteDashboard bd) {
        this.type = bd.readByte();
    }

    public abstract String stringifyValue();

    public String toShortString() {
        return stringifyValue();
    }

    @Override
    public String toString() {
        return stringifyValue();
    }

    public static ElementValue readElementValue(final ByteDashboard bd, final ConstantPool cp) {
        final byte tag = bd.peek();

        switch (tag) {
            case PRIMITIVE_BYTE:
            case PRIMITIVE_CHAR:
            case PRIMITIVE_DOUBLE:
            case PRIMITIVE_FLOAT:
            case PRIMITIVE_INT:
            case PRIMITIVE_LONG:
            case PRIMITIVE_SHORT:
            case PRIMITIVE_BOOLEAN:
            case STRING:
                return new SimpleElementValue(bd, cp);
            case ENUM_CONSTANT:
                return new EnumElementValue(bd, cp);
            case CLASS:
                return new ClassElementValue(bd, cp);
            case ANNOTATION:
                return new AnnotationElementValue(bd, cp);
            case ARRAY:
                return new ArrayElementValue(bd, cp);

            default:
                throw new RuntimeException("Unexpected element value kind in annotation: " + tag);
        }
    }
}
