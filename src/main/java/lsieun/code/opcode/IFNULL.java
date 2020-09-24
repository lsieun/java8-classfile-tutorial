package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IFNULL extends Instruction implements IfInstruction {

    public int branch;

    public IFNULL() {
        super(OpcodeConst.IFNULL, 3);
    }

    public IFNULL(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIFNULL(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
