package org.eclipse.jetty.util.compression;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jetty.util.component.AbstractLifeCycle;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/compression/CompressionPool.class */
public abstract class CompressionPool<T> extends AbstractLifeCycle {
    public static final int INFINITE_CAPACITY = -1;
    private final Queue<T> _pool;
    private final AtomicInteger _numObjects = new AtomicInteger(0);
    private final int _capacity;

    protected abstract T newObject();

    protected abstract void end(T t);

    protected abstract void reset(T t);

    public CompressionPool(int capacity) {
        this._capacity = capacity;
        this._pool = this._capacity == 0 ? null : new ConcurrentLinkedQueue();
    }

    public T acquire() {
        T object;
        if (this._capacity == 0) {
            object = newObject();
        } else {
            object = this._pool.poll();
            if (object == null) {
                object = newObject();
            } else if (this._capacity > 0) {
                this._numObjects.decrementAndGet();
            }
        }
        return object;
    }

    public void release(T object) {
        int d;
        if (object != null) {
            if (this._capacity == 0 || !isRunning()) {
                end(object);
            } else if (this._capacity < 0) {
                reset(object);
                this._pool.add(object);
            } else {
                do {
                    d = this._numObjects.get();
                    if (d >= this._capacity) {
                        end(object);
                        return;
                    }
                } while (!this._numObjects.compareAndSet(d, d + 1));
                reset(object);
                this._pool.add(object);
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() {
        T t = this._pool.poll();
        while (t != null) {
            end(t);
            t = this._pool.poll();
        }
        this._numObjects.set(0);
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getClass().getSimpleName());
        str.append('@').append(Integer.toHexString(hashCode()));
        str.append('{').append(getState());
        str.append(",size=").append(this._pool == null ? -1 : this._pool.size());
        str.append(",capacity=").append(this._capacity <= 0 ? "UNLIMITED" : Integer.valueOf(this._capacity));
        str.append('}');
        return str.toString();
    }
}
