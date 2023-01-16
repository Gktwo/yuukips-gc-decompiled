package org.bson.internal;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecConfigurationException;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/internal/CodecCache.class */
public final class CodecCache {
    private final ConcurrentMap<Class<?>, Optional<Codec<?>>> codecCache = new ConcurrentHashMap();

    public boolean containsKey(Class<?> clazz) {
        return this.codecCache.containsKey(clazz);
    }

    public void put(Class<?> clazz, Codec<?> codec) {
        this.codecCache.put(clazz, Optional.ofNullable(codec));
    }

    public synchronized <T> Codec<T> putIfMissing(Class<T> clazz, Codec<T> codec) {
        Optional<Codec<?>> cachedCodec = this.codecCache.computeIfAbsent(clazz, clz -> {
            return Optional.of(codec);
        });
        if (cachedCodec.isPresent()) {
            return (Codec<T>) cachedCodec.get();
        }
        this.codecCache.put(clazz, Optional.of(codec));
        return codec;
    }

    public <T> Codec<T> getOrThrow(Class<T> clazz) {
        return (Codec<T>) this.codecCache.getOrDefault(clazz, Optional.empty()).orElseThrow(() -> {
            return new CodecConfigurationException(String.format("Can't find a codec for %s.", clazz));
        });
    }
}
