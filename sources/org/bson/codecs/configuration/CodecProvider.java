package org.bson.codecs.configuration;

import org.bson.codecs.Codec;

/* loaded from: grasscutter.jar:org/bson/codecs/configuration/CodecProvider.class */
public interface CodecProvider {
    <T> Codec<T> get(Class<T> cls, CodecRegistry codecRegistry);
}
