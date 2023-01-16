package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2LongFunction.class */
public abstract class AbstractByte2LongFunction implements Byte2LongFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected long defRetValue;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
    public void defaultReturnValue(long rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
    public long defaultReturnValue() {
        return this.defRetValue;
    }
}
