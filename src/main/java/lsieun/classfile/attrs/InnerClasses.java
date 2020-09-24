package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public final class InnerClasses extends AttributeInfo {
    public final int number_of_classes;
    public final InnerClass[] entries;

    public InnerClasses(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.number_of_classes = bd.readUnsignedShort();
        this.entries = new InnerClass[number_of_classes];

        for (int i = 0; i < number_of_classes; i++) {
            InnerClass item = new InnerClass(bd, cp);
            this.entries[i] = item;
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitInnerClasses(this);
    }
}
