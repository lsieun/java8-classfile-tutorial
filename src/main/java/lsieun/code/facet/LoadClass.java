package lsieun.code.facet;

/**
 * Denotes that an opcode may start the process of loading and resolving
 * the referenced class in the Virtual Machine.
 */
public interface LoadClass {

//    /**
//     * Returns the ObjectType of the referenced class or interface
//     * that may be loaded and resolved.
//     *
//     * @return object type that may be loaded or null if a primitive is
//     * referenced
//     */
//    ObjectType getLoadClassType(String signature);
//
//
//    /**
//     * Returns the type associated with this opcode.
//     * LoadClass instances are always typed, but this type
//     * does not always refer to the type of the class or interface
//     * that it possibly forces to load. For example, GETFIELD would
//     * return the type of the c_field and not the type of the class
//     * where the c_field is defined.
//     * If no class is forced to be loaded, <B>null</B> is returned.
//     * An example for this is an ANEWARRAY opcode that creates
//     * an int[][].
//     */
//    Type getType(String signature);
}
