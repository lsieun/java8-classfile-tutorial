package lsieun.code.visitors.stack;

import lsieun.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class State implements Comparable<State> {
    public final int pos;
    public final List<String> from_pos_list = new ArrayList<>();
    public final Frame frame;

    public State(int pos, Frame frame) {
        this.pos = pos;
        this.frame = frame;
    }

    public State(int pos, Frame frame, int from_pos) {
        this.pos = pos;
        this.frame = frame;
        from_pos_list.add("@" + from_pos);
    }

    public void add_from_pos(int from_pos) {
        from_pos_list.add("@" + from_pos);
    }

    public void add_from_range(String from_range) {
        from_pos_list.add(from_range);
    }

    @Override
    public String toString() {
        String from_pos_str = StringUtils.list2str(from_pos_list, "[", "]", ",");
        return String.format("%s <-- %s", frame, from_pos_str);
    }

    @Override
    public int compareTo(State another) {
        return this.pos - another.pos;
    }
}
