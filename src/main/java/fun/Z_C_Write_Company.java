package fun;

import lsieun.utils.FileUtils;

public class Z_C_Write_Company {
    public static void main(String[] args) {
        User user1 = new User(1, "刘备");
        User user2 = new User(2, "关羽");
        User user3 = new User(3, "张飞");
        User[] users = new User[]{user1, user2, user3};
        Company company = new Company(3, users);
        System.out.println(company);

        String relative_path = "fun/company_info.bin";
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = FunUtils.toBytes(company);
        FileUtils.writeBytes(filepath, bytes);
        System.out.println("file://" + filepath);
    }
}
