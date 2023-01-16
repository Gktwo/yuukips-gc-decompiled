package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2ReferenceFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2ReferenceFunction.class */
public abstract class AbstractDouble2ReferenceFunction<V> implements Double2ReferenceFunction<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
