package lsieun.utils;

public class BitUtils {
    public static boolean hasBit(int i, int index) {
        if (index > Integer.SIZE || index < 1) return false;
        int rightShift = index - 1;
        int shiftValue = i >> rightShift;
        int andValue = shiftValue & 0x01;
        if (andValue == 1) return true;
        return false;
    }

    /**
     * This does not return a 1 for a 1 bit; it just returns non-zero
     */
    public static int get_bit(byte[] array, int bit) {
        return (array[bit / 8] & 0xFF) & (0x80 >> (bit % 8));
    }

    public static void set_bit(byte[] array, int bit) {
        int val = (array[bit / 8] & 0xFF) | (0x80 >> (bit % 8));
        array[bit / 8] = (byte) val;
    }

    public static void clear_bit(byte[] array, int bit) {
        int val = (array[bit / 8] & 0xFF) & ~(0x80 >> (bit % 8));
        array[bit / 8] = (byte) val;
    }

    public static String toBits(int val) {
        StringBuilder sb = new StringBuilder();
        for (int i = Integer.SIZE; i > 0; i--) {
            sb.append(hasBit(val, i) ? "1" : "0");
        }
        return sb.toString();
    }
}
