package lsieun.code.visitors.stack;

public class Frame {
    public final LocalVariables locals;
    public final OperandStack stack;

    public Frame(final int max_locals, final int max_stack) {
        locals = new LocalVariables(max_locals);
        stack = new OperandStack(max_stack);
    }

    public Frame(final LocalVariables locals, final OperandStack stack) {
        this.locals = locals;
        this.stack = stack;
    }

    @Override
    protected Object clone() {
        final Frame f = new Frame(locals.getClone(), stack.getClone());
        return f;
    }

    public Frame getClone() {
        return (Frame) clone();
    }

    @Override
    public String toString() {
        return String.format("%27s||%s %s", "", locals, stack);
    }
}
