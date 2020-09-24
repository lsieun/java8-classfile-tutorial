package lsieun.classfile.attrs.annotation;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public final class AnnotationElementValue extends ElementValue {
    // For annotation element values, this is the annotation
    public final AnnotationEntry annotation_entry;

    public AnnotationElementValue(ByteDashboard bd, ConstantPool cp) {
        super(bd);

        this.annotation_entry = new AnnotationEntry(bd, cp);
    }

    @Override
    public String stringifyValue() {
        return null;
    }
}
