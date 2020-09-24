package lsieun.code.type;

import lsieun.cst.TypeConst;
import lsieun.code.utils.TypeUtils;
import lsieun.code.utils.Utility;

/**
 * Abstract super class for all possible java types, namely cst types
 * such as int, object types like String and array types, e.g. int[]<br/><br/>
 *
 * <p>
 * 我对Type的理解是这样的：
 * </p>
 * <p>
 * （1）Java language有自己的类型，例如int/float/Object
 * </p>
 * <p>
 * （2）ClassFile对于类型有自己内部的表示，例如I/F/Ljava/lang/Object;
 * </p>
 * <p>
 * （3）Type类，虽然自己是一个表达“数据类型”的类，但这并不是它的最终目的，
 * 它的目的是将Java language和ClassFile的数据类型进行“中间”连接。
 * 举一个例子：先将美元兑换成银子，再用银子兑换成欧元，那么银子就起到“中间”连接的作用。
 * </p>
 */
public abstract class Type {

    private final byte type;

    private String signature; // signature for the type

    protected Type(final byte t, final String s) {
        type = t;
        signature = s;
    }

    /**
     * @return type as defined in Constants
     */
    public byte getType() {
        return type;
    }

    /**
     * @return signature for given type.
     */
    public String getSignature() {
        return signature;
    }

    /*
     * Currently only used by the ArrayType constructor.
     * The signature has a complicated dependency on other parameter
     * so it's tricky to do it in a call to the super ctor.
     */
    public void setSignature(final String signature) {
        this.signature = signature;
    }

    /**
     * @return f_stack size of this type (2 for long and double, 0 for void, 1 otherwise)
     */
    public int getSize() {
        switch (type) {
            case TypeConst.T_DOUBLE:
            case TypeConst.T_LONG:
                return 2;
            case TypeConst.T_VOID:
                return 0;
            default:
                return 1;
        }
    }

    /**
     * @return Type string, e.g. `int[]'
     */
    @Override
    public String toString() {
        return ((this.equals(TypeUtils.NULL) || (type >= TypeConst.T_UNKNOWN))) ? signature : Utility
                .signatureToString(signature, false);
    }


}
