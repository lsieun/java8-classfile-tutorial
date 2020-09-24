package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.cst.StackMapConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;

public final class StackMapFrame {
    public int frame_type;
    public int byte_code_offset;
    public StackMapType[] types_of_locals;
    public StackMapType[] types_of_stack_items;

    StackMapFrame(ByteDashboard bd, ConstantPool cp) {
        byte[] frame_type_bytes = bd.nextN(1);
        this.frame_type = ByteUtils.bytesToInt(frame_type_bytes, 0);
        this.byte_code_offset = 0;
        this.types_of_locals = new StackMapType[0];
        this.types_of_stack_items = new StackMapType[0];

        if (frame_type >= StackMapConst.SAME_FRAME && frame_type <= StackMapConst.SAME_FRAME_MAX) {
            byte_code_offset = frame_type - StackMapConst.SAME_FRAME;
        } else if (frame_type >= StackMapConst.SAME_LOCALS_1_STACK_ITEM_FRAME &&
                frame_type <= StackMapConst.SAME_LOCALS_1_STACK_ITEM_FRAME_MAX) {
            byte_code_offset = frame_type - StackMapConst.SAME_LOCALS_1_STACK_ITEM_FRAME;
            types_of_stack_items = new StackMapType[1];
            types_of_stack_items[0] = new StackMapType(bd, cp);
        } else if (frame_type == StackMapConst.SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED) {
            byte_code_offset = bd.readUnsignedShort();
            types_of_stack_items = new StackMapType[1];
            types_of_stack_items[0] = new StackMapType(bd, cp);
        } else if (frame_type >= StackMapConst.CHOP_FRAME && frame_type <= StackMapConst.CHOP_FRAME_MAX) {
            byte_code_offset = bd.readUnsignedShort();
        } else if (frame_type == StackMapConst.SAME_FRAME_EXTENDED) {
            byte_code_offset = bd.readUnsignedShort();
        } else if (frame_type >= StackMapConst.APPEND_FRAME && frame_type <= StackMapConst.APPEND_FRAME_MAX) {
            byte_code_offset = bd.readUnsignedShort();
            final int number_of_locals = frame_type - 251;
            types_of_locals = new StackMapType[number_of_locals];
            for (int i = 0; i < number_of_locals; i++) {
                types_of_locals[i] = new StackMapType(bd, cp);
            }
        } else if (frame_type == StackMapConst.FULL_FRAME) {
            byte_code_offset = bd.readUnsignedShort();
            final int number_of_locals = bd.readUnsignedShort();
            types_of_locals = new StackMapType[number_of_locals];
            for (int i = 0; i < number_of_locals; i++) {
                types_of_locals[i] = new StackMapType(bd, cp);
            }
            final int number_of_stack_items = bd.readUnsignedShort();
            types_of_stack_items = new StackMapType[number_of_stack_items];
            for (int i = 0; i < number_of_stack_items; i++) {
                types_of_stack_items[i] = new StackMapType(bd, cp);
            }
        } else {
            /* Can't happen */
            throw new RuntimeException("Invalid frame type found while parsing f_stack map table: " + frame_type);
        }
    }

    public String getLocalsString() {
        final StringBuilder buf = new StringBuilder(64);
        buf.append("locals=[");
        String value = stackMapTypes2String(types_of_locals);
        buf.append(value);
        buf.append("]");
        return buf.toString();
    }

    public String getStackItemsString() {
        final StringBuilder buf = new StringBuilder(64);
        buf.append("stack_items=[");
        String value = stackMapTypes2String(types_of_stack_items);
        buf.append(value);
        buf.append("]");
        return buf.toString();
    }

    private String stackMapTypes2String(StackMapType[] array) {
        final StringBuilder buf = new StringBuilder(64);

        for (int i = 0; i < array.length; i++) {
            StackMapType item = array[i];
            String str = item.toString();
            buf.append(str);
            if (i < array.length - 1) {
                buf.append(", ");
            }
        }
        return buf.toString();
    }
}
