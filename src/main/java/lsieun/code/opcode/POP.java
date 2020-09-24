package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.PopInstruction;
import lsieun.code.facet.StackInstruction;

/**
 * POP - Pop top operand f_stack word
 *
 * <PRE>Stack: ..., word -&gt; ...</PRE>
 */
public class POP extends Instruction implements StackInstruction, PopInstruction {

    public POP() {
        super(OpcodeConst.POP, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitPOP(this);
    }

}
