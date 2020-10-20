package lsieun.classfile;

import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public class Fields extends Node {
    public final int fields_count;
    public final FieldInfo[] entries;

    public Fields(ByteDashboard bd, ConstantPool cp) {
        byte[] fields_count_bytes = bd.nextN(2);
        this.fields_count = ByteUtils.bytesToInt(fields_count_bytes);

        this.entries = new FieldInfo[fields_count];
        for (int i = 0; i < fields_count; i++) {
            FieldInfo fieldInfo = new FieldInfo(bd, cp);
            this.entries[i] = fieldInfo;
        }
        super.bytes = fields_count_bytes;
    }

    public void accept(Visitor v) {
        v.visitFields(this);
    }

}
