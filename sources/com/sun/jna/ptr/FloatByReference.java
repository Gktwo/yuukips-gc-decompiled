package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* loaded from: grasscutter.jar:com/sun/jna/ptr/FloatByReference.class */
public class FloatByReference extends ByReference {
    public FloatByReference() {
        this(0.0f);
    }

    public FloatByReference(float value) {
        super(4);
        setValue(value);
    }

    public void setValue(float value) {
        getPointer().setFloat(0, value);
    }

    public float getValue() {
        return getPointer().getFloat(0);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("float@0x%x=%s", Long.valueOf(Pointer.nativeValue(getPointer())), Float.valueOf(getValue()));
    }
}
