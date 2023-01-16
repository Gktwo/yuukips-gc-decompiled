package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByte2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByte2BooleanFunction.class */
public abstract class AbstractByte2BooleanFunction implements Byte2BooleanFunction, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected boolean defRetValue;

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
    public void defaultReturnValue(boolean rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction
    public boolean defaultReturnValue() {
        return this.defRetValue;
    }
}
