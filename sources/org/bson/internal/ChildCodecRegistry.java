package org.bson.internal;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/internal/ChildCodecRegistry.class */
public class ChildCodecRegistry<T> implements CodecRegistry {
    private final ChildCodecRegistry<?> parent;
    private final CycleDetectingCodecRegistry registry;
    private final Class<T> codecClass;

    /* access modifiers changed from: package-private */
    public ChildCodecRegistry(CycleDetectingCodecRegistry registry, Class<T> codecClass) {
        this.codecClass = codecClass;
        this.parent = null;
        this.registry = registry;
    }

    private ChildCodecRegistry(ChildCodecRegistry<?> parent, Class<T> codecClass) {
        this.parent = parent;
        this.codecClass = codecClass;
        this.registry = parent.registry;
    }

    public Class<T> getCodecClass() {
        return this.codecClass;
    }

    @Override // org.bson.codecs.configuration.CodecRegistry
    public <U> Codec<U> get(Class<U> clazz) {
        if (hasCycles(clazz).booleanValue()) {
            return new LazyCodec(this.registry, clazz);
        }
        return this.registry.get(new ChildCodecRegistry<>((ChildCodecRegistry<?>) this, (Class) clazz));
    }

    @Override // org.bson.codecs.configuration.CodecProvider
    public <U> Codec<U> get(Class<U> clazz, CodecRegistry registry) {
        return this.registry.get(clazz, registry);
    }

    private <U> Boolean hasCycles(Class<U> theClass) {
        for (ChildCodecRegistry current = this; current != null; current = current.parent) {
            if (current.codecClass.equals(theClass)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChildCodecRegistry<?> that = (ChildCodecRegistry) o;
        if (!this.codecClass.equals(that.codecClass)) {
            return false;
        }
        if (this.parent != null) {
            if (!this.parent.equals(that.parent)) {
                return false;
            }
        } else if (that.parent != null) {
            return false;
        }
        if (!this.registry.equals(that.registry)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (31 * ((31 * (this.parent != null ? this.parent.hashCode() : 0)) + this.registry.hashCode())) + this.codecClass.hashCode();
    }
}
