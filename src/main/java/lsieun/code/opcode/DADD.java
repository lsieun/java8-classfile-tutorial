package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class DADD extends Instruction implements ArithmeticInstruction {

    public DADD() {
        super(OpcodeConst.DADD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDADD(this);
    }

}
