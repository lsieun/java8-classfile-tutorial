package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class NestHost extends AttributeInfo {
    public final int host_class_index;

    public NestHost(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.host_class_index = bd.readUnsignedShort();
    }

    @Override
    public void accept(Visitor v) {
        v.visitNestHost(this);
    }
}
