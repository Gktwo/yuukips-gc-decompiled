package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2CharFunction.class */
public abstract class AbstractDouble2CharFunction implements Double2CharFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected char defRetValue;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction
    public void defaultReturnValue(char rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2CharFunction
    public char defaultReturnValue() {
        return this.defRetValue;
    }
}
