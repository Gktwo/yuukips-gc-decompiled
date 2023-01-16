package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2ByteFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2ByteFunction.class */
public abstract class AbstractReference2ByteFunction<K> implements Reference2ByteFunction<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected byte defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
    public void defaultReturnValue(byte rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
    public byte defaultReturnValue() {
        return this.defRetValue;
    }
}
