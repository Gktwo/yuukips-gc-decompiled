package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.chars.AbstractChar2ByteFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/AbstractChar2ByteFunction.class */
public abstract class AbstractChar2ByteFunction implements Char2ByteFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected byte defRetValue;

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteFunction
    public void defaultReturnValue(byte rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteFunction
    public byte defaultReturnValue() {
        return this.defRetValue;
    }
}
