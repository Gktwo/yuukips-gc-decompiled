package com.sun.jna;

/* loaded from: grasscutter.jar:com/sun/jna/NativeMapped.class */
public interface NativeMapped {
    Object fromNative(Object obj, FromNativeContext fromNativeContext);

    Object toNative();

    Class<?> nativeType();
}
