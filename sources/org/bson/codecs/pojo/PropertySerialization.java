package org.bson.codecs.pojo;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertySerialization.class */
public interface PropertySerialization<T> {
    boolean shouldSerialize(T t);
}
