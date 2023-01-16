package org.bson.internal;

import java.util.ArrayList;
import java.util.List;
import org.bson.assertions.Assertions;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:org/bson/internal/ProvidersCodecRegistry.class */
public final class ProvidersCodecRegistry implements CodecRegistry, CycleDetectingCodecRegistry {
    private final List<CodecProvider> codecProviders;
    private final CodecCache codecCache = new CodecCache();

    public ProvidersCodecRegistry(List<? extends CodecProvider> codecProviders) {
        Assertions.isTrueArgument("codecProviders must not be null or empty", codecProviders != null && codecProviders.size() > 0);
        this.codecProviders = new ArrayList(codecProviders);
    }

    @Override // org.bson.codecs.configuration.CodecRegistry
    public <T> Codec<T> get(Class<T> clazz) {
        return get(new ChildCodecRegistry<>(this, clazz));
    }

    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        for (CodecProvider provider : this.codecProviders) {
            Codec<T> codec = provider.get(clazz, registry);
            if (codec != null) {
                return codec;
            }
        }
        return null;
    }

    @Override // org.bson.internal.CycleDetectingCodecRegistry
    public <T> Codec<T> get(ChildCodecRegistry<T> context) {
        if (!this.codecCache.containsKey(context.getCodecClass())) {
            for (CodecProvider provider : this.codecProviders) {
                Codec<T> codec = provider.get(context.getCodecClass(), context);
                if (codec != null) {
                    return this.codecCache.putIfMissing(context.getCodecClass(), codec);
                }
            }
            this.codecCache.put(context.getCodecClass(), null);
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
        ProvidersCodecRegistry that = (ProvidersCodecRegistry) o;
        if (this.codecProviders.size() != that.codecProviders.size()) {
            return false;
        }
        for (int i = 0; i < this.codecProviders.size(); i++) {
            if (this.codecProviders.get(i).getClass() != that.codecProviders.get(i).getClass()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.codecProviders.hashCode();
    }
}
