package lsieun.classfile.cp;

import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class ConstantString extends Constant {
    public final int string_index;

    ConstantString(ByteDashboard bd) {
        super(CPConst.CONSTANT_String);

        byte[] tag_bytes = bd.nextN(1);
        byte[] string_index_bytes = bd.nextN(2);

        this.string_index = ByteUtils.bytesToInt(string_index_bytes);
        super.value = "#" + string_index;
        super.bytes = ByteUtils.concatenate(tag_bytes, string_index_bytes);
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantString(this);
    }

}
