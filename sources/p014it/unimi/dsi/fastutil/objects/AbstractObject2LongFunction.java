package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2LongFunction.class */
public abstract class AbstractObject2LongFunction<K> implements Object2LongFunction<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected long defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunction
    public void defaultReturnValue(long rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2LongFunction
    public long defaultReturnValue() {
        return this.defRetValue;
    }
}
