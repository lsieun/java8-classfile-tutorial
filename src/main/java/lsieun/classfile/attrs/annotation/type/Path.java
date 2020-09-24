package lsieun.classfile.attrs.annotation.type;

import lsieun.utils.ByteDashboard;

public class Path {
    public final int type_path_kind;
    public final int type_argument_index;

    public Path(ByteDashboard bd) {
        this.type_path_kind = bd.readUnsignedByte();
        this.type_argument_index = bd.readUnsignedByte();
    }
}
