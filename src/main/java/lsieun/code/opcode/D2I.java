package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;


public class D2I extends Instruction implements ConversionInstruction {

    public D2I() {
        super(OpcodeConst.D2I, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitD2I(this);
    }

}
