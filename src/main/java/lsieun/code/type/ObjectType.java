package lsieun.code.type;

import lsieun.cst.TypeConst;

/**
 * Denotes reference such as java.lang.String.
 */
public class ObjectType extends ReferenceType {
    private final String class_name; // Class name of type

    /**
     * @param class_name fully qualified class name, e.g. java.lang.String
     */
    public ObjectType(final String class_name) {
        super(TypeConst.T_OBJECT, "L" + class_name.replace('.', '/') + ";");
        this.class_name = class_name.replace('/', '.');
    }

    public String getClassName() {
        return class_name;
    }

    /**
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        return class_name.hashCode();
    }

    /**
     * @return true if both type objects refer to the same class.
     */
    @Override
    public boolean equals(final Object type) {
        return (type instanceof ObjectType)
                ? ((ObjectType) type).class_name.equals(class_name)
                : false;
    }
}
