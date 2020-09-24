package run;

import lsieun.utils.FileUtils;
import lsieun.utils.HexFormat;
import lsieun.utils.HexUtils;
import lsieun.utils.ReadUtils;

public class A_File_Hex {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "sample/HelloWorld.class";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，输出数据
        String hex_str = HexUtils.format(bytes, HexFormat.FORMAT_FF_SPACE_FF_32);
        System.out.println(hex_str);
    }
}
