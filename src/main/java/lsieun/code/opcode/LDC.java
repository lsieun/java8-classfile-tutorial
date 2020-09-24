package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CPInstruction;
import lsieun.code.facet.PushInstruction;

public class LDC extends Instruction implements CPInstruction, PushInstruction {

    public int index;

    public LDC() {
        super(OpcodeConst.LDC, 2);
    }

    public LDC(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLDC(this);
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
