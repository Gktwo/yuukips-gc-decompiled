package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2ObjectFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2ObjectFunction.class */
public abstract class AbstractObject2ObjectFunction<K, V> implements Object2ObjectFunction<K, V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ObjectFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
