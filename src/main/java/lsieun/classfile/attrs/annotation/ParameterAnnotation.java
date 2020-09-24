package lsieun.classfile.attrs.annotation;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public class ParameterAnnotation {
    public final int num_annotations;
    public final AnnotationEntry[] annotations;

    public ParameterAnnotation(ByteDashboard bd, ConstantPool cp) {
        this.num_annotations = bd.readUnsignedShort();
        this.annotations = new AnnotationEntry[num_annotations];

        for (int i = 0; i < num_annotations; i++) {
            AnnotationEntry item = new AnnotationEntry(bd, cp);
            this.annotations[i] = item;
        }
    }
}
