package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class PermittedSubclasses extends AttributeInfo {
    public final int number_of_classes;
    public final int[] classes;

    public PermittedSubclasses(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.number_of_classes = bd.readUnsignedShort();
        this.classes = new int[number_of_classes];
        for (int i = 0; i < number_of_classes; i++) {
            this.classes[i] = bd.readUnsignedShort();
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitPermittedSubclasses(this);
    }
}
