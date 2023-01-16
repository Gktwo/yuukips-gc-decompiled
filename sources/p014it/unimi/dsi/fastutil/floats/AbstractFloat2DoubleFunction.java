package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2DoubleFunction.class */
public abstract class AbstractFloat2DoubleFunction implements Float2DoubleFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected double defRetValue;

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
    public void defaultReturnValue(double rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
    public double defaultReturnValue() {
        return this.defRetValue;
    }
}
