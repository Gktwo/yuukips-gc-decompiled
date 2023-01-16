package dev.morphia.mapping;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.mapping.codec.MorphiaCodecProvider;
import java.lang.annotation.Annotation;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:dev/morphia/mapping/MorphiaShortCutProvider.class */
class MorphiaShortCutProvider implements CodecProvider {
    private final Mapper mapper;
    private final MorphiaCodecProvider codecProvider;

    MorphiaShortCutProvider(Mapper mapper, MorphiaCodecProvider codecProvider) {
        this.mapper = mapper;
        this.codecProvider = codecProvider;
    }

    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        if (hasAnnotation(clazz, Entity.class) || hasAnnotation(clazz, Embedded.class) || this.mapper.isMapped(clazz)) {
            return this.codecProvider.get(clazz, registry);
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<? extends java.lang.annotation.Annotation> */
    /* JADX WARN: Multi-variable type inference failed */
    private <T> boolean hasAnnotation(Class<T> clazz, Class<? extends Annotation> ann) {
        return clazz.getAnnotation(ann) != null;
    }
}
