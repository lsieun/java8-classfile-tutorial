package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CompareInstruction;

public class DCMPG extends Instruction implements CompareInstruction {

    public DCMPG() {
        super(OpcodeConst.DCMPG, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDCMPG(this);
    }

}
