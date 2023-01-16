package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2IntFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2IntFunction.class */
public abstract class AbstractDouble2IntFunction implements Double2IntFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected int defRetValue;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntFunction
    public void defaultReturnValue(int rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2IntFunction
    public int defaultReturnValue() {
        return this.defRetValue;
    }
}
