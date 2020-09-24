package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;

public class WIDE extends Instruction {

    public WIDE() {
        super(OpcodeConst.WIDE, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitWIDE(this);
    }

}
