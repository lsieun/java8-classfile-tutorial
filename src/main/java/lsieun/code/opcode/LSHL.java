package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class LSHL extends Instruction implements ArithmeticInstruction {

    public LSHL() {
        super(OpcodeConst.LSHL, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLSHL(this);
    }

}
