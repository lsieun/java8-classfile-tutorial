package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArrayInstruction;
import lsieun.code.facet.StackProducer;

public class IALOAD extends Instruction implements ArrayInstruction, StackProducer {

    public IALOAD() {
        super(OpcodeConst.IALOAD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIALOAD(this);
    }

}
