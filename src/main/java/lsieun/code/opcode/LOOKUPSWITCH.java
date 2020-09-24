package lsieun.code.opcode;

import lsieun.cst.OpcodeConst;
import lsieun.code.Instruction;
import lsieun.code.visitors.OpcodeVisitor;
import lsieun.code.facet.SelectInstruction;

/**
 * LOOKUPSWITCH - Switch with unordered set of values
 */
public class LOOKUPSWITCH extends Instruction implements SelectInstruction {

    public int padding;
    public int default_branch;
    public int npairs;
    public int[] matches; // matches, i.e., case 1: ...
    public int[] offsets; // target offsets
    public int fix_length;

    public LOOKUPSWITCH() {
        super(OpcodeConst.LOOKUPSWITCH, 9);
    }


    public LOOKUPSWITCH(final int[] matches, final int[] offsets, final int default_branch) {
        this();

        /* alignment remainder assumed 0 here, until dump time. */
        this.default_branch = default_branch;
        this.npairs = matches.length;
        this.matches = matches;
        this.offsets = offsets;
        super.length = this.fix_length = (short) (9 + npairs * 8);
    }

    @Override
    public void accept(final OpcodeVisitor v) {
        v.visitLOOKUPSWITCH(this);
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
