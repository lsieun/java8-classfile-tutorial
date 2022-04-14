package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class Record extends AttributeInfo {
    public final int components_count;
    public final RecordComponent[] components;

    public Record(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.components_count = bd.readUnsignedShort();
        this.components = new RecordComponent[components_count];
        for (int i = 0; i < components_count; i++) {
            this.components[i] = new RecordComponent(bd, cp);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitRecord(this);
    }
}
