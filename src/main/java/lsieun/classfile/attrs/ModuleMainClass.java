package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class ModuleMainClass extends AttributeInfo {
    public final int main_class_index;

    public ModuleMainClass(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.main_class_index = bd.readUnsignedShort();
    }

    @Override
    public void accept(Visitor v) {
        v.visitModuleMainClass(this);
    }
}
