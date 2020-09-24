package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

public class D2F extends Instruction implements ConversionInstruction {

    public D2F() {
        super(OpcodeConst.D2F, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitD2F(this);
    }

}
