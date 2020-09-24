package lsieun.cst;

import lsieun.utils.BitUtils;
import lsieun.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccessConst {
    public static final int TYPE_CLASS = 1;
    public static final int TYPE_FIELD = 2;
    public static final int TYPE_METHOD = 3;

    public static final int ACC_PUBLIC    = 0x0001;
    public static final int ACC_PRIVATE   = 0x0002;
    public static final int ACC_PROTECTED = 0x0004;
    public static final int ACC_STATIC    = 0x0008;
    public static final int ACC_FINAL     = 0x0010;
    public static final int ACC_SYNCHRONIZED = 0x0020;
    public static final int ACC_VOLATILE  = 0x0040;
    public static final int ACC_BRIDGE    = 0x0040;     // for method_info
    public static final int ACC_TRANSIENT = 0x0080;
    public static final int ACC_VARARGS   = 0x0080;     // for method_info
    public static final int ACC_NATIVE    = 0x0100;
    public static final int ACC_INTERFACE = 0x0200;
    public static final int ACC_ABSTRACT  = 0x0400;
    public static final int ACC_STRICT    = 0x0800;
    public static final int ACC_SYNTHETIC = 0x1000;
    public static final int ACC_ANNOTATION = 0x2000;
    public static final int ACC_ENUM      = 0x4000;
    public static final int ACC_MANDATED  = 0x8000;

    // Note: 0x0020 is assigned to both ACC_SUPER and ACC_SYNCHRONIZED
    // although java.lang.reflect.Modifier does not recognize ACC_SUPER.
    public static final int ACC_SUPER     = 0x0020;
    public static final int ACC_MODULE    = 0x8000;

    /**
     * The names of the access flags.
     */
    private static final String[] ACCESS_NAMES = {
            "public", "private", "protected", "static", "final", "synchronized",
            "volatile", "transient", "native", "interface", "abstract", "strictfp",
            "synthetic", "annotation", "enum"
    };

    public static final int ACCESS_NAMES_LENGTH = ACCESS_NAMES.length;

    /**
     * @param index
     * @return the ACCESS_NAMES entry at the given index
     */
    public static String getAccessName(final int index) {
        return ACCESS_NAMES[index];
    }

    public static String getClassAccessFlagsString(int accessFlags) {
        return getAccessFlagsString(accessFlags, AccessConst.TYPE_CLASS);
    }

    public static String getFieldAccessFlagsString(int accessFlags) {
        return getAccessFlagsString(accessFlags, AccessConst.TYPE_FIELD);
    }

    public static String getMethodAccessFlagsString(int accessFlags) {
        return getAccessFlagsString(accessFlags, AccessConst.TYPE_METHOD);
    }

    public static String getAccessFlagsString(int accessFlags, int type) {
        List<String> list = new ArrayList();
        if(BitUtils.hasBit(accessFlags, 1)) {
            list.add("ACC_PUBLIC");
        }
        if(BitUtils.hasBit(accessFlags, 2)) {
            list.add("ACC_PRIVATE");
        }
        if(BitUtils.hasBit(accessFlags, 3)) {
            list.add("ACC_PROTECTED");
        }
        if(BitUtils.hasBit(accessFlags, 4)) {
            list.add("ACC_STATIC");
        }
        if(BitUtils.hasBit(accessFlags, 5)) {
            list.add("ACC_FINAL");
        }
        if(BitUtils.hasBit(accessFlags, 6)) {
            if(type == AccessConst.TYPE_CLASS) {
                list.add("ACC_SUPER");
            }
            else if(type == AccessConst.TYPE_METHOD) {
                list.add("ACC_SYNCHRONIZED");
            }
        }
        if(BitUtils.hasBit(accessFlags, 7)) {
            if(type == AccessConst.TYPE_FIELD) {
                list.add("ACC_VOLATILE");
            }
            else if(type == AccessConst.TYPE_METHOD) {
                list.add("ACC_BRIDGE");
            }
        }
        if(BitUtils.hasBit(accessFlags, 8)) {
            if(type == AccessConst.TYPE_FIELD) {
                list.add("ACC_TRANSIENT");
            }
            else if(type == AccessConst.TYPE_METHOD) {
                list.add("ACC_VARARGS");
            }
        }
        if(BitUtils.hasBit(accessFlags, 9)) {
            list.add("ACC_NATIVE");
        }
        if(BitUtils.hasBit(accessFlags, 10)) {
            list.add("ACC_INTERFACE");
        }
        if(BitUtils.hasBit(accessFlags, 11)) {
            list.add("ACC_ABSTRACT");
        }
        if(BitUtils.hasBit(accessFlags, 12)) {
            list.add("ACC_STRICT");
        }
        if(BitUtils.hasBit(accessFlags, 13)) {
            list.add("ACC_SYNTHETIC");
        }
        if(BitUtils.hasBit(accessFlags, 14)) {
            list.add("ACC_ANNOTATION");
        }
        if(BitUtils.hasBit(accessFlags, 15)) {
            list.add("ACC_ENUM");
        }
        if(BitUtils.hasBit(accessFlags, 16)) {
            list.add("ACC_MODULE");
        }

        String str = StringUtils.list2str(list, "[", "]", ",");
        return str;
    }

    public static String getInnerClassAccessFlagsString(int accessFlags) {
        List<String> list = new ArrayList();
        if(BitUtils.hasBit(accessFlags, 1)) {
            list.add("ACC_PUBLIC");
        }
        if(BitUtils.hasBit(accessFlags, 2)) {
            list.add("ACC_PRIVATE");
        }
        if(BitUtils.hasBit(accessFlags, 3)) {
            list.add("ACC_PROTECTED");
        }
        if(BitUtils.hasBit(accessFlags, 4)) {
            list.add("ACC_STATIC");
        }
        if(BitUtils.hasBit(accessFlags, 5)) {
            list.add("ACC_FINAL");
        }
        if(BitUtils.hasBit(accessFlags, 10)) {
            list.add("ACC_INTERFACE");
        }
        if(BitUtils.hasBit(accessFlags, 11)) {
            list.add("ACC_ABSTRACT");
        }
        if(BitUtils.hasBit(accessFlags, 13)) {
            list.add("ACC_SYNTHETIC");
        }
        if(BitUtils.hasBit(accessFlags, 14)) {
            list.add("ACC_ANNOTATION");
        }
        if(BitUtils.hasBit(accessFlags, 15)) {
            list.add("ACC_ENUM");
        }

        String str = StringUtils.list2str(list, "[", "]", ",");
        return str;
    }

    public static String getMethodParameterAccessFlagsString(int accessFlags) {
        List<String> list = new ArrayList();
        if(BitUtils.hasBit(accessFlags, 5)) {
            list.add("ACC_FINAL");
        }
        if(BitUtils.hasBit(accessFlags, 13)) {
            list.add("ACC_SYNTHETIC");
        }
        if(BitUtils.hasBit(accessFlags, 16)) {
            list.add("ACC_MANDATED");
        }

        String str = StringUtils.list2str(list, "[", "]", ",");
        return str;
    }

    public static boolean isStatic(int accessFlags) {
        return ((ACC_STATIC & accessFlags) == ACC_STATIC);
    }
}
