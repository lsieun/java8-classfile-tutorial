package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

public class DNEG extends Instruction implements ArithmeticInstruction {

    public DNEG() {
        super(OpcodeConst.DNEG, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitDNEG(this);
    }

}
