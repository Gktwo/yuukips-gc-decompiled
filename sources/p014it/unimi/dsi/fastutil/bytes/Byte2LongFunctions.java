package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntToLongFunction;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongFunctions.class */
public final class Byte2LongFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Byte2LongFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractByte2LongFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long get(byte k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long getOrDefault(byte k, long defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap
        public boolean containsKey(byte k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
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
            return Byte2LongFunctions.EMPTY_FUNCTION;
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
            return Byte2LongFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongFunctions$Singleton.class */
    public static class Singleton extends AbstractByte2LongFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final byte key;
        protected final long value;

        /* access modifiers changed from: protected */
        public Singleton(byte key, long value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap
        public boolean containsKey(byte k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long get(byte k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long getOrDefault(byte k, long defaultValue) {
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

    public static Byte2LongFunction singleton(byte key, long value) {
        return new Singleton(key, value);
    }

    public static Byte2LongFunction singleton(Byte key, Long value) {
        return new Singleton(key.byteValue(), value.longValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Byte2LongFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2LongFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Byte2LongFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Byte2LongFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, java.util.function.IntToLongFunction
        @Deprecated
        public long applyAsLong(int operand) {
            long applyAsLong;
            synchronized (this.sync) {
                applyAsLong = this.function.applyAsLong(operand);
            }
            return applyAsLong;
        }

        @Deprecated
        public Long apply(Byte key) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long defaultReturnValue() {
            long defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public void defaultReturnValue(long defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap
        public boolean containsKey(byte k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long put(byte k, long v) {
            long put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long get(byte k) {
            long j;
            synchronized (this.sync) {
                j = this.function.get(k);
            }
            return j;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long getOrDefault(byte k, long defaultValue) {
            long orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long remove(byte k) {
            long remove;
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        @Deprecated
        public Long put(Byte k, Long v) {
            Long put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Long get(Object k) {
            Long l;
            synchronized (this.sync) {
                l = this.function.get(k);
            }
            return l;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        @Deprecated
        public Long getOrDefault(Object k, Long defaultValue) {
            Long orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Byte2LongFunction synchronize(Byte2LongFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Byte2LongFunction synchronize(Byte2LongFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractByte2LongFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2LongFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Byte2LongFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public void defaultReturnValue(long defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap
        public boolean containsKey(byte k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long put(byte k, long v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long get(byte k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long getOrDefault(byte k, long defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long remove(byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        @Deprecated
        public Long put(Byte k, Long v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Long get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        @Deprecated
        public Long getOrDefault(Object k, Long defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Byte2LongFunction unmodifiable(Byte2LongFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2LongFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2LongFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Byte2LongFunction {
        protected final java.util.function.Function<? super Byte, ? extends Long> function;

        protected PrimitiveFunction(java.util.function.Function<? super Byte, ? extends Long> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.bytes.Byte2LongMap
        public boolean containsKey(byte key) {
            return this.function.apply(Byte.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Byte) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long get(byte key) {
            Long v = (Long) this.function.apply(Byte.valueOf(key));
            return v == null ? defaultReturnValue() : v.longValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        public long getOrDefault(byte key, long defaultValue) {
            Long v = (Long) this.function.apply(Byte.valueOf(key));
            return v == null ? defaultValue : v.longValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Long get(Object key) {
            if (key == null) {
                return null;
            }
            return (Long) this.function.apply((Byte) key);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        @Deprecated
        public Long getOrDefault(Object key, Long defaultValue) {
            Long v;
            if (!(key == null || (v = (Long) this.function.apply((Byte) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction
        @Deprecated
        public Long put(Byte key, Long value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Byte2LongFunction primitive(java.util.function.Function<? super Byte, ? extends Long> f) {
        Objects.requireNonNull(f);
        if (f instanceof Byte2LongFunction) {
            return (Byte2LongFunction) f;
        }
        if (!(f instanceof IntToLongFunction)) {
            return new PrimitiveFunction(f);
        }
        IntToLongFunction intToLongFunction = (IntToLongFunction) f;
        Objects.requireNonNull(intToLongFunction);
        return (v1) -> {
            return r0.applyAsLong(v1);
        };
    }
}
