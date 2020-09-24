package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.FieldInstruction;
import lsieun.code.facet.StackConsumer;
import lsieun.code.facet.StackProducer;

public class GETFIELD extends Instruction implements FieldInstruction, StackConsumer, StackProducer {

    public int index;

    public GETFIELD() {
        super(OpcodeConst.GETFIELD, 3);
    }

    public GETFIELD(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitGETFIELD(this);
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
