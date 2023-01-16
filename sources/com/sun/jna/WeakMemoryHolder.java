package com.sun.jna;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.IdentityHashMap;

/* loaded from: grasscutter.jar:com/sun/jna/WeakMemoryHolder.class */
public class WeakMemoryHolder {
    ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    IdentityHashMap<Reference<Object>, Memory> backingMap = new IdentityHashMap<>();

    public synchronized void put(Object o, Memory m) {
        clean();
        this.backingMap.put(new WeakReference<>(o, this.referenceQueue), m);
    }

    public synchronized void clean() {
        Reference ref = this.referenceQueue.poll();
        while (ref != null) {
            this.backingMap.remove(ref);
            ref = this.referenceQueue.poll();
        }
    }
}
