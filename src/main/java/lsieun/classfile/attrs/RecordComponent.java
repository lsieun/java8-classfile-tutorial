package lsieun.classfile.attrs;

import lsieun.classfile.Attributes;
import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;

public class RecordComponent {
    public final int name_index;
    public final int descriptor_index;
    public final Attributes attributes;

    public RecordComponent(ByteDashboard bd, ConstantPool cp) {
        this.name_index = bd.readUnsignedShort();
        this.descriptor_index = bd.readUnsignedShort();
        this.attributes = new Attributes(bd, cp);
    }
}
