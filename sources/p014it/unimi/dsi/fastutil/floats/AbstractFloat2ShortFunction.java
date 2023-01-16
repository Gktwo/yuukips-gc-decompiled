package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.floats.AbstractFloat2ShortFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/AbstractFloat2ShortFunction.class */
public abstract class AbstractFloat2ShortFunction implements Float2ShortFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected short defRetValue;

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    public void defaultReturnValue(short rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.Float2ShortFunction
    public short defaultReturnValue() {
        return this.defRetValue;
    }
}
