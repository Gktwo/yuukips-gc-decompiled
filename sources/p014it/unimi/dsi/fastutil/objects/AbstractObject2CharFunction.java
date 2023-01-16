package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2CharFunction.class */
public abstract class AbstractObject2CharFunction<K> implements Object2CharFunction<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected char defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
    public void defaultReturnValue(char rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2CharFunction
    public char defaultReturnValue() {
        return this.defRetValue;
    }
}
