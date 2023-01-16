package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;

@Immutable(containerOf = {"B"})
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableClassToInstanceMap.class */
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.m1419of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* renamed from: of */
    public static <B> ImmutableClassToInstanceMap<B> m1440of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    /* renamed from: of */
    public static <B, T extends B> ImmutableClassToInstanceMap<B> m1439of(Class<T> type, T value) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.m1418of(type, value));
    }

    public static <B> Builder<B> builder() {
        return new Builder<>();
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableClassToInstanceMap$Builder.class */
    public static final class Builder<B> {
        private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder = ImmutableMap.builder();

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(Class<T> key, T value) {
            this.mapBuilder.put(key, value);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.google.common.collect.ImmutableMap$Builder<java.lang.Class<? extends B>, B> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class cls = (Class) entry.getKey();
                this.mapBuilder.put(cls, cast(cls, entry.getValue()));
            }
            return this;
        }

        private static <B, T extends B> T cast(Class<T> type, B value) {
            return (T) Primitives.wrap(type).cast(value);
        }

        public ImmutableClassToInstanceMap<B> build() {
            ImmutableMap<Class<? extends B>, B> map = this.mapBuilder.build();
            if (map.isEmpty()) {
                return ImmutableClassToInstanceMap.m1440of();
            }
            return new ImmutableClassToInstanceMap<>(map);
        }
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap) map;
        }
        return new Builder().putAll(map).build();
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> delegate) {
        this.delegate = delegate;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T extends B, java.lang.Object] */
    @Override // com.google.common.collect.ClassToInstanceMap
    public <T extends B> T getInstance(Class<T> type) {
        return this.delegate.get(Preconditions.checkNotNull(type));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @CanIgnoreReturnValue
    @Deprecated
    public <T extends B> T putInstance(Class<T> type, T value) {
        throw new UnsupportedOperationException();
    }

    Object readResolve() {
        return isEmpty() ? m1440of() : this;
    }
}
