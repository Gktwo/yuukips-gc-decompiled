package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBoolean2ObjectFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBoolean2ObjectFunction.class */
public abstract class AbstractBoolean2ObjectFunction<V> implements Boolean2ObjectFunction<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    protected AbstractBoolean2ObjectFunction() {
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2ObjectFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2ObjectFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
