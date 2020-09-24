package lsieun.utils;


import lsieun.cst.AccessConst;

public class AccessFlagUtils {
    public static final boolean isPublic(int access_flags) {
        return (access_flags & AccessConst.ACC_PUBLIC) != 0;
    }

    public static final boolean isPrivate(int access_flags) {
        return (access_flags & AccessConst.ACC_PRIVATE) != 0;
    }

    public static final boolean isProtected(int access_flags) {
        return (access_flags & AccessConst.ACC_PROTECTED) != 0;
    }

    public static final boolean isStatic(int access_flags) {
        //return ((AccessConst.ACC_STATIC & access_flags) == AccessConst.ACC_STATIC);
        return (access_flags & AccessConst.ACC_STATIC) != 0;
    }

    public static final boolean isFinal(int access_flags) {
        return (access_flags & AccessConst.ACC_FINAL) != 0;
    }

    public static final boolean isSynchronized(int access_flags) {
        return (access_flags & AccessConst.ACC_SYNCHRONIZED) != 0;
    }

    public static final boolean isVolatile(int access_flags) {
        return (access_flags & AccessConst.ACC_VOLATILE) != 0;
    }

    public static final boolean isTransient(int access_flags) {
        return (access_flags & AccessConst.ACC_TRANSIENT) != 0;
    }

    public static final boolean isNative(int access_flags) {
        return (access_flags & AccessConst.ACC_NATIVE) != 0;
    }

    public static final boolean isInterface(int access_flags) {
        return (access_flags & AccessConst.ACC_INTERFACE) != 0;
    }

    public static final boolean isAbstract(int access_flags) {
        return (access_flags & AccessConst.ACC_ABSTRACT) != 0;
    }

    public static final boolean isStrictfp(int access_flags) {
        return (access_flags & AccessConst.ACC_STRICT) != 0;
    }

    public static final boolean isSynthetic(int access_flags) {
        return (access_flags & AccessConst.ACC_SYNTHETIC) != 0;
    }

    public static final boolean isAnnotation(int access_flags) {
        return (access_flags & AccessConst.ACC_ANNOTATION) != 0;
    }

    public static final boolean isEnum(int access_flags) {
        return (access_flags & AccessConst.ACC_ENUM) != 0;
    }

    public static final boolean isVarArgs(int access_flags) {
        return (access_flags & AccessConst.ACC_VARARGS) != 0;
    }
}
