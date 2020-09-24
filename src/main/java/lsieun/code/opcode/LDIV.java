package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class LDIV extends Instruction implements ArithmeticInstruction {

    public LDIV() {
        super(OpcodeConst.LDIV, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLDIV(this);
    }

}
