package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.SelectInstruction;

/**
 * TABLESWITCH - Switch within given range of values, i.e., low..high
 */
public class TABLESWITCH extends Instruction implements SelectInstruction {

    public int padding;
    public int default_branch;
    public int low;
    public int high;
    public int[] matches; // matches, i.e., case 1: ...
    public int[] offsets; // target offsets
    public int fix_length;

    public TABLESWITCH() {
        super(OpcodeConst.TABLESWITCH, 13);
    }

    public TABLESWITCH(final int[] matches, final int[] offsets, final int default_branch, int low, int high) {
        this();

        /* Alignment remainder assumed 0 here, until dump time */
        this.default_branch = default_branch;
        this.low = low;
        this.high = high;
        this.matches = matches;
        this.offsets = offsets;

        int max_length = high - low + 1;
        super.length = this.fix_length = (short) (13 + max_length * 4);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitTABLESWITCH(this);
    }

    @Override
    public int[] getMatches() {
        return matches;
    }

    @Override
    public int[] getOffsets() {
        return offsets;
    }

    @Override
    public int getDefaultBranch() {
        return default_branch;
    }
}
