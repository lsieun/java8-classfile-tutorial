package lsieun.classfile;

import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class CompilerVersion extends Node {
    public final int minor_version;
    public final int major_version;

    public CompilerVersion(ByteDashboard bd) {
        byte[] minor_version_bytes = bd.nextN(2);
        byte[] major_version_bytes = bd.nextN(2);

        this.minor_version = ByteUtils.bytesToInt(minor_version_bytes);
        this.major_version = ByteUtils.bytesToInt(major_version_bytes);
        super.bytes = ByteUtils.concatenate(minor_version_bytes, major_version_bytes);
    }

    public void accept(Visitor v) {
        v.visitCompilerVersion(this);
    }

}
