package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CompareInstruction;

public class FCMPG extends Instruction implements CompareInstruction {

    public FCMPG() {
        super(OpcodeConst.FCMPG, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFCMPG(this);
    }

}
