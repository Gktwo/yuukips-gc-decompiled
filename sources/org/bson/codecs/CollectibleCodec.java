package org.bson.codecs;

import org.bson.BsonValue;

/* loaded from: grasscutter.jar:org/bson/codecs/CollectibleCodec.class */
public interface CollectibleCodec<T> extends Codec<T> {
    T generateIdIfAbsentFromDocument(T t);

    boolean documentHasId(T t);

    BsonValue getDocumentId(T t);
}
