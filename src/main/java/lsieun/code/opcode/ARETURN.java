package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ReturnInstruction;

public class ARETURN extends Instruction implements ReturnInstruction {

    public ARETURN() {
        super(OpcodeConst.ARETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitARETURN(this);
    }
}
