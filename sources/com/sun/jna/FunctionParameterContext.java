package com.sun.jna;

/* loaded from: grasscutter.jar:com/sun/jna/FunctionParameterContext.class */
public class FunctionParameterContext extends ToNativeContext {
    private Function function;
    private Object[] args;
    private int index;

    /* access modifiers changed from: package-private */
    public FunctionParameterContext(Function f, Object[] args, int index) {
        this.function = f;
        this.args = args;
        this.index = index;
    }

    public Function getFunction() {
        return this.function;
    }

    public Object[] getParameters() {
        return this.args;
    }

    public int getParameterIndex() {
        return this.index;
    }
}
