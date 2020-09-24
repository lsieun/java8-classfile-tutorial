package lsieun.classfile.attrs;

import lsieun.utils.ByteDashboard;

public class BootstrapMethod {
    public final int bootstrap_method_ref;
    public final int num_bootstrap_arguments;
    public final int[] bootstrap_arguments;

    public BootstrapMethod(ByteDashboard bd) {
        this.bootstrap_method_ref = bd.readUnsignedShort();
        this.num_bootstrap_arguments = bd.readUnsignedShort();
        this.bootstrap_arguments = new int[num_bootstrap_arguments];
        for (int i=0; i<num_bootstrap_arguments; i++) {
            this.bootstrap_arguments[i] = bd.readUnsignedShort();
        }
    }
}
