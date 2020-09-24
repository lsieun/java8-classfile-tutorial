package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

/**
 * IMUL - Multiply ints
 * <PRE>Stack: ..., value1, value2 -&gt; result</PRE>
 */
public class IMUL extends Instruction implements ArithmeticInstruction {

    public IMUL() {
        super(OpcodeConst.IMUL,1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIMUL(this);
    }

}
