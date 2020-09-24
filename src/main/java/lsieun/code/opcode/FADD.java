package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class FADD extends Instruction implements ArithmeticInstruction {

    public FADD() {
        super(OpcodeConst.FADD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFADD(this);
    }

}
