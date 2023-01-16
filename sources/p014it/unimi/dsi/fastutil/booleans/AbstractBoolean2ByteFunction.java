package p014it.unimi.dsi.fastutil.booleans;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.booleans.AbstractBoolean2ByteFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/AbstractBoolean2ByteFunction.class */
public abstract class AbstractBoolean2ByteFunction implements Boolean2ByteFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected byte defRetValue;

    protected AbstractBoolean2ByteFunction() {
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2ByteFunction
    public void defaultReturnValue(byte rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.Boolean2ByteFunction
    public byte defaultReturnValue() {
        return this.defRetValue;
    }
}
