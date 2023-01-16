package com.sun.jna;

/* loaded from: grasscutter.jar:com/sun/jna/ToNativeConverter.class */
public interface ToNativeConverter {
    Object toNative(Object obj, ToNativeContext toNativeContext);

    Class<?> nativeType();
}
