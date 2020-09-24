package lsieun.code.facet;

/**
 * Denote entity that refers to an index, e.g. local variable instructions,
 * RET, CPInstruction, etc.
 */
public interface IndexedInstruction {

    int getIndex();


    void setIndex(int index);
}
