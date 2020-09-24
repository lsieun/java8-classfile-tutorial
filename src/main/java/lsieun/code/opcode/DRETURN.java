package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ReturnInstruction;

public class DRETURN extends Instruction implements ReturnInstruction {

    public DRETURN() {
        super(OpcodeConst.DRETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDRETURN(this);
    }

}
