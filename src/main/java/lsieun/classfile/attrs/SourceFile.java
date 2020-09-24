package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public final class SourceFile extends AttributeInfo {
    public final int sourcefile_index;

    public SourceFile(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);
        this.sourcefile_index = bd.readUnsignedShort();

        String value = cp.getConstantString(sourcefile_index, CPConst.CONSTANT_Utf8);
        super.value = value;
    }

    @Override
    public void accept(Visitor v) {
        v.visitSourceFile(this);
    }

}
