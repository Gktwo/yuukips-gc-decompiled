package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBoolean2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBoolean2BooleanFunction.class */
public abstract class AbstractBoolean2BooleanFunction implements Boolean2BooleanFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected boolean defRetValue;

    protected AbstractBoolean2BooleanFunction() {
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2BooleanFunction
    public void defaultReturnValue(boolean rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2BooleanFunction
    public boolean defaultReturnValue() {
        return this.defRetValue;
    }
}
