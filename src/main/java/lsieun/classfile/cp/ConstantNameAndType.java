package lsieun.classfile.cp;

import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class ConstantNameAndType extends Constant {
    public final int name_index;
    public final int descriptor_index;

    ConstantNameAndType(ByteDashboard bd) {
        super(CPConst.CONSTANT_NameAndType);

        byte[] tag_bytes = bd.nextN(1);
        byte[] name_index_bytes = bd.nextN(2);
        byte[] descriptor_index_bytes = bd.nextN(2);

        this.name_index = ByteUtils.bytesToInt(name_index_bytes);
        this.descriptor_index = ByteUtils.bytesToInt(descriptor_index_bytes);

        super.value = "#" + name_index + ":#" + descriptor_index;
        super.bytes = ByteUtils.concatenate(tag_bytes, name_index_bytes, descriptor_index_bytes);
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantNameAndType(this);
    }

}
