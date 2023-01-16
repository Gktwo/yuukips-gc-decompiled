package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2FloatFunction.class */
public abstract class AbstractInt2FloatFunction implements Int2FloatFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected float defRetValue;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatFunction
    public void defaultReturnValue(float rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2FloatFunction
    public float defaultReturnValue() {
        return this.defRetValue;
    }
}
