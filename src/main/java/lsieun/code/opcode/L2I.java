package lsieun.code.opcode;


import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ConversionInstruction;

/**
 * L2I - Convert long to int
 * <PRE>Stack: ..., value.word1, value.word2 -&gt; ..., result</PRE>
 */
public class L2I extends Instruction implements ConversionInstruction {

    public L2I() {
        super(OpcodeConst.L2I, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitL2I(this);
    }

}
