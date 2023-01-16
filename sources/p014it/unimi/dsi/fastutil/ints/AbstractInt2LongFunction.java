package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2LongFunction.class */
public abstract class AbstractInt2LongFunction implements Int2LongFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected long defRetValue;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction
    public void defaultReturnValue(long rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2LongFunction
    public long defaultReturnValue() {
        return this.defRetValue;
    }
}
