package lsieun.classfile;

import lsieun.classfile.cp.*;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public final class ConstantPool extends Node {
    public final int count;
    public final Constant[] entries;

    public ConstantPool(ByteDashboard bd) {
        byte[] count_bytes = bd.nextN(2);
        super.bytes = count_bytes;

        this.count = ByteUtils.bytesToInt(count_bytes);
        this.entries = new Constant[count];

        for (int i = 1; i < count; i++) {
            Constant item = Constant.readConstant(bd);
            item.index = i;

            this.entries[i] = item;
            /* Quote from the JVM specification:
             * "All eight byte constants take up two spots in the constant pool.
             * If this is the n'th byte in the constant pool, then the next item
             * will be numbered n+2"
             *
             * Thus we have to increment the index counter.
             */
            byte tag = item.tag;
            if ((tag == CPConst.CONSTANT_Double) || (tag == CPConst.CONSTANT_Long)) {
                i++;
            }
        }
    }

    public Constant getConstant(final int index) {
        if (index >= count || index < 0) {
            throw new RuntimeException("Invalid constant pool reference: " + index
                    + ". Constant pool size is: " + this.count);
        }
        return entries[index];
    }

    public Constant getConstant(final int index, final byte tag) {
        Constant c = getConstant(index);
        if (c == null) {
            throw new RuntimeException("Constant pool at index " + index + " is null.");
        }
        if (c.tag != tag) {
            throw new RuntimeException("Expected class '" + CPConst.getConstantName(tag)
                    + "' at index " + index + " and got " + c);
        }
        return c;
    }

    public String getConstantString(final int index, final byte tag) {
        Constant constant = getConstant(index, tag);
        return constant.value;
    }

    public void accept(Visitor v) {
        v.visitConstantPool(this);
    }

    public void simplify() {
        for (Constant item : entries) {
            if (item == null) continue;
            byte tag = item.tag;
            if (tag == CPConst.CONSTANT_Class) {
                ConstantClass sub = (ConstantClass) item;
                item.value = this.getConstantString(sub.name_index, CPConst.CONSTANT_Utf8);
            }
            else if (tag == CPConst.CONSTANT_String) {
                ConstantString sub = (ConstantString) item;
                item.value = this.getConstantString(sub.string_index, CPConst.CONSTANT_Utf8);
            }
            else if (tag == CPConst.CONSTANT_NameAndType) {
                ConstantNameAndType sub = (ConstantNameAndType) item;
                String name = this.getConstantString(sub.name_index, CPConst.CONSTANT_Utf8);
                String descriptor = this.getConstantString(sub.descriptor_index, CPConst.CONSTANT_Utf8);
                item.value = name + ":" + descriptor;
            }
            else if (tag == CPConst.CONSTANT_MethodType) {
                ConstantMethodType sub = (ConstantMethodType) item;
                item.value = this.getConstantString(sub.descriptor_index, CPConst.CONSTANT_Utf8);
            }
            else if (tag == CPConst.CONSTANT_Module) {
                ConstantModule sub = (ConstantModule) item;
                item.value = this.getConstantString(sub.name_index, CPConst.CONSTANT_Utf8);
            }
            else if (tag == CPConst.CONSTANT_Package) {
                ConstantPackage sub = (ConstantPackage) item;
                item.value = this.getConstantString(sub.name_index, CPConst.CONSTANT_Utf8);
            }
            else {
                // do nothing
            }
        }

        for (Constant item : entries) {
            if (item == null) continue;
            byte tag = item.tag;
            if (tag == CPConst.CONSTANT_Fieldref) {
                ConstantFieldref sub = (ConstantFieldref) item;
                int classIndex = sub.getClassIndex();
                int nameAndTypeIndex = sub.getNameAndTypeIndex();

                String className = this.getConstantString(classIndex, CPConst.CONSTANT_Class);
                String nameAndType = this.getConstantString(nameAndTypeIndex, CPConst.CONSTANT_NameAndType);
                item.value = className + "." + nameAndType;
            }
            else if (tag == CPConst.CONSTANT_Methodref) {
                ConstantMethodref sub = (ConstantMethodref) item;
                int classIndex = sub.getClassIndex();
                int nameAndTypeIndex = sub.getNameAndTypeIndex();

                String className = this.getConstantString(classIndex, CPConst.CONSTANT_Class);
                String nameAndType = this.getConstantString(nameAndTypeIndex, CPConst.CONSTANT_NameAndType);
                item.value = className + "." + nameAndType;
            }
            else if (tag == CPConst.CONSTANT_InterfaceMethodref) {
                ConstantInterfaceMethodref sub = (ConstantInterfaceMethodref) item;
                int classIndex = sub.getClassIndex();
                int nameAndTypeIndex = sub.getNameAndTypeIndex();

                String className = this.getConstantString(classIndex, CPConst.CONSTANT_Class);
                String nameAndType = this.getConstantString(nameAndTypeIndex, CPConst.CONSTANT_NameAndType);
                item.value = className + "." + nameAndType;
            }
            else if (tag == CPConst.CONSTANT_Dynamic) {
                ConstantDynamic sub = (ConstantDynamic) item;
                item.value = this.getConstantString(sub.name_and_type_index, CPConst.CONSTANT_NameAndType);
            }
            else if (tag == CPConst.CONSTANT_InvokeDynamic) {
                ConstantInvokeDynamic sub = (ConstantInvokeDynamic) item;
                item.value = "#" + sub.bootstrap_method_attr_index + ":" + this.getConstantString(sub.name_and_type_index, CPConst.CONSTANT_NameAndType);
            }
            else {
                // do nothing
            }
        }

        for (Constant item : entries) {
            if (item == null) continue;
            byte tag = item.tag;
            if (tag == CPConst.CONSTANT_MethodHandle) {
                ConstantMethodHandle sub = (ConstantMethodHandle) item;
                String reference_kind_str = getReferenceKind(sub.reference_kind);
                Constant target = this.getConstant(sub.reference_index);
                item.value = reference_kind_str + " " + target.value;
            }
        }
    }

    public static String getReferenceKind(int reference_kind) {
        switch (reference_kind) {
            case 1:
                return "getfield";
            case 2:
                return "getstatic";
            case 3:
                return "putfield";
            case 4:
                return "putstatic";
            case 5:
                return "invokevirtual";
            case 6:
                return "invokestatic";
            case 7:
                return "invokespecial";
            case 8:
                return "invokespecial";
            case 9:
                return "invokeinterface";
            default:
                throw new RuntimeException("Unknown reference_kind: " + reference_kind);
        }
    }

}
