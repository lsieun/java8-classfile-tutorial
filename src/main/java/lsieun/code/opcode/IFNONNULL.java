package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IFNONNULL extends Instruction implements IfInstruction {

    public int branch;

    public IFNONNULL() {
        super(OpcodeConst.IFNONNULL, 3);
    }

    public IFNONNULL(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIFNONNULL(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
