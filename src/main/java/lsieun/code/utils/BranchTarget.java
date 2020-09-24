package lsieun.code.utils;

import lsieun.code.Instruction;

public class BranchTarget {
    public final Instruction target;
    public final int stackDepth;


    public BranchTarget(final Instruction target, final int stackDepth) {
        this.target = target;
        this.stackDepth = stackDepth;
    }
}
