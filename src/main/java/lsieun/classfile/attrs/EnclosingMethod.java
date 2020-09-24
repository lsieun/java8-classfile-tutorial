package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class EnclosingMethod extends AttributeInfo {
    public final int class_index;
    public final int method_index;

    public EnclosingMethod(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.class_index = bd.readUnsignedShort();
        this.method_index = bd.readUnsignedShort();
    }

    @Override
    public void accept(Visitor v) {
        v.visitEnclosingMethod(this);
    }
}
