package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IFEQ extends Instruction implements IfInstruction {

    public int branch;

    public IFEQ() {
        super(OpcodeConst.IFEQ, 3);
    }

    public IFEQ(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIFEQ(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
