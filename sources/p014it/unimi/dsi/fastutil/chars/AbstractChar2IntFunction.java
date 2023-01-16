package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2IntFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2IntFunction.class */
public abstract class AbstractChar2IntFunction implements Char2IntFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected int defRetValue;

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
    public void defaultReturnValue(int rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
    public int defaultReturnValue() {
        return this.defRetValue;
    }
}
