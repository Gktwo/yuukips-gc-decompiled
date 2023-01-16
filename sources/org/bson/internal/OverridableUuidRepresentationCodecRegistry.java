package org.bson.internal;

import org.bson.UuidRepresentation;
import org.bson.assertions.Assertions;
import org.bson.codecs.Codec;
import org.bson.codecs.OverridableUuidRepresentationCodec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:org/bson/internal/OverridableUuidRepresentationCodecRegistry.class */
public class OverridableUuidRepresentationCodecRegistry implements CycleDetectingCodecRegistry {
    private final CodecProvider wrapped;
    private final CodecCache codecCache = new CodecCache();
    private final UuidRepresentation uuidRepresentation;

    /* access modifiers changed from: package-private */
    public OverridableUuidRepresentationCodecRegistry(CodecProvider wrapped, UuidRepresentation uuidRepresentation) {
        this.uuidRepresentation = (UuidRepresentation) Assertions.notNull("uuidRepresentation", uuidRepresentation);
        this.wrapped = (CodecProvider) Assertions.notNull("wrapped", wrapped);
    }

    public UuidRepresentation getUuidRepresentation() {
        return this.uuidRepresentation;
    }

    public CodecProvider getWrapped() {
        return this.wrapped;
    }

    @Override // org.bson.codecs.configuration.CodecRegistry
    public <T> Codec<T> get(Class<T> clazz) {
        return get(new ChildCodecRegistry<>(this, clazz));
    }

    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        Codec<T> codec = this.wrapped.get(clazz, registry);
        if (codec instanceof OverridableUuidRepresentationCodec) {
            return ((OverridableUuidRepresentationCodec) codec).withUuidRepresentation(this.uuidRepresentation);
        }
        return codec;
    }

    @Override // org.bson.internal.CycleDetectingCodecRegistry
    public <T> Codec<T> get(ChildCodecRegistry<T> context) {
        if (!this.codecCache.containsKey(context.getCodecClass())) {
            Codec<T> codec = this.wrapped.get(context.getCodecClass(), context);
            if (codec instanceof OverridableUuidRepresentationCodec) {
                codec = ((OverridableUuidRepresentationCodec) codec).withUuidRepresentation(this.uuidRepresentation);
            }
            this.codecCache.put(context.getCodecClass(), codec);
        }
        return this.codecCache.getOrThrow(context.getCodecClass());
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OverridableUuidRepresentationCodecRegistry that = (OverridableUuidRepresentationCodecRegistry) o;
        return this.wrapped.equals(that.wrapped) && this.uuidRepresentation == that.uuidRepresentation;
    }

    public int hashCode() {
        return (31 * this.wrapped.hashCode()) + this.uuidRepresentation.hashCode();
    }
}
