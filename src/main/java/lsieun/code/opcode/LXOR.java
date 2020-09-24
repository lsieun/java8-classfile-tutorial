package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class LXOR extends Instruction implements ArithmeticInstruction {

    public LXOR() {
        super(OpcodeConst.LXOR, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLXOR(this);
    }

}
