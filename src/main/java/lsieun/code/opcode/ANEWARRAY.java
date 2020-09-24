package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CPInstruction;
import lsieun.code.facet.AllocationInstruction;
import lsieun.code.facet.LoadClass;
import lsieun.code.facet.StackConsumer;
import lsieun.code.facet.StackProducer;

public class ANEWARRAY extends Instruction
        implements CPInstruction, LoadClass, AllocationInstruction, StackConsumer, StackProducer {

    public int index;

    public ANEWARRAY() {
        super(OpcodeConst.ANEWARRAY, 3);
    }

    public ANEWARRAY(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitANEWARRAY(this);
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
