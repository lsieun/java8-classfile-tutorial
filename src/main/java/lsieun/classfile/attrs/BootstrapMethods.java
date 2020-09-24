package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class BootstrapMethods extends AttributeInfo {
    public final int num_bootstrap_methods;
    public final BootstrapMethod[] entries;

    public BootstrapMethods(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.num_bootstrap_methods = bd.readUnsignedShort();
        this.entries = new BootstrapMethod[num_bootstrap_methods];
        for (int i = 0; i < num_bootstrap_methods; i++) {
            this.entries[i] = new BootstrapMethod(bd);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitBootstrapMethods(this);
    }
}
