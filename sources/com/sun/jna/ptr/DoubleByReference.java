package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* loaded from: grasscutter.jar:com/sun/jna/ptr/DoubleByReference.class */
public class DoubleByReference extends ByReference {
    public DoubleByReference() {
        this(0.0d);
    }

    public DoubleByReference(double value) {
        super(8);
        setValue(value);
    }

    public void setValue(double value) {
        getPointer().setDouble(0, value);
    }

    public double getValue() {
        return getPointer().getDouble(0);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("double@0x%x=%s", Long.valueOf(Pointer.nativeValue(getPointer())), Double.valueOf(getValue()));
    }
}
