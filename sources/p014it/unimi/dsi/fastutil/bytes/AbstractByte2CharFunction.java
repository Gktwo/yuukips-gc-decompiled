package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2CharFunction.class */
public abstract class AbstractByte2CharFunction implements Byte2CharFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected char defRetValue;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
    public void defaultReturnValue(char rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
    public char defaultReturnValue() {
        return this.defRetValue;
    }
}
