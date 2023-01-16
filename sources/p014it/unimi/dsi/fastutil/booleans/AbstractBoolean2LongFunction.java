package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBoolean2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBoolean2LongFunction.class */
public abstract class AbstractBoolean2LongFunction implements Boolean2LongFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected long defRetValue;

    protected AbstractBoolean2LongFunction() {
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2LongFunction
    public void defaultReturnValue(long rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2LongFunction
    public long defaultReturnValue() {
        return this.defRetValue;
    }
}
