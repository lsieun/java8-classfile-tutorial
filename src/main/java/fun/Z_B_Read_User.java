package fun;

import lsieun.utils.ByteDashboard;
import lsieun.utils.FileUtils;

public class Z_B_Read_User {
    public static void main(String[] args) {
        String relative_path = "fun/user_info.bin";
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = FileUtils.readBytes(filepath);

        ByteDashboard bd = new ByteDashboard(bytes);
        User user = FunUtils.parseUser(bd);
        System.out.println(user);
    }
}
