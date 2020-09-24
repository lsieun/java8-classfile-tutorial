package lsieun.code.facet;

/**
 * Abstract super class for instructions that use an index into the
 * constant pool such as LDC, INVOKEVIRTUAL, etc.
 */
public interface CPInstruction extends TypedInstruction, IndexedInstruction {
}
