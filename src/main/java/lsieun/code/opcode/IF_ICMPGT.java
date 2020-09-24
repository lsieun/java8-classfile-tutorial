package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IF_ICMPGT extends Instruction implements IfInstruction {

    public int branch;

    public IF_ICMPGT() {
        super(OpcodeConst.IF_ICMPGT, 3);
    }

    public IF_ICMPGT(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIF_ICMPGT(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
