package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.ToDoubleFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatFunctions.class */
public final class Object2FloatFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Object2FloatFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatFunctions$EmptyFunction.class */
    public static class EmptyFunction<K> extends AbstractObject2FloatFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float getFloat(Object k) {
            return 0.0f;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float getOrDefault(Object k, float defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2FloatFunction, p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float defaultReturnValue() {
            return 0.0f;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2FloatFunction, p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public void defaultReturnValue(float defRetValue) {
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
            return Object2FloatFunctions.EMPTY_FUNCTION;
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
            return Object2FloatFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatFunctions$Singleton.class */
    public static class Singleton<K> extends AbstractObject2FloatFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K key;
        protected final float value;

        /* access modifiers changed from: protected */
        public Singleton(K key, float value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return Objects.equals(this.key, k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float getFloat(Object k) {
            return Objects.equals(this.key, k) ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float getOrDefault(Object k, float defaultValue) {
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

    public static <K> Object2FloatFunction<K> singleton(K key, float value) {
        return new Singleton(key, value);
    }

    public static <K> Object2FloatFunction<K> singleton(K key, Float value) {
        return new Singleton(key, value.floatValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<K> implements Object2FloatFunction<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2FloatFunction<K> function;
        protected final Object sync;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Float put(Object obj, Float f) {
            return put((SynchronizedFunction<K>) obj, f);
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Object2FloatFunction<K> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Object2FloatFunction<K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, java.util.function.ToDoubleFunction
        public double applyAsDouble(K operand) {
            double applyAsDouble;
            synchronized (this.sync) {
                applyAsDouble = this.function.applyAsDouble(operand);
            }
            return applyAsDouble;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, java.util.function.Function
        @Deprecated
        public Float apply(K key) {
            Float apply;
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float defaultReturnValue() {
            float defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public void defaultReturnValue(float defRetValue) {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float put(K k, float v) {
            float put;
            synchronized (this.sync) {
                put = this.function.put((Object2FloatFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float getFloat(Object k) {
            float f;
            synchronized (this.sync) {
                f = this.function.getFloat(k);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float getOrDefault(Object k, float defaultValue) {
            float orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float removeFloat(Object k) {
            float removeFloat;
            synchronized (this.sync) {
                removeFloat = this.function.removeFloat(k);
            }
            return removeFloat;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            synchronized (this.sync) {
                this.function.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        @Deprecated
        public Float put(K k, Float v) {
            Float put;
            synchronized (this.sync) {
                put = this.function.put((Object2FloatFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Float get(Object k) {
            Float f;
            synchronized (this.sync) {
                f = this.function.get(k);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        @Deprecated
        public Float getOrDefault(Object k, Float defaultValue) {
            Float orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Float remove(Object k) {
            Float remove;
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

    public static <K> Object2FloatFunction<K> synchronize(Object2FloatFunction<K> f) {
        return new SynchronizedFunction(f);
    }

    public static <K> Object2FloatFunction<K> synchronize(Object2FloatFunction<K> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<K> extends AbstractObject2FloatFunction<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2FloatFunction<? extends K> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Float put(Object obj, Float f) {
            return put((UnmodifiableFunction<K>) obj, f);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Object2FloatFunction<? extends K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2FloatFunction, p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2FloatFunction, p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public void defaultReturnValue(float defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float put(K k, float v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float getFloat(Object k) {
            return this.function.getFloat(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float getOrDefault(Object k, float defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float removeFloat(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        @Deprecated
        public Float put(K k, Float v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Float get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        @Deprecated
        public Float getOrDefault(Object k, Float defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Float remove(Object k) {
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

    public static <K> Object2FloatFunction<K> unmodifiable(Object2FloatFunction<? extends K> f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2FloatFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2FloatFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction<K> implements Object2FloatFunction<K> {
        protected final java.util.function.Function<? super K, ? extends Float> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Float put(Object obj, Float f) {
            return put((PrimitiveFunction<K>) obj, f);
        }

        protected PrimitiveFunction(java.util.function.Function<? super K, ? extends Float> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object key) {
            return this.function.apply(key) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float getFloat(Object key) {
            Float v = (Float) this.function.apply(key);
            return v == null ? defaultReturnValue() : v.floatValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        public float getOrDefault(Object key, float defaultValue) {
            Float v = (Float) this.function.apply(key);
            return v == null ? defaultValue : v.floatValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Float get(Object key) {
            return (Float) this.function.apply(key);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            Float v = (Float) this.function.apply(key);
            return v == null ? defaultValue : v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2FloatFunction
        @Deprecated
        public Float put(K key, Float value) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2FloatFunction<K> primitive(java.util.function.Function<? super K, ? extends Float> f) {
        Objects.requireNonNull(f);
        return f instanceof Object2FloatFunction ? (Object2FloatFunction) f : f instanceof ToDoubleFunction ? key -> {
            return SafeMath.safeDoubleToFloat(((ToDoubleFunction) f).applyAsDouble(key));
        } : new PrimitiveFunction(f);
    }
}
