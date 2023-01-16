package org.bson.codecs.pojo;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/InstanceCreatorFactory.class */
public interface InstanceCreatorFactory<T> {
    InstanceCreator<T> create();
}
