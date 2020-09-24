package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.UnconditionalBranch;

public class ATHROW extends Instruction implements UnconditionalBranch {

    public ATHROW() {
        super(OpcodeConst.ATHROW, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitATHROW(this);
    }
}
