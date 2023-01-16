package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* loaded from: grasscutter.jar:com/sun/jna/ptr/LongByReference.class */
public class LongByReference extends ByReference {
    public LongByReference() {
        this(0);
    }

    public LongByReference(long value) {
        super(8);
        setValue(value);
    }

    public void setValue(long value) {
        getPointer().setLong(0, value);
    }

    public long getValue() {
        return getPointer().getLong(0);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("long@0x%1$x=0x%2$x (%2$d)", Long.valueOf(Pointer.nativeValue(getPointer())), Long.valueOf(getValue()));
    }
}
