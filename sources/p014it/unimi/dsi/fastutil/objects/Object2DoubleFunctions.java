package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.ToDoubleFunction;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleFunctions.class */
public final class Object2DoubleFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Object2DoubleFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleFunctions$EmptyFunction.class */
    public static class EmptyFunction<K> extends AbstractObject2DoubleFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double getDouble(Object k) {
            return 0.0d;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double getOrDefault(Object k, double defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2DoubleFunction, p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double defaultReturnValue() {
            return 0.0d;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2DoubleFunction, p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public void defaultReturnValue(double defRetValue) {
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
            return Object2DoubleFunctions.EMPTY_FUNCTION;
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
            return Object2DoubleFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleFunctions$Singleton.class */
    public static class Singleton<K> extends AbstractObject2DoubleFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K key;
        protected final double value;

        /* access modifiers changed from: protected */
        public Singleton(K key, double value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return Objects.equals(this.key, k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double getDouble(Object k) {
            return Objects.equals(this.key, k) ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double getOrDefault(Object k, double defaultValue) {
            return Objects.equals(this.key, k) ? this.value : defaultValue;
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

    public static <K> Object2DoubleFunction<K> singleton(K key, double value) {
        return new Singleton(key, value);
    }

    public static <K> Object2DoubleFunction<K> singleton(K key, Double value) {
        return new Singleton(key, value.doubleValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<K> implements Object2DoubleFunction<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2DoubleFunction<K> function;
        protected final Object sync;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Double put(Object obj, Double d) {
            return put((SynchronizedFunction<K>) obj, d);
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Object2DoubleFunction<K> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Object2DoubleFunction<K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, java.util.function.ToDoubleFunction
        public double applyAsDouble(K operand) {
            double applyAsDouble;
            synchronized (this.sync) {
                applyAsDouble = this.function.applyAsDouble(operand);
            }
            return applyAsDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, java.util.function.Function
        @Deprecated
        public Double apply(K key) {
            Double apply;
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double defaultReturnValue() {
            double defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public void defaultReturnValue(double defRetValue) {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double put(K k, double v) {
            double put;
            synchronized (this.sync) {
                put = this.function.put((Object2DoubleFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double getDouble(Object k) {
            double d;
            synchronized (this.sync) {
                d = this.function.getDouble(k);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double getOrDefault(Object k, double defaultValue) {
            double orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double removeDouble(Object k) {
            double removeDouble;
            synchronized (this.sync) {
                removeDouble = this.function.removeDouble(k);
            }
            return removeDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            synchronized (this.sync) {
                this.function.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        @Deprecated
        public Double put(K k, Double v) {
            Double put;
            synchronized (this.sync) {
                put = this.function.put((Object2DoubleFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double get(Object k) {
            Double d;
            synchronized (this.sync) {
                d = this.function.get(k);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object k, Double defaultValue) {
            Double orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double remove(Object k) {
            Double remove;
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

    public static <K> Object2DoubleFunction<K> synchronize(Object2DoubleFunction<K> f) {
        return new SynchronizedFunction(f);
    }

    public static <K> Object2DoubleFunction<K> synchronize(Object2DoubleFunction<K> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<K> extends AbstractObject2DoubleFunction<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2DoubleFunction<? extends K> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Double put(Object obj, Double d) {
            return put((UnmodifiableFunction<K>) obj, d);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Object2DoubleFunction<? extends K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2DoubleFunction, p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2DoubleFunction, p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public void defaultReturnValue(double defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double put(K k, double v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double getDouble(Object k) {
            return this.function.getDouble(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double getOrDefault(Object k, double defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double removeDouble(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        @Deprecated
        public Double put(K k, Double v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object k, Double defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double remove(Object k) {
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

    public static <K> Object2DoubleFunction<K> unmodifiable(Object2DoubleFunction<? extends K> f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2DoubleFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2DoubleFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction<K> implements Object2DoubleFunction<K> {
        protected final java.util.function.Function<? super K, ? extends Double> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Double put(Object obj, Double d) {
            return put((PrimitiveFunction<K>) obj, d);
        }

        protected PrimitiveFunction(java.util.function.Function<? super K, ? extends Double> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object key) {
            return this.function.apply(key) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double getDouble(Object key) {
            Double v = (Double) this.function.apply(key);
            return v == null ? defaultReturnValue() : v.doubleValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        public double getOrDefault(Object key, double defaultValue) {
            Double v = (Double) this.function.apply(key);
            return v == null ? defaultValue : v.doubleValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double get(Object key) {
            return (Double) this.function.apply(key);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object key, Double defaultValue) {
            Double v = (Double) this.function.apply(key);
            return v == null ? defaultValue : v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction
        @Deprecated
        public Double put(K key, Double value) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2DoubleFunction<K> primitive(java.util.function.Function<? super K, ? extends Double> f) {
        Objects.requireNonNull(f);
        return f instanceof Object2DoubleFunction ? (Object2DoubleFunction) f : f instanceof ToDoubleFunction ? key -> {
            return ((ToDoubleFunction) f).applyAsDouble(key);
        } : new PrimitiveFunction(f);
    }
}
