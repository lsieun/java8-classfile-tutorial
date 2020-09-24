package lsieun.code.opcode;


import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

/**
 * L2F - Convert long to float
 * <PRE>Stack: ..., value.word1, value.word2 -&gt; ..., result</PRE>
 */
public class L2F extends Instruction implements ConversionInstruction {

    public L2F() {
        super(OpcodeConst.L2F, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitL2F(this);
    }

}
