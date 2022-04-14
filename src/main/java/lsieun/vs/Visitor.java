package lsieun.vs;

import lsieun.classfile.*;
import lsieun.classfile.attrs.Deprecated;
import lsieun.classfile.attrs.*;
import lsieun.classfile.cp.*;

public interface Visitor {
    void visitClassFile(ClassFile obj);

    void visitMagicNumber(MagicNumber obj);

    void visitCompilerVersion(CompilerVersion obj);

    void visitConstantPool(ConstantPool obj);

    void visitClassInfo(ClassInfo obj);

    void visitFields(Fields obj);

    void visitFieldInfo(FieldInfo obj);

    void visitMethods(Methods obj);

    void visitMethodInfo(MethodInfo obj);

    void visitAttributes(Attributes obj);

    void visitAttributeInfo(AttributeInfo obj);



    // region constant pool
    void visitConstant(Constant obj);

    void visitConstantUtf8(ConstantUtf8 obj);

    void visitConstantInteger(ConstantInteger obj);

    void visitConstantFloat(ConstantFloat obj);

    void visitConstantLong(ConstantLong obj);

    void visitConstantDouble(ConstantDouble obj);

    void visitConstantClass(ConstantClass obj);

    void visitConstantString(ConstantString obj);

    void visitConstantFieldref(ConstantFieldref obj);

    void visitConstantMethodref(ConstantMethodref obj);

    void visitConstantInterfaceMethodref(ConstantInterfaceMethodref obj);

    void visitConstantNameAndType(ConstantNameAndType obj);

    void visitConstantMethodHandle(ConstantMethodHandle obj);

    void visitConstantMethodType(ConstantMethodType obj);

    void visitConstantDynamic(ConstantDynamic obj);

    void visitConstantInvokeDynamic(ConstantInvokeDynamic obj);

    void visitConstantModule(ConstantModule obj);

    void visitConstantPackage(ConstantPackage obj);
    // endregion

    // region attributes
    void visitAnnotationDefault(AnnotationDefault obj);

    void visitBootstrapMethods(BootstrapMethods obj);

    void visitCode(Code obj);

    void visitConstantValue(ConstantValue obj);

    void visitDeprecated(Deprecated obj);

    void visitEnclosingMethod(EnclosingMethod obj);

    void visitExceptions(Exceptions obj);

    void visitInnerClasses(InnerClasses obj);

    void visitLineNumberTable(LineNumberTable obj);

    void visitLocalVariableTable(LocalVariableTable obj);

    void visitLocalVariableTypeTable(LocalVariableTypeTable obj);

    void visitMethodParameters(MethodParameters obj);

    void visitRuntimeInvisibleAnnotations(RuntimeInvisibleAnnotations obj);

    void visitRuntimeVisibleAnnotations(RuntimeVisibleAnnotations obj);

    void visitRuntimeInvisibleParameterAnnotations(RuntimeInvisibleParameterAnnotations obj);

    void visitRuntimeVisibleParameterAnnotations(RuntimeVisibleParameterAnnotations obj);

    void visitRuntimeInvisibleTypeAnnotations(RuntimeInvisibleTypeAnnotations obj);

    void visitRuntimeVisibleTypeAnnotations(RuntimeVisibleTypeAnnotations obj);

    void visitSignature(Signature obj);

    void visitSourceDebugExtension(SourceDebugExtension obj);

    void visitSourceFile(SourceFile obj);

    void visitStackMapTable(StackMapTable obj);

    void visitModule(Module obj);

    void visitModulePackages(ModulePackages obj);

    void visitModuleMainClass(ModuleMainClass obj);

    void visitNestHost(NestHost obj);

    void visitNestMembers(NestMembers obj);

    void visitRecord(Record obj);

    void visitPermittedSubclasses(PermittedSubclasses obj);
    // endregion
}
