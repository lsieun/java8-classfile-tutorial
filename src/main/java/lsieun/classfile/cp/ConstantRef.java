package lsieun.classfile.cp;

public interface ConstantRef {

    int getClassIndex();

    void setClassIndex(int class_index);

    int getNameAndTypeIndex();

    void setNameAndTypeIndex(int name_and_type_index);

}
