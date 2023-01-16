package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2ReferenceFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2ReferenceFunction.class */
public abstract class AbstractInt2ReferenceFunction<V> implements Int2ReferenceFunction<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
