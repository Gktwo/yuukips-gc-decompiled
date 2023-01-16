package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2LongFunction.class */
public abstract class AbstractReference2LongFunction<K> implements Reference2LongFunction<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected long defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    public void defaultReturnValue(long rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
    public long defaultReturnValue() {
        return this.defRetValue;
    }
}
