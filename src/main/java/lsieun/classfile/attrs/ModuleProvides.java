package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public class ModuleProvides {
    public final int provides_index;
    public final int provides_with_count;
    public final int[] provides_with_index;

    public ModuleProvides(ByteDashboard bd, ConstantPool cp) {
        this.provides_index = bd.readUnsignedShort();
        this.provides_with_count = bd.readUnsignedShort();
        this.provides_with_index = new int[provides_with_count];
        for (int i = 0; i < provides_with_count; i++) {
            this.provides_with_index[i] = bd.readUnsignedShort();
        }
    }
}
