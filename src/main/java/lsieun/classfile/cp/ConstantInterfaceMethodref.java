package lsieun.classfile.cp;

import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class ConstantInterfaceMethodref extends Constant implements ConstantRef {
    public int class_index;
    public int name_and_type_index;

    public ConstantInterfaceMethodref(ByteDashboard bd) {
        super(CPConst.CONSTANT_InterfaceMethodref);

        byte[] tag_bytes = bd.nextN(1);
        byte[] class_index_bytes = bd.nextN(2);
        byte[] name_and_type_index_bytes = bd.nextN(2);

        this.class_index = ByteUtils.bytesToInt(class_index_bytes);
        this.name_and_type_index = ByteUtils.bytesToInt(name_and_type_index_bytes);

        super.value = "#" + class_index + ".#" + name_and_type_index;
        super.bytes = ByteUtils.concatenate(tag_bytes, class_index_bytes, name_and_type_index_bytes);
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantInterfaceMethodref(this);
    }

    @Override
    public int getClassIndex() {
        return class_index;
    }

    @Override
    public void setClassIndex(int class_index) {
        this.class_index = class_index;
    }

    @Override
    public int getNameAndTypeIndex() {
        return name_and_type_index;
    }

    @Override
    public void setNameAndTypeIndex(int name_and_type_index) {
        this.name_and_type_index = name_and_type_index;
    }

}
