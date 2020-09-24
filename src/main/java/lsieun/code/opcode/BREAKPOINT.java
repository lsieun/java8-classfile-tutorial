package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;

/**
 * BREAKPOINT, JVM dependent, ignored by default
 */
public class BREAKPOINT extends Instruction {

    public BREAKPOINT() {
        super(OpcodeConst.BREAKPOINT, 1);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitBREAKPOINT(this);
    }
}
