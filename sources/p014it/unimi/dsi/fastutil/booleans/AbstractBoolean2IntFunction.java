package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBoolean2IntFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBoolean2IntFunction.class */
public abstract class AbstractBoolean2IntFunction implements Boolean2IntFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected int defRetValue;

    protected AbstractBoolean2IntFunction() {
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2IntFunction
    public void defaultReturnValue(int rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2IntFunction
    public int defaultReturnValue() {
        return this.defRetValue;
    }
}
