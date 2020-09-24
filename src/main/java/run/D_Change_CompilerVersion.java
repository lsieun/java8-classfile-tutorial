package run;

import lsieun.utils.FileUtils;
import lsieun.utils.HexUtils;
import lsieun.utils.ReadUtils;

public class D_Change_CompilerVersion {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        String compiler_version_str = "00000035";
        byte[] compiler_version_bytes = HexUtils.parse(compiler_version_str);
        System.arraycopy(compiler_version_bytes, 0, bytes, 4, compiler_version_bytes.length);
        FileUtils.writeBytes(filepath, bytes);
    }
}
