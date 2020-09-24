package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

/**
 * IUSHR - Logical shift right int
 * <PRE>Stack: ..., value1, value2 -&gt; ..., result</PRE>
 */
public class IUSHR extends Instruction implements ArithmeticInstruction {

    public IUSHR() {
        super(OpcodeConst.IUSHR, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIUSHR(this);
    }

}
