package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBoolean2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBoolean2FloatFunction.class */
public abstract class AbstractBoolean2FloatFunction implements Boolean2FloatFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected float defRetValue;

    protected AbstractBoolean2FloatFunction() {
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2FloatFunction
    public void defaultReturnValue(float rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2FloatFunction
    public float defaultReturnValue() {
        return this.defRetValue;
    }
}
