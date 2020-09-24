package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class LNEG extends Instruction implements ArithmeticInstruction {

    public LNEG() {
        super(OpcodeConst.LNEG, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLNEG(this);
    }

}
