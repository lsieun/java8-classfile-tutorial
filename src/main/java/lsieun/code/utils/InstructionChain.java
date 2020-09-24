package lsieun.code.utils;

import lsieun.code.Instruction;

/**
 * This class is a container for a list of Instruction objects. Instructions can be appended, inserted, moved, deleted, etc..
 * Instructions are being wrapped into <a href="Handle.html">InstructionHandles</a> objects that are returned upon append/insert operations. They
 * give the user (read only) access to the list structure, such that it can be traversed and manipulated in a controlled way.
 *
 * A list is finally dumped to a byte code array with <a href="#getByteCode()">getByteCode</a>.
 */
public class InstructionChain {
    public int count;
    public Instruction start;
    public Instruction end;

    /**
     * Test for empty list.
     */
    public boolean isEmpty() {
        return start == null;
    } // && end == null

    public void append(Instruction ins) {
        if (isEmpty()) {
            start = end = ins;
            ins.pre = null;
            ins.next = null;
        }
        else {
            end.next = ins;
            ins.pre = end;
            ins.next = null;
            end = ins;
        }
        count++;
    }

}
