package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDouble2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDouble2FloatFunction.class */
public abstract class AbstractDouble2FloatFunction implements Double2FloatFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected float defRetValue;

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction
    public void defaultReturnValue(float rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction
    public float defaultReturnValue() {
        return this.defRetValue;
    }
}
