package lsieun.classfile;

import lsieun.classfile.attrs.AttributeInfo;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public class Attributes extends Node {
    public final int attributes_count;
    public final AttributeInfo[] entries;

    public Attributes(ByteDashboard bd, ConstantPool cp) {
        byte[] attributes_count_bytes = bd.nextN(2);
        this.attributes_count = ByteUtils.bytesToInt(attributes_count_bytes);

        this.entries = new AttributeInfo[attributes_count];
        for (int i = 0; i < attributes_count; i++) {
            AttributeInfo attr = AttributeInfo.read(bd, cp);
            this.entries[i] = attr;
        }
        super.bytes = attributes_count_bytes;
    }

    public void accept(Visitor v) {
        v.visitAttributes(this);
    }
}
