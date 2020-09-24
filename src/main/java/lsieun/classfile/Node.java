package lsieun.classfile;

import lsieun.utils.HexUtils;

public abstract class Node {
    public byte[] bytes;
    public String value;

    public String hex() {
        return HexUtils.toHex(this.bytes);
    }
}
