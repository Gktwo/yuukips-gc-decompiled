package dev.morphia.mapping.codec;

import java.util.HashMap;
import java.util.Map;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/PrimitiveCodecRegistry.class */
public class PrimitiveCodecRegistry implements CodecRegistry {
    private final Map<Class, Codec> primitiveCodecs = new HashMap();

    public PrimitiveCodecRegistry(CodecRegistry codecRegistry) {
        this.primitiveCodecs.put(Byte.TYPE, codecRegistry.get(Byte.class));
        this.primitiveCodecs.put(Character.TYPE, codecRegistry.get(Character.class));
        this.primitiveCodecs.put(Short.TYPE, codecRegistry.get(Short.class));
        this.primitiveCodecs.put(Integer.TYPE, codecRegistry.get(Integer.class));
        this.primitiveCodecs.put(Long.TYPE, codecRegistry.get(Long.class));
        this.primitiveCodecs.put(Float.TYPE, codecRegistry.get(Float.class));
        this.primitiveCodecs.put(Double.TYPE, codecRegistry.get(Double.class));
        this.primitiveCodecs.put(Boolean.TYPE, codecRegistry.get(Boolean.class));
    }

    @Override // org.bson.codecs.configuration.CodecRegistry
    public <T> Codec<T> get(Class<T> clazz) {
        return this.primitiveCodecs.get(clazz);
    }

    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        return this.primitiveCodecs.get(clazz);
    }
}
