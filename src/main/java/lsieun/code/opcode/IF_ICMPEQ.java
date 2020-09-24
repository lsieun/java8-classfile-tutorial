package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IF_ICMPEQ extends Instruction implements IfInstruction {

    public int branch;

    public IF_ICMPEQ() {
        super(OpcodeConst.IF_ICMPEQ, 3);
    }

    public IF_ICMPEQ(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIF_ICMPEQ(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
