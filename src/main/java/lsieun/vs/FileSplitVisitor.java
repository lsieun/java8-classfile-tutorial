package lsieun.vs;

import lsieun.classfile.*;
import lsieun.classfile.attrs.AttributeInfo;
import lsieun.classfile.cp.Constant;
import lsieun.cst.CPConst;
import lsieun.utils.ByteUtils;
import lsieun.utils.FileUtils;

import java.io.File;

public class FileSplitVisitor extends DefaultVisitor {
    public final File dirFile;

    public FileSplitVisitor(String dir_path) {
        this.dirFile = new File(dir_path);
        FileUtils.clear(dirFile);
        FileUtils.mkdirs(dirFile);
    }

    // region ClassFile
    @Override
    public void visitClassFile(ClassFile obj) {
        visitMagicNumber(obj.magic_number);
        visitCompilerVersion(obj.compiler_version);
        visitConstantPool(obj.constant_pool);
        visitClassInfo(obj.class_info);
        visitFields(obj.fields);
        visitMethods(obj.methods);
        visitAttributes(obj.attributes);
    }

    @Override
    public void visitMagicNumber(MagicNumber obj) {
        File file = new File(dirFile, "A_MagicNumber.clz");
        FileUtils.writeBytes(file.getAbsolutePath(), obj.bytes);
    }

    @Override
    public void visitCompilerVersion(CompilerVersion obj) {
        File file = new File(dirFile, "B_CompilerVersion.clz");
        FileUtils.writeBytes(file.getAbsolutePath(), obj.bytes);
    }

    @Override
    public void visitConstantPool(ConstantPool obj) {
        byte[] cp_count_bytes = ByteUtils.toBytes(obj.count, 2);
        File file = new File(dirFile, "C_Count_ConstantPool.clz");
        FileUtils.writeBytes(file.getAbsolutePath(), cp_count_bytes);

        Constant[] entries = obj.entries;
        for (int i = 0; i < entries.length; i++) {
            Constant entry = entries[i];
            if (entry == null) {
                continue;
            }

            int tag = entry.tag;
            String cp_name = CPConst.getConstantName(tag);
            String filename = String.format("C_Item_%03d_%s.clz", entry.index, cp_name);
            File f = new File(dirFile, filename);
            FileUtils.writeBytes(f.getAbsolutePath(), entry.bytes);
        }
    }

    @Override
    public void visitClassInfo(ClassInfo obj) {
        File file = new File(dirFile, "D_ClassInfo.clz");
        FileUtils.writeBytes(file.getAbsolutePath(), obj.bytes);
    }

    @Override
    public void visitFields(Fields obj) {
        byte[] count_bytes = ByteUtils.toBytes(obj.fields_count, 2);
        File file = new File(dirFile, "E_Count_Fields.clz");
        FileUtils.writeBytes(file.getAbsolutePath(), count_bytes);

        FieldInfo[] entries = obj.entries;
        for (int i = 0; i < entries.length; i++) {
            FieldInfo entry = entries[i];
            String field_name = entry.name;
            String filename = String.format("E_Item_%03d_%s.clz", i, field_name);
            File f = new File(dirFile, filename);
            FileUtils.writeBytes(f.getAbsolutePath(), entry.bytes);
        }
    }

    @Override
    public void visitMethods(Methods obj) {
        byte[] count_bytes = ByteUtils.toBytes(obj.methods_count, 2);
        File file = new File(dirFile, "F_Count_Methods.clz");
        FileUtils.writeBytes(file.getAbsolutePath(), count_bytes);

        MethodInfo[] entries = obj.entries;
        for (int i = 0; i < entries.length; i++) {
            MethodInfo entry = entries[i];
            String method_name = entry.name.replaceAll("<", "").replaceAll(">", "");
            String filename = String.format("F_Item_%03d_%s.clz", i, method_name);
            File f = new File(dirFile, filename);
            FileUtils.writeBytes(f.getAbsolutePath(), entry.bytes);
        }
    }

    @Override
    public void visitAttributes(Attributes obj) {
        byte[] count_bytes = ByteUtils.toBytes(obj.attributes_count, 2);
        File file = new File(dirFile, "G_Count_Attributes.clz");
        FileUtils.writeBytes(file.getAbsolutePath(), count_bytes);

        AttributeInfo[] entries = obj.entries;
        for (int i = 0; i < entries.length; i++) {
            AttributeInfo entry = entries[i];
            String method_name = entry.name;
            String filename = String.format("G_Item_%03d_%s.clz", i, method_name);
            File f = new File(dirFile, filename);
            FileUtils.writeBytes(f.getAbsolutePath(), entry.bytes);
        }
    }
    // endregion
}
