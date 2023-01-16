package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2BooleanFunction.class */
public abstract class AbstractObject2BooleanFunction<K> implements Object2BooleanFunction<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected boolean defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
    public void defaultReturnValue(boolean rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
    public boolean defaultReturnValue() {
        return this.defRetValue;
    }
}
