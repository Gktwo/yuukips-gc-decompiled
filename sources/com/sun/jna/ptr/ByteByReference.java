package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* loaded from: grasscutter.jar:com/sun/jna/ptr/ByteByReference.class */
public class ByteByReference extends ByReference {
    public ByteByReference() {
        this((byte) 0);
    }

    public ByteByReference(byte value) {
        super(1);
        setValue(value);
    }

    public void setValue(byte value) {
        getPointer().setByte(0, value);
    }

    public byte getValue() {
        return getPointer().getByte(0);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("byte@0x%1$x=0x%2$x (%2$d)", Long.valueOf(Pointer.nativeValue(getPointer())), Byte.valueOf(getValue()));
    }
}
