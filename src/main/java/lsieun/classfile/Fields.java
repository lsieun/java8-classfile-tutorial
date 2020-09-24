package lsieun.classfile;

import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class Fields extends Node {
    public final int fields_count;
    public final FieldInfo[] entries;

    public Fields(ByteDashboard bd, ConstantPool cp) {
        super.bytes = bd.peekN(2);

        this.fields_count = bd.readUnsignedShort();
        this.entries = new FieldInfo[fields_count];
        for (int i = 0; i < fields_count; i++) {
            FieldInfo fieldInfo = new FieldInfo(bd, cp);
            this.entries[i] = fieldInfo;
        }
    }

    public void accept(Visitor v) {
        v.visitFields(this);
    }

}
