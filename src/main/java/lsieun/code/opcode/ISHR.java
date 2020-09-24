package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

/**
 * ISHR - Arithmetic shift right int
 * <PRE>Stack: ..., value1, value2 -&gt; ..., result</PRE>
 */
public class ISHR extends Instruction implements ArithmeticInstruction {

    public ISHR() {
        super(OpcodeConst.ISHR, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitISHR(this);
    }

}
