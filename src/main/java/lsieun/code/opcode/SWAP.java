package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StackConsumer;
import lsieun.code.facet.StackInstruction;
import lsieun.code.facet.StackProducer;

public class SWAP extends Instruction implements StackInstruction, StackConsumer, StackProducer {

    public SWAP() {
        super(OpcodeConst.SWAP, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitSWAP(this);
    }

}
