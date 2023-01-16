package p014it.unimi.dsi.fastutil.objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.ToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteFunctions.class */
public final class Reference2ByteFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Reference2ByteFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteFunctions$EmptyFunction.class */
    public static class EmptyFunction<K> extends AbstractReference2ByteFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte getByte(Object k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte getOrDefault(Object k, byte defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ByteFunction, p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ByteFunction, p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public void defaultReturnValue(byte defRetValue) {
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
            return Reference2ByteFunctions.EMPTY_FUNCTION;
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
            return Reference2ByteFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteFunctions$Singleton.class */
    public static class Singleton<K> extends AbstractReference2ByteFunction<K> implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K key;
        protected final byte value;

        /* access modifiers changed from: protected */
        public Singleton(K key, byte value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte getByte(Object k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte getOrDefault(Object k, byte defaultValue) {
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

    public static <K> Reference2ByteFunction<K> singleton(K key, byte value) {
        return new Singleton(key, value);
    }

    public static <K> Reference2ByteFunction<K> singleton(K key, Byte value) {
        return new Singleton(key, value.byteValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction<K> implements Reference2ByteFunction<K>, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ByteFunction<K> function;
        protected final Object sync;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Byte put(Object obj, Byte b) {
            return put((SynchronizedFunction<K>) obj, b);
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Reference2ByteFunction<K> f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Reference2ByteFunction<K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, java.util.function.ToIntFunction
        public int applyAsInt(K operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, java.util.function.Function
        @Deprecated
        public Byte apply(K key) {
            Byte apply;
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte defaultReturnValue() {
            byte defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public void defaultReturnValue(byte defRetValue) {
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

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte put(K k, byte v) {
            byte put;
            synchronized (this.sync) {
                put = this.function.put((Reference2ByteFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte getByte(Object k) {
            byte b;
            synchronized (this.sync) {
                b = this.function.getByte(k);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte getOrDefault(Object k, byte defaultValue) {
            byte orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte removeByte(Object k) {
            byte removeByte;
            synchronized (this.sync) {
                removeByte = this.function.removeByte(k);
            }
            return removeByte;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            synchronized (this.sync) {
                this.function.clear();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        @Deprecated
        public Byte put(K k, Byte v) {
            Byte put;
            synchronized (this.sync) {
                put = this.function.put((Reference2ByteFunction<K>) k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte get(Object k) {
            Byte b;
            synchronized (this.sync) {
                b = this.function.get(k);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object k, Byte defaultValue) {
            Byte orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte remove(Object k) {
            Byte remove;
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

    public static <K> Reference2ByteFunction<K> synchronize(Reference2ByteFunction<K> f) {
        return new SynchronizedFunction(f);
    }

    public static <K> Reference2ByteFunction<K> synchronize(Reference2ByteFunction<K> f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction<K> extends AbstractReference2ByteFunction<K> implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Reference2ByteFunction<? extends K> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Byte put(Object obj, Byte b) {
            return put((UnmodifiableFunction<K>) obj, b);
        }

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Reference2ByteFunction<? extends K> f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ByteFunction, p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.AbstractReference2ByteFunction, p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public void defaultReturnValue(byte defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte put(K k, byte v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte getByte(Object k) {
            return this.function.getByte(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte getOrDefault(Object k, byte defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte removeByte(Object k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        @Deprecated
        public Byte put(K k, Byte v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object k, Byte defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte remove(Object k) {
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

    public static <K> Reference2ByteFunction<K> unmodifiable(Reference2ByteFunction<? extends K> f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction<K> implements Reference2ByteFunction<K> {
        protected final java.util.function.Function<? super K, ? extends Byte> function;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public /* bridge */ /* synthetic */ Byte put(Object obj, Byte b) {
            return put((PrimitiveFunction<K>) obj, b);
        }

        protected PrimitiveFunction(java.util.function.Function<? super K, ? extends Byte> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.Function
        public boolean containsKey(Object key) {
            return this.function.apply(key) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte getByte(Object key) {
            Byte v = (Byte) this.function.apply(key);
            return v == null ? defaultReturnValue() : v.byteValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        public byte getOrDefault(Object key, byte defaultValue) {
            Byte v = (Byte) this.function.apply(key);
            return v == null ? defaultValue : v.byteValue();
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte get(Object key) {
            return (Byte) this.function.apply(key);
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            Byte v = (Byte) this.function.apply(key);
            return v == null ? defaultValue : v;
        }

        @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
        @Deprecated
        public Byte put(K key, Byte value) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K> Reference2ByteFunction<K> primitive(java.util.function.Function<? super K, ? extends Byte> f) {
        Objects.requireNonNull(f);
        return f instanceof Reference2ByteFunction ? (Reference2ByteFunction) f : f instanceof ToIntFunction ? key -> {
            return SafeMath.safeIntToByte(((ToIntFunction) f).applyAsInt(key));
        } : new PrimitiveFunction(f);
    }
}
