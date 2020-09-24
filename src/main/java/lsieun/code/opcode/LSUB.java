package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class LSUB extends Instruction implements ArithmeticInstruction {

    public LSUB() {
        super(OpcodeConst.LSUB, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLSUB(this);
    }

}
