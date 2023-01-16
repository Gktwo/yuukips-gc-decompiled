package com.sun.jna;

/* loaded from: grasscutter.jar:com/sun/jna/FromNativeConverter.class */
public interface FromNativeConverter {
    Object fromNative(Object obj, FromNativeContext fromNativeContext);

    @Override // com.sun.jna.ToNativeConverter
    Class<?> nativeType();
}
