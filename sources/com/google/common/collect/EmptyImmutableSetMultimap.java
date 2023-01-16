package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/EmptyImmutableSetMultimap.class */
public class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
    static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
    private static final long serialVersionUID = 0;

    private EmptyImmutableSetMultimap() {
        super(ImmutableMap.m1419of(), 0, null);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
