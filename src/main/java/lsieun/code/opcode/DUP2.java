package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StackInstruction;
import lsieun.code.facet.PushInstruction;

public class DUP2 extends Instruction implements StackInstruction, PushInstruction {

    public DUP2() {
        super(OpcodeConst.DUP2, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDUP2(this);
    }

}
