package fun;

import lsieun.utils.FileUtils;
import lsieun.utils.HexFormat;
import lsieun.utils.HexUtils;

public class Z_E_Read_Hex {
    public static void main(String[] args) {
        String relative_path = "fun/user_info.bin";
        String filepath = FileUtils.getFilePath(relative_path);

        byte[] bytes = FileUtils.readBytes(filepath);
        String hex_str = HexUtils.format(bytes, HexFormat.FORMAT_FF_SPACE_FF_32);
        System.out.println(hex_str);
    }
}
