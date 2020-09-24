package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CompareInstruction;

public class FCMPL extends Instruction implements CompareInstruction {

    public FCMPL() {
        super(OpcodeConst.FCMPL, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFCMPL(this);
    }

}
