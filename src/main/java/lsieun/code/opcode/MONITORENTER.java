package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StackConsumer;

public class MONITORENTER extends Instruction implements StackConsumer {

    public MONITORENTER() {
        super(OpcodeConst.MONITORENTER, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitMONITORENTER(this);
    }

}
