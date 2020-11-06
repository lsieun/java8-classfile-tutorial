package lsieun.code.visitors.stack;

import lsieun.code.type.Type;
import lsieun.code.type.UninitializedObjectType;
import lsieun.code.utils.TypeUtils;

import java.util.Formatter;

public class LocalVariables implements Cloneable {
    private final Type[] locals;

    public LocalVariables(final int localVariableCount) {
        locals = new Type[localVariableCount];
        for (int i = 0; i < localVariableCount; i++) {
            locals[i] = TypeUtils.UNKNOWN;
        }
    }

    @Override
    public Object clone() {
        final LocalVariables another_locals = new LocalVariables(locals.length);
        System.arraycopy(this.locals, 0, another_locals.locals, 0, locals.length);
        return another_locals;
    }

    public LocalVariables getClone() {
        return (LocalVariables) this.clone();
    }

    public int max_locals() {
        return locals.length;
    }

    public Type get(final int slot_index) {
        return locals[slot_index];
    }

    public void set(final int slot_index, final Type type) {
        if (type == TypeUtils.BYTE || type == TypeUtils.SHORT || type == TypeUtils.BOOLEAN || type == TypeUtils.CHAR) {
            throw new RuntimeException("LocalVariables do not know about '" + type + "'. Use Type.INT instead.");
        }
        locals[slot_index] = type;
        if (type == TypeUtils.LONG || type == TypeUtils.DOUBLE) {
            locals[slot_index + 1] = TypeUtils.TOP;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("[");

        int max_index = locals.length - 1;
        for (int i = 0; i < max_index; i++) {
            Type t = locals[i];
            fm.format("%s, ", t.toString());
        }
        if (max_index > -1) {
            fm.format("%s", locals[max_index]);
        }
        fm.format("]");
        return sb.toString();
    }

    /**
     * Replaces all occurrences of {@code uninitializedObjectType} in this local variables set
     * with an "initialized" ObjectType.
     *
     * @param uninitializedObjectType the object to match.
     */
    public void initializeObject(final UninitializedObjectType uninitializedObjectType) {
        for (int i = 0; i < locals.length; i++) {
            if (locals[i] == uninitializedObjectType) {
                locals[i] = uninitializedObjectType.getInitialized();
            }
        }
    }

}
