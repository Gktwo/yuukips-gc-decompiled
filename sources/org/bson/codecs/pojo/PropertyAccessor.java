package org.bson.codecs.pojo;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertyAccessor.class */
public interface PropertyAccessor<T> {
    <S> T get(S s);

    <S> void set(S s, T t);
}
