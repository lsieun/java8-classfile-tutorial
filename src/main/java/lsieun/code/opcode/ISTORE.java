package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StoreInstruction;

/**
 * ISTORE - Store int from f_stack into local variable
 * <PRE>Stack: ..., value -&gt; ... </PRE>
 */
public class ISTORE extends Instruction implements StoreInstruction {

    public int index;

    public ISTORE() {
        super(OpcodeConst.ISTORE, 2);
    }

    public ISTORE(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitISTORE(this);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

}
