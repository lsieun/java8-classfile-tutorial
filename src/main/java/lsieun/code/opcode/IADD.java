package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class IADD extends Instruction implements ArithmeticInstruction {

    public IADD() {
        super(OpcodeConst.IADD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIADD(this);
    }

}
