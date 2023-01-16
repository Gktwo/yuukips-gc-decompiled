package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractObject2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractObject2FloatFunction.class */
public abstract class AbstractObject2FloatFunction<K> implements Object2FloatFunction<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected float defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
    public void defaultReturnValue(float rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
    public float defaultReturnValue() {
        return this.defRetValue;
    }
}
