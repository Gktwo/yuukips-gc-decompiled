package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2ShortFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2ShortFunction.class */
public abstract class AbstractReference2ShortFunction<K> implements Reference2ShortFunction<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected short defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction
    public void defaultReturnValue(short rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction
    public short defaultReturnValue() {
        return this.defRetValue;
    }
}
