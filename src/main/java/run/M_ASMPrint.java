package run;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;
import lsieun.utils.FileUtils;
import lsieun.utils.ReadUtils;

import java.io.PrintWriter;

public class M_ASMPrint {
    public static void main(String[] args) {
        String relative_path = "sample/HelloWorld.class";
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);
        generate(bytes);
    }

    public static void generate(byte[] bytes) {
        ASMifier printer = new ASMifier();
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(null, printer, new PrintWriter(System.out));
        ClassReader cr = new ClassReader(bytes);
        cr.accept(traceClassVisitor, ClassReader.SKIP_FRAMES);
    }
}
