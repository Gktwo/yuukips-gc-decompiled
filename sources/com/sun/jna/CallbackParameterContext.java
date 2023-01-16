package com.sun.jna;

import java.lang.reflect.Method;

/* loaded from: grasscutter.jar:com/sun/jna/CallbackParameterContext.class */
public class CallbackParameterContext extends FromNativeContext {
    private Method method;
    private Object[] args;
    private int index;

    /* access modifiers changed from: package-private */
    public CallbackParameterContext(Class<?> javaType, Method m, Object[] args, int index) {
        super(javaType);
        this.method = m;
        this.args = args;
        this.index = index;
    }

    public Method getMethod() {
        return this.method;
    }

    public Object[] getArguments() {
        return this.args;
    }

    public int getIndex() {
        return this.index;
    }
}
