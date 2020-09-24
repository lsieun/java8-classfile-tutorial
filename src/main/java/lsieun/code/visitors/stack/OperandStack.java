package lsieun.code.visitors.stack;

import lsieun.code.type.Type;
import lsieun.code.type.UninitializedObjectType;
import lsieun.code.utils.TypeUtils;

import java.util.ArrayList;
import java.util.Formatter;

public class OperandStack implements Cloneable {
    public ArrayList<Type> stack = new ArrayList<>();

    public final int max_stack;

    /**
     * Creates an empty stack with a maximum of maxStack slots.
     */
    public OperandStack(final int max_stack) {
        this.max_stack = max_stack;
    }

    @Override
    public Object clone() {
        final OperandStack another_stack = new OperandStack(this.max_stack);
        @SuppressWarnings("unchecked") // OK because this.stack is the same type
        final ArrayList<Type> clone = (ArrayList<Type>) this.stack.clone();
        another_stack.stack = clone;
        return another_stack;
    }

    public OperandStack getClone() {
        return (OperandStack) this.clone();
    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public Type peek() {
        return peek(0);
    }

    public Type peek(final int i) {
        return stack.get(size() - i - 1);
    }

    public Type pop() {
        return stack.remove(size() - 1);
    }

    public Type pop(final int n) {
        for (int i = 0; i < n; i++) {
            pop();
        }
        return null;
    }

    public boolean match(int... type_size_stack) {
        int length = type_size_stack.length;
        for (int i = 0; i < length; i++) {
            int expected_size = type_size_stack[i];
            Type type = peek(i);
            int real_size = type.getSize();
            if (expected_size != real_size) {
                return false;
            }
        }
        return true;
    }

    public void push(final Type type) {
        if (type == null) {
            throw new RuntimeException("Cannot push NULL onto OperandStack.");
        }


        int size = slots_used();
        int t_size = type.getSize();
        int total_size = size + t_size;
        if (total_size > max_stack) {
            throw new RuntimeException("OperandStack too small, should have thrown proper Exception elsewhere. Stack: " + this);
        }
        if (type == TypeUtils.BOOLEAN || type == TypeUtils.CHAR || type == TypeUtils.BYTE || type == TypeUtils.SHORT) {
            stack.add(TypeUtils.INT);
        }
        else {
            stack.add(type);
        }

    }

    /**
     * Returns the number of stack slots used.
     */
    public int slots_used() {
        int slots = 0;
        for (int i = 0; i < stack.size(); i++) {
            slots += peek(i).getSize();
        }
        return slots;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("[");

        int max_index = size() - 1;
        for (int i = 0; i < max_index; i++) {
            Type t = stack.get(i);
            int size = t.getSize();
            if (size == 1) {
                fm.format("%s, ", t);
            } else if (size == 2) {
                fm.format("%s, %s, ", t, TypeUtils.TOP);
            }

        }
        if (max_index > -1) {
            Type t = stack.get(max_index);
            int size = t.getSize();
            if (size == 1) {
                fm.format("%s", t);
            } else if (size == 2) {
                fm.format("%s, %s", t, TypeUtils.TOP);
            }
        }
        fm.format("]");
        return sb.toString();
    }

    public void initializeObject(final UninitializedObjectType u) {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (stack.get(i) == u) {
                stack.set(i, u.getInitialized());
            }
        }
    }

}
