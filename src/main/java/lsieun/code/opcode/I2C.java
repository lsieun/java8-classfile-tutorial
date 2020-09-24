package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

public class I2C extends Instruction implements ConversionInstruction {

    public I2C() {
        super(OpcodeConst.I2C, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitI2C(this);
    }

}
