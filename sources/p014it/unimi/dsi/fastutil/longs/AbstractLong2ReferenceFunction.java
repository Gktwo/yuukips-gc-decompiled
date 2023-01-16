package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2ReferenceFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2ReferenceFunction.class */
public abstract class AbstractLong2ReferenceFunction<V> implements Long2ReferenceFunction<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
