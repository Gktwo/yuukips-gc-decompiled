package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ObjectFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ObjectFunction.class */
public abstract class AbstractChar2ObjectFunction<V> implements Char2ObjectFunction<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
