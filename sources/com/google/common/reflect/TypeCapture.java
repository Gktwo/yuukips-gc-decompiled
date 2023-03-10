package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/common/reflect/TypeCapture.class */
public abstract class TypeCapture<T> {
    /* access modifiers changed from: package-private */
    public final Type capture() {
        Type superclass = getClass().getGenericSuperclass();
        Preconditions.checkArgument(superclass instanceof ParameterizedType, "%s isn't parameterized", superclass);
        return ((ParameterizedType) superclass).getActualTypeArguments()[0];
    }
}
