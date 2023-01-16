package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortFunctions.class */
public final class Short2ShortFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Short2ShortFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractShort2ShortFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short get(short k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short getOrDefault(short k, short defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
        public boolean containsKey(short k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
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
            return Short2ShortFunctions.EMPTY_FUNCTION;
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
            return Short2ShortFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortFunctions$Singleton.class */
    public static class Singleton extends AbstractShort2ShortFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final short key;
        protected final short value;

        /* access modifiers changed from: protected */
        public Singleton(short key, short value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
        public boolean containsKey(short k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short get(short k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short getOrDefault(short k, short defaultValue) {
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

    public static Short2ShortFunction singleton(short key, short value) {
        return new Singleton(key, value);
    }

    public static Short2ShortFunction singleton(Short key, Short value) {
        return new Singleton(key.shortValue(), value.shortValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Short2ShortFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ShortFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Short2ShortFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Short2ShortFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, java.util.function.IntUnaryOperator
        @Deprecated
        public int applyAsInt(int operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Deprecated
        public Short apply(Short key) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short defaultReturnValue() {
            short defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public void defaultReturnValue(short defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
        public boolean containsKey(short k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short put(short k, short v) {
            short put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short get(short k) {
            short s;
            synchronized (this.sync) {
                s = this.function.get(k);
            }
            return s;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short getOrDefault(short k, short defaultValue) {
            short orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short remove(short k) {
            short remove;
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        @Deprecated
        public Short put(Short k, Short v) {
            Short put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Short get(Object k) {
            Short sh;
            synchronized (this.sync) {
                sh = this.function.get(k);
            }
            return sh;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        @Deprecated
        public Short getOrDefault(Object k, Short defaultValue) {
            Short orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Short2ShortFunction synchronize(Short2ShortFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Short2ShortFunction synchronize(Short2ShortFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractShort2ShortFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2ShortFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Short2ShortFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public void defaultReturnValue(short defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
        public boolean containsKey(short k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short put(short k, short v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short get(short k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short getOrDefault(short k, short defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short remove(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        @Deprecated
        public Short put(Short k, Short v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Short get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        @Deprecated
        public Short getOrDefault(Object k, Short defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Short2ShortFunction unmodifiable(Short2ShortFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Short2ShortFunction {
        protected final java.util.function.Function<? super Short, ? extends Short> function;

        protected PrimitiveFunction(java.util.function.Function<? super Short, ? extends Short> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
        public boolean containsKey(short key) {
            return this.function.apply(Short.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Short) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short get(short key) {
            Short v = (Short) this.function.apply(Short.valueOf(key));
            return v == null ? defaultReturnValue() : v.shortValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        public short getOrDefault(short key, short defaultValue) {
            Short v = (Short) this.function.apply(Short.valueOf(key));
            return v == null ? defaultValue : v.shortValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Short get(Object key) {
            if (key == null) {
                return null;
            }
            return (Short) this.function.apply((Short) key);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        @Deprecated
        public Short getOrDefault(Object key, Short defaultValue) {
            Short v;
            if (!(key == null || (v = (Short) this.function.apply((Short) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction
        @Deprecated
        public Short put(Short key, Short value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Short2ShortFunction primitive(java.util.function.Function<? super Short, ? extends Short> f) {
        Objects.requireNonNull(f);
        return f instanceof Short2ShortFunction ? (Short2ShortFunction) f : f instanceof IntUnaryOperator ? key -> {
            return SafeMath.safeIntToShort(((IntUnaryOperator) f).applyAsInt(key));
        } : new PrimitiveFunction(f);
    }
}
