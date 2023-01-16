package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractInt2ByteFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractInt2ByteFunction.class */
public abstract class AbstractInt2ByteFunction implements Int2ByteFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected byte defRetValue;

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    public void defaultReturnValue(byte rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2ByteFunction
    public byte defaultReturnValue() {
        return this.defRetValue;
    }
}
