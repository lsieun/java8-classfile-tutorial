package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IFLE extends Instruction implements IfInstruction {

    public int branch;

    public IFLE() {
        super(OpcodeConst.IFLE, 3);
    }

    public IFLE(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIFLE(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
