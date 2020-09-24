package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.FieldInstruction;
import lsieun.code.facet.PushInstruction;

public class GETSTATIC extends Instruction implements FieldInstruction, PushInstruction {

    public int index;

    public GETSTATIC() {
        super(OpcodeConst.GETSTATIC, 3);
    }

    public GETSTATIC(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitGETSTATIC(this);
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
