package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

/**
 * ISUB - Substract ints
 * <PRE>Stack: ..., value1, value2 -&gt; result</PRE>
 */
public class ISUB extends Instruction implements ArithmeticInstruction {

    public ISUB() {
        super(OpcodeConst.ISUB, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitISUB(this);
    }

}
