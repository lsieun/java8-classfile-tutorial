package run;

import lsieun.classfile.Attributes;
import lsieun.classfile.ClassFile;
import lsieun.classfile.ConstantPool;
import lsieun.classfile.FieldInfo;
import lsieun.utils.ConstantPoolUtils;
import lsieun.utils.FieldUtils;
import lsieun.utils.FileUtils;
import lsieun.utils.ReadUtils;
import lsieun.vs.AttributeStandardVisitor;
import lsieun.vs.Visitor;

public class I_Attributes_Field {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";
        String name_and_type = "intValue:I";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        FieldInfo field_info = FieldUtils.findField(classfile, name_and_type);

        ConstantPool cp = classfile.constant_pool;
        ConstantPoolUtils.print(cp);

        Attributes attributes = field_info.attributes;
        Visitor v = new AttributeStandardVisitor(cp);
        attributes.accept(v);
    }
}
