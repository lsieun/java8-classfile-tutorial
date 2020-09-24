package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.GotoInstruction;

/**
 * GOTO_W - Branch always (to relative offset, not absolute address)
 */
public class GOTO_W extends Instruction implements GotoInstruction {

    public int branch;

    public GOTO_W() {
        super(OpcodeConst.GOTO_W, 5);
    }

    public GOTO_W(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitGOTO_W(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
