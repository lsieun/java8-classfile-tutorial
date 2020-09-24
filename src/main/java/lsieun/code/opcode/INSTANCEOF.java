package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CPInstruction;
import lsieun.code.facet.LoadClass;
import lsieun.code.facet.StackConsumer;
import lsieun.code.facet.StackProducer;

public class INSTANCEOF extends Instruction
        implements CPInstruction, LoadClass, StackProducer, StackConsumer {

    public int index;

    public INSTANCEOF() {
        super(OpcodeConst.INSTANCEOF, 3);
    }

    public INSTANCEOF(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitINSTANCEOF(this);
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
