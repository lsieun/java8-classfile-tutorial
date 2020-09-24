package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

public class D2L extends Instruction implements ConversionInstruction {

    public D2L() {
        super(OpcodeConst.D2L, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitD2L(this);
    }

}
