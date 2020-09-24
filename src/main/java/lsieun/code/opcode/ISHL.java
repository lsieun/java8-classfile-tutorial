package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

/**
 * ISHL - Arithmetic shift left int
 * <PRE>Stack: ..., value1, value2 -&gt; ..., result</PRE>
 */
public class ISHL extends Instruction implements ArithmeticInstruction {

    public ISHL() {
        super(OpcodeConst.ISHL, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitISHL(this);
    }

}
