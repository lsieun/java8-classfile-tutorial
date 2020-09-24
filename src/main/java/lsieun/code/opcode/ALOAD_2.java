package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.LoadInstruction;

public final class ALOAD_2 extends Instruction implements LoadInstruction {

    public final int index = 2;

    public ALOAD_2() {
        super(OpcodeConst.ALOAD_2, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitALOAD_2(this);
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        throw new RuntimeException("index is final");
    }
}
