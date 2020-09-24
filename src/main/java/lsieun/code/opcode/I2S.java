package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

public class I2S extends Instruction implements ConversionInstruction {

    public I2S() {
        super(OpcodeConst.I2S, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitI2S(this);
    }

}
