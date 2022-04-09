package run;

import org.objectweb.asm.*;
import lsieun.utils.FileUtils;

import static org.objectweb.asm.Opcodes.*;

public class M_ASMStackMapFrame {
    public static void main(String[] args) {
        try {
            String relative_path = "sample/HelloWorld.class";
            String filepath = FileUtils.getFilePath(relative_path);
            byte[] bytes = dump();
            FileUtils.writeBytes(filepath, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        MethodVisitor mv;

        String constructor_name = "<init>";

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "sample/HelloWorld", null, "java/lang/Object", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, constructor_name, "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", constructor_name, "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }
        {
            // region 替换区域
            // ......
            // endregion
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
