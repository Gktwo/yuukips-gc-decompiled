package org.bson.codecs.pojo;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/InstanceCreator.class */
public interface InstanceCreator<T> {
    <S> void set(S s, PropertyModel<S> propertyModel);

    T getInstance();
}
