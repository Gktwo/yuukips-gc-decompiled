package org.bson.codecs.pojo;

import org.bson.codecs.Codec;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertyCodecRegistry.class */
public interface PropertyCodecRegistry {
    <T> Codec<T> get(TypeWithTypeParameters<T> typeWithTypeParameters);
}
