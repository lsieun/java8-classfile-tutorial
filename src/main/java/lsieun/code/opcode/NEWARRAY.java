package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.AllocationInstruction;
import lsieun.code.facet.StackProducer;

public class NEWARRAY extends Instruction
        implements AllocationInstruction, StackProducer {

    public byte atype;

    public NEWARRAY() {
        super(OpcodeConst.NEWARRAY, 2);
    }

    public NEWARRAY(final byte atype) {
        this();
        this.atype = atype;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitNEWARRAY(this);
    }

}
