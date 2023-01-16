package nonapi.p019io.github.classgraph.recycler;

import java.lang.Exception;

/* renamed from: nonapi.io.github.classgraph.recycler.RecycleOnClose */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/recycler/RecycleOnClose.class */
public class RecycleOnClose<T, E extends Exception> implements AutoCloseable {
    private final Recycler<T, E> recycler;
    private final T instance;

    /* access modifiers changed from: package-private */
    public RecycleOnClose(Recycler<T, E> recycler, T instance) {
        this.recycler = recycler;
        this.instance = instance;
    }

    public T get() {
        return this.instance;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.recycler.recycle(this.instance);
    }
}
