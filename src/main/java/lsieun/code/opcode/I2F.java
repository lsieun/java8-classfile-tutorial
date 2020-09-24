package lsieun.code.opcode;


import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

public class I2F extends Instruction implements ConversionInstruction {

    public I2F() {
        super(OpcodeConst.I2F, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitI2F(this);
    }

}
