package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IFLT extends Instruction implements IfInstruction {

    public int branch;

    public IFLT() {
        super(OpcodeConst.IFLT, 3);
    }

    public IFLT(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIFLT(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
