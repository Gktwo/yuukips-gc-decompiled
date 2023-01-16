package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ShortFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ShortFunction.class */
public abstract class AbstractChar2ShortFunction implements Char2ShortFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected short defRetValue;

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortFunction
    public void defaultReturnValue(short rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortFunction
    public short defaultReturnValue() {
        return this.defRetValue;
    }
}
