package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.DoubleToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteFunctions.class */
public final class Float2ByteFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Float2ByteFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractFloat2ByteFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte get(float k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte getOrDefault(float k, byte defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean containsKey(float k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ByteFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ByteFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
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
            return Float2ByteFunctions.EMPTY_FUNCTION;
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
            return Float2ByteFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteFunctions$Singleton.class */
    public static class Singleton extends AbstractFloat2ByteFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final float key;
        protected final byte value;

        /* access modifiers changed from: protected */
        public Singleton(float key, byte value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean containsKey(float k) {
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte get(float k) {
            return Float.floatToIntBits(this.key) == Float.floatToIntBits(k) ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte getOrDefault(float k, byte defaultValue) {
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

    public static Float2ByteFunction singleton(float key, byte value) {
        return new Singleton(key, value);
    }

    public static Float2ByteFunction singleton(Float key, Byte value) {
        return new Singleton(key.floatValue(), value.byteValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Float2ByteFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ByteFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Float2ByteFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Float2ByteFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, java.util.function.DoubleToIntFunction
        @Deprecated
        public int applyAsInt(double operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Deprecated
        public Byte apply(Float key) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte defaultReturnValue() {
            byte defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public void defaultReturnValue(byte defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean containsKey(float k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte put(float k, byte v) {
            byte put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte get(float k) {
            byte b;
            synchronized (this.sync) {
                b = this.function.get(k);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte getOrDefault(float k, byte defaultValue) {
            byte orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte remove(float k) {
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

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        @Deprecated
        public Byte put(Float k, Byte v) {
            Byte put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte get(Object k) {
            Byte b;
            synchronized (this.sync) {
                b = this.function.get(k);
            }
            return b;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object k, Byte defaultValue) {
            Byte orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Float2ByteFunction synchronize(Float2ByteFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Float2ByteFunction synchronize(Float2ByteFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractFloat2ByteFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Float2ByteFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Float2ByteFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ByteFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloat2ByteFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public void defaultReturnValue(byte defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean containsKey(float k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte put(float k, byte v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte get(float k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte getOrDefault(float k, byte defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte remove(float k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        @Deprecated
        public Byte put(Float k, Byte v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object k, Byte defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Float2ByteFunction unmodifiable(Float2ByteFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.floats.Float2ByteFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/Float2ByteFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Float2ByteFunction {
        protected final java.util.function.Function<? super Float, ? extends Byte> function;

        protected PrimitiveFunction(java.util.function.Function<? super Float, ? extends Byte> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.floats.Float2ByteMap
        public boolean containsKey(float key) {
            return this.function.apply(Float.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Float) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte get(float key) {
            Byte v = (Byte) this.function.apply(Float.valueOf(key));
            return v == null ? defaultReturnValue() : v.byteValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        public byte getOrDefault(float key, byte defaultValue) {
            Byte v = (Byte) this.function.apply(Float.valueOf(key));
            return v == null ? defaultValue : v.byteValue();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Byte get(Object key) {
            if (key == null) {
                return null;
            }
            return (Byte) this.function.apply((Float) key);
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        @Deprecated
        public Byte getOrDefault(Object key, Byte defaultValue) {
            Byte v;
            if (!(key == null || (v = (Byte) this.function.apply((Float) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.Float2ByteFunction
        @Deprecated
        public Byte put(Float key, Byte value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Float2ByteFunction primitive(java.util.function.Function<? super Float, ? extends Byte> f) {
        Objects.requireNonNull(f);
        return f instanceof Float2ByteFunction ? (Float2ByteFunction) f : f instanceof DoubleToIntFunction ? key -> {
            return SafeMath.safeIntToByte(((DoubleToIntFunction) f).applyAsInt((double) key));
        } : new PrimitiveFunction(f);
    }
}
