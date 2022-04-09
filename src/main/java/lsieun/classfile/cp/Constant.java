package lsieun.classfile.cp;

import lsieun.classfile.Node;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public abstract class Constant extends Node {
    // basic info
    public final byte tag;

    // auxiliary info
    public int index;

    Constant(final byte tag) {
        this.tag = tag;
    }

    public static Constant readConstant(final ByteDashboard bd) {
        final byte tag = bd.peek();

        switch (tag) {
            case CPConst.CONSTANT_Utf8:
                return new ConstantUtf8(bd);
            case CPConst.CONSTANT_Integer:
                return new ConstantInteger(bd);
            case CPConst.CONSTANT_Float:
                return new ConstantFloat(bd);
            case CPConst.CONSTANT_Long:
                return new ConstantLong(bd);
            case CPConst.CONSTANT_Double:
                return new ConstantDouble(bd);
            case CPConst.CONSTANT_Class:
                return new ConstantClass(bd);
            case CPConst.CONSTANT_String:
                return new ConstantString(bd);
            case CPConst.CONSTANT_Fieldref:
                return new ConstantFieldref(bd);
            case CPConst.CONSTANT_Methodref:
                return new ConstantMethodref(bd);
            case CPConst.CONSTANT_InterfaceMethodref:
                return new ConstantInterfaceMethodref(bd);
            case CPConst.CONSTANT_NameAndType:
                return new ConstantNameAndType(bd);
            case CPConst.CONSTANT_MethodHandle:
                return new ConstantMethodHandle(bd);
            case CPConst.CONSTANT_MethodType:
                return new ConstantMethodType(bd);
            case CPConst.CONSTANT_Dynamic:
                return new ConstantDynamic(bd);
            case CPConst.CONSTANT_InvokeDynamic:
                return new ConstantInvokeDynamic(bd);
            case CPConst.CONSTANT_Module:
                return new ConstantModule(bd);
            case CPConst.CONSTANT_Package:
                return new ConstantPackage(bd);
            default:
                throw new RuntimeException("Invalid byte tag in constant pool: " + tag);
        }
    }

    public void accept(Visitor obj) {
        obj.visitConstant(this);
    }
}
