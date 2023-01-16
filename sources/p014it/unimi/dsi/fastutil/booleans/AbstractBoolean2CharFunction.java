package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBoolean2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBoolean2CharFunction.class */
public abstract class AbstractBoolean2CharFunction implements Boolean2CharFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected char defRetValue;

    protected AbstractBoolean2CharFunction() {
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2CharFunction
    public void defaultReturnValue(char rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2CharFunction
    public char defaultReturnValue() {
        return this.defRetValue;
    }
}
