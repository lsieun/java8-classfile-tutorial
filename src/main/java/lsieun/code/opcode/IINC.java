package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.LocalVariableInstruction;

/**
 * IINC - Increment local variable by constant
 */
public class IINC extends Instruction implements LocalVariableInstruction {

    public int index;
    public int constValue;

    public IINC() {
        super(OpcodeConst.IINC, 3);
    }

    public IINC(final int index, final int constValue) {
        this();
        this.index = index;
        this.constValue = constValue;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIINC(this);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

}
