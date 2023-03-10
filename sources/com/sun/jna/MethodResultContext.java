package com.sun.jna;

import java.lang.reflect.Method;

/* loaded from: grasscutter.jar:com/sun/jna/MethodResultContext.class */
public class MethodResultContext extends FunctionResultContext {
    private final Method method;

    /* access modifiers changed from: package-private */
    public MethodResultContext(Class<?> resultClass, Function function, Object[] args, Method method) {
        super(resultClass, function, args);
        this.method = method;
    }

    public Method getMethod() {
        return this.method;
    }
}
