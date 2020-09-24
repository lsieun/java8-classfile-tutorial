package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StoreInstruction;

public final class DSTORE_1 extends Instruction implements StoreInstruction {

    public final int index = 1;

    public DSTORE_1() {
        super(OpcodeConst.DSTORE_1, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitDSTORE_1(this);
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
