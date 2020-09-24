package lsieun.classfile.attrs.annotation.type;

import lsieun.utils.ByteDashboard;

public class ThrowsTarget {
    public final int throws_type_index;

    public ThrowsTarget(ByteDashboard bd) {
        this.throws_type_index = bd.readUnsignedShort();
    }
}
