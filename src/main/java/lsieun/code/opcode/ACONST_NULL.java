package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.TypedInstruction;

public class ACONST_NULL extends Instruction implements TypedInstruction {

    public ACONST_NULL() {
        super(OpcodeConst.ACONST_NULL, 1);
    }

    @Override
    public void accept(OpcodeVisitor v) {
        v.visitACONST_NULL(this);
    }

}
