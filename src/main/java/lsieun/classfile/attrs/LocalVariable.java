package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;

public class LocalVariable implements Comparable<LocalVariable> {
    public final int start_pc; // Range in which the variable is valid
    public final int length;
    public final int name_index; // Index in constant pool of variable name
    public final int descriptor_index; // Index of variable signature
    public final int index; /* Variable is `index'th local variable on
     * this d_method's frame.
     */
    public final String nameAndType;

    public LocalVariable(ByteDashboard bd, ConstantPool cp) {
        this.start_pc = bd.readUnsignedShort();
        this.length = bd.readUnsignedShort();
        this.name_index = bd.readUnsignedShort();
        this.descriptor_index = bd.readUnsignedShort();
        this.index = bd.readUnsignedShort();

        String name = cp.getConstantString(name_index, CPConst.CONSTANT_Utf8);
        String descriptor = cp.getConstantString(descriptor_index, CPConst.CONSTANT_Utf8);
        this.nameAndType = name + ":" + descriptor;
    }

    @Override
    public int compareTo(LocalVariable another) {
        return (this.index - another.index);
    }
}
