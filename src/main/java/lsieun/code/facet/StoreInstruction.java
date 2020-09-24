package lsieun.code.facet;

/**
 * Denotes an unparameterized opcode to store a value into a local variable,
 * e.g. ISTORE.
 */
public interface StoreInstruction extends LocalVariableInstruction, PopInstruction {
}
