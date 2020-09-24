package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.classfile.attrs.annotation.type.TypeAnnotation;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class RuntimeVisibleTypeAnnotations extends AttributeInfo {
    public final int num_annotations;
    public final TypeAnnotation[] annotations;

    public RuntimeVisibleTypeAnnotations(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.num_annotations = bd.readUnsignedShort();
        this.annotations = new TypeAnnotation[num_annotations];

        for (int i = 0; i < num_annotations; i++) {
            this.annotations[i] = new TypeAnnotation(bd, cp);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitRuntimeVisibleTypeAnnotations(this);
    }
}
