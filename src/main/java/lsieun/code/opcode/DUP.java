package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StackInstruction;
import lsieun.code.facet.PushInstruction;

public class DUP extends Instruction implements StackInstruction, PushInstruction {

    public DUP() {
        super(OpcodeConst.DUP, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDUP(this);
    }

}
