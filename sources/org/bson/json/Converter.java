package org.bson.json;

/* loaded from: grasscutter.jar:org/bson/json/Converter.class */
public interface Converter<T> {
    void convert(T t, StrictJsonWriter strictJsonWriter);
}
