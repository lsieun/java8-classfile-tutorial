package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

/**
 * IREM - Remainder of int
 * <PRE>Stack: ..., value1, value2 -&gt; result</PRE>
 */
public class IREM extends Instruction implements ArithmeticInstruction {

    public IREM() {
        super(OpcodeConst.IREM, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIREM(this);
    }

}
