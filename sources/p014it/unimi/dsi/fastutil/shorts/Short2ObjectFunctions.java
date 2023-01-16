package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntFunction;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectFunctions.class */
public final class Short2ObjectFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Short2ObjectFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectFunctions$EmptyFunction.class */
    public static class EmptyFunction<V> extends AbstractShort2ObjectFunction<V> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V get(short k) {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V getOrDefault(short k, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public boolean containsKey(short k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V defaultReturnValue() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
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
            return Short2ObjectFunctions.EMPTY_FUNCTION;
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
            return Short2ObjectFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectFunctions$Singleton.class */
    public static class Singleton<V> extends AbstractShort2ObjectFunction<V> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final short key;
        protected final V value;

        /* access modifiers changed from: protected */
        public Singleton(short key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public boolean containsKey(short k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V get(short k) {
            return this.key == k ? this.value : (V) this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V getOrDefault(short k, V defaultValue) {
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

    public static <V> Short2ObjectFunction<V> singleton(short key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Short2ObjectFunction<V> singleton(Short key, V value) {
        return new Singleton(key.shortValue(), value);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<V> implements Short2ObjectFunction<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ObjectFunction<V> function;
        protected final Object sync;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Object put(Short sh, Object obj) {
            return put(sh, (Short) obj);
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Short2ObjectFunction<V> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Short2ObjectFunction<V> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, java.util.function.IntFunction
        @Deprecated
        public V apply(int operand) {
            V apply;
            synchronized (this.sync) {
                apply = this.function.apply(operand);
            }
            return apply;
        }

        @Deprecated
        public V apply(Short key) {
            V apply;
            synchronized (this.sync) {
                apply = this.function.apply((Short2ObjectFunction<V>) key);
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V defaultReturnValue() {
            V defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public void defaultReturnValue(V defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public boolean containsKey(short k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V put(short k, V v) {
            V put;
            synchronized (this.sync) {
                put = this.function.put(k, (short) v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V get(short k) {
            V v;
            synchronized (this.sync) {
                v = this.function.get(k);
            }
            return v;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V getOrDefault(short k, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, (short) defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V remove(short k) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        @Deprecated
        public V put(Short k, V v) {
            V put;
            synchronized (this.sync) {
                put = this.function.put(k, (Short) v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V get(Object k) {
            V v;
            synchronized (this.sync) {
                v = this.function.get(k);
            }
            return v;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object k, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V remove(Object k) {
            V remove;
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

    public static <V> Short2ObjectFunction<V> synchronize(Short2ObjectFunction<V> f) {
        return new SynchronizedFunction(f);
    }

    public static <V> Short2ObjectFunction<V> synchronize(Short2ObjectFunction<V> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<V> extends AbstractShort2ObjectFunction<V> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ObjectFunction<? extends V> function;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Object put(Short sh, Object obj) {
            return put(sh, (Short) obj);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Short2ObjectFunction<? extends V> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V defaultReturnValue() {
            return (V) this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public void defaultReturnValue(V defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public boolean containsKey(short k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V put(short k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V get(short k) {
            return (V) this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V getOrDefault(short k, V defaultValue) {
            return (V) this.function.getOrDefault(k, (short) defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V remove(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        @Deprecated
        public V put(Short k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V get(Object k) {
            return (V) this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object k, V defaultValue) {
            return (V) this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V remove(Object k) {
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

    public static <V> Short2ObjectFunction<V> unmodifiable(Short2ObjectFunction<? extends V> f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ObjectFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ObjectFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction<V> implements Short2ObjectFunction<V> {
        protected final java.util.function.Function<? super Short, ? extends V> function;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Object put(Short sh, Object obj) {
            return put(sh, (Short) obj);
        }

        protected PrimitiveFunction(java.util.function.Function<? super Short, ? extends V> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.shorts.Short2ObjectMap
        public boolean containsKey(short key) {
            return this.function.apply(Short.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Short) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V get(short key) {
            V v = (V) this.function.apply(Short.valueOf(key));
            if (v == null) {
                return null;
            }
            return v;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        public V getOrDefault(short key, V defaultValue) {
            V v = (V) this.function.apply(Short.valueOf(key));
            return v == null ? defaultValue : v;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V get(Object key) {
            if (key == null) {
                return null;
            }
            return (V) this.function.apply((Short) key);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            V v;
            if (!(key == null || (v = (V) this.function.apply((Short) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction
        @Deprecated
        public V put(Short key, V value) {
            throw new UnsupportedOperationException();
        }
    }

    public static <V> Short2ObjectFunction<V> primitive(java.util.function.Function<? super Short, ? extends V> f) {
        Objects.requireNonNull(f);
        if (f instanceof Short2ObjectFunction) {
            return (Short2ObjectFunction) f;
        }
        if (!(f instanceof IntFunction)) {
            return new PrimitiveFunction(f);
        }
        IntFunction intFunction = (IntFunction) f;
        Objects.requireNonNull(intFunction);
        return (v1) -> {
            return r0.apply(v1);
        };
    }
}
