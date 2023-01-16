package dev.morphia.mapping.codec;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/EnumCodecProvider.class */
public class EnumCodecProvider implements CodecProvider {
    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> type, CodecRegistry registry) {
        if (type.isEnum()) {
            return new EnumCodec(type);
        }
        return null;
    }
}
