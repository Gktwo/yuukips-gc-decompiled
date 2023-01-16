package nonapi.p019io.github.classgraph.recycler;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: nonapi.io.github.classgraph.recycler.Recycler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/recycler/Recycler.class */
public abstract class Recycler<T, E extends Exception> implements AutoCloseable {
    private final Set<T> usedInstances = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Queue<T> unusedInstances = new ConcurrentLinkedQueue();

    public abstract T newInstance() throws Exception;

    public T acquire() throws Exception {
        T instance;
        T recycledInstance = this.unusedInstances.poll();
        if (recycledInstance == null) {
            T newInstance = newInstance();
            if (newInstance == null) {
                throw new NullPointerException("Failed to allocate a new recyclable instance");
            }
            instance = newInstance;
        } else {
            instance = recycledInstance;
        }
        this.usedInstances.add(instance);
        return instance;
    }

    public RecycleOnClose<T, E> acquireRecycleOnClose() throws Exception {
        return new RecycleOnClose<>(this, acquire());
    }

    public final void recycle(T instance) {
        if (instance == null) {
            return;
        }
        if (!this.usedInstances.remove(instance)) {
            throw new IllegalArgumentException("Tried to recycle an instance that was not in use");
        }
        if (instance instanceof Resettable) {
            ((Resettable) instance).reset();
        }
        if (!this.unusedInstances.add(instance)) {
            throw new IllegalArgumentException("Tried to recycle an instance twice");
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        while (true) {
            T unusedInstance = this.unusedInstances.poll();
            if (unusedInstance == null) {
                return;
            }
            if (unusedInstance instanceof AutoCloseable) {
                try {
                    ((AutoCloseable) unusedInstance).close();
                } catch (Exception e) {
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: java.util.Queue<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void forceClose() {
        Iterator it = new ArrayList(this.usedInstances).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (this.usedInstances.remove(next)) {
                this.unusedInstances.add(next);
            }
        }
        close();
    }
}
