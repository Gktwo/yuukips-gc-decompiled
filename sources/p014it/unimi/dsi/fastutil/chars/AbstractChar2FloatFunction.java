package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2FloatFunction.class */
public abstract class AbstractChar2FloatFunction implements Char2FloatFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected float defRetValue;

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
    public void defaultReturnValue(float rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatFunction
    public float defaultReturnValue() {
        return this.defRetValue;
    }
}
