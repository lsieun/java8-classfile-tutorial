package lsieun.code.utils;

import java.util.ArrayList;
import java.util.List;

import lsieun.cst.TypeConst;
import lsieun.code.type.*;

public class TypeUtils {

    private static final ThreadLocal<Integer> consumed_chars = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return Integer.valueOf(0);
        }
    };//int consumed_chars=0; // Remember position in string, see getArgumentTypes

    // region private static
    private static int unwrap(final ThreadLocal<Integer> tl) {
        return tl.get().intValue();
    }


    private static void wrap(final ThreadLocal<Integer> tl, final int value) {
        tl.set(Integer.valueOf(value));
    }
    // endregion

    /**
     * Predefined constants
     */
    public static final BasicType VOID = new BasicType(TypeConst.T_VOID);
    public static final BasicType BOOLEAN = new BasicType(TypeConst.T_BOOLEAN);
    public static final BasicType INT = new BasicType(TypeConst.T_INT);
    public static final BasicType SHORT = new BasicType(TypeConst.T_SHORT);
    public static final BasicType BYTE = new BasicType(TypeConst.T_BYTE);
    public static final BasicType LONG = new BasicType(TypeConst.T_LONG);
    public static final BasicType DOUBLE = new BasicType(TypeConst.T_DOUBLE);
    public static final BasicType FLOAT = new BasicType(TypeConst.T_FLOAT);
    public static final BasicType CHAR = new BasicType(TypeConst.T_CHAR);
    public static final ObjectType OBJECT = new ObjectType("java.lang.Object");
    public static final ObjectType CLASS = new ObjectType("java.lang.Class");
    public static final ObjectType STRING = new ObjectType("java.lang.String");
    public static final ObjectType STRINGBUFFER = new ObjectType("java.lang.StringBuffer");
    public static final ObjectType THROWABLE = new ObjectType("java.lang.Throwable");
    public static final Type[] NO_ARGS = new Type[0]; // EMPTY, so immutable
    public static final Type[] STR_ARGS = new Type[]{new ArrayType("java.lang.String", 1)};
    public static final Type NULL = new ReferenceType() {};

    public static final ObjectType TOP = new ObjectType("top");
    public static final Type UNKNOWN = new Type(TypeConst.T_UNKNOWN, "<unknown>") {
    };
    public static final Type THIS = new ObjectType("this");
    public static final Type UninitializedThis = new ObjectType("uninitialized_this");

    public static BasicType getType(final byte type) {
        switch (type) {
            case TypeConst.T_VOID:
                return TypeUtils.VOID;
            case TypeConst.T_BOOLEAN:
                return TypeUtils.BOOLEAN;
            case TypeConst.T_BYTE:
                return TypeUtils.BYTE;
            case TypeConst.T_SHORT:
                return TypeUtils.SHORT;
            case TypeConst.T_CHAR:
                return TypeUtils.CHAR;
            case TypeConst.T_INT:
                return TypeUtils.INT;
            case TypeConst.T_LONG:
                return TypeUtils.LONG;
            case TypeConst.T_DOUBLE:
                return TypeUtils.DOUBLE;
            case TypeConst.T_FLOAT:
                return TypeUtils.FLOAT;
            default:
                throw new RuntimeException("Invalid type: " + type);
        }
    }

    // region Type-->str(ClassFile)

    /**
     * Convert type to Java d_method signature, e.g. int[] f(java.lang.String x)
     * becomes (Ljava/lang/String;)[I
     *
     * @param return_type what the d_method returns
     * @param arg_types   what are the argument types
     * @return d_method signature for given type(s).
     */
    public static String getMethodSignature(final Type return_type, final Type[] arg_types) {
        final StringBuilder buf = new StringBuilder("(");
        if (arg_types != null) {
            for (final Type arg_type : arg_types) {
                buf.append(arg_type.getSignature());
            }
        }
        buf.append(')');
        buf.append(return_type.getSignature());
        return buf.toString();
    }
    // endregion

    // region str(ClassFile)-->Type

    public static ObjectType getInstance(final String class_name) {
        return new ObjectType(class_name);
    }

    /**
     * Convert signature to a Type object.
     *
     * @param signature signature string such as Ljava/lang/String;
     * @return type object
     */
    public static Type getType(final String signature) throws StringIndexOutOfBoundsException {
        final byte type = Utility.typeOfSignature(signature);
        if (type <= TypeConst.T_VOID) {
            //corrected concurrent private static c_field acess
            wrap(consumed_chars, 1);
            return getType(type);
        } else if (type == TypeConst.T_ARRAY) {
            int dim = 0;
            do { // Count dimensions
                dim++;
            } while (signature.charAt(dim) == '[');
            // Recurse, but just once, if the signature is ok
            final Type t = getType(signature.substring(dim));
            //corrected concurrent private static c_field acess
            //  consumed_chars += dim; // update counter - is replaced by
            final int _temp = unwrap(consumed_chars) + dim;
            wrap(consumed_chars, _temp);
            return new ArrayType(t, dim);
        } else { // type == T_REFERENCE
            // Utility.signatureToString understands how to parse
            // generic types.
            final String parsedSignature = Utility.signatureToString(signature, false);
            wrap(consumed_chars, parsedSignature.length() + 2); // "Lblabla;" `L' and `;' are removed
            return TypeUtils.getInstance(parsedSignature.replace('/', '.'));
        }
    }

    /**
     * Convert return value of a d_method (signature) to a Type object.
     *
     * @param signature signature string such as (Ljava/lang/String;)V
     * @return return type
     */
    public static Type getReturnType(final String signature) {
        try {
            // Read return type after `)'
            final int index = signature.lastIndexOf(')') + 1;
            return getType(signature.substring(index));
        } catch (final StringIndexOutOfBoundsException e) { // Should never occur
            throw new RuntimeException("Invalid d_method signature: " + signature, e);
        }
    }

    /**
     * Convert arguments of a d_method (signature) to an array of Type objects.
     *
     * @param signature signature string such as (Ljava/lang/String;)V
     * @return array of argument types
     */
    public static Type[] getArgumentTypes(final String signature) {
        final List<Type> vec = new ArrayList<>();
        int index;
        Type[] types;
        try { // Read all declarations between for `(' and `)'
            if (signature.charAt(0) != '(') {
                throw new RuntimeException("Invalid d_method signature: " + signature);
            }
            index = 1; // current string position
            while (signature.charAt(index) != ')') {
                vec.add(getType(signature.substring(index)));
                //corrected concurrent private static c_field acess
                index += unwrap(consumed_chars); // update position
            }
        } catch (final StringIndexOutOfBoundsException e) { // Should never occur
            throw new RuntimeException("Invalid d_method signature: " + signature, e);
        }
        types = new Type[vec.size()];
        vec.toArray(types);
        return types;
    }

    // endregion

    // region str(ClassFile)-->size(int)

    public static int getReturnTypeSize(final String methodSignature) {
        final int index = methodSignature.lastIndexOf(')') + 1;
        String returnSignature = methodSignature.substring(index);
        int sizeAndCharNum = getTypeSizeAndCharNum(returnSignature);
        return size(sizeAndCharNum);
    }

    public static int getArgumentTypesSize(final String signature) {
        int res = 0;
        int index;
        try { // Read all declarations between for `(' and `)'
            if (signature.charAt(0) != '(') {
                throw new RuntimeException("Invalid d_method signature: " + signature);
            }
            index = 1; // current string position
            while (signature.charAt(index) != ')') {
                final int coded = getTypeSizeAndCharNum(signature.substring(index));
                res += size(coded);
                index += consumed(coded);
            }
        } catch (final StringIndexOutOfBoundsException e) { // Should never occur
            throw new RuntimeException("Invalid d_method signature: " + signature, e);
        }
        return res;
    }

    /**
     * GOOD_CODE: 这个“方法的实现思路”很不错，它将“两个int值”合并成“一个int值”进行返回。
     * <br/><br/>
     * <p>
     * 这个方法的返回值（return value），其实包含了两个部分数据：
     * </p><br/>
     * <p>
     * 第一部分数据，就是这个Type究竟占用几个slot，它的取值只能是1或2。
     * 例如，对于int、float、Object，它所占用的slot的大小就是1个；
     * 而对于long、double，它所占用的slot大小就是2个。
     * </p><br/>
     * <p>
     * 第二部分数据，就是这个Signature的字符长度。
     * 比如说，I、F、D、J，它的长度是1；对于Ljava/lang/String;，它的长度是18。
     * </p><br/>
     * <p>
     * 这个方法精妙的地方在于：第一部分数据的取值范围就是1和2,那么这部分只占2个bit就可以进行存储了，
     * 第二部分的数据在进行存储的时候，只要向左移动2个bit就可以了。
     * </p>
     *
     * @param signature
     * @return
     * @throws StringIndexOutOfBoundsException
     */
    public static int getTypeSizeAndCharNum(final String signature) throws StringIndexOutOfBoundsException {
        final byte type = Utility.typeOfSignature(signature);
        if (type <= TypeConst.T_VOID) {
            return encode(getType(type).getSize(), 1);
        } else if (type == TypeConst.T_ARRAY) {
            int dim = 0;
            do { // Count dimensions
                dim++;
            } while (signature.charAt(dim) == '[');
            // Recurse, but just once, if the signature is ok
            final int consumed = consumed(getTypeSizeAndCharNum(signature.substring(dim)));
            return encode(1, dim + consumed);
        } else { // type == T_REFERENCE
            final int index = signature.indexOf(';'); // Look for closing `;'
            if (index < 0) {
                throw new RuntimeException("Invalid signature: " + signature);
            }
            return encode(1, index + 1);
        }
    }
    // endregion

    // region auxiliary methods

    public static int size(final int coded) {
        return coded & 3;
    }

    static int consumed(final int coded) {
        return coded >> 2;
    }

    static int encode(final int size, final int consumed) {
        return consumed << 2 | size;
    }

    // endregion

    /**
     * Convert runtime java.lang.Class to BCEL Type object.
     *
     * @param cl Java class
     * @return corresponding Type object
     */
    public static Type getType(final Class<?> cl) {
        if (cl == null) {
            throw new IllegalArgumentException("Class must not be null");
        }
        /* That's an amzingly easy case, because getName() returns
         * the signature. That's what we would have liked anyway.
         */
        if (cl.isArray()) {
            return getType(cl.getName());
        } else if (cl.isPrimitive()) {
            if (cl == Integer.TYPE) {
                return INT;
            } else if (cl == Void.TYPE) {
                return VOID;
            } else if (cl == Double.TYPE) {
                return DOUBLE;
            } else if (cl == Float.TYPE) {
                return FLOAT;
            } else if (cl == Boolean.TYPE) {
                return BOOLEAN;
            } else if (cl == Byte.TYPE) {
                return BYTE;
            } else if (cl == Short.TYPE) {
                return SHORT;
            } else if (cl == Byte.TYPE) {
                return BYTE;
            } else if (cl == Long.TYPE) {
                return LONG;
            } else if (cl == Character.TYPE) {
                return CHAR;
            } else {
                throw new IllegalStateException("Ooops, what primitive type is " + cl);
            }
        } else { // "Real" class
            return TypeUtils.getInstance(cl.getName());
        }
    }
}
