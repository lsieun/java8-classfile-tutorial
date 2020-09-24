package lsieun.classfile.attrs;

import lsieun.classfile.Attributes;
import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class Code extends AttributeInfo {
    public int max_stack;
    public int max_locals;
    public int code_length;
    public byte[] code;
    public int exception_table_length;
    public ExceptionTable[] exception_table_array;
    public Attributes attributes;

    public Code(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        // 第一部分
        this.max_stack = bd.readUnsignedShort();
        this.max_locals = bd.readUnsignedShort();
        this.code_length = bd.readInt();
        this.code = bd.nextN(code_length);

        // 第二部分
        byte[] exception_table_length_bytes = bd.nextN(2);
        this.exception_table_length = ByteUtils.bytesToInt(exception_table_length_bytes, 0);
        this.exception_table_array = new ExceptionTable[exception_table_length];
        for (int i = 0; i < exception_table_length; i++) {
            ExceptionTable item = new ExceptionTable(bd, cp);
            this.exception_table_array[i] = item;
        }

        // 第三部分
        this.attributes = new Attributes(bd, cp);
    }

    @Override
    public void accept(Visitor v) {
        v.visitCode(this);
    }
}
