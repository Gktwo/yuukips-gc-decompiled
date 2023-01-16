package org.bson.codecs.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.codecs.Codec;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/configuration/MapOfCodecsProvider.class */
public final class MapOfCodecsProvider implements CodecProvider {
    private final Map<Class<?>, Codec<?>> codecsMap = new HashMap();

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: java.util.Map<java.lang.Class<?>, org.bson.codecs.Codec<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public MapOfCodecsProvider(List<? extends Codec<?>> codecsList) {
        for (Codec<?> codec : codecsList) {
            this.codecsMap.put(codec.getEncoderClass(), codec);
        }
    }

    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        return (Codec<T>) this.codecsMap.get(clazz);
    }
}
