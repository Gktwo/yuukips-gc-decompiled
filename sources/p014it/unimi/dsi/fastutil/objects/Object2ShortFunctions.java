package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.ToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortFunctions.class */
public final class Object2ShortFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Object2ShortFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortFunctions$EmptyFunction.class */
    public static class EmptyFunction<K> extends AbstractObject2ShortFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getShort(Object k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getOrDefault(Object k, short defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortFunction, p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortFunction, p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public void defaultReturnValue(short defRetValue) {
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
            return Object2ShortFunctions.EMPTY_FUNCTION;
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
            return Object2ShortFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortFunctions$Singleton.class */
    public static class Singleton<K> extends AbstractObject2ShortFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K key;
        protected final short value;

        /* access modifiers changed from: protected */
        public Singleton(K key, short value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return Objects.equals(this.key, k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getShort(Object k) {
            return Objects.equals(this.key, k) ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getOrDefault(Object k, short defaultValue) {
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

    public static <K> Object2ShortFunction<K> singleton(K key, short value) {
        return new Singleton(key, value);
    }

    public static <K> Object2ShortFunction<K> singleton(K key, Short value) {
        return new Singleton(key, value.shortValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<K> implements Object2ShortFunction<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ShortFunction<K> function;
        protected final Object sync;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Short put(Object obj, Short sh) {
            return put((SynchronizedFunction<K>) obj, sh);
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Object2ShortFunction<K> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Object2ShortFunction<K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction, java.util.function.ToIntFunction
        public int applyAsInt(K operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, java.util.function.Function
        @Deprecated
        public Short apply(K key) {
            Short apply;
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short defaultReturnValue() {
            short defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public void defaultReturnValue(short defRetValue) {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short put(K k, short v) {
            short put;
            synchronized (this.sync) {
                put = this.function.put((Object2ShortFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getShort(Object k) {
            short s;
            synchronized (this.sync) {
                s = this.function.getShort(k);
            }
            return s;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getOrDefault(Object k, short defaultValue) {
            short orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short removeShort(Object k) {
            short removeShort;
            synchronized (this.sync) {
                removeShort = this.function.removeShort(k);
            }
            return removeShort;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            synchronized (this.sync) {
                this.function.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        @Deprecated
        public Short put(K k, Short v) {
            Short put;
            synchronized (this.sync) {
                put = this.function.put((Object2ShortFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Short get(Object k) {
            Short sh;
            synchronized (this.sync) {
                sh = this.function.get(k);
            }
            return sh;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        @Deprecated
        public Short getOrDefault(Object k, Short defaultValue) {
            Short orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Short remove(Object k) {
            Short remove;
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

    public static <K> Object2ShortFunction<K> synchronize(Object2ShortFunction<K> f) {
        return new SynchronizedFunction(f);
    }

    public static <K> Object2ShortFunction<K> synchronize(Object2ShortFunction<K> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<K> extends AbstractObject2ShortFunction<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2ShortFunction<? extends K> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Short put(Object obj, Short sh) {
            return put((UnmodifiableFunction<K>) obj, sh);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Object2ShortFunction<? extends K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortFunction, p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2ShortFunction, p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public void defaultReturnValue(short defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short put(K k, short v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getShort(Object k) {
            return this.function.getShort(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getOrDefault(Object k, short defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short removeShort(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        @Deprecated
        public Short put(K k, Short v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Short get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        @Deprecated
        public Short getOrDefault(Object k, Short defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Short remove(Object k) {
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

    public static <K> Object2ShortFunction<K> unmodifiable(Object2ShortFunction<? extends K> f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction<K> implements Object2ShortFunction<K> {
        protected final java.util.function.Function<? super K, ? extends Short> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Short put(Object obj, Short sh) {
            return put((PrimitiveFunction<K>) obj, sh);
        }

        protected PrimitiveFunction(java.util.function.Function<? super K, ? extends Short> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object key) {
            return this.function.apply(key) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getShort(Object key) {
            Short v = (Short) this.function.apply(key);
            return v == null ? defaultReturnValue() : v.shortValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        public short getOrDefault(Object key, short defaultValue) {
            Short v = (Short) this.function.apply(key);
            return v == null ? defaultValue : v.shortValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Short get(Object key) {
            return (Short) this.function.apply(key);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            Short v = (Short) this.function.apply(key);
            return v == null ? defaultValue : v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2ShortFunction
        @Deprecated
        public Short put(K key, Short value) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2ShortFunction<K> primitive(java.util.function.Function<? super K, ? extends Short> f) {
        Objects.requireNonNull(f);
        return f instanceof Object2ShortFunction ? (Object2ShortFunction) f : f instanceof ToIntFunction ? key -> {
            return SafeMath.safeIntToShort(((ToIntFunction) f).applyAsInt(key));
        } : new PrimitiveFunction(f);
    }
}
