package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class DMUL extends Instruction implements ArithmeticInstruction {

    public DMUL() {
        super(OpcodeConst.DMUL, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDMUL(this);
    }

}
