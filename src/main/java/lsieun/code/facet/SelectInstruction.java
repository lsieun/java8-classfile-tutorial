package lsieun.code.facet;

public interface SelectInstruction extends BranchInstruction, VariableLengthInstruction, StackConsumer, StackProducer {
    int[] getMatches();
    int[] getOffsets();
}
