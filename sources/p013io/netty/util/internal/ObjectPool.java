package p013io.netty.util.internal;

import p013io.netty.util.Recycler;

/* renamed from: io.netty.util.internal.ObjectPool */
/* loaded from: grasscutter.jar:io/netty/util/internal/ObjectPool.class */
public abstract class ObjectPool<T> {

    /* renamed from: io.netty.util.internal.ObjectPool$Handle */
    /* loaded from: grasscutter.jar:io/netty/util/internal/ObjectPool$Handle.class */
    public interface Handle<T> {
        void recycle(T t);
    }

    /* renamed from: io.netty.util.internal.ObjectPool$ObjectCreator */
    /* loaded from: grasscutter.jar:io/netty/util/internal/ObjectPool$ObjectCreator.class */
    public interface ObjectCreator<T> {
        T newObject(Handle<T> handle);
    }

    public abstract T get();

    ObjectPool() {
    }

    public static <T> ObjectPool<T> newPool(ObjectCreator<T> creator) {
        return new RecyclerObjectPool((ObjectCreator) ObjectUtil.checkNotNull(creator, "creator"));
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.internal.ObjectPool$RecyclerObjectPool */
    /* loaded from: grasscutter.jar:io/netty/util/internal/ObjectPool$RecyclerObjectPool.class */
    public static final class RecyclerObjectPool<T> extends ObjectPool<T> {
        private final Recycler<T> recycler;

        RecyclerObjectPool(final ObjectCreator<T> creator) {
            this.recycler = new Recycler<T>() { // from class: io.netty.util.internal.ObjectPool.RecyclerObjectPool.1
                @Override // p013io.netty.util.Recycler
                protected T newObject(Recycler.Handle<T> handle) {
                    return (T) creator.newObject(handle);
                }
            };
        }

        @Override // p013io.netty.util.internal.ObjectPool
        public T get() {
            return this.recycler.get();
        }
    }
}
