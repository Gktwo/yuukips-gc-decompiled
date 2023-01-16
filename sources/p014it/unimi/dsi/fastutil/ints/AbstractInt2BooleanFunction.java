package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2BooleanFunction.class */
public abstract class AbstractInt2BooleanFunction implements Int2BooleanFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected boolean defRetValue;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
    public void defaultReturnValue(boolean rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
    public boolean defaultReturnValue() {
        return this.defRetValue;
    }
}
