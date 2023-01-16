package com.sun.jna;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: grasscutter.jar:com/sun/jna/NativeMappedConverter.class */
public class NativeMappedConverter implements TypeConverter {
    private static final Map<Class<?>, Reference<NativeMappedConverter>> converters = new WeakHashMap();
    private final Class<?> type;
    private final Class<?> nativeType;
    private final NativeMapped instance;

    public static NativeMappedConverter getInstance(Class<?> cls) {
        NativeMappedConverter nmc;
        synchronized (converters) {
            Reference<NativeMappedConverter> r = converters.get(cls);
            nmc = r != null ? r.get() : null;
            if (nmc == null) {
                nmc = new NativeMappedConverter(cls);
                converters.put(cls, new SoftReference(nmc));
            }
        }
        return nmc;
    }

    public NativeMappedConverter(Class<?> type) {
        if (!NativeMapped.class.isAssignableFrom(type)) {
            throw new IllegalArgumentException("Type must derive from " + NativeMapped.class);
        }
        this.type = type;
        this.instance = defaultValue();
        this.nativeType = this.instance.nativeType();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public NativeMapped defaultValue() {
        if (this.type.isEnum()) {
            return (NativeMapped) this.type.getEnumConstants()[0];
        }
        return (NativeMapped) Klass.newInstance(this.type);
    }

    @Override // com.sun.jna.FromNativeConverter
    public Object fromNative(Object nativeValue, FromNativeContext context) {
        return this.instance.fromNative(nativeValue, context);
    }

    @Override // com.sun.jna.FromNativeConverter, com.sun.jna.ToNativeConverter
    public Class<?> nativeType() {
        return this.nativeType;
    }

    @Override // com.sun.jna.ToNativeConverter
    public Object toNative(Object value, ToNativeContext context) {
        if (value == null) {
            if (Pointer.class.isAssignableFrom(this.nativeType)) {
                return null;
            }
            value = defaultValue();
        }
        return ((NativeMapped) value).toNative();
    }
}
