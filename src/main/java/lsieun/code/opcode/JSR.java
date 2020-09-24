package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.JsrInstruction;
import lsieun.code.facet.VariableLengthInstruction;

/**
 * JSR - Jump to subroutine
 */
public class JSR extends Instruction implements JsrInstruction, VariableLengthInstruction {

    public int branch;

    public JSR() {
        super(OpcodeConst.JSR, 3);
    }

    public JSR(final int branch) {
        this();
        this.branch = branch;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitJSR(this);
    }

    @Override
    public int getDefaultBranch() {
        return branch;
    }

}
