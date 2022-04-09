package lsieun.vs;

import lsieun.classfile.*;
import lsieun.classfile.attrs.AttributeInfo;
import lsieun.classfile.cp.Constant;
import lsieun.cst.AccessConst;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.HexUtils;

import java.util.Formatter;

public class ClassFileStandardVisitor extends DefaultVisitor {
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
        for (Constant item : entries) {
            if (item == null) continue;
            item.accept(this);
        }
    }

    @Override
    public void visitConstant(Constant obj) {
        String line = String.format("    |%03d| %s {Value='%s', HexCode='%s'}",
                obj.index,
                CPConst.getConstantName(obj.tag),
                obj.value,
                obj.hex());
        System.out.println(line);
    }

    @Override
    public void visitClassInfo(ClassInfo obj) {
        byte[] bytes = obj.bytes;
        ByteDashboard bd = new ByteDashboard(bytes);
        String hexCode = obj.hex();
        int access_flags = obj.access_flags;
        int this_class = obj.this_class;
        int super_class = obj.super_class;
        int interfaces_count = obj.interfaces_count;
        int[] interfaces = obj.interfaces;

        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("class_info='%s'%n", hexCode);

        String format = "    %s='%s' (%s)%n";
        fm.format(format, "access_flags", HexUtils.toHex(bd.nextN(2)), AccessConst.getClassAccessFlagsString(access_flags));
        fm.format(format, "this_class", HexUtils.toHex(bd.nextN(2)), "#" + this_class);
        fm.format(format, "super_class", HexUtils.toHex(bd.nextN(2)), "#" + super_class);
        fm.format(format, "interfaces_count", HexUtils.toHex(bd.nextN(2)), interfaces_count);
        fm.format(format, "interfaces", HexUtils.toHex(bd.nextN(2 * interfaces_count)), array2str(interfaces));
        System.out.print(sb);
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
        for (int i = 0; i < entries.length; i++) {
            FieldInfo item = entries[i];
            if (item == null) continue;

            byte[] bytes = item.bytes;
            ByteDashboard bd = new ByteDashboard(bytes);

            StringBuilder sb = new StringBuilder();
            Formatter fm = new Formatter(sb);
            fm.format("|%03d| %s%n", i, item.value);
            fm.format("HexCode: %s%n", item.hex());

            byte[] access_flags_bytes = bd.nextN(2);
            byte[] name_index_bytes = bd.nextN(2);
            byte[] descriptor_index_bytes = bd.nextN(2);
            byte[] attributes_count_bytes = bd.nextN(2);
            fm.format("access_flags='%s'(%s)%n", HexUtils.toHex(access_flags_bytes), item.getAccessFlagsString());
            fm.format("name_index='%s'(#%s)%n", HexUtils.toHex(name_index_bytes), item.name_index);
            fm.format("descriptor_index='%s'(#%s)%n", HexUtils.toHex(descriptor_index_bytes), item.descriptor_index);
            fm.format("attributes_count='%s'(%s)%n", HexUtils.toHex(attributes_count_bytes), item.attributes.attributes_count);
            for (int j = 0; j < item.attributes.attributes_count; j++) {
                AttributeInfo entry = item.attributes.entries[j];
                fm.format("--->%s=%s%n", entry.name, entry.hex());
            }
            System.out.println(sb);
        }
    }

    @Override
    public void visitMethods(Methods obj) {
        int count = obj.methods_count;
        MethodInfo[] entries = obj.entries;

        String countLine = String.format("methods_count='%s' (%d)", obj.hex(), count);
        System.out.println(countLine);

        System.out.println("methods");
        for (int i = 0; i < entries.length; i++) {
            MethodInfo item = entries[i];
            if (item == null) continue;

            byte[] bytes = item.bytes;
            ByteDashboard bd = new ByteDashboard(bytes);

            StringBuilder sb = new StringBuilder();
            Formatter fm = new Formatter(sb);
            fm.format("|%03d| %s%n", i, item.value);
            fm.format("HexCode: %s%n", item.hex());

            byte[] access_flags_bytes = bd.nextN(2);
            byte[] name_index_bytes = bd.nextN(2);
            byte[] descriptor_index_bytes = bd.nextN(2);
            byte[] attributes_count_bytes = bd.nextN(2);
            fm.format("access_flags    ='%s'(%s)%n", HexUtils.toHex(access_flags_bytes), item.getAccessFlagsString());
            fm.format("name_index      ='%s'(#%s)%n", HexUtils.toHex(name_index_bytes), item.name_index);
            fm.format("descriptor_index='%s'(#%s)%n", HexUtils.toHex(descriptor_index_bytes), item.descriptor_index);
            fm.format("attributes_count='%s'(%s)%n", HexUtils.toHex(attributes_count_bytes), item.attributes.attributes_count);
            for (int j = 0; j < item.attributes.attributes_count; j++) {
                AttributeInfo entry = item.attributes.entries[j];
                fm.format("--->%s=%s%n", entry.name, entry.hex());
            }
            System.out.println(sb);
        }
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
            String hexCode = item.hex();
            String attrName = item.name;
            System.out.println(String.format("--->|%03d| %s:", i, attrName));
            System.out.println("HexCode: " + hexCode);
            item.accept(this);
        }
    }

    @Override
    public void visitAttributeInfo(AttributeInfo obj) {
        byte[] bytes = obj.bytes;
        ByteDashboard bd = new ByteDashboard(bytes);
        int attribute_name_index = obj.attribute_name_index;
        int attribute_length = obj.attribute_length;

        String format = "%s='%s' (%s)%n";
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format(format, "attribute_name_index", HexUtils.toHex(bd.nextN(2)), "#" + attribute_name_index);
        fm.format(format, "attribute_length", HexUtils.toHex(bd.nextN(4)), attribute_length);
        fm.format("%s='%s'%n", "info", HexUtils.toHex(bd.nextN(attribute_length)));
        System.out.println(sb);
    }
}
