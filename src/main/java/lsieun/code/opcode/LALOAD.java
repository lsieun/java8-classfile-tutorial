package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.ArrayInstruction;
import lsieun.code.facet.StackProducer;

/**
 * LALOAD - Load long from array
 * <PRE>Stack: ..., arrayref, index -&gt; ..., value1, value2</PRE>
 */
public class LALOAD extends Instruction implements ArrayInstruction, StackProducer {

    public LALOAD() {
        super(OpcodeConst.LALOAD, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLALOAD(this);
    }

}
