package lsieun.classfile.cp;

import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class ConstantInvokeDynamic extends Constant {
    public final int bootstrap_method_attr_index;
    public final int name_and_type_index;

    public ConstantInvokeDynamic(ByteDashboard bd) {
        super(CPConst.CONSTANT_InvokeDynamic);
        super.bytes = bd.peekN(5);

        byte[] tag_bytes = bd.nextN(1);
        byte[] bootstrap_method_attr_index_bytes = bd.nextN(2);
        byte[] name_and_type_index_bytes = bd.nextN(2);

        this.bootstrap_method_attr_index = ByteUtils.bytesToInt(bootstrap_method_attr_index_bytes);
        this.name_and_type_index = ByteUtils.bytesToInt(name_and_type_index_bytes);

        super.value = String.format("#%d:#%d", bootstrap_method_attr_index, name_and_type_index);
        super.bytes = ByteUtils.concatenate(tag_bytes, bootstrap_method_attr_index_bytes, name_and_type_index_bytes);
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantInvokeDynamic(this);
    }
}
