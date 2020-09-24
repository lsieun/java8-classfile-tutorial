package run;

import lsieun.classfile.Attributes;
import lsieun.classfile.ClassFile;
import lsieun.classfile.ConstantPool;
import lsieun.utils.ConstantPoolUtils;
import lsieun.utils.FileUtils;
import lsieun.utils.ReadUtils;
import lsieun.vs.*;

public class I_Attributes_ClassFile {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);

        ConstantPool cp = classfile.constant_pool;
        ConstantPoolUtils.print(cp);

        Attributes attributes = classfile.attributes;
        Visitor v = new AttributeStandardVisitor(cp);
        attributes.accept(v);
    }
}
