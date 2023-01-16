package org.bson.codecs.pojo;

import org.bson.codecs.Codec;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PojoCodec.class */
public abstract class PojoCodec<T> implements Codec<T> {
    /* access modifiers changed from: package-private */
    public abstract ClassModel<T> getClassModel();

    /* access modifiers changed from: package-private */
    public abstract DiscriminatorLookup getDiscriminatorLookup();
}
