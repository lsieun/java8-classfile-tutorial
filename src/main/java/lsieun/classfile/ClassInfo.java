package lsieun.classfile;

import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public class ClassInfo extends Node {
    public final int access_flags;
    public final int this_class;
    public final int super_class;
    public final int interfaces_count;
    public final int[] interfaces;

    public ClassInfo(ByteDashboard bd) {
        byte[] access_flags_bytes = bd.nextN(2);
        byte[] this_class_bytes = bd.nextN(2);
        byte[] super_class_bytes = bd.nextN(2);
        byte[] interfaces_count_bytes = bd.nextN(2);

        this.access_flags = ByteUtils.bytesToInt(access_flags_bytes);
        this.this_class = ByteUtils.bytesToInt(this_class_bytes);
        this.super_class = ByteUtils.bytesToInt(super_class_bytes);
        this.interfaces_count = ByteUtils.bytesToInt(interfaces_count_bytes);
        this.interfaces = new int[interfaces_count];

        byte[] bytes = ByteUtils.concatenate(access_flags_bytes, this_class_bytes, super_class_bytes);
        bytes = ByteUtils.concatenate(bytes, interfaces_count_bytes);
        for (int i = 0; i < interfaces_count; i++) {
            byte[] interface_bytes = bd.nextN(2);
            interfaces[i] = ByteUtils.bytesToInt(interface_bytes);
            bytes = ByteUtils.concatenate(bytes, interface_bytes);
        }
        super.bytes = bytes;
    }

    public void accept(Visitor v) {
        v.visitClassInfo(this);
    }

}
