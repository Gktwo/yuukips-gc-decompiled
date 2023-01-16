package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2BooleanFunction.class */
public abstract class AbstractShort2BooleanFunction implements Short2BooleanFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected boolean defRetValue;

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction
    public void defaultReturnValue(boolean rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction
    public boolean defaultReturnValue() {
        return this.defRetValue;
    }
}
