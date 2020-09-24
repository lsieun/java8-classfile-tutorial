package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CPInstruction;
import lsieun.code.facet.AllocationInstruction;
import lsieun.code.facet.LoadClass;
import lsieun.code.facet.StackProducer;

public class NEW extends Instruction
        implements CPInstruction, LoadClass, AllocationInstruction, StackProducer {

    public int index;

    public NEW() {
        super(OpcodeConst.NEW, 3);
    }


    public NEW(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitNEW(this);
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
