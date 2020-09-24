package lsieun.classfile.cp;

import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class ConstantDouble extends Constant {
    public final Double doubleValue;

    public ConstantDouble(ByteDashboard bd) {
        super(CPConst.CONSTANT_Double);

        byte[] tag_bytes = bd.nextN(1);
        byte[] value_bytes = bd.nextN(8);

        this.doubleValue = ByteUtils.toDouble(value_bytes);
        super.value = String.valueOf(this.doubleValue);
        super.bytes = ByteUtils.concatenate(tag_bytes, value_bytes);
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantDouble(this);
    }

}
