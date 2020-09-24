package lsieun.classfile.attrs.annotation;

import lsieun.classfile.ConstantPool;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;

public final class AnnotationEntry {
    public final int type_index;
    public final int num_element_value_pairs;
    public final ElementValuePair[] element_value_pair_list;
    public final String value;

    public AnnotationEntry(ByteDashboard bd, ConstantPool cp) {
        this.type_index = bd.readUnsignedShort();
        this.num_element_value_pairs = bd.readUnsignedShort();
        this.element_value_pair_list = new ElementValuePair[num_element_value_pairs];

        for (int i = 0; i < num_element_value_pairs; i++) {
            ElementValuePair item = new ElementValuePair(bd, cp);
            this.element_value_pair_list[i] = item;
        }

        String type = cp.getConstantString(type_index, CPConst.CONSTANT_Utf8);
        this.value = type;
    }
}
