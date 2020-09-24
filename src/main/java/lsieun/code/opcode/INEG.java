package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

/**
 * INEG - Negate int
 * <PRE>Stack: ..., value -&gt; ..., result</PRE>
 */
public class INEG extends Instruction implements ArithmeticInstruction {

    public INEG() {
        super(OpcodeConst.INEG, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitINEG(this);
    }

}
