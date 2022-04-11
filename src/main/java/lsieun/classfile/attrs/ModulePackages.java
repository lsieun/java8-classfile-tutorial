package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class ModulePackages extends AttributeInfo {
    public final int package_count;
    public final int[] package_index;

    public ModulePackages(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.package_count = bd.readUnsignedShort();
        this.package_index = new int[package_count];
        for (int i = 0; i < package_count; i++) {
            this.package_index[i] = bd.readUnsignedShort();
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitModulePackages(this);
    }
}
