package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

public class F2I extends Instruction implements ConversionInstruction {

    public F2I() {
        super(OpcodeConst.F2I, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitF2I(this);
    }

}
