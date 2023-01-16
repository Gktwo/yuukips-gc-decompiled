package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ReferenceFunction.class */
public abstract class AbstractFloat2ReferenceFunction<V> implements Float2ReferenceFunction<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
