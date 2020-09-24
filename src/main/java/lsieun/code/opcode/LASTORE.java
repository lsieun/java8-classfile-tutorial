package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArrayInstruction;
import lsieun.code.facet.StackConsumer;

/**
 * LASTORE -  Store into long array
 * <PRE>Stack: ..., arrayref, index, value.word1, value.word2 -&gt; ...</PRE>
 */
public class LASTORE extends Instruction implements ArrayInstruction, StackConsumer {

    public LASTORE() {
        super(OpcodeConst.LASTORE, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLASTORE(this);
    }

}
