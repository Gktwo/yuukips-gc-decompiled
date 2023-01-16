package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntToDoubleFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatFunctions.class */
public final class Byte2FloatFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Byte2FloatFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractByte2FloatFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float get(byte k) {
            return 0.0f;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float getOrDefault(byte k, float defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap
        public boolean containsKey(byte k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatFunction, p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float defaultReturnValue() {
            return 0.0f;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatFunction, p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public void defaultReturnValue(float defRetValue) {
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
            return Byte2FloatFunctions.EMPTY_FUNCTION;
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
            return Byte2FloatFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatFunctions$Singleton.class */
    public static class Singleton extends AbstractByte2FloatFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final byte key;
        protected final float value;

        /* access modifiers changed from: protected */
        public Singleton(byte key, float value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap
        public boolean containsKey(byte k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float get(byte k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float getOrDefault(byte k, float defaultValue) {
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

    public static Byte2FloatFunction singleton(byte key, float value) {
        return new Singleton(key, value);
    }

    public static Byte2FloatFunction singleton(Byte key, Float value) {
        return new Singleton(key.byteValue(), value.floatValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Byte2FloatFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2FloatFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Byte2FloatFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Byte2FloatFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, java.util.function.IntToDoubleFunction
        @Deprecated
        public double applyAsDouble(int operand) {
            double applyAsDouble;
            synchronized (this.sync) {
                applyAsDouble = this.function.applyAsDouble(operand);
            }
            return applyAsDouble;
        }

        @Deprecated
        public Float apply(Byte key) {
            Float apply;
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float defaultReturnValue() {
            float defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public void defaultReturnValue(float defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap
        public boolean containsKey(byte k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float put(byte k, float v) {
            float put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float get(byte k) {
            float f;
            synchronized (this.sync) {
                f = this.function.get(k);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float getOrDefault(byte k, float defaultValue) {
            float orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float remove(byte k) {
            float remove;
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        @Deprecated
        public Float put(Byte k, Float v) {
            Float put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Float get(Object k) {
            Float f;
            synchronized (this.sync) {
                f = this.function.get(k);
            }
            return f;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        @Deprecated
        public Float getOrDefault(Object k, Float defaultValue) {
            Float orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Float remove(Object k) {
            Float remove;
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

    public static Byte2FloatFunction synchronize(Byte2FloatFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Byte2FloatFunction synchronize(Byte2FloatFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractByte2FloatFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2FloatFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Byte2FloatFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatFunction, p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2FloatFunction, p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public void defaultReturnValue(float defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap
        public boolean containsKey(byte k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float put(byte k, float v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float get(byte k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float getOrDefault(byte k, float defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float remove(byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        @Deprecated
        public Float put(Byte k, Float v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Float get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        @Deprecated
        public Float getOrDefault(Object k, Float defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Float remove(Object k) {
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

    public static Byte2FloatFunction unmodifiable(Byte2FloatFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2FloatFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2FloatFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Byte2FloatFunction {
        protected final java.util.function.Function<? super Byte, ? extends Float> function;

        protected PrimitiveFunction(java.util.function.Function<? super Byte, ? extends Float> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.bytes.Byte2FloatMap
        public boolean containsKey(byte key) {
            return this.function.apply(Byte.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Byte) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float get(byte key) {
            Float v = (Float) this.function.apply(Byte.valueOf(key));
            return v == null ? defaultReturnValue() : v.floatValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        public float getOrDefault(byte key, float defaultValue) {
            Float v = (Float) this.function.apply(Byte.valueOf(key));
            return v == null ? defaultValue : v.floatValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Float get(Object key) {
            if (key == null) {
                return null;
            }
            return (Float) this.function.apply((Byte) key);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        @Deprecated
        public Float getOrDefault(Object key, Float defaultValue) {
            Float v;
            if (!(key == null || (v = (Float) this.function.apply((Byte) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction
        @Deprecated
        public Float put(Byte key, Float value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Byte2FloatFunction primitive(java.util.function.Function<? super Byte, ? extends Float> f) {
        Objects.requireNonNull(f);
        return f instanceof Byte2FloatFunction ? (Byte2FloatFunction) f : f instanceof IntToDoubleFunction ? key -> {
            return SafeMath.safeDoubleToFloat(((IntToDoubleFunction) f).applyAsDouble(key));
        } : new PrimitiveFunction(f);
    }
}
