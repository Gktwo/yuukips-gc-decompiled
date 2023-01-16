package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2DoubleFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2DoubleFunction.class */
public abstract class AbstractDouble2DoubleFunction implements Double2DoubleFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected double defRetValue;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleFunction
    public void defaultReturnValue(double rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2DoubleFunction
    public double defaultReturnValue() {
        return this.defRetValue;
    }
}
