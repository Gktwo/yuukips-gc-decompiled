package com.sun.jna;

import java.lang.reflect.Method;

/* loaded from: grasscutter.jar:com/sun/jna/CallbackResultContext.class */
public class CallbackResultContext extends ToNativeContext {
    private Method method;

    /* access modifiers changed from: package-private */
    public CallbackResultContext(Method callbackMethod) {
        this.method = callbackMethod;
    }

    public Method getMethod() {
        return this.method;
    }
}
