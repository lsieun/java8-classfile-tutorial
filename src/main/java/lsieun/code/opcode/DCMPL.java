package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CompareInstruction;

public class DCMPL extends Instruction implements CompareInstruction {

    public DCMPL() {
        super(OpcodeConst.DCMPL, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitDCMPL(this);
    }

}
