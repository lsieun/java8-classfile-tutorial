package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public class ModuleExports {
    public final int exports_index;
    public final int exports_flags;
    public final int exports_to_count;
    public final int[] exports_to_index;

    public ModuleExports(ByteDashboard bd, ConstantPool cp) {
        this.exports_index = bd.readUnsignedShort();
        this.exports_flags = bd.readUnsignedShort();
        this.exports_to_count = bd.readUnsignedShort();
        this.exports_to_index = new int[exports_to_count];
        for (int i = 0; i < exports_to_count; i++) {
            this.exports_to_index[i] = bd.readUnsignedShort();
        }
    }
}
