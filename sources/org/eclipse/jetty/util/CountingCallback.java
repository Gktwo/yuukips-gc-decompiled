package org.eclipse.jetty.util;

import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jetty.util.Callback;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/CountingCallback.class */
public class CountingCallback extends Callback.Nested {
    private final AtomicInteger count;

    public CountingCallback(Callback callback, int count) {
        super(callback);
        if (count < 1) {
            throw new IllegalArgumentException();
        }
        this.count = new AtomicInteger(count);
    }

    @Override // org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
    public void succeeded() {
        int current;
        do {
            current = this.count.get();
            if (current == 0) {
                return;
            }
        } while (!this.count.compareAndSet(current, current - 1));
        if (current == 1) {
            succeeded();
        }
    }

    @Override // org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
    public void failed(Throwable failure) {
        int current;
        do {
            current = this.count.get();
            if (current == 0) {
                return;
            }
        } while (!this.count.compareAndSet(current, 0));
        failed(failure);
    }

    public String toString() {
        return String.format("%s@%x", getClass().getSimpleName(), Integer.valueOf(hashCode()));
    }
}
