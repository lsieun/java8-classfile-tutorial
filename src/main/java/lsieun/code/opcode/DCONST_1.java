package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConstantPushInstruction;

public final class DCONST_1 extends Instruction implements ConstantPushInstruction {

    public double value = 1;

    public DCONST_1() {
        super(OpcodeConst.DCONST_1, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitDCONST_1(this);
    }

    @Override
    public Number getValue() {
        return Double.valueOf(value);
    }

}
