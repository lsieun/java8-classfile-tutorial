package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.FieldInstruction;
import lsieun.code.facet.PopInstruction;

public class PUTSTATIC extends Instruction implements FieldInstruction, PopInstruction {

    public int index;

    public PUTSTATIC() {
        super(OpcodeConst.PUTSTATIC, 3);
    }

    public PUTSTATIC(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitPUTSTATIC(this);
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
