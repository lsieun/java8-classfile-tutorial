package lsieun.classfile.attrs;

import lsieun.classfile.ConstantPool;
import lsieun.utils.ByteDashboard;
import lsieun.vs.Visitor;

public class Module extends AttributeInfo {
    public final int module_name_index;
    public final int module_flags;
    public final int module_version_index;

    // requires
    public final int requires_count;
    public final ModuleRequires[] requires;

    // exports
    public final int exports_count;
    public final ModuleExports[] exports;

    // opens
    public final int opens_count;
    public final ModuleOpens[] opens;

    // uses
    public final int uses_count;
    public final int[] uses_index;

    // provides
    public final int provides_count;
    public final ModuleProvides[] provides;

    public Module(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.module_name_index = bd.readUnsignedShort();
        this.module_flags = bd.readUnsignedShort();
        this.module_version_index = bd.readUnsignedShort();

        // requires
        this.requires_count = bd.readUnsignedShort();
        this.requires = new ModuleRequires[requires_count];
        for (int i = 0; i < requires_count; i++) {
            this.requires[i] = new ModuleRequires(bd, cp);
        }

        // requires
        this.exports_count = bd.readUnsignedShort();
        this.exports = new ModuleExports[exports_count];
        for (int i = 0; i < exports_count; i++) {
            this.exports[i] = new ModuleExports(bd, cp);
        }

        // opens
        this.opens_count = bd.readUnsignedShort();
        this.opens = new ModuleOpens[opens_count];
        for (int i = 0; i < opens_count; i++) {
            this.opens[i] = new ModuleOpens(bd, cp);
        }

        // uses
        this.uses_count = bd.readUnsignedShort();
        this.uses_index = new int[uses_count];
        for (int i = 0; i < uses_count; i++) {
            this.uses_index[i] = bd.readUnsignedShort();
        }

        // provides
        this.provides_count = bd.readUnsignedShort();
        this.provides = new ModuleProvides[provides_count];
        for (int i = 0; i < provides_count; i++) {
            this.provides[i] = new ModuleProvides(bd, cp);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitModule(this);
    }
}
