package org.bson.codecs;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.json.JsonObject;

/* loaded from: grasscutter.jar:org/bson/codecs/JsonObjectCodecProvider.class */
public final class JsonObjectCodecProvider implements CodecProvider {
    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        if (clazz.equals(JsonObject.class)) {
            return new JsonObjectCodec();
        }
        return null;
    }
}
