package lsieun.utils;

import lsieun.classfile.*;
import lsieun.classfile.attrs.AttributeInfo;
import lsieun.classfile.attrs.Code;

import java.util.ArrayList;
import java.util.List;

public class MethodUtils {
    // 接收方法名、签名，来找到具体的方法
    public static MethodInfo findMethod(ClassFile classFile, String nameAndType) {
        Methods methods = classFile.methods;
        return findMethod(methods, nameAndType);
    }

    public static MethodInfo findMethod(Methods methods, String nameAndType) {
        if (StringUtils.isBlank(nameAndType)) return null;

        MethodInfo[] entries = methods.entries;
        for (MethodInfo item : entries) {
            String value = item.value;
            if (nameAndType.equals(value)) {
                return item;
            }
        }

        System.out.println("Method DOES NOT EXIST: " + nameAndType);
        displayAvailableMethods(methods);
        return null;
    }

    public static void displayAvailableMethods(ClassFile classFile) {
        Methods methods = classFile.methods;
        displayAvailableMethods(methods);
    }

    public static void displayAvailableMethods(Methods methods) {
        MethodInfo[] entries = methods.entries;
        if (entries != null && entries.length > 0) {
            System.out.println("\nAvailable Methods:");
            for (MethodInfo item : entries) {
                Attributes attributes = item.attributes;
                String attrNames = AttributeUtils.getAttributeNames(attributes);

                String codeAttrs = "";
                AttributeInfo codeAttribute = AttributeUtils.findAttribute(attributes, "Code");
                if (codeAttribute != null) {
                    Code code = (Code) codeAttribute;
                    codeAttrs = AttributeUtils.getAttributeNames(code.attributes);
                }

                String format = "    Method='%s', AccessFlags='%s', Attrs='%s' CodeAttrs='%s'";
                String line = String.format(format, item.value, item.getAccessFlagsString(), attrNames, codeAttrs);
                System.out.println(line);
            }
        }
    }

    public static String getMethodNames(Methods methods) {
        MethodInfo[] entries = methods.entries;
        List<String> list = new ArrayList<>();
        for (MethodInfo item : entries) {
            String value = item.value;
            list.add(value);
        }
        return StringUtils.list2str(list, ", ");
    }

    public static void print(MethodInfo method_info, ConstantPool cp) {
        final int name_index = method_info.name_index;
        final int descriptor_index = method_info.descriptor_index;

        String name = cp.getConstant(name_index).value;
        String descriptor = cp.getConstant(descriptor_index).value;
        String line = String.format("Method %s:%s", name, descriptor);
        System.out.println(line);
    }
}
