package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBoolean2DoubleFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBoolean2DoubleFunction.class */
public abstract class AbstractBoolean2DoubleFunction implements Boolean2DoubleFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected double defRetValue;

    protected AbstractBoolean2DoubleFunction() {
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2DoubleFunction
    public void defaultReturnValue(double rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2DoubleFunction
    public double defaultReturnValue() {
        return this.defRetValue;
    }
}
