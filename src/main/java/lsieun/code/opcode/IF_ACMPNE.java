package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IF_ACMPNE extends Instruction implements IfInstruction {

    public int branch;

    public IF_ACMPNE() {
        super(OpcodeConst.IF_ACMPNE, 3);
    }

    public IF_ACMPNE(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIF_ACMPNE(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
