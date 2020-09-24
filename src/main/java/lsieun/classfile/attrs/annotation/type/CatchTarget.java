package lsieun.classfile.attrs.annotation.type;

import lsieun.utils.ByteDashboard;

public class CatchTarget {
    public final int exception_table_index;

    public CatchTarget(ByteDashboard bd) {
        this.exception_table_index = bd.readUnsignedShort();
    }
}
