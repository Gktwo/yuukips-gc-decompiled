package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.ToIntFunction;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2IntFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntFunctions.class */
public final class Object2IntFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Object2IntFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntFunctions$EmptyFunction.class */
    public static class EmptyFunction<K> extends AbstractObject2IntFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getInt(Object k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getOrDefault(Object k, int defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntFunction, p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntFunction, p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public void defaultReturnValue(int defRetValue) {
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
            return Object2IntFunctions.EMPTY_FUNCTION;
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
            return Object2IntFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntFunctions$Singleton.class */
    public static class Singleton<K> extends AbstractObject2IntFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K key;
        protected final int value;

        /* access modifiers changed from: protected */
        public Singleton(K key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return Objects.equals(this.key, k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getInt(Object k) {
            return Objects.equals(this.key, k) ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getOrDefault(Object k, int defaultValue) {
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

    public static <K> Object2IntFunction<K> singleton(K key, int value) {
        return new Singleton(key, value);
    }

    public static <K> Object2IntFunction<K> singleton(K key, Integer value) {
        return new Singleton(key, value.intValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<K> implements Object2IntFunction<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2IntFunction<K> function;
        protected final Object sync;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Integer put(Object obj, Integer num) {
            return put((SynchronizedFunction<K>) obj, num);
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Object2IntFunction<K> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Object2IntFunction<K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction, java.util.function.ToIntFunction
        public int applyAsInt(K operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, java.util.function.Function
        @Deprecated
        public Integer apply(K key) {
            Integer apply;
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int defaultReturnValue() {
            int defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public void defaultReturnValue(int defRetValue) {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int put(K k, int v) {
            int put;
            synchronized (this.sync) {
                put = this.function.put((Object2IntFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getInt(Object k) {
            int i;
            synchronized (this.sync) {
                i = this.function.getInt(k);
            }
            return i;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getOrDefault(Object k, int defaultValue) {
            int orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int removeInt(Object k) {
            int removeInt;
            synchronized (this.sync) {
                removeInt = this.function.removeInt(k);
            }
            return removeInt;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            synchronized (this.sync) {
                this.function.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        @Deprecated
        public Integer put(K k, Integer v) {
            Integer put;
            synchronized (this.sync) {
                put = this.function.put((Object2IntFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object k) {
            Integer num;
            synchronized (this.sync) {
                num = this.function.get(k);
            }
            return num;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        @Deprecated
        public Integer getOrDefault(Object k, Integer defaultValue) {
            Integer orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer remove(Object k) {
            Integer remove;
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

    public static <K> Object2IntFunction<K> synchronize(Object2IntFunction<K> f) {
        return new SynchronizedFunction(f);
    }

    public static <K> Object2IntFunction<K> synchronize(Object2IntFunction<K> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<K> extends AbstractObject2IntFunction<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2IntFunction<? extends K> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Integer put(Object obj, Integer num) {
            return put((UnmodifiableFunction<K>) obj, num);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Object2IntFunction<? extends K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntFunction, p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2IntFunction, p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public void defaultReturnValue(int defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int put(K k, int v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getInt(Object k) {
            return this.function.getInt(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getOrDefault(Object k, int defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int removeInt(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        @Deprecated
        public Integer put(K k, Integer v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        @Deprecated
        public Integer getOrDefault(Object k, Integer defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer remove(Object k) {
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

    public static <K> Object2IntFunction<K> unmodifiable(Object2IntFunction<? extends K> f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2IntFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2IntFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction<K> implements Object2IntFunction<K> {
        protected final java.util.function.Function<? super K, ? extends Integer> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Integer put(Object obj, Integer num) {
            return put((PrimitiveFunction<K>) obj, num);
        }

        protected PrimitiveFunction(java.util.function.Function<? super K, ? extends Integer> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object key) {
            return this.function.apply(key) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getInt(Object key) {
            Integer v = (Integer) this.function.apply(key);
            return v == null ? defaultReturnValue() : v.intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        public int getOrDefault(Object key, int defaultValue) {
            Integer v = (Integer) this.function.apply(key);
            return v == null ? defaultValue : v.intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object key) {
            return (Integer) this.function.apply(key);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        @Deprecated
        public Integer getOrDefault(Object key, Integer defaultValue) {
            Integer v = (Integer) this.function.apply(key);
            return v == null ? defaultValue : v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2IntFunction
        @Deprecated
        public Integer put(K key, Integer value) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2IntFunction<K> primitive(java.util.function.Function<? super K, ? extends Integer> f) {
        Objects.requireNonNull(f);
        return f instanceof Object2IntFunction ? (Object2IntFunction) f : f instanceof ToIntFunction ? key -> {
            return ((ToIntFunction) f).applyAsInt(key);
        } : new PrimitiveFunction(f);
    }
}
