package lsieun.classfile.attrs.annotation;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public class ElementValuePair {
    public final int element_name_index;
    public final ElementValue value;

    public ElementValuePair(ByteDashboard bd, ConstantPool cp) {
        this.element_name_index = bd.readUnsignedShort();
        this.value = ElementValue.readElementValue(bd, cp);
    }
}
