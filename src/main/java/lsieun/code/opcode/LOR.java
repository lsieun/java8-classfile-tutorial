package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class LOR extends Instruction implements ArithmeticInstruction {

    public LOR() {
        super(OpcodeConst.LOR, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLOR(this);
    }

}
