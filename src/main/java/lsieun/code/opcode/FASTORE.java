package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArrayInstruction;
import lsieun.code.facet.StackConsumer;

public class FASTORE extends Instruction implements ArrayInstruction, StackConsumer {

    public FASTORE() {
        super(OpcodeConst.FASTORE, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitFASTORE(this);
    }

}
