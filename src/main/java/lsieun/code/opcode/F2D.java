package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

public class F2D extends Instruction implements ConversionInstruction {

    public F2D() {
        super(OpcodeConst.F2D, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitF2D(this);
    }

}
