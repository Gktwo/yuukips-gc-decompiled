package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ByteFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ByteFunction.class */
public abstract class AbstractByte2ByteFunction implements Byte2ByteFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected byte defRetValue;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
    public void defaultReturnValue(byte rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction
    public byte defaultReturnValue() {
        return this.defRetValue;
    }
}
