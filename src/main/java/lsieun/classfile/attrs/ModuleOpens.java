package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public class ModuleOpens {
    public final int opens_index;
    public final int opens_flags;
    public final int opens_to_count;
    public final int[] opens_to_index;

    public ModuleOpens(ByteDashboard bd, ConstantPool cp) {
        this.opens_index = bd.readUnsignedShort();
        this.opens_flags = bd.readUnsignedShort();
        this.opens_to_count = bd.readUnsignedShort();
        this.opens_to_index = new int[opens_to_count];
        for (int i = 0; i < opens_to_count; i++) {
            this.opens_to_index[i] = bd.readUnsignedShort();
        }
    }
}
