package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public final class ConstantValue extends AttributeInfo {
    public final int constantvalue_index;

    public ConstantValue(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.constantvalue_index = bd.readUnsignedShort();
        this.value = cp.getConstant(constantvalue_index).value;
    }

    @Override
    public void accept(Visitor v) {
        v.visitConstantValue(this);
    }
}
