package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ObjectFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ObjectFunction.class */
public abstract class AbstractFloat2ObjectFunction<V> implements Float2ObjectFunction<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
