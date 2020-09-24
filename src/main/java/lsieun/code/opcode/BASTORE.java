package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArrayInstruction;
import lsieun.code.facet.StackConsumer;

public class BASTORE extends Instruction implements ArrayInstruction, StackConsumer {

    public BASTORE() {
        super(OpcodeConst.BASTORE, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitBASTORE(this);
    }
}
