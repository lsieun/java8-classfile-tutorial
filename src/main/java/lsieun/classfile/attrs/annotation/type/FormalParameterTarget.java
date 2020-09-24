package lsieun.classfile.attrs.annotation.type;

import lsieun.utils.ByteDashboard;

public class FormalParameterTarget {
    public final int formal_parameter_index;

    public FormalParameterTarget(ByteDashboard bd) {
        this.formal_parameter_index = bd.readUnsignedByte();
    }
}
