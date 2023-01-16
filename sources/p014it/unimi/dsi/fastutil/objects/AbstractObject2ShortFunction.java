package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2ShortFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2ShortFunction.class */
public abstract class AbstractObject2ShortFunction<K> implements Object2ShortFunction<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected short defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
    public void defaultReturnValue(short rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
    public short defaultReturnValue() {
        return this.defRetValue;
    }
}
