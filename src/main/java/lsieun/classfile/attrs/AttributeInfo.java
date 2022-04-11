package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.classfile.Node;
import lsieun.cst.CPConst;
import lsieun.utils.ByteDashboard;
import lsieun.utils.ByteUtils;
import lsieun.vs.Visitor;

public class AttributeInfo extends Node {
    public final int attribute_name_index;
    public final int attribute_length;

    // auxiliary info
    public final String name;

    public AttributeInfo(ByteDashboard bd, ConstantPool cp) {
        byte[] attribute_name_index_bytes = bd.nextN(2);
        byte[] attribute_length_bytes = bd.nextN(4);

        this.attribute_name_index = ByteUtils.bytesToInt(attribute_name_index_bytes);
        this.attribute_length = ByteUtils.bytesToInt(attribute_length_bytes);

        byte[] info_bytes = bd.peekN(attribute_length);
        super.bytes = ByteUtils.concatenate(attribute_name_index_bytes, attribute_length_bytes, info_bytes);

        this.name = cp.getConstantString(attribute_name_index, CPConst.CONSTANT_Utf8);
    }

    public static AttributeInfo read(ByteDashboard bd, ConstantPool cp) {
        byte[] attribute_name_index_bytes = bd.peekN(2);
        int attribute_name_index = ByteUtils.bytesToInt(attribute_name_index_bytes, 0);

        String name = cp.getConstantString(attribute_name_index, CPConst.CONSTANT_Utf8);
        AttributeInfo instance;

        if ("SourceFile".equals(name)) {
            instance = new SourceFile(bd, cp);
        }
        else if ("InnerClasses".equals(name)) {
            instance = new InnerClasses(bd, cp);
        }
        else if ("Code".equals(name)) {
            instance = new Code(bd, cp);
        }
        else if ("LineNumberTable".equals(name)) {
            instance = new LineNumberTable(bd, cp);
        }
        else if ("LocalVariableTable".equals(name)) {
            instance = new LocalVariableTable(bd, cp);
        }
        else if ("LocalVariableTypeTable".equals(name)) {
            instance = new LocalVariableTypeTable(bd, cp);
        }
        else if ("Signature".equals(name)) {
            instance = new Signature(bd, cp);
        }
        else if ("Deprecated".equals(name)) {
            instance = new Deprecated(bd, cp);
        }
        else if ("Exceptions".equals(name)) {
            instance = new Exceptions(bd, cp);
        }
        else if ("ConstantValue".equals(name)) {
            instance = new ConstantValue(bd, cp);
        }
        else if ("RuntimeVisibleAnnotations".equals(name)) {
            instance = new RuntimeVisibleAnnotations(bd, cp);
        }
        else if ("RuntimeInvisibleAnnotations".equals(name)) {
            instance = new RuntimeInvisibleAnnotations(bd, cp);
        }
        else if ("RuntimeVisibleParameterAnnotations".equals(name)) {
            instance = new RuntimeVisibleParameterAnnotations(bd, cp);
        }
        else if ("RuntimeInvisibleParameterAnnotations".equals(name)) {
            instance = new RuntimeInvisibleParameterAnnotations(bd, cp);
        }
        else if ("RuntimeVisibleTypeAnnotations".equals(name)) {
            instance = new RuntimeVisibleTypeAnnotations(bd, cp);
        }
        else if ("RuntimeInvisibleTypeAnnotations".equals(name)) {
            instance = new RuntimeInvisibleTypeAnnotations(bd, cp);
        }
        else if ("StackMapTable".equals(name)) {
            instance = new StackMapTable(bd, cp);
        }
        else if ("MethodParameters".equals(name)) {
            instance = new MethodParameters(bd, cp);
        }
        else if ("EnclosingMethod".equals(name)) {
            instance = new EnclosingMethod(bd, cp);
        }
        else if ("AnnotationDefault".equals(name)) {
            instance = new AnnotationDefault(bd, cp);
        }
        else if ("BootstrapMethods".equals(name)) {
            instance = new BootstrapMethods(bd, cp);
        }
        else if ("SourceDebugExtension".equals(name)) {
            instance = new SourceDebugExtension(bd, cp);
        }
        else if ("Module".equals(name)) {
            instance = new Module(bd, cp);
        }
        else if ("ModulePackages".equals(name)) {
            instance = new ModulePackages(bd, cp);
        }
        else if ("ModuleMainClass".equals(name)) {
            instance = new ModuleMainClass(bd, cp);
        }
        else {
            throw new RuntimeException("Unknown Attribute Name: " + name);
//            instance = new AttributeInfo(bd, cp);
        }
        return instance;
    }

    public void accept(Visitor v) {
        v.visitAttributeInfo(this);
    }
}
