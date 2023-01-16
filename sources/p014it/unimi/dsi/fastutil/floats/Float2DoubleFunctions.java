package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.DoubleUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleFunctions.class */
public final class Float2DoubleFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Float2DoubleFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractFloat2DoubleFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double get(float k) {
            return 0.0d;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double getOrDefault(float k, double defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean containsKey(float k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double defaultReturnValue() {
            return 0.0d;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public void defaultReturnValue(double defRetValue) {
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
            return Float2DoubleFunctions.EMPTY_FUNCTION;
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
            return Float2DoubleFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleFunctions$Singleton.class */
    public static class Singleton extends AbstractFloat2DoubleFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final float key;
        protected final double value;

        /* access modifiers changed from: protected */
        public Singleton(float key, double value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean containsKey(float k) {
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double get(float k) {
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(k) ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double getOrDefault(float k, double defaultValue) {
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

    public static Float2DoubleFunction singleton(float key, double value) {
        return new Singleton(key, value);
    }

    public static Float2DoubleFunction singleton(Float key, Double value) {
        return new Singleton(key.floatValue(), value.doubleValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Float2DoubleFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2DoubleFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Float2DoubleFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Float2DoubleFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, java.util.function.DoubleUnaryOperator
        @Deprecated
        public double applyAsDouble(double operand) {
            double applyAsDouble;
            synchronized (this.sync) {
                applyAsDouble = this.function.applyAsDouble(operand);
            }
            return applyAsDouble;
        }

        @Deprecated
        public Double apply(Float key) {
            Double apply;
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double defaultReturnValue() {
            double defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public void defaultReturnValue(double defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean containsKey(float k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double put(float k, double v) {
            double put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double get(float k) {
            double d;
            synchronized (this.sync) {
                d = this.function.get(k);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double getOrDefault(float k, double defaultValue) {
            double orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double remove(float k) {
            double remove;
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        @Deprecated
        public Double put(Float k, Double v) {
            Double put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double get(Object k) {
            Double d;
            synchronized (this.sync) {
                d = this.function.get(k);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object k, Double defaultValue) {
            Double orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double remove(Object k) {
            Double remove;
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

    public static Float2DoubleFunction synchronize(Float2DoubleFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Float2DoubleFunction synchronize(Float2DoubleFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractFloat2DoubleFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2DoubleFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Float2DoubleFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public void defaultReturnValue(double defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean containsKey(float k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double put(float k, double v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double get(float k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double getOrDefault(float k, double defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double remove(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        @Deprecated
        public Double put(Float k, Double v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object k, Double defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double remove(Object k) {
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

    public static Float2DoubleFunction unmodifiable(Float2DoubleFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2DoubleFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2DoubleFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Float2DoubleFunction {
        protected final java.util.function.Function<? super Float, ? extends Double> function;

        protected PrimitiveFunction(java.util.function.Function<? super Float, ? extends Double> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.floats.Float2DoubleMap
        public boolean containsKey(float key) {
            return this.function.apply(Float.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Float) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double get(float key) {
            Double v = (Double) this.function.apply(Float.valueOf(key));
            return v == null ? defaultReturnValue() : v.doubleValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        public double getOrDefault(float key, double defaultValue) {
            Double v = (Double) this.function.apply(Float.valueOf(key));
            return v == null ? defaultValue : v.doubleValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double get(Object key) {
            if (key == null) {
                return null;
            }
            return (Double) this.function.apply((Float) key);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object key, Double defaultValue) {
            Double v;
            if (!(key == null || (v = (Double) this.function.apply((Float) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction
        @Deprecated
        public Double put(Float key, Double value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Float2DoubleFunction primitive(java.util.function.Function<? super Float, ? extends Double> f) {
        Objects.requireNonNull(f);
        if (f instanceof Float2DoubleFunction) {
            return (Float2DoubleFunction) f;
        }
        if (!(f instanceof DoubleUnaryOperator)) {
            return new PrimitiveFunction(f);
        }
        DoubleUnaryOperator doubleUnaryOperator = (DoubleUnaryOperator) f;
        Objects.requireNonNull(doubleUnaryOperator);
        return (v1) -> {
            return r0.applyAsDouble(v1);
        };
    }
}
