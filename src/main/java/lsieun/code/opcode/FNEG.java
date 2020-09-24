package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class FNEG extends Instruction implements ArithmeticInstruction {

    public FNEG() {
        super(OpcodeConst.FNEG, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFNEG(this);
    }

}
