package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/EmptyImmutableListMultimap.class */
public class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {
    static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap();
    private static final long serialVersionUID = 0;

    private EmptyImmutableListMultimap() {
        super(ImmutableMap.m1419of(), 0);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
