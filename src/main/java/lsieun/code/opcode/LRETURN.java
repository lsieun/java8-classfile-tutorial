package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ReturnInstruction;

public class LRETURN extends Instruction implements ReturnInstruction {

    public LRETURN() {
        super(OpcodeConst.LRETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLRETURN(this);
    }

}
