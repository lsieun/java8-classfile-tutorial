package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class FDIV extends Instruction implements ArithmeticInstruction {

    public FDIV() {
        super(OpcodeConst.FDIV, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFDIV(this);
    }

}
