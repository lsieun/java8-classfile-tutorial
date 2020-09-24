package lsieun.classfile;

import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public final class Methods extends Node {
    public final int methods_count;
    public final MethodInfo[] entries;

    public Methods(ByteDashboard bd, ConstantPool cp) {
        super.bytes = bd.peekN(2);

        this.methods_count = bd.readUnsignedShort();
        this.entries = new MethodInfo[methods_count];
        for (int i = 0; i < methods_count; i++) {
            MethodInfo methodInfo = new MethodInfo(bd, cp);
            this.entries[i] = methodInfo;
        }
    }

    public void accept(Visitor v) {
        v.visitMethods(this);
    }

}
