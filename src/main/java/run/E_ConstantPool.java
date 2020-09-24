package run;

import lsieun.classfile.ClassFile;
import lsieun.classfile.ConstantPool;
import lsieun.utils.FileUtils;
import lsieun.utils.ReadUtils;
import lsieun.vs.*;

public class E_ConstantPool {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        ConstantPool cp = classfile.constant_pool;
        //cp.simplify();
        Visitor v = new ClassFileStandardVisitor();
        cp.accept(v);
    }
}
