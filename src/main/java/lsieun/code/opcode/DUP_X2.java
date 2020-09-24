package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StackInstruction;

public class DUP_X2 extends Instruction implements StackInstruction {

    public DUP_X2() {
        super(OpcodeConst.DUP_X2, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDUP_X2(this);
    }

}
