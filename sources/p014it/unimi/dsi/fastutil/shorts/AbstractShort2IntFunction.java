package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2IntFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2IntFunction.class */
public abstract class AbstractShort2IntFunction implements Short2IntFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected int defRetValue;

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
    public void defaultReturnValue(int rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
    public int defaultReturnValue() {
        return this.defRetValue;
    }
}
