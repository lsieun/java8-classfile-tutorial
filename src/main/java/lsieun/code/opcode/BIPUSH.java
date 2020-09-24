package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConstantPushInstruction;

public class BIPUSH extends Instruction implements ConstantPushInstruction {
    public byte value;

    public BIPUSH() {
        super(OpcodeConst.BIPUSH, 2);
    }

    public BIPUSH(final byte value) {
        this();
        this.value = value;
    }

    @Override
    public Number getValue() {
        return Integer.valueOf(value);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitBIPUSH(this);
    }

}
