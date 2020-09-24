package lsieun.classfile.attrs.annotation.type;

import lsieun.utils.ByteDashboard;

public class OffsetTarget {
    public final int offset;

    public OffsetTarget(ByteDashboard bd) {
        this.offset = bd.readUnsignedShort();
    }
}
