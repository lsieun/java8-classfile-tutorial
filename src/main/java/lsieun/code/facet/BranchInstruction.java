package lsieun.code.facet;

/**
 * Abstract super class for branching instructions like GOTO, IFEQ, etc..
 * Branch instructions may have a variable length, namely GOTO, JSR,
 * LOOKUPSWITCH and TABLESWITCH.
 */
public interface BranchInstruction {

    int getDefaultBranch();

}
