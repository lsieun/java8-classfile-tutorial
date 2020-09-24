package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ReturnInstruction;

public class FRETURN extends Instruction implements ReturnInstruction {

    public FRETURN() {
        super(OpcodeConst.FRETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFRETURN(this);
    }

}
