package lsieun.code.facet;

/**
 * Denotes an unparameterized opcode to produce a value on top of the f_stack,
 * such as ILOAD, LDC, SIPUSH, DUP, ICONST, etc.
 */
public interface PushInstruction extends StackProducer {
}
