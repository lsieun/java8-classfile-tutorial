package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IfInstruction;

public class IF_ICMPLT extends Instruction implements IfInstruction {

    public int branch;

    public IF_ICMPLT() {
        super(OpcodeConst.IF_ICMPLT, 3);
    }

    public IF_ICMPLT(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIF_ICMPLT(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
