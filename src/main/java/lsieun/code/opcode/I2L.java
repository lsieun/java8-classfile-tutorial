package lsieun.code.opcode;


import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

public class I2L extends Instruction implements ConversionInstruction {

    public I2L() {
        super(OpcodeConst.I2L, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitI2L(this);
    }

}
