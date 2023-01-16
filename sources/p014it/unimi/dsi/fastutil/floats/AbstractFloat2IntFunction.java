package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2IntFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2IntFunction.class */
public abstract class AbstractFloat2IntFunction implements Float2IntFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected int defRetValue;

    @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
    public void defaultReturnValue(int rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
    public int defaultReturnValue() {
        return this.defRetValue;
    }
}
