package org.bson.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import net.bytebuddy.implementation.MethodDelegation;
import org.bson.assertions.Assertions;

/* loaded from: grasscutter.jar:org/bson/util/AbstractCopyOnWriteMap.class */
abstract class AbstractCopyOnWriteMap<K, V, M extends Map<K, V>> implements ConcurrentMap<K, V> {
    private volatile M delegate;
    private final transient Lock lock = new ReentrantLock();
    private final View<K, V> view;

    abstract <N extends Map<? extends K, ? extends V>> M copy(N n);

    /* access modifiers changed from: protected */
    public <N extends Map<? extends K, ? extends V>> AbstractCopyOnWriteMap(N map, View.Type viewType) {
        this.delegate = (M) ((Map) Assertions.notNull(MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, copy((Map) Assertions.notNull("map", map))));
        this.view = ((View.Type) Assertions.notNull("viewType", viewType)).get(this);
    }

    @Override // java.util.Map
    public final void clear() {
        this.lock.lock();
        try {
            set(copy(Collections.emptyMap()));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Map
    public final V remove(Object key) {
        this.lock.lock();
        try {
            if (!this.delegate.containsKey(key)) {
                return null;
            }
            M map = copy();
            V v = (V) map.remove(key);
            set(map);
            this.lock.unlock();
            return v;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean remove(Object key, Object value) {
        this.lock.lock();
        try {
            if (!this.delegate.containsKey(key) || !equals(value, this.delegate.get(key))) {
                return false;
            }
            M map = copy();
            map.remove(key);
            set(map);
            this.lock.unlock();
            return true;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean replace(K key, V oldValue, V newValue) {
        this.lock.lock();
        try {
            if (!this.delegate.containsKey(key) || !equals(oldValue, this.delegate.get(key))) {
                return false;
            }
            M map = copy();
            map.put(key, newValue);
            set(map);
            this.lock.unlock();
            return true;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V replace(K key, V value) {
        this.lock.lock();
        try {
            if (!this.delegate.containsKey(key)) {
                return null;
            }
            M map = copy();
            V v = (V) map.put(key, value);
            set(map);
            this.lock.unlock();
            return v;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Map
    public final V put(K key, V value) {
        this.lock.lock();
        try {
            M map = copy();
            V v = (V) map.put(key, value);
            set(map);
            this.lock.unlock();
            return v;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V putIfAbsent(K key, V value) {
        this.lock.lock();
        try {
            if (!this.delegate.containsKey(key)) {
                M map = copy();
                V v = (V) map.put(key, value);
                set(map);
                this.lock.unlock();
                return v;
            }
            V v2 = (V) this.delegate.get(key);
            this.lock.unlock();
            return v2;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> t) {
        this.lock.lock();
        try {
            M map = copy();
            map.putAll(t);
            set(map);
        } finally {
            this.lock.unlock();
        }
    }

    protected M copy() {
        this.lock.lock();
        try {
            return copy(this.delegate);
        } finally {
            this.lock.unlock();
        }
    }

    protected void set(M map) {
        this.delegate = map;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return this.view.entrySet();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return this.view.keySet();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return this.view.values();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object key) {
        return this.delegate.containsKey(key);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object value) {
        return this.delegate.containsValue(value);
    }

    @Override // java.util.Map
    public final V get(Object key) {
        return (V) this.delegate.get(key);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public final int size() {
        return this.delegate.size();
    }

    @Override // java.util.Map, java.lang.Object
    public final boolean equals(Object o) {
        return this.delegate.equals(o);
    }

    @Override // java.util.Map, java.lang.Object
    public final int hashCode() {
        return this.delegate.hashCode();
    }

    protected final M getDelegate() {
        return this.delegate;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.delegate.toString();
    }

    /* loaded from: grasscutter.jar:org/bson/util/AbstractCopyOnWriteMap$KeySet.class */
    private class KeySet extends CollectionView<K> implements Set<K> {
        private KeySet() {
        }

        @Override // org.bson.util.AbstractCopyOnWriteMap.CollectionView
        Collection<K> getDelegate() {
            return AbstractCopyOnWriteMap.this.delegate.keySet();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: org.bson.util.AbstractCopyOnWriteMap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public void clear() {
            AbstractCopyOnWriteMap.this.lock.lock();
            try {
                Map copy = AbstractCopyOnWriteMap.this.copy();
                copy.keySet().clear();
                AbstractCopyOnWriteMap.this.set(copy);
            } finally {
                AbstractCopyOnWriteMap.this.lock.unlock();
            }
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return AbstractCopyOnWriteMap.this.remove(o) != null;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0037
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(java.util.Collection<?> r4) {
            /*
                r3 = this;
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.lock()
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                java.util.Map r0 = r0.copy()     // Catch: all -> 0x0044
                r5 = r0
                r0 = r5
                java.util.Set r0 = r0.keySet()     // Catch: all -> 0x0044, all -> 0x0037
                r1 = r4
                boolean r0 = r0.removeAll(r1)     // Catch: all -> 0x0044, all -> 0x0037
                r6 = r0
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r6
                return r0
            L_0x0037:
                r7 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r7
                throw r0     // Catch: all -> 0x0044
            L_0x0044:
                r8 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r8
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bson.util.AbstractCopyOnWriteMap.KeySet.removeAll(java.util.Collection):boolean");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0037
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(java.util.Collection<?> r4) {
            /*
                r3 = this;
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.lock()
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                java.util.Map r0 = r0.copy()     // Catch: all -> 0x0044
                r5 = r0
                r0 = r5
                java.util.Set r0 = r0.keySet()     // Catch: all -> 0x0044, all -> 0x0037
                r1 = r4
                boolean r0 = r0.retainAll(r1)     // Catch: all -> 0x0044, all -> 0x0037
                r6 = r0
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r6
                return r0
            L_0x0037:
                r7 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r7
                throw r0     // Catch: all -> 0x0044
            L_0x0044:
                r8 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r8
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bson.util.AbstractCopyOnWriteMap.KeySet.retainAll(java.util.Collection):boolean");
        }
    }

    /* loaded from: grasscutter.jar:org/bson/util/AbstractCopyOnWriteMap$Values.class */
    private final class Values extends CollectionView<V> {
        private Values() {
        }

        @Override // org.bson.util.AbstractCopyOnWriteMap.CollectionView
        Collection<V> getDelegate() {
            return AbstractCopyOnWriteMap.this.delegate.values();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: org.bson.util.AbstractCopyOnWriteMap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection
        public void clear() {
            AbstractCopyOnWriteMap.this.lock.lock();
            try {
                Map copy = AbstractCopyOnWriteMap.this.copy();
                copy.values().clear();
                AbstractCopyOnWriteMap.this.set(copy);
            } finally {
                AbstractCopyOnWriteMap.this.lock.unlock();
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x004f
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.util.Collection
        public boolean remove(java.lang.Object r4) {
            /*
                r3 = this;
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.lock()
                r0 = r3
                r1 = r4
                boolean r0 = r0.contains(r1)     // Catch: all -> 0x005c
                if (r0 != 0) goto L_0x0024
                r0 = 0
                r5 = r0
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r5
                return r0
            L_0x0024:
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x005c
                java.util.Map r0 = r0.copy()     // Catch: all -> 0x005c
                r5 = r0
                r0 = r5
                java.util.Collection r0 = r0.values()     // Catch: all -> 0x005c, all -> 0x004f
                r1 = r4
                boolean r0 = r0.remove(r1)     // Catch: all -> 0x005c, all -> 0x004f
                r6 = r0
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x005c
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x005c
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r6
                return r0
            L_0x004f:
                r7 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x005c
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x005c
                r0 = r7
                throw r0     // Catch: all -> 0x005c
            L_0x005c:
                r8 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r8
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bson.util.AbstractCopyOnWriteMap.Values.remove(java.lang.Object):boolean");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0037
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.util.Collection
        public boolean removeAll(java.util.Collection<?> r4) {
            /*
                r3 = this;
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.lock()
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                java.util.Map r0 = r0.copy()     // Catch: all -> 0x0044
                r5 = r0
                r0 = r5
                java.util.Collection r0 = r0.values()     // Catch: all -> 0x0044, all -> 0x0037
                r1 = r4
                boolean r0 = r0.removeAll(r1)     // Catch: all -> 0x0044, all -> 0x0037
                r6 = r0
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r6
                return r0
            L_0x0037:
                r7 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r7
                throw r0     // Catch: all -> 0x0044
            L_0x0044:
                r8 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r8
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bson.util.AbstractCopyOnWriteMap.Values.removeAll(java.util.Collection):boolean");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0037
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.util.Collection
        public boolean retainAll(java.util.Collection<?> r4) {
            /*
                r3 = this;
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.lock()
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                java.util.Map r0 = r0.copy()     // Catch: all -> 0x0044
                r5 = r0
                r0 = r5
                java.util.Collection r0 = r0.values()     // Catch: all -> 0x0044, all -> 0x0037
                r1 = r4
                boolean r0 = r0.retainAll(r1)     // Catch: all -> 0x0044, all -> 0x0037
                r6 = r0
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r6
                return r0
            L_0x0037:
                r7 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r7
                throw r0     // Catch: all -> 0x0044
            L_0x0044:
                r8 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r8
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bson.util.AbstractCopyOnWriteMap.Values.retainAll(java.util.Collection):boolean");
        }
    }

    /* loaded from: grasscutter.jar:org/bson/util/AbstractCopyOnWriteMap$EntrySet.class */
    private class EntrySet extends CollectionView<Map.Entry<K, V>> implements Set<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // org.bson.util.AbstractCopyOnWriteMap.CollectionView
        Collection<Map.Entry<K, V>> getDelegate() {
            return AbstractCopyOnWriteMap.this.delegate.entrySet();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: org.bson.util.AbstractCopyOnWriteMap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public void clear() {
            AbstractCopyOnWriteMap.this.lock.lock();
            try {
                Map copy = AbstractCopyOnWriteMap.this.copy();
                copy.entrySet().clear();
                AbstractCopyOnWriteMap.this.set(copy);
            } finally {
                AbstractCopyOnWriteMap.this.lock.unlock();
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x004f
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object r4) {
            /*
                r3 = this;
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.lock()
                r0 = r3
                r1 = r4
                boolean r0 = r0.contains(r1)     // Catch: all -> 0x005c
                if (r0 != 0) goto L_0x0024
                r0 = 0
                r5 = r0
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r5
                return r0
            L_0x0024:
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x005c
                java.util.Map r0 = r0.copy()     // Catch: all -> 0x005c
                r5 = r0
                r0 = r5
                java.util.Set r0 = r0.entrySet()     // Catch: all -> 0x005c, all -> 0x004f
                r1 = r4
                boolean r0 = r0.remove(r1)     // Catch: all -> 0x005c, all -> 0x004f
                r6 = r0
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x005c
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x005c
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r6
                return r0
            L_0x004f:
                r7 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x005c
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x005c
                r0 = r7
                throw r0     // Catch: all -> 0x005c
            L_0x005c:
                r8 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r8
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bson.util.AbstractCopyOnWriteMap.EntrySet.remove(java.lang.Object):boolean");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0037
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(java.util.Collection<?> r4) {
            /*
                r3 = this;
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.lock()
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                java.util.Map r0 = r0.copy()     // Catch: all -> 0x0044
                r5 = r0
                r0 = r5
                java.util.Set r0 = r0.entrySet()     // Catch: all -> 0x0044, all -> 0x0037
                r1 = r4
                boolean r0 = r0.removeAll(r1)     // Catch: all -> 0x0044, all -> 0x0037
                r6 = r0
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r6
                return r0
            L_0x0037:
                r7 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r7
                throw r0     // Catch: all -> 0x0044
            L_0x0044:
                r8 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r8
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bson.util.AbstractCopyOnWriteMap.EntrySet.removeAll(java.util.Collection):boolean");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0037
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(java.util.Collection<?> r4) {
            /*
                r3 = this;
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.lock()
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                java.util.Map r0 = r0.copy()     // Catch: all -> 0x0044
                r5 = r0
                r0 = r5
                java.util.Set r0 = r0.entrySet()     // Catch: all -> 0x0044, all -> 0x0037
                r1 = r4
                boolean r0 = r0.retainAll(r1)     // Catch: all -> 0x0044, all -> 0x0037
                r6 = r0
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r6
                return r0
            L_0x0037:
                r7 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this     // Catch: all -> 0x0044
                r1 = r5
                r0.set(r1)     // Catch: all -> 0x0044
                r0 = r7
                throw r0     // Catch: all -> 0x0044
            L_0x0044:
                r8 = move-exception
                r0 = r3
                org.bson.util.AbstractCopyOnWriteMap r0 = org.bson.util.AbstractCopyOnWriteMap.this
                java.util.concurrent.locks.Lock r0 = org.bson.util.AbstractCopyOnWriteMap.access$100(r0)
                r0.unlock()
                r0 = r8
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bson.util.AbstractCopyOnWriteMap.EntrySet.retainAll(java.util.Collection):boolean");
        }
    }

    /* loaded from: grasscutter.jar:org/bson/util/AbstractCopyOnWriteMap$UnmodifiableIterator.class */
    private static class UnmodifiableIterator<T> implements Iterator<T> {
        private final Iterator<T> delegate;

        UnmodifiableIterator(Iterator<T> delegate) {
            this.delegate = delegate;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.delegate.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.delegate.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: grasscutter.jar:org/bson/util/AbstractCopyOnWriteMap$CollectionView.class */
    protected static abstract class CollectionView<E> implements Collection<E> {
        abstract Collection<E> getDelegate();

        protected CollectionView() {
        }

        @Override // java.util.Collection
        public final boolean contains(Object o) {
            return getDelegate().contains(o);
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> c) {
            return getDelegate().containsAll(c);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<E> iterator() {
            return new UnmodifiableIterator(getDelegate().iterator());
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return getDelegate().isEmpty();
        }

        @Override // java.util.Collection
        public final int size() {
            return getDelegate().size();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            return getDelegate().toArray();
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] a) {
            return (T[]) getDelegate().toArray(a);
        }

        @Override // java.util.Collection, java.lang.Object
        public int hashCode() {
            return getDelegate().hashCode();
        }

        @Override // java.util.Collection, java.lang.Object
        public boolean equals(Object obj) {
            return getDelegate().equals(obj);
        }

        @Override // java.lang.Object
        public String toString() {
            return getDelegate().toString();
        }

        @Override // java.util.Collection
        public final boolean add(E o) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends E> c) {
            throw new UnsupportedOperationException();
        }
    }

    private boolean equals(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        }
        return o1.equals(o2);
    }

    /* loaded from: grasscutter.jar:org/bson/util/AbstractCopyOnWriteMap$View.class */
    public static abstract class View<K, V> {

        /* loaded from: grasscutter.jar:org/bson/util/AbstractCopyOnWriteMap$View$Type.class */
        public enum Type {
            STABLE {
                @Override // org.bson.util.AbstractCopyOnWriteMap.View.Type
                <K, V, M extends Map<K, V>> View<K, V> get(AbstractCopyOnWriteMap<K, V, M> host) {
                    Objects.requireNonNull(host);
                    return new Immutable();
                }
            },
            LIVE {
                @Override // org.bson.util.AbstractCopyOnWriteMap.View.Type
                <K, V, M extends Map<K, V>> View<K, V> get(AbstractCopyOnWriteMap<K, V, M> host) {
                    Objects.requireNonNull(host);
                    return new Mutable();
                }
            };

            abstract <K, V, M extends Map<K, V>> View<K, V> get(AbstractCopyOnWriteMap<K, V, M> abstractCopyOnWriteMap);
        }

        abstract Set<K> keySet();

        abstract Set<Map.Entry<K, V>> entrySet();

        abstract Collection<V> values();

        View() {
        }
    }

    /* loaded from: grasscutter.jar:org/bson/util/AbstractCopyOnWriteMap$Immutable.class */
    final class Immutable extends View<K, V> {
        Immutable() {
        }

        @Override // org.bson.util.AbstractCopyOnWriteMap.View
        public Set<K> keySet() {
            return Collections.unmodifiableSet(AbstractCopyOnWriteMap.this.delegate.keySet());
        }

        @Override // org.bson.util.AbstractCopyOnWriteMap.View
        public Set<Map.Entry<K, V>> entrySet() {
            return Collections.unmodifiableSet(AbstractCopyOnWriteMap.this.delegate.entrySet());
        }

        @Override // org.bson.util.AbstractCopyOnWriteMap.View
        public Collection<V> values() {
            return Collections.unmodifiableCollection(AbstractCopyOnWriteMap.this.delegate.values());
        }
    }

    /* loaded from: grasscutter.jar:org/bson/util/AbstractCopyOnWriteMap$Mutable.class */
    final class Mutable extends View<K, V> {
        private final transient AbstractCopyOnWriteMap<K, V, M>.KeySet keySet;
        private final transient AbstractCopyOnWriteMap<K, V, M>.EntrySet entrySet;
        private final transient AbstractCopyOnWriteMap<K, V, M>.Values values;

        Mutable() {
            this.keySet = new KeySet();
            this.entrySet = new EntrySet();
            this.values = new Values();
        }

        @Override // org.bson.util.AbstractCopyOnWriteMap.View
        public Set<K> keySet() {
            return this.keySet;
        }

        @Override // org.bson.util.AbstractCopyOnWriteMap.View
        public Set<Map.Entry<K, V>> entrySet() {
            return this.entrySet;
        }

        @Override // org.bson.util.AbstractCopyOnWriteMap.View
        public Collection<V> values() {
            return this.values;
        }
    }
}
