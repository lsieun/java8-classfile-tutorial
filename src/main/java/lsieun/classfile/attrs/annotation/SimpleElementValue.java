package lsieun.classfile.attrs.annotation;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public final class SimpleElementValue extends ElementValue {
    public final int const_value_index;

    public SimpleElementValue(ByteDashboard bd, final ConstantPool cp) {
        super(bd);

        this.const_value_index = bd.readUnsignedShort();
        this.value = cp.getConstant(const_value_index).value;
    }

    @Override
    public String stringifyValue() {
        return this.value;
    }
}
