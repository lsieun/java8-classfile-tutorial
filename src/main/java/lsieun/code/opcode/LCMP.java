package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CompareInstruction;

public class LCMP extends Instruction implements CompareInstruction {

    public LCMP() {
        super(OpcodeConst.LCMP, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLCMP(this);
    }

}
