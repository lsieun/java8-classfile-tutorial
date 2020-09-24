package lsieun.classfile.attrs.annotation.type;

import lsieun.classfile.ConstantPool;
import lsieun.classfile.attrs.annotation.ElementValuePair;
import lsieun.utils.ByteDashboard;

public class TypeAnnotation {
    public final int target_type;
    public final TargetInfo target_info;
    public final TypePath target_path;
    public final int type_index;
    public final int num_element_value_pairs;
    public final ElementValuePair[] element_value_pairs;

    public TypeAnnotation(ByteDashboard bd, ConstantPool cp) {
        this.target_type = bd.readUnsignedByte();
        TargetInfo target_info = null;

        switch (target_type) {
            case 0x00:
            case 0x01:
                TypeParameterTarget type_parameter_target = new TypeParameterTarget(bd);
                target_info = new TargetInfo(type_parameter_target);
                break;
            case 0x10:
                SuperTypeTarget supertype_target = new SuperTypeTarget(bd);
                target_info = new TargetInfo(supertype_target);
                break;
            case 0x11:
            case 0x12:
                TypeParameterBoundTarget type_parameter_bound_target = new TypeParameterBoundTarget(bd);
                target_info = new TargetInfo(type_parameter_bound_target);
                break;
            case 0x13:
            case 0x14:
            case 0x15:
                EmptyTarget empty_target = new EmptyTarget();
                target_info = new TargetInfo(empty_target);
                break;
            case 0x16:
                FormalParameterTarget method_formal_parameter_target = new FormalParameterTarget(bd);
                target_info = new TargetInfo(method_formal_parameter_target);
                break;
            case 0x17:
                ThrowsTarget throws_target = new ThrowsTarget(bd);
                target_info = new TargetInfo(throws_target);
                break;
            case 0x40:
            case 0x41:
                LocalVarTarget localvar_target = new LocalVarTarget(bd);
                target_info = new TargetInfo(localvar_target);
                break;
            case 0x42:
                CatchTarget catch_target = new CatchTarget(bd);
                target_info = new TargetInfo(catch_target);
                break;
            case 0x43:
            case 0x44:
            case 0x45:
            case 0x46:
                OffsetTarget offset_target = new OffsetTarget(bd);
                target_info = new TargetInfo(offset_target);
                break;
            case 0x47:
                TypeArgumentTarget type_argument_target = new TypeArgumentTarget(bd);
                target_info = new TargetInfo(type_argument_target);
                break;
            default:
                throw new RuntimeException("Unknown target_type: " + target_type);
        }
        this.target_info = target_info;
        this.target_path = new TypePath(bd);

        this.type_index = bd.readUnsignedShort();
        this.num_element_value_pairs = bd.readUnsignedShort();
        this.element_value_pairs = new ElementValuePair[num_element_value_pairs];

        for (int i = 0; i < num_element_value_pairs; i++) {
            ElementValuePair item = new ElementValuePair(bd, cp);
            this.element_value_pairs[i] = item;
        }
    }
}
