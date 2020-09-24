package lsieun.classfile.attrs.annotation;


import lsieun.classfile.ConstantPool;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;

public final class ClassElementValue extends ElementValue {
    public final int class_info_index;

    public ClassElementValue(ByteDashboard bd, final ConstantPool cp) {
        super(bd);

        this.class_info_index = bd.readUnsignedShort();

        this.value = cp.getConstantString(class_info_index, CPConst.CONSTANT_Utf8);
    }

    @Override
    public String stringifyValue() {
        return this.value;
    }
}
