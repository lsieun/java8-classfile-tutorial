package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArrayInstruction;

public class AASTORE extends Instruction implements ArrayInstruction {

    public AASTORE() {
        super(OpcodeConst.AASTORE, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitAASTORE(this);
    }
}
