package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.InvokeInstruction;

/**
 * INVOKEVIRTUAL - Invoke instance d_method; dispatch based on class
 *
 * <PRE>Stack: ..., objectref, [arg1, [arg2 ...]] -&gt; ...</PRE>
 */
public class INVOKEVIRTUAL extends Instruction implements InvokeInstruction {

    public int index;

    public INVOKEVIRTUAL() {
        super(OpcodeConst.INVOKEVIRTUAL, 3);
    }

    public INVOKEVIRTUAL(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitINVOKEVIRTUAL(this);
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
