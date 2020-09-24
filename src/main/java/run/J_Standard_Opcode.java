package run;

import lsieun.classfile.ClassFile;
import lsieun.classfile.ConstantPool;
import lsieun.classfile.MethodInfo;
import lsieun.classfile.attrs.Code;
import lsieun.code.Instruction;
import lsieun.code.utils.InstructionChain;
import lsieun.code.visitors.OpcodeReadVisitor;
import lsieun.code.visitors.StandardOpcodeVisitor;
import lsieun.utils.*;

public class J_Standard_Opcode {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";
        String name_and_type = "test:()V";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        process(classfile, name_and_type);
    }

    public static void process(ClassFile classfile, String name_and_type) {
        // constant_pool
        ConstantPool cp = classfile.constant_pool;
        ConstantPoolUtils.print(cp);
        System.out.println("=== === ===  === === ===  === === ===");

        // method_info
        MethodInfo method_info = MethodUtils.findMethod(classfile, name_and_type);
        MethodUtils.print(method_info, cp);
        System.out.println("=== === ===  === === ===  === === ===");

        // Code Attribute
        Code code_attr = AttributeUtils.findCodeAttribute(method_info);
        byte[] code_bytes = code_attr.code;
        System.out.println("HexCode:");
        System.out.println(HexUtils.format(code_bytes, HexFormat.FORMAT_FF_SPACE_FF_16));
        System.out.println("=== === ===  === === ===  === === ===");

        OpcodeReadVisitor rv = new OpcodeReadVisitor(code_bytes);
        InstructionChain chain = rv.getInstructionChain();
        StandardOpcodeVisitor v = new StandardOpcodeVisitor(cp, code_bytes);
        Instruction current = chain.start;
        while (current != null) {
            current.accept(v);
            current = current.next;
        }
    }
}
