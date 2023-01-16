package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2FloatFunction.class */
public abstract class AbstractShort2FloatFunction implements Short2FloatFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected float defRetValue;

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction
    public void defaultReturnValue(float rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction
    public float defaultReturnValue() {
        return this.defRetValue;
    }
}
