package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArrayInstruction;

public class AALOAD extends Instruction implements ArrayInstruction {

    public AALOAD() {
        super(OpcodeConst.AALOAD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitAALOAD(this);
    }
}
