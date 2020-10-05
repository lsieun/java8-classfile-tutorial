package fun;

import lsieun.utils.ByteDashboard;
import lsieun.utils.FileUtils;

public class Z_D_Read_Company {
    public static void main(String[] args) {
        String relative_path = "fun/company_info.bin";
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = FileUtils.readBytes(filepath);

        ByteDashboard bd = new ByteDashboard(bytes);
        Company company = FunUtils.parseCompany(bd);
        System.out.println(company);
    }
}
