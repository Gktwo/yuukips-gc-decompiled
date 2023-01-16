package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2CharFunction.class */
public abstract class AbstractLong2CharFunction implements Long2CharFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected char defRetValue;

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
    public void defaultReturnValue(char rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
    public char defaultReturnValue() {
        return this.defRetValue;
    }
}
