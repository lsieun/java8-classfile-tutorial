package lsieun.code.type;

import lsieun.cst.TypeConst;

/**
 * This class represents an uninitialized object type; see The Java
 * Virtual Machine Specification, Second Edition, page 147: 4.9.4 for
 * more details.
 */
public class UninitializedObjectType extends ReferenceType {
    /** The "initialized" version. */
    private final ObjectType initialized;

    /** Creates a new instance. */
    public UninitializedObjectType(final ObjectType t) {
        super(TypeConst.T_UNKNOWN, "UninitializedObject<"+t.getClassName()+">");
        initialized = t;
    }

    /**
     * Returns the ObjectType of the same class as the one of the uninitialized object
     * represented by this UninitializedObjectType instance.
     */
    public ObjectType getInitialized() {
        return initialized;
    }

    /** @return a hash code value for the object.
     */
    @Override
    public int hashCode() { return initialized.hashCode(); }

    /**
     * Returns true on equality of this and o.
     * Equality means the ObjectType instances of "initialized"
     * equal one another in this and the o instance.
     *
     */
    @Override
    public boolean equals(final Object obj) {
        if (! (obj instanceof UninitializedObjectType)) {
            return false;
        }
        return initialized.equals(((UninitializedObjectType)obj).initialized);
    }
}
