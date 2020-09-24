package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.CPInstruction;
import lsieun.code.facet.AllocationInstruction;
import lsieun.code.facet.LoadClass;

public class MULTIANEWARRAY extends Instruction
        implements CPInstruction, LoadClass, AllocationInstruction {

    public int index;
    public int dimensions;

    public MULTIANEWARRAY() {
        super(OpcodeConst.MULTIANEWARRAY, 4);
    }

    public MULTIANEWARRAY(final int index, final short dimensions) {
        this();

        if (dimensions < 1) {
            throw new RuntimeException("Invalid dimensions value: " + dimensions);
        }

        this.index = index;
        this.dimensions = dimensions;
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitMULTIANEWARRAY(this);
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
