package run;

import lsieun.classfile.ClassFile;
import lsieun.classfile.ClassInfo;
import lsieun.classfile.ConstantPool;
import lsieun.utils.ConstantPoolUtils;
import lsieun.utils.FileUtils;
import lsieun.utils.ReadUtils;
import lsieun.vs.*;

public class F_ClassInfo {
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

        ClassInfo class_info = classfile.class_info;
        Visitor class_info_visitor = new ClassFileStandardVisitor();
        class_info.accept(class_info_visitor);
    }
}
