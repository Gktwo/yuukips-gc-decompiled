package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBoolean2ShortFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBoolean2ShortFunction.class */
public abstract class AbstractBoolean2ShortFunction implements Boolean2ShortFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected short defRetValue;

    protected AbstractBoolean2ShortFunction() {
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2ShortFunction
    public void defaultReturnValue(short rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2ShortFunction
    public short defaultReturnValue() {
        return this.defRetValue;
    }
}
