package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;

public class LocalVariableType implements Comparable<LocalVariableType> {
    public final int start_pc;
    public final int length;
    public final int name_index;
    public final int signature_index;
    public final int index;
    public final String nameAndType;

    public LocalVariableType(ByteDashboard bd, ConstantPool cp) {
        this.start_pc = bd.readUnsignedShort();
        this.length = bd.readUnsignedShort();
        this.name_index = bd.readUnsignedShort();
        this.signature_index = bd.readUnsignedShort();
        this.index = bd.readUnsignedShort();

        String name = cp.getConstantString(name_index, CPConst.CONSTANT_Utf8);
        String signature = cp.getConstantString(signature_index, CPConst.CONSTANT_Utf8);
        this.nameAndType = name + ":" + signature;
    }

    @Override
    public int compareTo(LocalVariableType another) {
        int thisIndex = this.index;
        int anotherIndex = another.index;
        return (thisIndex - anotherIndex);
    }
}
