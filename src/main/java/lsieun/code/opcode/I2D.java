package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

public class I2D extends Instruction implements ConversionInstruction {

    public I2D() {
        super(OpcodeConst.I2D, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitI2D(this);
    }

}
