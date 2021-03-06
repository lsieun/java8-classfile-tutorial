package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ReturnInstruction;

public class RETURN extends Instruction implements ReturnInstruction {

    public RETURN() {
        super(OpcodeConst.RETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitRETURN(this);
    }

}
