package lsieun.classfile.cp;

import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class ConstantFloat extends Constant {
    public final Float floatValue;

    ConstantFloat(ByteDashboard bd) {
        super(CPConst.CONSTANT_Float);

        byte[] tag_bytes = bd.nextN(1);
        byte[] value_bytes = bd.nextN(4);

        this.floatValue = ByteUtils.toFloat(value_bytes);
        super.value = String.valueOf(this.floatValue);
        super.bytes = ByteUtils.concatenate(tag_bytes, value_bytes);
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantFloat(this);
    }
}
