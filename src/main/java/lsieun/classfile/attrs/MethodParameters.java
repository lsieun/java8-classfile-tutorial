package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class MethodParameters extends AttributeInfo {
    public final int parameters_count;
    public final MethodParameter[] parameters;

    public MethodParameters(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.parameters_count = bd.readUnsignedByte();
        this.parameters = new MethodParameter[parameters_count];
        for(int i=0; i<parameters_count; i++) {
            this.parameters[i] = new MethodParameter(bd);
        }
    }

    public void accept(Visitor v) {
        v.visitMethodParameters(this);
    }
}
