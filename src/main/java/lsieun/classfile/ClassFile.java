package lsieun.classfile;

import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public final class ClassFile extends Node {
    public MagicNumber magic_number;
    public CompilerVersion compiler_version;
    public ConstantPool constant_pool;
    public ClassInfo class_info;
    public Fields fields;
    public Methods methods;
    public Attributes attributes;

    public ClassFile(ByteDashboard bd) {
        this.magic_number = new MagicNumber(bd);
        this.compiler_version = new CompilerVersion(bd);
        this.constant_pool = new ConstantPool(bd);
        this.class_info = new ClassInfo(bd);
        this.fields = new Fields(bd, constant_pool);
        this.methods = new Methods(bd, constant_pool);
        this.attributes = new Attributes(bd, constant_pool);
    }

    public void accept(Visitor v) {
        v.visitClassFile(this);
    }

    public static ClassFile parse(byte[] bytes) {
        ByteDashboard bd = new ByteDashboard(bytes);
        return new ClassFile(bd);
    }
}
