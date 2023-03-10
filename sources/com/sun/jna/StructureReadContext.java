package com.sun.jna;

import java.lang.reflect.Field;

/* loaded from: grasscutter.jar:com/sun/jna/StructureReadContext.class */
public class StructureReadContext extends FromNativeContext {
    private Structure structure;
    private Field field;

    /* access modifiers changed from: package-private */
    public StructureReadContext(Structure struct, Field field) {
        super(field.getType());
        this.structure = struct;
        this.field = field;
    }

    public Structure getStructure() {
        return this.structure;
    }

    public Field getField() {
        return this.field;
    }
}
