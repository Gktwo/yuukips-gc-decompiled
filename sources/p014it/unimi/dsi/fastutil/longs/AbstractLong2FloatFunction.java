package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2FloatFunction.class */
public abstract class AbstractLong2FloatFunction implements Long2FloatFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected float defRetValue;

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
    public void defaultReturnValue(float rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2FloatFunction
    public float defaultReturnValue() {
        return this.defRetValue;
    }
}
