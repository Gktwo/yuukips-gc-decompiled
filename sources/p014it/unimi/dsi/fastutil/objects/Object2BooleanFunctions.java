package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.Predicate;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanFunctions.class */
public final class Object2BooleanFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Object2BooleanFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanFunctions$EmptyFunction.class */
    public static class EmptyFunction<K> extends AbstractObject2BooleanFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getBoolean(Object k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getOrDefault(Object k, boolean defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanFunction, p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean defaultReturnValue() {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanFunction, p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public void defaultReturnValue(boolean defRetValue) {
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
            return Object2BooleanFunctions.EMPTY_FUNCTION;
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
            return Object2BooleanFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanFunctions$Singleton.class */
    public static class Singleton<K> extends AbstractObject2BooleanFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K key;
        protected final boolean value;

        /* access modifiers changed from: protected */
        public Singleton(K key, boolean value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return Objects.equals(this.key, k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getBoolean(Object k) {
            return Objects.equals(this.key, k) ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getOrDefault(Object k, boolean defaultValue) {
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

    public static <K> Object2BooleanFunction<K> singleton(K key, boolean value) {
        return new Singleton(key, value);
    }

    public static <K> Object2BooleanFunction<K> singleton(K key, Boolean value) {
        return new Singleton(key, value.booleanValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<K> implements Object2BooleanFunction<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2BooleanFunction<K> function;
        protected final Object sync;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Boolean put(Object obj, Boolean bool) {
            return put((SynchronizedFunction<K>) obj, bool);
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Object2BooleanFunction<K> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Object2BooleanFunction<K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, java.util.function.Predicate
        public boolean test(K operand) {
            boolean test;
            synchronized (this.sync) {
                test = this.function.test(operand);
            }
            return test;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, java.util.function.Function
        @Deprecated
        public Boolean apply(K key) {
            Boolean apply;
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean defaultReturnValue() {
            boolean defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public void defaultReturnValue(boolean defRetValue) {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean put(K k, boolean v) {
            boolean put;
            synchronized (this.sync) {
                put = this.function.put((Object2BooleanFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getBoolean(Object k) {
            boolean z;
            synchronized (this.sync) {
                z = this.function.getBoolean(k);
            }
            return z;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getOrDefault(Object k, boolean defaultValue) {
            boolean orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean removeBoolean(Object k) {
            boolean removeBoolean;
            synchronized (this.sync) {
                removeBoolean = this.function.removeBoolean(k);
            }
            return removeBoolean;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            synchronized (this.sync) {
                this.function.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        @Deprecated
        public Boolean put(K k, Boolean v) {
            Boolean put;
            synchronized (this.sync) {
                put = this.function.put((Object2BooleanFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Boolean get(Object k) {
            Boolean bool;
            synchronized (this.sync) {
                bool = this.function.get(k);
            }
            return bool;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object k, Boolean defaultValue) {
            Boolean orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Boolean remove(Object k) {
            Boolean remove;
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

    public static <K> Object2BooleanFunction<K> synchronize(Object2BooleanFunction<K> f) {
        return new SynchronizedFunction(f);
    }

    public static <K> Object2BooleanFunction<K> synchronize(Object2BooleanFunction<K> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<K> extends AbstractObject2BooleanFunction<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Object2BooleanFunction<? extends K> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Boolean put(Object obj, Boolean bool) {
            return put((UnmodifiableFunction<K>) obj, bool);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Object2BooleanFunction<? extends K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanFunction, p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractObject2BooleanFunction, p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public void defaultReturnValue(boolean defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean put(K k, boolean v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getBoolean(Object k) {
            return this.function.getBoolean(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getOrDefault(Object k, boolean defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean removeBoolean(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        @Deprecated
        public Boolean put(K k, Boolean v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Boolean get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object k, Boolean defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Boolean remove(Object k) {
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

    public static <K> Object2BooleanFunction<K> unmodifiable(Object2BooleanFunction<? extends K> f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction<K> implements Object2BooleanFunction<K> {
        protected final java.util.function.Function<? super K, ? extends Boolean> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Boolean put(Object obj, Boolean bool) {
            return put((PrimitiveFunction<K>) obj, bool);
        }

        protected PrimitiveFunction(java.util.function.Function<? super K, ? extends Boolean> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object key) {
            return this.function.apply(key) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getBoolean(Object key) {
            Boolean v = (Boolean) this.function.apply(key);
            return v == null ? defaultReturnValue() : v.booleanValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        public boolean getOrDefault(Object key, boolean defaultValue) {
            Boolean v = (Boolean) this.function.apply(key);
            return v == null ? defaultValue : v.booleanValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Boolean get(Object key) {
            return (Boolean) this.function.apply(key);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object key, Boolean defaultValue) {
            Boolean v = (Boolean) this.function.apply(key);
            return v == null ? defaultValue : v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
        @Deprecated
        public Boolean put(K key, Boolean value) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Object2BooleanFunction<K> primitive(java.util.function.Function<? super K, ? extends Boolean> f) {
        Objects.requireNonNull(f);
        return f instanceof Object2BooleanFunction ? (Object2BooleanFunction) f : f instanceof Predicate ? key -> {
            return ((Predicate) f).test(key);
        } : new PrimitiveFunction(f);
    }
}
