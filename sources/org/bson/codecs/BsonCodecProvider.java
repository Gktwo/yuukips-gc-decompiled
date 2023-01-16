package org.bson.codecs;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:org/bson/codecs/BsonCodecProvider.class */
public class BsonCodecProvider implements CodecProvider {
    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        if (Bson.class.isAssignableFrom(clazz)) {
            return new BsonCodec(registry);
        }
        return null;
    }
}
