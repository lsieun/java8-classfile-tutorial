package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.IndexedInstruction;
import lsieun.code.facet.TypedInstruction;

public class RET extends Instruction implements IndexedInstruction, TypedInstruction {

    public int index; // index to local variable containg the return address

    public RET() {
        super(OpcodeConst.RET, 2);
    }


    public RET(final int index) {
        this();
        this.index = index;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitRET(this);
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
