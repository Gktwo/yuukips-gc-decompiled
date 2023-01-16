package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;

/* renamed from: it.unimi.dsi.fastutil.objects.AbstractReference2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/AbstractReference2BooleanFunction.class */
public abstract class AbstractReference2BooleanFunction<K> implements Reference2BooleanFunction<K>, Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected boolean defRetValue;

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction
    public void defaultReturnValue(boolean rv) {
        this.defRetValue = rv;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2BooleanFunction
    public boolean defaultReturnValue() {
        return this.defRetValue;
    }
}
