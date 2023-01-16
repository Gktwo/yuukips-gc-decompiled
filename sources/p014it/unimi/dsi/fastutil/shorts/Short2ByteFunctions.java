package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteFunctions.class */
public final class Short2ByteFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Short2ByteFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractShort2ByteFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte get(short k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte getOrDefault(short k, byte defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap
        public boolean containsKey(short k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ByteFunction, p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ByteFunction, p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
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
            return Short2ByteFunctions.EMPTY_FUNCTION;
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
            return Short2ByteFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteFunctions$Singleton.class */
    public static class Singleton extends AbstractShort2ByteFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final short key;
        protected final byte value;

        /* access modifiers changed from: protected */
        public Singleton(short key, byte value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap
        public boolean containsKey(short k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte get(short k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte getOrDefault(short k, byte defaultValue) {
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

    public static Short2ByteFunction singleton(short key, byte value) {
        return new Singleton(key, value);
    }

    public static Short2ByteFunction singleton(Short key, Byte value) {
        return new Singleton(key.shortValue(), value.byteValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Short2ByteFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ByteFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Short2ByteFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Short2ByteFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, java.util.function.IntUnaryOperator
        @Deprecated
        public int applyAsInt(int operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Deprecated
        public Byte apply(Short key) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte defaultReturnValue() {
            byte defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public void defaultReturnValue(byte defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap
        public boolean containsKey(short k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte put(short k, byte v) {
            byte put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte get(short k) {
            byte b;
            synchronized (this.sync) {
                b = this.function.get(k);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte getOrDefault(short k, byte defaultValue) {
            byte orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte remove(short k) {
            byte remove;
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        @Deprecated
        public Byte put(Short k, Byte v) {
            Byte put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte get(Object k) {
            Byte b;
            synchronized (this.sync) {
                b = this.function.get(k);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object k, Byte defaultValue) {
            Byte orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Short2ByteFunction synchronize(Short2ByteFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Short2ByteFunction synchronize(Short2ByteFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractShort2ByteFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ByteFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Short2ByteFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ByteFunction, p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ByteFunction, p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public void defaultReturnValue(byte defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap
        public boolean containsKey(short k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte put(short k, byte v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte get(short k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte getOrDefault(short k, byte defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte remove(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        @Deprecated
        public Byte put(Short k, Byte v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object k, Byte defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Short2ByteFunction unmodifiable(Short2ByteFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ByteFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ByteFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Short2ByteFunction {
        protected final java.util.function.Function<? super Short, ? extends Byte> function;

        protected PrimitiveFunction(java.util.function.Function<? super Short, ? extends Byte> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.shorts.Short2ByteMap
        public boolean containsKey(short key) {
            return this.function.apply(Short.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Short) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte get(short key) {
            Byte v = (Byte) this.function.apply(Short.valueOf(key));
            return v == null ? defaultReturnValue() : v.byteValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        public byte getOrDefault(short key, byte defaultValue) {
            Byte v = (Byte) this.function.apply(Short.valueOf(key));
            return v == null ? defaultValue : v.byteValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte get(Object key) {
            if (key == null) {
                return null;
            }
            return (Byte) this.function.apply((Short) key);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            Byte v;
            if (!(key == null || (v = (Byte) this.function.apply((Short) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction
        @Deprecated
        public Byte put(Short key, Byte value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Short2ByteFunction primitive(java.util.function.Function<? super Short, ? extends Byte> f) {
        Objects.requireNonNull(f);
        return f instanceof Short2ByteFunction ? (Short2ByteFunction) f : f instanceof IntUnaryOperator ? key -> {
            return SafeMath.safeIntToByte(((IntUnaryOperator) f).applyAsInt(key));
        } : new PrimitiveFunction(f);
    }
}
