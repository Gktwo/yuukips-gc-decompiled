package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.shorts.AbstractShort2ByteFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/AbstractShort2ByteFunction.class */
public abstract class AbstractShort2ByteFunction implements Short2ByteFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected byte defRetValue;

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
    public void defaultReturnValue(byte rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
    public byte defaultReturnValue() {
        return this.defRetValue;
    }
}
