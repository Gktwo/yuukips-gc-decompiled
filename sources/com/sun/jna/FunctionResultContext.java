package com.sun.jna;

/* loaded from: grasscutter.jar:com/sun/jna/FunctionResultContext.class */
public class FunctionResultContext extends FromNativeContext {
    private Function function;
    private Object[] args;

    /* access modifiers changed from: package-private */
    public FunctionResultContext(Class<?> resultClass, Function function, Object[] args) {
        super(resultClass);
        this.function = function;
        this.args = args;
    }

    public Function getFunction() {
        return this.function;
    }

    public Object[] getArguments() {
        return this.args;
    }
}
