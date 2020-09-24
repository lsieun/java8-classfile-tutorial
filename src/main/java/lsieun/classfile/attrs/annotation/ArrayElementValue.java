package lsieun.classfile.attrs.annotation;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public final class ArrayElementValue extends ElementValue {
    public final int num_values;
    public final ElementValue[] entries;

    public ArrayElementValue(ByteDashboard bd, final ConstantPool cp) {
        super(bd);

        this.num_values = bd.readUnsignedShort();
        this.entries = new ElementValue[num_values];

        for (int i = 0; i < num_values; i++) {
            ElementValue item = ElementValue.readElementValue(bd, cp);
            this.entries[i] = item;
        }

        this.value = "//FIXME: 这里value不对啊";
    }

    @Override
    public String stringifyValue() {
        return this.value;
    }
}
