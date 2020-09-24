package run;

import lsieun.classfile.Attributes;
import lsieun.classfile.ClassFile;
import lsieun.classfile.ConstantPool;
import lsieun.classfile.MethodInfo;
import lsieun.classfile.attrs.Code;
import lsieun.classfile.attrs.LocalVariableTable;
import lsieun.classfile.attrs.LocalVariableTypeTable;
import lsieun.code.Instruction;
import lsieun.code.utils.InstructionChain;
import lsieun.code.visitors.StandardOpcodeVisitor;
import lsieun.code.visitors.OpcodeReadVisitor;
import lsieun.utils.*;
import lsieun.vs.*;

public class K_Code_Locals {
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
        HumanReadableVisitor human_readable_visitor = new HumanReadableVisitor(cp);
        code_attr.accept(human_readable_visitor);
        System.out.println("=== === ===  === === ===  === === ===");

        // opcode
        byte[] code_bytes = code_attr.code;
        OpcodeReadVisitor rv = new OpcodeReadVisitor(code_bytes);
        InstructionChain chain = rv.getInstructionChain();

        StandardOpcodeVisitor v = new StandardOpcodeVisitor(cp, code_bytes);
        Instruction current = chain.start;
        while (current != null) {
            current.accept(v);
            current = current.next;
        }
        System.out.println("=== === ===  === === ===  === === ===");

        // attributes
        Attributes attributes = code_attr.attributes;
        LocalVariableTable localVariableTable = (LocalVariableTable) AttributeUtils.findAttribute(attributes, "LocalVariableTable");
        if (localVariableTable != null) {
            localVariableTable.accept(human_readable_visitor);
        }

        LocalVariableTypeTable localVariableTypeTable = (LocalVariableTypeTable) AttributeUtils.findAttribute(attributes, "LocalVariableTypeTable");
        if (localVariableTypeTable != null) {
            localVariableTypeTable.accept(human_readable_visitor);
        }
    }
}
