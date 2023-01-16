package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLong2IntFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLong2IntFunction.class */
public abstract class AbstractLong2IntFunction implements Long2IntFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected int defRetValue;

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction
    public void defaultReturnValue(int rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntFunction
    public int defaultReturnValue() {
        return this.defRetValue;
    }
}
