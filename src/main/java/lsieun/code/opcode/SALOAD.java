package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArrayInstruction;
import lsieun.code.facet.StackProducer;

public class SALOAD extends Instruction implements ArrayInstruction, StackProducer {

    public SALOAD() {
        super(OpcodeConst.SALOAD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitSALOAD(this);
    }

}
