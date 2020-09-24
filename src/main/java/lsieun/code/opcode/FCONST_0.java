package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConstantPushInstruction;

public final class FCONST_0 extends Instruction implements ConstantPushInstruction {

    public final float value = 0;

    public FCONST_0() {
        super(OpcodeConst.FCONST_0, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitFCONST_0(this);
    }

    @Override
    public Number getValue() {
        return Float.valueOf(value);
    }

}
