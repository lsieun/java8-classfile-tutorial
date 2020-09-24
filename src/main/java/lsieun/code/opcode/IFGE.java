package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IFGE extends Instruction implements IfInstruction {

    public int branch;

    public IFGE() {
        super(OpcodeConst.IFGE, 3);
    }

    public IFGE(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIFGE(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
