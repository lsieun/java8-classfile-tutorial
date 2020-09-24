package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class LSHR extends Instruction implements ArithmeticInstruction {

    public LSHR() {
        super(OpcodeConst.LSHR, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLSHR(this);
    }

}
