package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class IDIV extends Instruction implements ArithmeticInstruction {

    public IDIV() {
        super(OpcodeConst.IDIV, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIDIV(this);
    }

}
