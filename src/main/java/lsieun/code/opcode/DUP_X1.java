package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StackInstruction;

public class DUP_X1 extends Instruction implements StackInstruction {

    public DUP_X1() {
        super(OpcodeConst.DUP_X1, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDUP_X1(this);
    }

}
