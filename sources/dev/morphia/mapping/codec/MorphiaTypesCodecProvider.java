package dev.morphia.mapping.codec;

import dev.morphia.mapping.Mapper;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.codecs.Codec;
import org.bson.codecs.MapCodec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaTypesCodecProvider.class */
public class MorphiaTypesCodecProvider implements CodecProvider {
    private final Mapper mapper;
    private final Map<Class<?>, Codec<?>> codecs = new HashMap();

    public MorphiaTypesCodecProvider(Mapper mapper) {
        this.mapper = mapper;
        addCodec(new MorphiaDateCodec(mapper));
        addCodec(new MorphiaMapCodec(mapper));
        addCodec(new MorphiaLocalDateTimeCodec(mapper));
        addCodec(new MorphiaLocalTimeCodec());
        addCodec(new ClassCodec());
        addCodec(new CenterCodec());
        addCodec(new HashMapCodec());
        addCodec(new KeyCodec(mapper));
        addCodec(new LocaleCodec());
        addCodec(new ObjectCodec(mapper));
        addCodec(new ShapeCodec());
        addCodec(new URICodec());
        addCodec(new ByteWrapperArrayCodec());
        addCodec(new LegacyQueryCodec(mapper));
        List.of((Object[]) new Class[]{Boolean.TYPE, Boolean.class, Character.TYPE, Character.class, Double.TYPE, Double.class, Float.TYPE, Float.class, Integer.TYPE, Integer.class, Long.TYPE, Long.class, Short.TYPE, Short.class}).forEach(c -> {
            addCodec(new TypedArrayCodec(mapper, mapper));
        });
    }

    protected <T> void addCodec(Codec<T> codec) {
        this.codecs.put(codec.getEncoderClass(), codec);
    }

    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        Codec<T> codec = (Codec<T>) this.codecs.get(clazz);
        if (codec != null) {
            return codec;
        }
        if (AbstractMap.class.isAssignableFrom(clazz)) {
            return get(Map.class, registry);
        }
        if (!clazz.isArray() || clazz.getComponentType().equals(Byte.TYPE)) {
            return null;
        }
        return new ArrayCodec(this.mapper, clazz);
    }

    /* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaTypesCodecProvider$HashMapCodec.class */
    private static class HashMapCodec extends MapCodec {
        private HashMapCodec() {
        }

        @Override // org.bson.codecs.MapCodec, org.bson.codecs.Encoder
        public Class<Map<String, Object>> getEncoderClass() {
            return HashMap.class;
        }
    }
}
