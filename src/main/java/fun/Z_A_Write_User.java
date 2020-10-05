package fun;

import lsieun.utils.FileUtils;

public class Z_A_Write_User {
    public static void main(String[] args) {
        User user = new User(3, "张飞");
        System.out.println(user);
        byte[] bytes = FunUtils.toBytes(user);

        String relative_path = "fun/user_info.bin";
        String filepath = FileUtils.getFilePath(relative_path);
        FileUtils.writeBytes(filepath, bytes);
        System.out.println("file://" + filepath);
    }
}
