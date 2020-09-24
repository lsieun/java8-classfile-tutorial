package fun;

import java.util.Formatter;

public class Company {
    public int count;
    public User[] users;

    public Company(int count, User[] users) {
        this.count = count;
        this.users = users;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("Company {%n");
        fm.format("    count = '%d'%n", count);
        for (User u : users) {
            fm.format("    %s%n", u);
        }
        fm.format("}%n");
        return sb.toString();
    }
}
