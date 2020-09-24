package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CPInstruction;
import lsieun.code.facet.PushInstruction;

public class LDC_W extends Instruction implements CPInstruction, PushInstruction {

    public int index;

    public LDC_W() {
        super(OpcodeConst.LDC_W, 3);
    }

    public LDC_W(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitLDC_W(this);
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
