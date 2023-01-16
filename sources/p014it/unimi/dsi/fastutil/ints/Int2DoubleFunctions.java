package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntToDoubleFunction;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleFunctions.class */
public final class Int2DoubleFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Int2DoubleFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractInt2DoubleFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double get(int k) {
            return 0.0d;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double getOrDefault(int k, double defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
        public boolean containsKey(int k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double defaultReturnValue() {
            return 0.0d;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
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
            return Int2DoubleFunctions.EMPTY_FUNCTION;
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
            return Int2DoubleFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleFunctions$Singleton.class */
    public static class Singleton extends AbstractInt2DoubleFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final int key;
        protected final double value;

        /* access modifiers changed from: protected */
        public Singleton(int key, double value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
        public boolean containsKey(int k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double get(int k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double getOrDefault(int k, double defaultValue) {
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

    public static Int2DoubleFunction singleton(int key, double value) {
        return new Singleton(key, value);
    }

    public static Int2DoubleFunction singleton(Integer key, Double value) {
        return new Singleton(key.intValue(), value.doubleValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Int2DoubleFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2DoubleFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Int2DoubleFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Int2DoubleFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, java.util.function.IntToDoubleFunction
        public double applyAsDouble(int operand) {
            double applyAsDouble;
            synchronized (this.sync) {
                applyAsDouble = this.function.applyAsDouble(operand);
            }
            return applyAsDouble;
        }

        @Deprecated
        public Double apply(Integer key) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double defaultReturnValue() {
            double defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public void defaultReturnValue(double defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
        public boolean containsKey(int k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double put(int k, double v) {
            double put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double get(int k) {
            double d;
            synchronized (this.sync) {
                d = this.function.get(k);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double getOrDefault(int k, double defaultValue) {
            double orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double remove(int k) {
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

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        @Deprecated
        public Double put(Integer k, Double v) {
            Double put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double get(Object k) {
            Double d;
            synchronized (this.sync) {
                d = this.function.get(k);
            }
            return d;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object k, Double defaultValue) {
            Double orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Int2DoubleFunction synchronize(Int2DoubleFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Int2DoubleFunction synchronize(Int2DoubleFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractInt2DoubleFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2DoubleFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Int2DoubleFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public void defaultReturnValue(double defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
        public boolean containsKey(int k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double put(int k, double v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double get(int k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double getOrDefault(int k, double defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        @Deprecated
        public Double put(Integer k, Double v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object k, Double defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Int2DoubleFunction unmodifiable(Int2DoubleFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2DoubleFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2DoubleFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Int2DoubleFunction {
        protected final java.util.function.Function<? super Integer, ? extends Double> function;

        protected PrimitiveFunction(java.util.function.Function<? super Integer, ? extends Double> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.ints.Int2DoubleMap
        public boolean containsKey(int key) {
            return this.function.apply(Integer.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Integer) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double get(int key) {
            Double v = (Double) this.function.apply(Integer.valueOf(key));
            return v == null ? defaultReturnValue() : v.doubleValue();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        public double getOrDefault(int key, double defaultValue) {
            Double v = (Double) this.function.apply(Integer.valueOf(key));
            return v == null ? defaultValue : v.doubleValue();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Double get(Object key) {
            if (key == null) {
                return null;
            }
            return (Double) this.function.apply((Integer) key);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        @Deprecated
        public Double getOrDefault(Object key, Double defaultValue) {
            Double v;
            if (!(key == null || (v = (Double) this.function.apply((Integer) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction
        @Deprecated
        public Double put(Integer key, Double value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Int2DoubleFunction primitive(java.util.function.Function<? super Integer, ? extends Double> f) {
        Objects.requireNonNull(f);
        if (f instanceof Int2DoubleFunction) {
            return (Int2DoubleFunction) f;
        }
        if (!(f instanceof IntToDoubleFunction)) {
            return new PrimitiveFunction(f);
        }
        IntToDoubleFunction intToDoubleFunction = (IntToDoubleFunction) f;
        Objects.requireNonNull(intToDoubleFunction);
        return this::applyAsDouble;
    }
}
