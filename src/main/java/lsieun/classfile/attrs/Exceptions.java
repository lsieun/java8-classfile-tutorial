package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.StringUtils;
import lsieun.vs.Visitor;

import java.util.ArrayList;
import java.util.List;

public final class Exceptions extends AttributeInfo {
    public final int number_of_exceptions;
    public final int[] exception_index_array;

    public Exceptions(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.number_of_exceptions = bd.readUnsignedShort();
        this.exception_index_array = new int[number_of_exceptions];

        List<String> list = new ArrayList<>();
        for (int i = 0; i < number_of_exceptions; i++) {
            int exception_index = bd.readUnsignedShort();
            this.exception_index_array[i] = exception_index;

            String value = cp.getConstantString(exception_index, CPConst.CONSTANT_Class);
            list.add(value);
        }
        this.value = StringUtils.list2str(list, "[", "]", ", ");
    }

    @Override
    public void accept(Visitor v) {
        v.visitExceptions(this);
    }
}
