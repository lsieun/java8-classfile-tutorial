package lsieun.vs;

import lsieun.classfile.*;
import lsieun.classfile.attrs.AttributeInfo;
import lsieun.classfile.cp.Constant;
import lsieun.cst.AccessConst;
import lsieun.cst.CPConst;
import lsieun.utils.AttributeUtils;
import lsieun.utils.ByteDashboard;
import lsieun.utils.HexUtils;

import java.util.Arrays;
import java.util.Formatter;

public class ClassFileSimpleVisitor extends DefaultVisitor {
    @Override
    public void visitClassFile(ClassFile obj) {
        obj.magic_number.accept(this);
        obj.compiler_version.accept(this);
        obj.constant_pool.accept(this);
        obj.class_info.accept(this);
        obj.fields.accept(this);
        obj.methods.accept(this);
        obj.attributes.accept(this);
    }

    @Override
    public void visitMagicNumber(MagicNumber obj) {
        String line = String.format("magic_number='%s'", obj.hex());
        System.out.println(line);
    }

    @Override
    public void visitCompilerVersion(CompilerVersion obj) {
        String line = String.format("version='%s'", obj.hex());
        System.out.println(line);
    }

    @Override
    public void visitConstantPool(ConstantPool obj) {
        int count = obj.count;
        Constant[] entries = obj.entries;

        String count_line = String.format("constant_pool_count='%s' (%d)", obj.hex(), count);
        System.out.println(count_line);

        System.out.println("constant_pool");
        for(Constant item : entries) {
            if(item == null) continue;
            item.accept(this);
        }
    }

    @Override
    public void visitConstant(Constant obj) {
        String line = String.format("    |%03d| %s {Value='%s'}",
                obj.index,
                CPConst.getConstantName(obj.tag),
                obj.value);
        System.out.println(line);
    }

    @Override
    public void visitClassInfo(ClassInfo obj) {
        String hexCode = obj.hex();
        int access_flags = obj.access_flags;
        int this_class = obj.this_class;
        int super_class = obj.super_class;
        int interfaces_count = obj.interfaces_count;
        int[] interfaces = obj.interfaces;

        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("class_info='%s'%n", hexCode);

        String format = "    %s=%s%n";
        fm.format(format, "access_flags", AccessConst.getClassAccessFlagsString(access_flags));
        fm.format(format, "this_class", "#" + this_class);
        fm.format(format, "super_class", "#" + super_class);
        fm.format(format, "interfaces_count", interfaces_count);
        fm.format(format, "interfaces", array2str(interfaces));
        System.out.print(sb.toString());
    }

    public static String array2str(int[] array) {
        int length = array.length;
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("[");
        for (int i = 0; i < length - 1; i++) {
            int item = array[i];
            fm.format("#%s,", item);
        }
        if (length > 0) {
            fm.format("#%s", array[length - 1]);
        }
        fm.format("]");
        return sb.toString();
    }

    @Override
    public void visitFields(Fields obj) {
        int count = obj.fields_count;
        FieldInfo[] entries = obj.entries;

        String countLine = String.format("fields_count='%s' (%d)", obj.hex(), count);
        System.out.println(countLine);

        System.out.println("fields");
        for(FieldInfo item : entries) {
            if(item == null) continue;
            item.accept(this);
        }
    }

    @Override
    public void visitFieldInfo(FieldInfo obj) {
        Attributes attributes = obj.attributes;
        String attrNames = AttributeUtils.getAttributeNames(attributes);

        String line = String.format("    FieldInfo {Value='%s', AccessFlags='%s', Attrs='%s'}",
                obj.value,
                obj.getAccessFlagsString(),
                attrNames);
        System.out.println(line);
    }

    @Override
    public void visitMethods(Methods obj) {
        int count = obj.methods_count;
        MethodInfo[] entries = obj.entries;

        String countLine = String.format("methods_count='%s' (%d)", obj.hex(), count);
        System.out.println(countLine);

        System.out.println("methods");
        for(MethodInfo item : entries) {
            if(item == null) continue;
            item.accept(this);
        }
    }

    @Override
    public void visitMethodInfo(MethodInfo obj) {
        Attributes attributes = obj.attributes;
        String attrNames = AttributeUtils.getAttributeNames(attributes);

        String line = String.format("    MethodInfo {Value='%s', AccessFlags='%s', Attrs='%s'}",
                obj.value,
                obj.getAccessFlagsString(),
                attrNames);
        System.out.println(line);
    }

    private String simplify(String hex_str) {
        if (hex_str.length() > 16) {
            return hex_str.substring(0,16) + "...";
        }
        return hex_str;
    }

    @Override
    public void visitAttributes(Attributes obj) {
        int count = obj.attributes_count;
        AttributeInfo[] entries = obj.entries;

        String countLine = String.format("attributes_count='%s' (%d)", obj.hex(), count);
        System.out.println(countLine);

        System.out.println("attributes");
        for (int i = 0; i < count; i++) {
            AttributeInfo item = entries[i];
            item.accept(this);
        }
    }

    @Override
    public void visitAttributeInfo(AttributeInfo obj) {
        String line = String.format("    %s {HexCode='%s'}",
                obj.name,
                simplify(obj.hex()));
        System.out.println(line);
    }
}
