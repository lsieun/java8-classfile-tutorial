package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.LoadInstruction;

public final class DLOAD_2 extends Instruction implements LoadInstruction {

    public final int index = 2;

    public DLOAD_2() {
        super(OpcodeConst.DLOAD_2, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitDLOAD_2(this);
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
