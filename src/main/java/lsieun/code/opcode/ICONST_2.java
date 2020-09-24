package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConstantPushInstruction;

public final class ICONST_2 extends Instruction implements ConstantPushInstruction {

    public final int value = 2;

    public ICONST_2() {
        super(OpcodeConst.ICONST_2, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitICONST_2(this);
    }

    @Override
    public Number getValue() {
        return Integer.valueOf(value);
    }

}
