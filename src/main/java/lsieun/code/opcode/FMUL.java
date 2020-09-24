package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class FMUL extends Instruction implements ArithmeticInstruction {

    public FMUL() {
        super(OpcodeConst.FMUL, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFMUL(this);
    }

}
