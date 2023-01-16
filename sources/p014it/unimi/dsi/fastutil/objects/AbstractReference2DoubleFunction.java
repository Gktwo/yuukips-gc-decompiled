package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2DoubleFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2DoubleFunction.class */
public abstract class AbstractReference2DoubleFunction<K> implements Reference2DoubleFunction<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected double defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
    public void defaultReturnValue(double rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction
    public double defaultReturnValue() {
        return this.defRetValue;
    }
}
