package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

/**
 * IXOR - Bitwise XOR int
 * <PRE>Stack: ..., value1, value2 -&gt; ..., result</PRE>
 */
public class IXOR extends Instruction implements ArithmeticInstruction {

    public IXOR() {
        super(OpcodeConst.IXOR, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIXOR(this);
    }

}

