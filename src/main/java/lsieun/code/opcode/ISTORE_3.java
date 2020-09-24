package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.StoreInstruction;

public final class ISTORE_3 extends Instruction implements StoreInstruction {

    public final int index = 3;

    public ISTORE_3() {
        super(OpcodeConst.ISTORE_3, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitISTORE_3(this);
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
