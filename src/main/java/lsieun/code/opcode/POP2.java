package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.PopInstruction;
import lsieun.code.facet.StackInstruction;

public class POP2 extends Instruction implements StackInstruction, PopInstruction {

    public POP2() {
        super(OpcodeConst.POP2, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitPOP2(this);
    }

}
