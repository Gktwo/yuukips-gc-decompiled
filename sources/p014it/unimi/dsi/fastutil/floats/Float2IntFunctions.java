package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.DoubleToIntFunction;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2IntFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntFunctions.class */
public final class Float2IntFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Float2IntFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2IntFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractFloat2IntFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int get(float k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int getOrDefault(float k, int defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.floats.Float2IntMap
        public boolean containsKey(float k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2IntFunction, p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2IntFunction, p014it.unimi.dsi.fastutil.floats.Float2IntFunction
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
            return Float2IntFunctions.EMPTY_FUNCTION;
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
            return Float2IntFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2IntFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntFunctions$Singleton.class */
    public static class Singleton extends AbstractFloat2IntFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final float key;
        protected final int value;

        /* access modifiers changed from: protected */
        public Singleton(float key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.floats.Float2IntMap
        public boolean containsKey(float k) {
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int get(float k) {
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(k) ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int getOrDefault(float k, int defaultValue) {
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(k) ? this.value : defaultValue;
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

    public static Float2IntFunction singleton(float key, int value) {
        return new Singleton(key, value);
    }

    public static Float2IntFunction singleton(Float key, Integer value) {
        return new Singleton(key.floatValue(), value.intValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2IntFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Float2IntFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2IntFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Float2IntFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Float2IntFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, java.util.function.DoubleToIntFunction
        @Deprecated
        public int applyAsInt(double operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Deprecated
        public Integer apply(Float key) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int defaultReturnValue() {
            int defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public void defaultReturnValue(int defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.floats.Float2IntMap
        public boolean containsKey(float k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int put(float k, int v) {
            int put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int get(float k) {
            int i;
            synchronized (this.sync) {
                i = this.function.get(k);
            }
            return i;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int getOrDefault(float k, int defaultValue) {
            int orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int remove(float k) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        @Deprecated
        public Integer put(Float k, Integer v) {
            Integer put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object k) {
            Integer num;
            synchronized (this.sync) {
                num = this.function.get(k);
            }
            return num;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        @Deprecated
        public Integer getOrDefault(Object k, Integer defaultValue) {
            Integer orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Float2IntFunction synchronize(Float2IntFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Float2IntFunction synchronize(Float2IntFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2IntFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractFloat2IntFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2IntFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Float2IntFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2IntFunction, p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2IntFunction, p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public void defaultReturnValue(int defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.floats.Float2IntMap
        public boolean containsKey(float k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int put(float k, int v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int get(float k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int getOrDefault(float k, int defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int remove(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        @Deprecated
        public Integer put(Float k, Integer v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        @Deprecated
        public Integer getOrDefault(Object k, Integer defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Float2IntFunction unmodifiable(Float2IntFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2IntFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2IntFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Float2IntFunction {
        protected final java.util.function.Function<? super Float, ? extends Integer> function;

        protected PrimitiveFunction(java.util.function.Function<? super Float, ? extends Integer> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.floats.Float2IntMap
        public boolean containsKey(float key) {
            return this.function.apply(Float.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Float) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int get(float key) {
            Integer v = (Integer) this.function.apply(Float.valueOf(key));
            return v == null ? defaultReturnValue() : v.intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        public int getOrDefault(float key, int defaultValue) {
            Integer v = (Integer) this.function.apply(Float.valueOf(key));
            return v == null ? defaultValue : v.intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object key) {
            if (key == null) {
                return null;
            }
            return (Integer) this.function.apply((Float) key);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        @Deprecated
        public Integer getOrDefault(Object key, Integer defaultValue) {
            Integer v;
            if (!(key == null || (v = (Integer) this.function.apply((Float) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2IntFunction
        @Deprecated
        public Integer put(Float key, Integer value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Float2IntFunction primitive(java.util.function.Function<? super Float, ? extends Integer> f) {
        Objects.requireNonNull(f);
        if (f instanceof Float2IntFunction) {
            return (Float2IntFunction) f;
        }
        if (!(f instanceof DoubleToIntFunction)) {
            return new PrimitiveFunction(f);
        }
        DoubleToIntFunction doubleToIntFunction = (DoubleToIntFunction) f;
        Objects.requireNonNull(doubleToIntFunction);
        return (v1) -> {
            return r0.applyAsInt(v1);
        };
    }
}
