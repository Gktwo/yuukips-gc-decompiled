package org.bson.codecs;

import org.bson.BsonType;

/* loaded from: grasscutter.jar:org/bson/codecs/RepresentationConfigurable.class */
public interface RepresentationConfigurable<T> {
    BsonType getRepresentation();

    Codec<T> withRepresentation(BsonType bsonType);
}
