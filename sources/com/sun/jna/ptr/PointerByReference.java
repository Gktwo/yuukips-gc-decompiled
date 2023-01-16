package com.sun.jna.ptr;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

/* loaded from: grasscutter.jar:com/sun/jna/ptr/PointerByReference.class */
public class PointerByReference extends ByReference {
    public PointerByReference() {
        this(null);
    }

    public PointerByReference(Pointer value) {
        super(Native.POINTER_SIZE);
        setValue(value);
    }

    public void setValue(Pointer value) {
        getPointer().setPointer(0, value);
    }

    public Pointer getValue() {
        return getPointer().getPointer(0);
    }
}
