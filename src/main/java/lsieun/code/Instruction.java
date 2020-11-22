package lsieun.code;

import lsieun.code.visitors.OpcodeVisitor;

/**
 * Abstract super class for all Java byte codes.
 */
public abstract class Instruction {
    // basic
    public int opcode = -1; // Opcode number
    public int length = 1; // Length of opcode in bytes

    // auxiliary
    public Instruction pre;
    public Instruction next;
    public int pos;

    public Instruction(final int opcode, final int length) {
        this.opcode = opcode;
        this.length = length;
    }

    public abstract void accept(OpcodeVisitor v);

}
