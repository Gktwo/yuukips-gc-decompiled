package org.bson.codecs.pojo;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/InstanceCreatorFactoryImpl.class */
public final class InstanceCreatorFactoryImpl<T> implements InstanceCreatorFactory<T> {
    private final CreatorExecutable<T> creatorExecutable;

    /* access modifiers changed from: package-private */
    public InstanceCreatorFactoryImpl(CreatorExecutable<T> creatorExecutable) {
        this.creatorExecutable = creatorExecutable;
    }

    @Override // org.bson.codecs.pojo.InstanceCreatorFactory
    public InstanceCreator<T> create() {
        return new InstanceCreatorImpl(this.creatorExecutable);
    }
}
