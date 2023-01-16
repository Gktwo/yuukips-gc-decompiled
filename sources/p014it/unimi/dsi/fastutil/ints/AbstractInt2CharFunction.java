package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2CharFunction.class */
public abstract class AbstractInt2CharFunction implements Int2CharFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected char defRetValue;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    public void defaultReturnValue(char rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    public char defaultReturnValue() {
        return this.defRetValue;
    }
}
