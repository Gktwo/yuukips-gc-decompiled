package org.bson.codecs.configuration;

import org.bson.codecs.Codec;

/* loaded from: grasscutter.jar:org/bson/codecs/configuration/CodecRegistry.class */
public interface CodecRegistry extends CodecProvider {
    <T> Codec<T> get(Class<T> cls);
}
