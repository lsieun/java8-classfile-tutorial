package lsieun.vs;

import lsieun.classfile.*;
import lsieun.classfile.attrs.*;
import lsieun.classfile.attrs.Deprecated;
import lsieun.classfile.cp.*;

public class DefaultVisitor implements Visitor {
    // region ClassFile
    @Override
    public void visitClassFile(ClassFile obj) {

    }

    @Override
    public void visitMagicNumber(MagicNumber obj) {

    }

    @Override
    public void visitCompilerVersion(CompilerVersion obj) {

    }

    @Override
    public void visitConstantPool(ConstantPool obj) {

    }

    @Override
    public void visitClassInfo(ClassInfo obj) {

    }

    @Override
    public void visitFields(Fields obj) {

    }

    @Override
    public void visitFieldInfo(FieldInfo obj) {

    }

    @Override
    public void visitMethods(Methods obj) {

    }

    @Override
    public void visitMethodInfo(MethodInfo obj) {

    }

    @Override
    public void visitAttributes(Attributes obj) {

    }

    @Override
    public void visitAttributeInfo(AttributeInfo obj) {

    }
    // endregion

    // region Constant Pool
    @Override
    public void visitConstant(Constant obj) {

    }

    @Override
    public void visitConstantUtf8(ConstantUtf8 obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantInteger(ConstantInteger obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantFloat(ConstantFloat obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantLong(ConstantLong obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantDouble(ConstantDouble obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantClass(ConstantClass obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantString(ConstantString obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantFieldref(ConstantFieldref obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantMethodref(ConstantMethodref obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantInterfaceMethodref(ConstantInterfaceMethodref obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantNameAndType(ConstantNameAndType obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantMethodHandle(ConstantMethodHandle obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantMethodType(ConstantMethodType obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantDynamic(ConstantDynamic obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantInvokeDynamic(ConstantInvokeDynamic obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantModule(ConstantModule obj) {
        visitConstant(obj);
    }

    @Override
    public void visitConstantPackage(ConstantPackage obj) {
        visitConstant(obj);
    }
    // endregion

    // region Attributes
    @Override
    public void visitAnnotationDefault(AnnotationDefault obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitBootstrapMethods(BootstrapMethods obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitCode(Code obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitConstantValue(ConstantValue obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitDeprecated(Deprecated obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitEnclosingMethod(EnclosingMethod obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitExceptions(Exceptions obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitInnerClasses(InnerClasses obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitLineNumberTable(LineNumberTable obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitLocalVariableTable(LocalVariableTable obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitLocalVariableTypeTable(LocalVariableTypeTable obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitMethodParameters(MethodParameters obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitRuntimeInvisibleAnnotations(RuntimeInvisibleAnnotations obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitRuntimeVisibleAnnotations(RuntimeVisibleAnnotations obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitRuntimeInvisibleParameterAnnotations(RuntimeInvisibleParameterAnnotations obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitRuntimeVisibleParameterAnnotations(RuntimeVisibleParameterAnnotations obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitRuntimeInvisibleTypeAnnotations(RuntimeInvisibleTypeAnnotations obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitRuntimeVisibleTypeAnnotations(RuntimeVisibleTypeAnnotations obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitSignature(Signature obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitSourceDebugExtension(SourceDebugExtension obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitSourceFile(SourceFile obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitStackMapTable(StackMapTable obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitModule(Module obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitModulePackages(ModulePackages obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitModuleMainClass(ModuleMainClass obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitNestHost(NestHost obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitNestMembers(NestMembers obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitRecord(Record obj) {
        visitAttributeInfo(obj);
    }

    @Override
    public void visitPermittedSubclasses(PermittedSubclasses obj) {
        visitAttributeInfo(obj);
    }

    // endregion
}
