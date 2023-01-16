package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBoolean2ReferenceFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBoolean2ReferenceFunction.class */
public abstract class AbstractBoolean2ReferenceFunction<V> implements Boolean2ReferenceFunction<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    protected AbstractBoolean2ReferenceFunction() {
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2ReferenceFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2ReferenceFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
