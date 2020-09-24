package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

public class F2L extends Instruction implements ConversionInstruction {

    public F2L() {
        super(OpcodeConst.F2L, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitF2L(this);
    }

}
