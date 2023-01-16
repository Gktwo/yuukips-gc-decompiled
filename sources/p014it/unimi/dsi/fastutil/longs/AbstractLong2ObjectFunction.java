package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ObjectFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ObjectFunction.class */
public abstract class AbstractLong2ObjectFunction<V> implements Long2ObjectFunction<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
