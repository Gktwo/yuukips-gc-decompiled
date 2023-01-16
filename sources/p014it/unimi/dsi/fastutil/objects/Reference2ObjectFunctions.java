package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectFunctions.class */
public final class Reference2ObjectFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Reference2ObjectFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectFunctions$EmptyFunction.class */
    public static class EmptyFunction<K, V> extends AbstractReference2ObjectFunction<K, V> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V get(Object k) {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V getOrDefault(Object k, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ObjectFunction, p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction
        public V defaultReturnValue() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ObjectFunction, p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction
        public void defaultReturnValue(V defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
        }

        @Override // java.lang.Object
        public Object clone() {
            return Reference2ObjectFunctions.EMPTY_FUNCTION;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            return (o instanceof Function) && ((Function) o).size() == 0;
        }

        @Override // java.lang.Object
        public String toString() {
            return "{}";
        }

        private Object readResolve() {
            return Reference2ObjectFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectFunctions$Singleton.class */
    public static class Singleton<K, V> extends AbstractReference2ObjectFunction<K, V> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K key;
        protected final V value;

        /* access modifiers changed from: protected */
        public Singleton(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V get(Object k) {
            return this.key == k ? this.value : (V) this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V getOrDefault(Object k, V defaultValue) {
            return this.key == k ? this.value : defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return 1;
        }

        @Override // java.lang.Object
        public Object clone() {
            return this;
        }
    }

    public static <K, V> Reference2ObjectFunction<K, V> singleton(K key, V value) {
        return new Singleton(key, value);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<K, V> implements Reference2ObjectFunction<K, V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ObjectFunction<K, V> function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Reference2ObjectFunction<K, V> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Reference2ObjectFunction<K, V> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, java.util.function.Function
        public V apply(K key) {
            V apply;
            synchronized (this.sync) {
                apply = this.function.apply(key);
            }
            return apply;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            int size;
            synchronized (this.sync) {
                size = this.function.size();
            }
            return size;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction
        public V defaultReturnValue() {
            V defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction
        public void defaultReturnValue(V defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V put(K k, V v) {
            V put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V get(Object k) {
            V v;
            synchronized (this.sync) {
                v = this.function.get(k);
            }
            return v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V getOrDefault(Object k, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V remove(Object k) {
            V remove;
            synchronized (this.sync) {
                remove = this.function.remove(k);
            }
            return remove;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            synchronized (this.sync) {
                this.function.clear();
            }
        }

        @Override // java.lang.Object
        public int hashCode() {
            int hashCode;
            synchronized (this.sync) {
                hashCode = this.function.hashCode();
            }
            return hashCode;
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            boolean equals;
            if (o == this) {
                return true;
            }
            synchronized (this.sync) {
                equals = this.function.equals(o);
            }
            return equals;
        }

        @Override // java.lang.Object
        public String toString() {
            String obj;
            synchronized (this.sync) {
                obj = this.function.toString();
            }
            return obj;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.sync) {
                s.defaultWriteObject();
            }
        }
    }

    public static <K, V> Reference2ObjectFunction<K, V> synchronize(Reference2ObjectFunction<K, V> f) {
        return new SynchronizedFunction(f);
    }

    public static <K, V> Reference2ObjectFunction<K, V> synchronize(Reference2ObjectFunction<K, V> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ObjectFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ObjectFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<K, V> extends AbstractReference2ObjectFunction<K, V> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ObjectFunction<? extends K, ? extends V> function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Reference2ObjectFunction<? extends K, ? extends V> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ObjectFunction, p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction
        public V defaultReturnValue() {
            return (V) this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ObjectFunction, p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction
        public void defaultReturnValue(V defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V get(Object k) {
            return (V) this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V getOrDefault(Object k, V defaultValue) {
            return (V) this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        public V remove(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.function.hashCode();
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            return o == this || this.function.equals(o);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.function.toString();
        }
    }

    public static <K, V> Reference2ObjectFunction<K, V> unmodifiable(Reference2ObjectFunction<? extends K, ? extends V> f) {
        return new UnmodifiableFunction(f);
    }
}
