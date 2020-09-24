package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class LREM extends Instruction implements ArithmeticInstruction {

    public LREM() {
        super(OpcodeConst.LREM, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLREM(this);
    }

}
