package lsieun.vs;

import lsieun.classfile.*;
import lsieun.classfile.attrs.AttributeInfo;
import lsieun.classfile.cp.Constant;

public class ClassFileRawVisitor extends DefaultVisitor {
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
        System.out.println("magic");
        System.out.println(obj.hex());
        System.out.println();
    }

    @Override
    public void visitCompilerVersion(CompilerVersion obj) {
        System.out.println("compiler_version");
        System.out.println(obj.hex());
        System.out.println();
    }

    @Override
    public void visitConstantPool(ConstantPool obj) {
        System.out.println("constant_pool_count");
        System.out.println(obj.hex());
        System.out.println();

        System.out.println("constant_pool");
        for (Constant item : obj.entries) {
            if (item == null) continue;
            String line = String.format("|%03d| %s", item.index, item.hex());
            System.out.println(line);
        }
        System.out.println();
    }

    @Override
    public void visitClassInfo(ClassInfo obj) {
        System.out.println("class_info");
        System.out.println(obj.hex());
        System.out.println();
    }

    @Override
    public void visitFields(Fields obj) {
        System.out.println("fields_count");
        System.out.println(obj.hex());
        System.out.println();

        System.out.println("fields");
        for (int i = 0; i < obj.fields_count; i++) {
            FieldInfo item = obj.entries[i];
            String line = String.format("|%03d| %s", i, item.hex());
            System.out.println(line);
        }
        System.out.println();
    }

    @Override
    public void visitMethods(Methods obj) {
        System.out.println("methods_count");
        System.out.println(obj.hex());
        System.out.println();

        System.out.println("methods");
        for (int i = 0; i < obj.methods_count; i++) {
            MethodInfo item = obj.entries[i];
            String line = String.format("|%03d| %s", i, item.hex());
            System.out.println(line);
        }
        System.out.println();
    }

    @Override
    public void visitAttributes(Attributes obj) {
        System.out.println("attributes_count");
        System.out.println(obj.hex());
        System.out.println();

        System.out.println("attributes");
        for (int i = 0; i < obj.attributes_count; i++) {
            AttributeInfo item = obj.entries[i];
            String line = String.format("|%03d| %s", i, item.hex());
            System.out.println(line);
        }
        System.out.println();
    }
}
