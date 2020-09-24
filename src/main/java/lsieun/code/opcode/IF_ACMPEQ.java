package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IF_ACMPEQ extends Instruction implements IfInstruction {

    public int branch;

    public IF_ACMPEQ() {
        super(OpcodeConst.IF_ACMPEQ, 3);
    }

    public IF_ACMPEQ(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIF_ACMPEQ(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
