package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IF_ICMPNE extends Instruction implements IfInstruction {

    public int branch;

    public IF_ICMPNE() {
        super(OpcodeConst.IF_ICMPNE, 3);
    }

    public IF_ICMPNE(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIF_ICMPNE(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
