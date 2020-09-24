package lsieun.code.facet;

/**
 * Denotes an unparameterized opcode to pop a value on top from the f_stack,
 * such as ISTORE, POP, PUTSTATIC.
 */
public interface PopInstruction extends StackConsumer {
}
