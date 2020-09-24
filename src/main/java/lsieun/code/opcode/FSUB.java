package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class FSUB extends Instruction implements ArithmeticInstruction {

    public FSUB() {
        super(OpcodeConst.FSUB, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFSUB(this);
    }

}
