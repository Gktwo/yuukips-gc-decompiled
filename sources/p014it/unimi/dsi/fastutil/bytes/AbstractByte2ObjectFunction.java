package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2ObjectFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2ObjectFunction.class */
public abstract class AbstractByte2ObjectFunction<V> implements Byte2ObjectFunction<V>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
    public void defaultReturnValue(V rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}
