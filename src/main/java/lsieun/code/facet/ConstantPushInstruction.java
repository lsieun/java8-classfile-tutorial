package lsieun.code.facet;

/**
 * Denotes a push opcode that produces a literal on the f_stack
 * such as  SIPUSH, BIPUSH, ICONST, etc.
 */
public interface ConstantPushInstruction extends PushInstruction, TypedInstruction {

    Number getValue();

}
