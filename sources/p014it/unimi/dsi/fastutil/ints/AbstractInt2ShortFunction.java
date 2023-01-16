package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2ShortFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2ShortFunction.class */
public abstract class AbstractInt2ShortFunction implements Int2ShortFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected short defRetValue;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
    public void defaultReturnValue(short rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ShortFunction
    public short defaultReturnValue() {
        return this.defRetValue;
    }
}
