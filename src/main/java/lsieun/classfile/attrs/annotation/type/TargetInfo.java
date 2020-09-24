package lsieun.classfile.attrs.annotation.type;

public class TargetInfo {
    public final TypeParameterTarget type_parameter_target;
    public final SuperTypeTarget supertype_target;
    public final TypeParameterBoundTarget type_parameter_bound_target;
    public final EmptyTarget empty_target;
    public final FormalParameterTarget method_formal_parameter_target;
    public final ThrowsTarget throws_target;
    public final LocalVarTarget localvar_target;
    public final CatchTarget catch_target;
    public final OffsetTarget offset_target;
    public final TypeArgumentTarget type_argument_target;

    public TargetInfo(TypeParameterTarget type_parameter_target) {
        this.type_parameter_target = type_parameter_target;
        this.supertype_target = null;
        this.type_parameter_bound_target = null;
        this.empty_target = null;
        this.method_formal_parameter_target = null;
        this.throws_target = null;
        this.localvar_target = null;
        this.catch_target = null;
        this.offset_target = null;
        this.type_argument_target = null;
    }

    public TargetInfo(SuperTypeTarget supertype_target) {
        this.type_parameter_target = null;
        this.supertype_target = supertype_target;
        this.type_parameter_bound_target = null;
        this.empty_target = null;
        this.method_formal_parameter_target = null;
        this.throws_target = null;
        this.localvar_target = null;
        this.catch_target = null;
        this.offset_target = null;
        this.type_argument_target = null;
    }

    public TargetInfo(TypeParameterBoundTarget type_parameter_bound_target) {
        this.type_parameter_target = null;
        this.supertype_target = null;
        this.type_parameter_bound_target = type_parameter_bound_target;
        this.empty_target = null;
        this.method_formal_parameter_target = null;
        this.throws_target = null;
        this.localvar_target = null;
        this.catch_target = null;
        this.offset_target = null;
        this.type_argument_target = null;
    }

    public TargetInfo(EmptyTarget empty_target) {
        this.type_parameter_target = null;
        this.supertype_target = null;
        this.type_parameter_bound_target = null;
        this.empty_target = empty_target;
        this.method_formal_parameter_target = null;
        this.throws_target = null;
        this.localvar_target = null;
        this.catch_target = null;
        this.offset_target = null;
        this.type_argument_target = null;
    }

    public TargetInfo(FormalParameterTarget method_formal_parameter_target) {
        this.type_parameter_target = null;
        this.supertype_target = null;
        this.type_parameter_bound_target = null;
        this.empty_target = null;
        this.method_formal_parameter_target = method_formal_parameter_target;
        this.throws_target = null;
        this.localvar_target = null;
        this.catch_target = null;
        this.offset_target = null;
        this.type_argument_target = null;
    }

    public TargetInfo(ThrowsTarget throws_target) {
        this.type_parameter_target = null;
        this.supertype_target = null;
        this.type_parameter_bound_target = null;
        this.empty_target = null;
        this.method_formal_parameter_target = null;
        this.throws_target = throws_target;
        this.localvar_target = null;
        this.catch_target = null;
        this.offset_target = null;
        this.type_argument_target = null;
    }

    public TargetInfo(LocalVarTarget localvar_target) {
        this.type_parameter_target = null;
        this.supertype_target = null;
        this.type_parameter_bound_target = null;
        this.empty_target = null;
        this.method_formal_parameter_target = null;
        this.throws_target = null;
        this.localvar_target = localvar_target;
        this.catch_target = null;
        this.offset_target = null;
        this.type_argument_target = null;
    }

    public TargetInfo(CatchTarget catch_target) {
        this.type_parameter_target = null;
        this.supertype_target = null;
        this.type_parameter_bound_target = null;
        this.empty_target = null;
        this.method_formal_parameter_target = null;
        this.throws_target = null;
        this.localvar_target = null;
        this.catch_target = catch_target;
        this.offset_target = null;
        this.type_argument_target = null;
    }

    public TargetInfo(OffsetTarget offset_target) {
        this.type_parameter_target = null;
        this.supertype_target = null;
        this.type_parameter_bound_target = null;
        this.empty_target = null;
        this.method_formal_parameter_target = null;
        this.throws_target = null;
        this.localvar_target = null;
        this.catch_target = null;
        this.offset_target = offset_target;
        this.type_argument_target = null;
    }

    public TargetInfo(TypeArgumentTarget type_argument_target) {
        this.type_parameter_target = null;
        this.supertype_target = null;
        this.type_parameter_bound_target = null;
        this.empty_target = null;
        this.method_formal_parameter_target = null;
        this.throws_target = null;
        this.localvar_target = null;
        this.catch_target = null;
        this.offset_target = null;
        this.type_argument_target = type_argument_target;
    }

    private TargetInfo() {
        this.type_parameter_target = null;
        this.supertype_target = null;
        this.type_parameter_bound_target = null;
        this.empty_target = null;
        this.method_formal_parameter_target = null;
        this.throws_target = null;
        this.localvar_target = null;
        this.catch_target = null;
        this.offset_target = null;
        this.type_argument_target = null;
    }
}
