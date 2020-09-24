package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IFNE extends Instruction implements IfInstruction {

    public int branch;

    public IFNE() {
        super(OpcodeConst.IFNE, 3);
    }

    public IFNE(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIFNE(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
