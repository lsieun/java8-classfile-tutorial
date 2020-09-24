package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StoreInstruction;

public final class ASTORE_0 extends Instruction implements StoreInstruction {

    public final int index = 0;

    public ASTORE_0() {
        super(OpcodeConst.ASTORE_0, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitASTORE_0(this);
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
