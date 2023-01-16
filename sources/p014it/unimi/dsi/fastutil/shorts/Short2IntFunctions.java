package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntFunctions.class */
public final class Short2IntFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Short2IntFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractShort2IntFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int get(short k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int getOrDefault(short k, int defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntMap
        public boolean containsKey(short k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
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
            return Short2IntFunctions.EMPTY_FUNCTION;
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
            return Short2IntFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntFunctions$Singleton.class */
    public static class Singleton extends AbstractShort2IntFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final short key;
        protected final int value;

        /* access modifiers changed from: protected */
        public Singleton(short key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntMap
        public boolean containsKey(short k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int get(short k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int getOrDefault(short k, int defaultValue) {
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

    public static Short2IntFunction singleton(short key, int value) {
        return new Singleton(key, value);
    }

    public static Short2IntFunction singleton(Short key, Integer value) {
        return new Singleton(key.shortValue(), value.intValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Short2IntFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2IntFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Short2IntFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Short2IntFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, java.util.function.IntUnaryOperator
        @Deprecated
        public int applyAsInt(int operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Deprecated
        public Integer apply(Short key) {
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int defaultReturnValue() {
            int defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public void defaultReturnValue(int defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntMap
        public boolean containsKey(short k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int put(short k, int v) {
            int put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int get(short k) {
            int i;
            synchronized (this.sync) {
                i = this.function.get(k);
            }
            return i;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int getOrDefault(short k, int defaultValue) {
            int orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int remove(short k) {
            int remove;
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

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        @Deprecated
        public Integer put(Short k, Integer v) {
            Integer put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object k) {
            Integer num;
            synchronized (this.sync) {
                num = this.function.get(k);
            }
            return num;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        @Deprecated
        public Integer getOrDefault(Object k, Integer defaultValue) {
            Integer orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Short2IntFunction synchronize(Short2IntFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Short2IntFunction synchronize(Short2IntFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractShort2IntFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Short2IntFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Short2IntFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShort2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public void defaultReturnValue(int defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntMap
        public boolean containsKey(short k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int put(short k, int v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int get(short k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int getOrDefault(short k, int defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int remove(short k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        @Deprecated
        public Integer put(Short k, Integer v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        @Deprecated
        public Integer getOrDefault(Object k, Integer defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Short2IntFunction unmodifiable(Short2IntFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2IntFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2IntFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Short2IntFunction {
        protected final java.util.function.Function<? super Short, ? extends Integer> function;

        protected PrimitiveFunction(java.util.function.Function<? super Short, ? extends Integer> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.shorts.Short2IntMap
        public boolean containsKey(short key) {
            return this.function.apply(Short.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Short) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int get(short key) {
            Integer v = (Integer) this.function.apply(Short.valueOf(key));
            return v == null ? defaultReturnValue() : v.intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        public int getOrDefault(short key, int defaultValue) {
            Integer v = (Integer) this.function.apply(Short.valueOf(key));
            return v == null ? defaultValue : v.intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object key) {
            if (key == null) {
                return null;
            }
            return (Integer) this.function.apply((Short) key);
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        @Deprecated
        public Integer getOrDefault(Object key, Integer defaultValue) {
            Integer v;
            if (!(key == null || (v = (Integer) this.function.apply((Short) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.Short2IntFunction
        @Deprecated
        public Integer put(Short key, Integer value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Short2IntFunction primitive(java.util.function.Function<? super Short, ? extends Integer> f) {
        Objects.requireNonNull(f);
        if (f instanceof Short2IntFunction) {
            return (Short2IntFunction) f;
        }
        if (!(f instanceof IntUnaryOperator)) {
            return new PrimitiveFunction(f);
        }
        IntUnaryOperator intUnaryOperator = (IntUnaryOperator) f;
        Objects.requireNonNull(intUnaryOperator);
        return (v1) -> {
            return r0.applyAsInt(v1);
        };
    }
}
