package run;

import lsieun.classfile.Attributes;
import lsieun.classfile.ClassFile;
import lsieun.classfile.ConstantPool;
import lsieun.classfile.MethodInfo;
import lsieun.classfile.attrs.Code;
import lsieun.utils.*;
import lsieun.vs.AttributeStandardVisitor;
import lsieun.vs.Visitor;

public class I_Attributes_Code {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";
        String name_and_type = "test:()V";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        MethodInfo methodInfo = MethodUtils.findMethod(classfile, name_and_type);
        Code code_attr = AttributeUtils.findCodeAttribute(methodInfo);

        ConstantPool cp = classfile.constant_pool;
        ConstantPoolUtils.print(cp);

        System.out.println("=== === ===  === === ===  === === ===");
        Attributes attributes = code_attr.attributes;
        Visitor v = new AttributeStandardVisitor(cp);
        attributes.accept(v);
    }
}
