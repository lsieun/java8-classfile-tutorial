package lsieun.classfile;

import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class Methods extends Node {
    public final int methods_count;
    public final MethodInfo[] entries;

    public Methods(ByteDashboard bd, ConstantPool cp) {
        byte[] methods_count_bytes = bd.nextN(2);
        this.methods_count = ByteUtils.bytesToInt(methods_count_bytes);

        this.entries = new MethodInfo[methods_count];
        for (int i = 0; i < methods_count; i++) {
            MethodInfo methodInfo = new MethodInfo(bd, cp);
            this.entries[i] = methodInfo;
        }
        super.bytes = methods_count_bytes;
    }

    public void accept(Visitor v) {
        v.visitMethods(this);
    }

}
