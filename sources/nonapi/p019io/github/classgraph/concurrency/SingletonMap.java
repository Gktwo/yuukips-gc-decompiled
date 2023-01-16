package nonapi.p019io.github.classgraph.concurrency;

import java.lang.Exception;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* renamed from: nonapi.io.github.classgraph.concurrency.SingletonMap */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/concurrency/SingletonMap.class */
public abstract class SingletonMap<K, V, E extends Exception> {
    private final ConcurrentMap<K, SingletonHolder<V>> map = new ConcurrentHashMap();

    public abstract V newInstance(K k, LogNode logNode) throws Exception, InterruptedException;

    /* renamed from: nonapi.io.github.classgraph.concurrency.SingletonMap$NullSingletonException */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/concurrency/SingletonMap$NullSingletonException.class */
    public static class NullSingletonException extends Exception {
        static final long serialVersionUID = 1;

        public <K> NullSingletonException(K key) {
            super("newInstance returned null for key " + key);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: nonapi.io.github.classgraph.concurrency.SingletonMap$SingletonHolder */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/concurrency/SingletonMap$SingletonHolder.class */
    public static class SingletonHolder<V> {
        private volatile V singleton;
        private final CountDownLatch initialized;

        private SingletonHolder() {
            this.initialized = new CountDownLatch(1);
        }

        void set(V singleton) throws IllegalArgumentException {
            if (this.initialized.getCount() < 1) {
                throw new IllegalArgumentException("Singleton already initialized");
            }
            this.singleton = singleton;
            this.initialized.countDown();
            if (this.initialized.getCount() != 0) {
                throw new IllegalArgumentException("Singleton initialized more than once");
            }
        }

        V get() throws InterruptedException {
            this.initialized.await();
            return this.singleton;
        }
    }

    public V get(K key, LogNode log) throws Exception, InterruptedException, NullSingletonException {
        SingletonHolder<V> singletonHolder = this.map.get(key);
        V instance = null;
        if (singletonHolder != null) {
            instance = singletonHolder.get();
        } else {
            SingletonHolder<V> newSingletonHolder = new SingletonHolder<>();
            SingletonHolder<V> oldSingletonHolder = this.map.putIfAbsent(key, newSingletonHolder);
            if (oldSingletonHolder != null) {
                instance = oldSingletonHolder.get();
            } else {
                try {
                    instance = newInstance(key, log);
                    newSingletonHolder.set(instance);
                } catch (Throwable th) {
                    newSingletonHolder.set(instance);
                    throw th;
                }
            }
        }
        if (instance != null) {
            return instance;
        }
        throw new NullSingletonException(key);
    }

    public List<V> values() throws InterruptedException {
        List<V> entries = new ArrayList<>(this.map.size());
        for (Map.Entry<K, SingletonHolder<V>> ent : this.map.entrySet()) {
            V entryValue = ent.getValue().get();
            if (entryValue != null) {
                entries.add(entryValue);
            }
        }
        return entries;
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public List<Map.Entry<K, V>> entries() throws InterruptedException {
        List<Map.Entry<K, V>> entries = new ArrayList<>(this.map.size());
        for (Map.Entry<K, SingletonHolder<V>> ent : this.map.entrySet()) {
            entries.add(new AbstractMap.SimpleEntry<>(ent.getKey(), ent.getValue().get()));
        }
        return entries;
    }

    public V remove(K key) throws InterruptedException {
        SingletonHolder<V> val = this.map.remove(key);
        if (val == null) {
            return null;
        }
        return val.get();
    }

    public void clear() {
        this.map.clear();
    }
}
