package org.bson.codecs.pojo;

import org.bson.codecs.Codec;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertyCodecProvider.class */
public interface PropertyCodecProvider {
    <T> Codec<T> get(TypeWithTypeParameters<T> typeWithTypeParameters, PropertyCodecRegistry propertyCodecRegistry);
}
