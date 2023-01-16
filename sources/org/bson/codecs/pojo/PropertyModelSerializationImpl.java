package org.bson.codecs.pojo;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertyModelSerializationImpl.class */
public class PropertyModelSerializationImpl<T> implements PropertySerialization<T> {
    @Override // org.bson.codecs.pojo.PropertySerialization
    public boolean shouldSerialize(T value) {
        return value != null;
    }
}
