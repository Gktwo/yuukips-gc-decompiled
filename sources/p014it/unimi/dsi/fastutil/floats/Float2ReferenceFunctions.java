package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.DoubleFunction;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceFunctions.class */
public final class Float2ReferenceFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Float2ReferenceFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceFunctions$EmptyFunction.class */
    public static class EmptyFunction<V> extends AbstractFloat2ReferenceFunction<V> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V get(float k) {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V getOrDefault(float k, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public boolean containsKey(float k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V defaultReturnValue() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
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
            return Float2ReferenceFunctions.EMPTY_FUNCTION;
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
            return Float2ReferenceFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceFunctions$Singleton.class */
    public static class Singleton<V> extends AbstractFloat2ReferenceFunction<V> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final float key;
        protected final V value;

        /* access modifiers changed from: protected */
        public Singleton(float key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public boolean containsKey(float k) {
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V get(float k) {
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(k) ? this.value : (V) this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V getOrDefault(float k, V defaultValue) {
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(k) ? this.value : defaultValue;
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

    public static <V> Float2ReferenceFunction<V> singleton(float key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Float2ReferenceFunction<V> singleton(Float key, V value) {
        return new Singleton(key.floatValue(), value);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<V> implements Float2ReferenceFunction<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ReferenceFunction<V> function;
        protected final Object sync;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Object put(Float f, Object obj) {
            return put(f, (Float) obj);
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Float2ReferenceFunction<V> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Float2ReferenceFunction<V> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, java.util.function.DoubleFunction
        @Deprecated
        public V apply(double operand) {
            V apply;
            synchronized (this.sync) {
                apply = this.function.apply(operand);
            }
            return apply;
        }

        @Deprecated
        public V apply(Float key) {
            V apply;
            synchronized (this.sync) {
                apply = this.function.apply((Float2ReferenceFunction<V>) key);
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V defaultReturnValue() {
            V defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public void defaultReturnValue(V defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public boolean containsKey(float k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V put(float k, V v) {
            V put;
            synchronized (this.sync) {
                put = this.function.put(k, (float) v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V get(float k) {
            V v;
            synchronized (this.sync) {
                v = this.function.get(k);
            }
            return v;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V getOrDefault(float k, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, (float) defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V remove(float k) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        @Deprecated
        public V put(Float k, V v) {
            V put;
            synchronized (this.sync) {
                put = this.function.put(k, (Float) v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V get(Object k) {
            V v;
            synchronized (this.sync) {
                v = this.function.get(k);
            }
            return v;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object k, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
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

    public static <V> Float2ReferenceFunction<V> synchronize(Float2ReferenceFunction<V> f) {
        return new SynchronizedFunction(f);
    }

    public static <V> Float2ReferenceFunction<V> synchronize(Float2ReferenceFunction<V> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<V> extends AbstractFloat2ReferenceFunction<V> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ReferenceFunction<? extends V> function;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Object put(Float f, Object obj) {
            return put(f, (Float) obj);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Float2ReferenceFunction<? extends V> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V defaultReturnValue() {
            return (V) this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ReferenceFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public void defaultReturnValue(V defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public boolean containsKey(float k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V put(float k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V get(float k) {
            return (V) this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V getOrDefault(float k, V defaultValue) {
            return (V) this.function.getOrDefault(k, (float) defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V remove(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        @Deprecated
        public V put(Float k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V get(Object k) {
            return (V) this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object k, V defaultValue) {
            return (V) this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
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

    public static <V> Float2ReferenceFunction<V> unmodifiable(Float2ReferenceFunction<? extends V> f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ReferenceFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ReferenceFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction<V> implements Float2ReferenceFunction<V> {
        protected final java.util.function.Function<? super Float, ? extends V> function;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Object put(Float f, Object obj) {
            return put(f, (Float) obj);
        }

        protected PrimitiveFunction(java.util.function.Function<? super Float, ? extends V> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.floats.Float2ReferenceMap
        public boolean containsKey(float key) {
            return this.function.apply(Float.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Float) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V get(float key) {
            V v = (V) this.function.apply(Float.valueOf(key));
            if (v == null) {
                return null;
            }
            return v;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        public V getOrDefault(float key, V defaultValue) {
            V v = (V) this.function.apply(Float.valueOf(key));
            return v == null ? defaultValue : v;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V get(Object key) {
            if (key == null) {
                return null;
            }
            return (V) this.function.apply((Float) key);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            V v;
            if (!(key == null || (v = (V) this.function.apply((Float) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction
        @Deprecated
        public V put(Float key, V value) {
            throw new UnsupportedOperationException();
        }
    }

    public static <V> Float2ReferenceFunction<V> primitive(java.util.function.Function<? super Float, ? extends V> f) {
        Objects.requireNonNull(f);
        if (f instanceof Float2ReferenceFunction) {
            return (Float2ReferenceFunction) f;
        }
        if (!(f instanceof DoubleFunction)) {
            return new PrimitiveFunction(f);
        }
        DoubleFunction doubleFunction = (DoubleFunction) f;
        Objects.requireNonNull(doubleFunction);
        return (v1) -> {
            return r0.apply(v1);
        };
    }
}
