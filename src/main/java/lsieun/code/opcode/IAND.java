package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class IAND extends Instruction implements ArithmeticInstruction {

    public IAND() {
        super(OpcodeConst.IAND, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIAND(this);
    }

}
