package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2DoubleFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2DoubleFunction.class */
public abstract class AbstractShort2DoubleFunction implements Short2DoubleFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected double defRetValue;

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction
    public void defaultReturnValue(double rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction
    public double defaultReturnValue() {
        return this.defRetValue;
    }
}
