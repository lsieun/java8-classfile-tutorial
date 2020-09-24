package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;

/**
 * NOP - Do nothing
 */
public class NOP extends Instruction {

    public NOP() {
        super(OpcodeConst.NOP, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitNOP(this);
    }

}
