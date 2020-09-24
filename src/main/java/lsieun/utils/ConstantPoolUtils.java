package lsieun.utils;

import lsieun.classfile.ConstantPool;
import lsieun.vs.*;

public class ConstantPoolUtils {
    public static void print(ConstantPool cp) {
        print(cp, false);
    }

    public static void print(ConstantPool cp, boolean raw) {
        if (!raw) {
            cp.simplify();
        }

        Visitor v = new ClassFileStandardVisitor();
        cp.accept(v);
    }
}
