package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArithmeticInstruction;

/**
 * IOR - Bitwise OR int
 * <PRE>Stack: ..., value1, value2 -&gt; ..., result</PRE>
 */
public class IOR extends Instruction implements ArithmeticInstruction {

    public IOR() {
        super(OpcodeConst.IOR, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIOR(this);
    }

}
