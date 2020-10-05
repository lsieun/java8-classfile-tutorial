package fun;

import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;

import java.nio.charset.StandardCharsets;

public class FunUtils {
    public static byte[] toBytes(int value, int byte_count) {
        if (byte_count < 0 || byte_count > Integer.BYTES) {
            throw new IllegalArgumentException("byte_count is illegal: " + byte_count);
        }

        byte[] bytes = new byte[byte_count];
        for (int i = 0; i < byte_count; i++) {
            int newValue = value >> (i * 8);
            byte b = (byte) (newValue & 0xFF);
            bytes[byte_count - 1 - i] = b;
        }

        return bytes;
    }

    public static byte[] toBytes(String value) {
        byte[] value_bytes = value.getBytes(StandardCharsets.UTF_8);
        byte[] length_bytes = toBytes(value_bytes.length, 2);
        return ByteUtils.concatenate(length_bytes, value_bytes);
    }

    public static byte[] toBytes(User user) {
        byte[] id_bytes = FunUtils.toBytes(user.id, 2);
        byte[] name_bytes = FunUtils.toBytes(user.name);
        return ByteUtils.concatenate(id_bytes, name_bytes);
    }

    public static User parseUser(ByteDashboard bd) {
        byte[] id_bytes = bd.nextN(2);
        int id = ByteUtils.bytesToInt(id_bytes);

        byte[] name_length_bytes = bd.nextN(2);
        int name_length = ByteUtils.bytesToInt(name_length_bytes);
        byte[] name_bytes = bd.nextN(name_length);
        String name = new String(name_bytes, StandardCharsets.UTF_8);
        return new User(id, name);
    }

    public static byte[] toBytes(Company company) {
        int count = company.count;
        User[] users = company.users;

        byte[] count_bytes = FunUtils.toBytes(count, 2);
        byte[] company_bytes = ByteUtils.concatenate(new byte[0], count_bytes);

        for (User u : users) {
            byte[] user_bytes = toBytes(u);
            company_bytes = ByteUtils.concatenate(company_bytes, user_bytes);
        }
        return company_bytes;
    }

    public static Company parseCompany(ByteDashboard bd) {
        byte[] count_bytes = bd.nextN(2);
        int count = ByteUtils.bytesToInt(count_bytes);

        User[] users = new User[count];
        for (int i = 0; i < count; i++) {
            users[i] = parseUser(bd);
        }
        return new Company(count, users);
    }
}
