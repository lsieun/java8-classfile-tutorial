package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StackConsumer;
import lsieun.code.facet.StackProducer;

public class ARRAYLENGTH extends Instruction implements StackProducer, StackConsumer {

    public ARRAYLENGTH() {
        super(OpcodeConst.ARRAYLENGTH, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitARRAYLENGTH(this);
    }
}
