package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class DREM extends Instruction implements ArithmeticInstruction {

    public DREM() {
        super(OpcodeConst.DREM, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDREM(this);
    }

}
