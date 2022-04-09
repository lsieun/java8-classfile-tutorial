package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public class ModuleRequires {
    public final int requires_index;
    public final int requires_flags;
    public final int requires_version_index;

    public ModuleRequires(ByteDashboard bd, ConstantPool cp) {
        this.requires_index = bd.readUnsignedShort();
        this.requires_flags = bd.readUnsignedShort();
        this.requires_version_index = bd.readUnsignedShort();
    }
}
