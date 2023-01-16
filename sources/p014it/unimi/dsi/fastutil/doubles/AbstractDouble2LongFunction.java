package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2LongFunction.class */
public abstract class AbstractDouble2LongFunction implements Double2LongFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected long defRetValue;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongFunction
    public void defaultReturnValue(long rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2LongFunction
    public long defaultReturnValue() {
        return this.defRetValue;
    }
}
