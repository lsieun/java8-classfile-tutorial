package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public final class Deprecated extends AttributeInfo {
    public Deprecated(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);
    }

    @Override
    public void accept(Visitor v) {
        v.visitDeprecated(this);
    }
}
