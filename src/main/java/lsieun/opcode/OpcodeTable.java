package lsieun.opcode;

import java.util.Formatter;

public class OpcodeTable {
    public static void main(String[] args) {
        int start = 192;
        int stop = 193;
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        for (int i = start; i <= stop; i++) {
            fm.format("<tr><td><code>%s</code></td><td>%s</td><td></td></tr>%n", i, Opcodes.getName(Opcode.valueOf(i)));
        }
        System.out.println(sb.toString());
    }
}
