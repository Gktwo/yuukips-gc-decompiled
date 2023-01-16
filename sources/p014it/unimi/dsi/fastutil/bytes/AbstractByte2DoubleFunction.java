package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2DoubleFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2DoubleFunction.class */
public abstract class AbstractByte2DoubleFunction implements Byte2DoubleFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected double defRetValue;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction
    public void defaultReturnValue(double rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction
    public double defaultReturnValue() {
        return this.defRetValue;
    }
}
