package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2ObjectFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2ObjectFunction.class */
public abstract class AbstractReference2ObjectFunction<K, V> implements Reference2ObjectFunction<K, V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
