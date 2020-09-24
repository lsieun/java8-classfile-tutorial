package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class DDIV extends Instruction implements ArithmeticInstruction {

    public DDIV() {
        super(OpcodeConst.DDIV, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitDDIV(this);
    }

}
