package lsieun.classfile.cp;

import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public class ConstantPackage extends Constant {
    public final int name_index;

    public ConstantPackage(ByteDashboard bd) {
        super(CPConst.CONSTANT_Package);

        byte[] tag_bytes = bd.nextN(1);
        byte[] name_index_bytes = bd.nextN(2);
        super.bytes = ByteUtils.concatenate(tag_bytes, name_index_bytes);

        this.name_index = ByteUtils.bytesToInt(name_index_bytes);
        super.value = "#" + this.name_index;
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantPackage(this);
    }
}
