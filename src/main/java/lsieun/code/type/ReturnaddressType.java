package lsieun.code.type;

import lsieun.cst.TypeConst;
import lsieun.code.Instruction;

/**
 * Returnaddress, the type JSR or JSR_W instructions push upon the f_stack.
 */
public class ReturnaddressType extends Type {

    public static final ReturnaddressType NO_TARGET = new ReturnaddressType();
    private Instruction returnTarget;

    /**
     * A Returnaddress [that doesn't know where to return to].
     */
    private ReturnaddressType() {
        super(TypeConst.T_ADDRESS, "<return address>");
    }


    /**
     * Creates a ReturnaddressType object with a target.
     */
    public ReturnaddressType(final Instruction returnTarget) {
        super(TypeConst.T_ADDRESS, "<return address targeting " + returnTarget + ">");
        this.returnTarget = returnTarget;
    }


    /**
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode() {
        if (returnTarget == null) {
            return 0;
        }
        return returnTarget.hashCode();
    }


    /**
     * Returns if the two Returnaddresses refer to the same target.
     */
    @Override
    public boolean equals(final Object rat) {
        if (!(rat instanceof ReturnaddressType)) {
            return false;
        }
        final ReturnaddressType that = (ReturnaddressType) rat;
        if (this.returnTarget == null || that.returnTarget == null) {
            return that.returnTarget == this.returnTarget;
        }
        return that.returnTarget.equals(this.returnTarget);
    }


    /**
     * @return the target of this ReturnaddressType
     */
    public Instruction getTarget() {
        return returnTarget;
    }
}
