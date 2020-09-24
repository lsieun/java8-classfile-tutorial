package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.cst.AccessConst;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;

public class InnerClass {
    public final int inner_class_info_index;
    public final int outer_class_info_index;
    public final int inner_name_index;
    public final int inner_class_access_flags;

    public final String name;
    public String value;

    public InnerClass(ByteDashboard bd, ConstantPool cp) {
        this.inner_class_info_index = bd.readUnsignedShort();
        this.outer_class_info_index = bd.readUnsignedShort();
        this.inner_name_index = bd.readUnsignedShort();
        this.inner_class_access_flags = bd.readUnsignedShort();

        this.value = "#" + inner_class_info_index + ",#" + outer_class_info_index
                + ",#" + inner_name_index + ",#" + AccessConst.getClassAccessFlagsString(inner_class_access_flags);
        if(inner_name_index == 0) {
            // If the Class is anonymous, the value of the 'inner_name_index' item
            // must be zero.
            this.name = "<anonymous class>";
        }
        else {
            this.name = cp.getConstantString(inner_name_index, CPConst.CONSTANT_Utf8);
        }

    }
}
