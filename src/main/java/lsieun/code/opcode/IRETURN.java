package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ReturnInstruction;

/**
 * IRETURN -  Return int from d_method
 * <PRE>Stack: ..., value -&gt; &lt;empty&gt;</PRE>
 */
public class IRETURN extends Instruction implements ReturnInstruction {

    public IRETURN() {
        super(OpcodeConst.IRETURN, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitIRETURN(this);
    }

}
