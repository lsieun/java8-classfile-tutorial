package lsieun.code.facet;

import lsieun.code.Instruction;

/**
 * <p>
 *     想像这样一个场景：有一个人要拉弓射箭，前面不远处有一个箭靶。这里面注意两个重要角色：一个是“射箭的人”，另一个是“箭靶”。
 *     Targeter这个单词就是指“射箭的人”。
 * </p><br/>
 * Denote that a class targets InstructionHandles within an InstructionChain. Namely
 * the following implementers:
 */
public interface InstructionTargeter {

    /**
     * Checks whether this targeter targets the specified opcode handle.
     */
    boolean containsTarget(Instruction ins);

}
