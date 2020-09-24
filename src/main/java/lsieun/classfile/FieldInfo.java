package lsieun.classfile;

import lsieun.classfile.attrs.AttributeInfo;
import lsieun.cst.AccessConst;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class FieldInfo extends Node {
    public final int access_flags;
    public final int name_index;
    public final int descriptor_index;
    public final Attributes attributes;

    // auxiliary
    public final String name;
    public final String descriptor;

    public FieldInfo(ByteDashboard bd, ConstantPool cp) {
        byte[] bytes = bd.peekN(8);

        this.access_flags = bd.readUnsignedShort();
        this.name_index = bd.readUnsignedShort();
        this.descriptor_index = bd.readUnsignedShort();
        //this.value = "#" + name_index + ":#" + descriptor_index;

        String name = cp.getConstantString(name_index, CPConst.CONSTANT_Utf8);
        String descriptor = cp.getConstantString(descriptor_index, CPConst.CONSTANT_Utf8);
        this.name = name;
        this.descriptor = descriptor;
        this.value = name + ":" + descriptor;

        this.attributes = new Attributes(bd, cp);
        for (int i = 0; i < attributes.attributes_count; i++) {
            AttributeInfo attr = attributes.entries[i];
            bytes = ByteUtils.concatenate(bytes, attr.bytes);
        }
        // 设置bytes
        super.bytes = bytes;
    }

    public String getAccessFlagsString() {
        return AccessConst.getFieldAccessFlagsString(access_flags);
    }

    public int getAttributesCount() {
        return attributes.attributes_count;
    }

    public void accept(Visitor v) {
        v.visitFieldInfo(this);
    }
}
