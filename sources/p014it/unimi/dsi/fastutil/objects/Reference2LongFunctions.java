package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.ToLongFunction;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongFunctions.class */
public final class Reference2LongFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Reference2LongFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongFunctions$EmptyFunction.class */
    public static class EmptyFunction<K> extends AbstractReference2LongFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long getLong(Object k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long getOrDefault(Object k, long defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongFunction, p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongFunction, p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public void defaultReturnValue(long defRetValue) {
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
            return Reference2LongFunctions.EMPTY_FUNCTION;
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
            return Reference2LongFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongFunctions$Singleton.class */
    public static class Singleton<K> extends AbstractReference2LongFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K key;
        protected final long value;

        /* access modifiers changed from: protected */
        public Singleton(K key, long value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long getLong(Object k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long getOrDefault(Object k, long defaultValue) {
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

    public static <K> Reference2LongFunction<K> singleton(K key, long value) {
        return new Singleton(key, value);
    }

    public static <K> Reference2LongFunction<K> singleton(K key, Long value) {
        return new Singleton(key, value.longValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<K> implements Reference2LongFunction<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2LongFunction<K> function;
        protected final Object sync;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Long put(Object obj, Long l) {
            return put((SynchronizedFunction<K>) obj, l);
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Reference2LongFunction<K> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Reference2LongFunction<K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, java.util.function.ToLongFunction
        public long applyAsLong(K operand) {
            long applyAsLong;
            synchronized (this.sync) {
                applyAsLong = this.function.applyAsLong(operand);
            }
            return applyAsLong;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, java.util.function.Function
        @Deprecated
        public Long apply(K key) {
            Long apply;
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long defaultReturnValue() {
            long defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public void defaultReturnValue(long defRetValue) {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long put(K k, long v) {
            long put;
            synchronized (this.sync) {
                put = this.function.put((Reference2LongFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long getLong(Object k) {
            long j;
            synchronized (this.sync) {
                j = this.function.getLong(k);
            }
            return j;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long getOrDefault(Object k, long defaultValue) {
            long orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long removeLong(Object k) {
            long removeLong;
            synchronized (this.sync) {
                removeLong = this.function.removeLong(k);
            }
            return removeLong;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            synchronized (this.sync) {
                this.function.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        @Deprecated
        public Long put(K k, Long v) {
            Long put;
            synchronized (this.sync) {
                put = this.function.put((Reference2LongFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Long get(Object k) {
            Long l;
            synchronized (this.sync) {
                l = this.function.get(k);
            }
            return l;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        @Deprecated
        public Long getOrDefault(Object k, Long defaultValue) {
            Long orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Long remove(Object k) {
            Long remove;
            synchronized (this.sync) {
                remove = this.function.remove(k);
            }
            return remove;
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

    public static <K> Reference2LongFunction<K> synchronize(Reference2LongFunction<K> f) {
        return new SynchronizedFunction(f);
    }

    public static <K> Reference2LongFunction<K> synchronize(Reference2LongFunction<K> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<K> extends AbstractReference2LongFunction<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2LongFunction<? extends K> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Long put(Object obj, Long l) {
            return put((UnmodifiableFunction<K>) obj, l);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Reference2LongFunction<? extends K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongFunction, p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2LongFunction, p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public void defaultReturnValue(long defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long put(K k, long v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long getLong(Object k) {
            return this.function.getLong(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long getOrDefault(Object k, long defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long removeLong(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        @Deprecated
        public Long put(K k, Long v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Long get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        @Deprecated
        public Long getOrDefault(Object k, Long defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Long remove(Object k) {
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

    public static <K> Reference2LongFunction<K> unmodifiable(Reference2LongFunction<? extends K> f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction<K> implements Reference2LongFunction<K> {
        protected final java.util.function.Function<? super K, ? extends Long> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Long put(Object obj, Long l) {
            return put((PrimitiveFunction<K>) obj, l);
        }

        protected PrimitiveFunction(java.util.function.Function<? super K, ? extends Long> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object key) {
            return this.function.apply(key) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long getLong(Object key) {
            Long v = (Long) this.function.apply(key);
            return v == null ? defaultReturnValue() : v.longValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        public long getOrDefault(Object key, long defaultValue) {
            Long v = (Long) this.function.apply(key);
            return v == null ? defaultValue : v.longValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Long get(Object key) {
            return (Long) this.function.apply(key);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            Long v = (Long) this.function.apply(key);
            return v == null ? defaultValue : v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2LongFunction
        @Deprecated
        public Long put(K key, Long value) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Reference2LongFunction<K> primitive(java.util.function.Function<? super K, ? extends Long> f) {
        Objects.requireNonNull(f);
        return f instanceof Reference2LongFunction ? (Reference2LongFunction) f : f instanceof ToLongFunction ? key -> {
            return ((ToLongFunction) f).applyAsLong(key);
        } : new PrimitiveFunction(f);
    }
}
