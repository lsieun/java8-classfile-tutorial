package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.classfile.attrs.annotation.ElementValue;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class AnnotationDefault extends AttributeInfo {
    public final ElementValue default_value;

    public AnnotationDefault(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);
        this.default_value = ElementValue.readElementValue(bd, cp);
    }

    @Override
    public void accept(Visitor v) {
        v.visitAnnotationDefault(this);
    }
}
