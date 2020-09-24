package lsieun.vs;

import lsieun.classfile.ConstantPool;
import lsieun.classfile.attrs.*;
import lsieun.utils.HexUtils;

import java.util.Arrays;
import java.util.Formatter;

public class HumanReadableVisitor extends DefaultVisitor {
    private final ConstantPool constant_pool;

    public HumanReadableVisitor(ConstantPool constant_pool) {
        this.constant_pool = constant_pool;
    }

    @Override
    public void visitCode(Code obj) {
        int max_stack = obj.max_stack;
        int max_locals = obj.max_locals;
        int code_length = obj.code_length;
        byte[] code_bytes = obj.code;
        ExceptionTable[] exception_table_array = obj.exception_table_array;

        String format = "%s = %s%n";
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format(format, "max_stack", max_stack);
        fm.format(format, "max_locals", max_locals);
        fm.format(format, "code_length", code_length);
        fm.format(format, "code", HexUtils.toHex(code_bytes));

        if (exception_table_array != null && exception_table_array.length > 0) {
            fm.format("Exception Table:%n");
            fm.format("from    to  target  type%n");
            String exception_format = "%4d  %4d  %6d  %s%n";
            for (ExceptionTable item : exception_table_array) {
                int start_pc = item.start_pc;
                int end_pc = item.end_pc;
                int handler_pc = item.handler_pc;
                int catch_type = item.catch_type;


                String catch_type_value = (catch_type == 0) ? "All Exceptions(catch_type = 0)" : constant_pool.getConstant(catch_type).value;
                fm.format(exception_format, start_pc, end_pc, handler_pc, catch_type_value);
            }
        }
        System.out.print(sb.toString());
    }

    @Override
    public void visitLocalVariableTable(LocalVariableTable obj) {
        LocalVariable[] entries = obj.entries;
        Arrays.sort(entries);
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("LocalVariableTable:%n");
        fm.format("index  start_pc  length  name_and_type%n");
        String format = "%5d  %8d  %6d  %s:%s%n";
        for (LocalVariable entry : entries) {
            int index = entry.index;
            int start_pc = entry.start_pc;
            int length = entry.length;
            int name_index = entry.name_index;
            int descriptor_index = entry.descriptor_index;

            String name = constant_pool.getConstant(name_index).value;
            String descriptor = constant_pool.getConstant(descriptor_index).value;
            fm.format(format, index, start_pc, length, name, descriptor);
        }
        System.out.println(sb.toString());
    }

    @Override
    public void visitLocalVariableTypeTable(LocalVariableTypeTable obj) {
        LocalVariableType[] entries = obj.entries;
        Arrays.sort(entries);
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("LocalVariableTypeTable:%n");
        fm.format("index  start_pc  length  name_and_type%n");
        String format = "%5d  %8d  %6d  %s:%s%n";
        for (LocalVariableType entry : entries) {
            int index = entry.index;
            int start_pc = entry.start_pc;
            int length = entry.length;
            int name_index = entry.name_index;
            int signature_index = entry.signature_index;

            String name = constant_pool.getConstant(name_index).value;
            String signature = constant_pool.getConstant(signature_index).value;
            fm.format(format, index, start_pc, length, name, signature);

        }
        System.out.println(sb.toString());
    }
}
