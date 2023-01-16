package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.DoubleFunction;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectFunctions.class */
public final class Double2ObjectFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Double2ObjectFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectFunctions$EmptyFunction.class */
    public static class EmptyFunction<V> extends AbstractDouble2ObjectFunction<V> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V get(double k) {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V getOrDefault(double k, V defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public boolean containsKey(double k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ObjectFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V defaultReturnValue() {
            return null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ObjectFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
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
            return Double2ObjectFunctions.EMPTY_FUNCTION;
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
            return Double2ObjectFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectFunctions$Singleton.class */
    public static class Singleton<V> extends AbstractDouble2ObjectFunction<V> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final double key;
        protected final V value;

        /* access modifiers changed from: protected */
        public Singleton(double key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public boolean containsKey(double k) {
            return Double.doubleToLongBits(this.key) == Double.doubleToLongBits(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V get(double k) {
            return Double.doubleToLongBits(this.key) == Double.doubleToLongBits(k) ? this.value : (V) this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V getOrDefault(double k, V defaultValue) {
            return Double.doubleToLongBits(this.key) == Double.doubleToLongBits(k) ? this.value : defaultValue;
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

    public static <V> Double2ObjectFunction<V> singleton(double key, V value) {
        return new Singleton(key, value);
    }

    public static <V> Double2ObjectFunction<V> singleton(Double key, V value) {
        return new Singleton(key.doubleValue(), value);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<V> implements Double2ObjectFunction<V>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2ObjectFunction<V> function;
        protected final Object sync;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Object put(Double d, Object obj) {
            return put(d, (Double) obj);
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Double2ObjectFunction<V> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Double2ObjectFunction<V> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, java.util.function.DoubleFunction
        public V apply(double operand) {
            V apply;
            synchronized (this.sync) {
                apply = this.function.apply(operand);
            }
            return apply;
        }

        @Deprecated
        public V apply(Double key) {
            V apply;
            synchronized (this.sync) {
                apply = this.function.apply((Double2ObjectFunction<V>) key);
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

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V defaultReturnValue() {
            V defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public void defaultReturnValue(V defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public boolean containsKey(double k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V put(double k, V v) {
            V put;
            synchronized (this.sync) {
                put = this.function.put(k, (double) v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V get(double k) {
            V v;
            synchronized (this.sync) {
                v = this.function.get(k);
            }
            return v;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V getOrDefault(double k, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, (double) defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V remove(double k) {
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

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        @Deprecated
        public V put(Double k, V v) {
            V put;
            synchronized (this.sync) {
                put = this.function.put(k, (Double) v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V get(Object k) {
            V v;
            synchronized (this.sync) {
                v = this.function.get(k);
            }
            return v;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object k, V defaultValue) {
            V orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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

    public static <V> Double2ObjectFunction<V> synchronize(Double2ObjectFunction<V> f) {
        return new SynchronizedFunction(f);
    }

    public static <V> Double2ObjectFunction<V> synchronize(Double2ObjectFunction<V> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<V> extends AbstractDouble2ObjectFunction<V> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Double2ObjectFunction<? extends V> function;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Object put(Double d, Object obj) {
            return put(d, (Double) obj);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Double2ObjectFunction<? extends V> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ObjectFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V defaultReturnValue() {
            return (V) this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDouble2ObjectFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public void defaultReturnValue(V defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public boolean containsKey(double k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V put(double k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V get(double k) {
            return (V) this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V getOrDefault(double k, V defaultValue) {
            return (V) this.function.getOrDefault(k, (double) defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V remove(double k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        @Deprecated
        public V put(Double k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V get(Object k) {
            return (V) this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object k, V defaultValue) {
            return (V) this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
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

    public static <V> Double2ObjectFunction<V> unmodifiable(Double2ObjectFunction<? extends V> f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction<V> implements Double2ObjectFunction<V> {
        protected final java.util.function.Function<? super Double, ? extends V> function;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Object put(Double d, Object obj) {
            return put(d, (Double) obj);
        }

        protected PrimitiveFunction(java.util.function.Function<? super Double, ? extends V> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.doubles.Double2ObjectMap
        public boolean containsKey(double key) {
            return this.function.apply(Double.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Double) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V get(double key) {
            V v = (V) this.function.apply(Double.valueOf(key));
            if (v == null) {
                return null;
            }
            return v;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        public V getOrDefault(double key, V defaultValue) {
            V v = (V) this.function.apply(Double.valueOf(key));
            return v == null ? defaultValue : v;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V get(Object key) {
            if (key == null) {
                return null;
            }
            return (V) this.function.apply((Double) key);
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public V getOrDefault(Object key, V defaultValue) {
            V v;
            if (!(key == null || (v = (V) this.function.apply((Double) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
        @Deprecated
        public V put(Double key, V value) {
            throw new UnsupportedOperationException();
        }
    }

    public static <V> Double2ObjectFunction<V> primitive(java.util.function.Function<? super Double, ? extends V> f) {
        Objects.requireNonNull(f);
        if (f instanceof Double2ObjectFunction) {
            return (Double2ObjectFunction) f;
        }
        if (!(f instanceof DoubleFunction)) {
            return new PrimitiveFunction(f);
        }
        DoubleFunction doubleFunction = (DoubleFunction) f;
        Objects.requireNonNull(doubleFunction);
        return this::apply;
    }
}
