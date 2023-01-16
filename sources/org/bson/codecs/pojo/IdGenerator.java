package org.bson.codecs.pojo;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/IdGenerator.class */
public interface IdGenerator<T> {
    T generate();

    Class<T> getType();
}
