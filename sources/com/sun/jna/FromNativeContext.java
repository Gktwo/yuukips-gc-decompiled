package com.sun.jna;

/* loaded from: grasscutter.jar:com/sun/jna/FromNativeContext.class */
public class FromNativeContext {
    private Class<?> type;

    /* access modifiers changed from: package-private */
    public FromNativeContext(Class<?> javaType) {
        this.type = javaType;
    }

    public Class<?> getTargetType() {
        return this.type;
    }
}
