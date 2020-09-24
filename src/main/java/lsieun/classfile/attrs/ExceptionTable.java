package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;

public class ExceptionTable {
    public final int start_pc;
    public final int end_pc;
    public final int handler_pc;
    public final int catch_type;
    public String exceptionType;

    public ExceptionTable(ByteDashboard bd, ConstantPool cp) {
        this.start_pc = bd.readUnsignedShort();
        this.end_pc = bd.readUnsignedShort();
        this.handler_pc = bd.readUnsignedShort();
        this.catch_type = bd.readUnsignedShort();

        String exceptionType = "";
        if(catch_type == 0) {
            // If the value of the 'catch_type' item is zero, this exception handler is called
            // for all exceptions.
            exceptionType = "All";
        }
        else {
            exceptionType = cp.getConstant(catch_type, CPConst.CONSTANT_Class).value;
        }

        //exceptionType = exceptionType.replaceAll("/", ".");
        this.exceptionType = exceptionType;
    }

}
