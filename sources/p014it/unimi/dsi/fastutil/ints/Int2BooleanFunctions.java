package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntPredicate;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanFunctions.class */
public final class Int2BooleanFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Int2BooleanFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractInt2BooleanFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean get(int k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean getOrDefault(int k, boolean defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap
        public boolean containsKey(int k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2BooleanFunction, p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean defaultReturnValue() {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2BooleanFunction, p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public void defaultReturnValue(boolean defRetValue) {
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
            return Int2BooleanFunctions.EMPTY_FUNCTION;
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
            return Int2BooleanFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanFunctions$Singleton.class */
    public static class Singleton extends AbstractInt2BooleanFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final int key;
        protected final boolean value;

        /* access modifiers changed from: protected */
        public Singleton(int key, boolean value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap
        public boolean containsKey(int k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean get(int k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean getOrDefault(int k, boolean defaultValue) {
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

    public static Int2BooleanFunction singleton(int key, boolean value) {
        return new Singleton(key, value);
    }

    public static Int2BooleanFunction singleton(Integer key, Boolean value) {
        return new Singleton(key.intValue(), value.booleanValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Int2BooleanFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2BooleanFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Int2BooleanFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Int2BooleanFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, java.util.function.IntPredicate
        public boolean test(int operand) {
            boolean test;
            synchronized (this.sync) {
                test = this.function.test(operand);
            }
            return test;
        }

        @Deprecated
        public Boolean apply(Integer key) {
            Boolean apply;
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

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean defaultReturnValue() {
            boolean defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public void defaultReturnValue(boolean defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap
        public boolean containsKey(int k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean put(int k, boolean v) {
            boolean put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean get(int k) {
            boolean z;
            synchronized (this.sync) {
                z = this.function.get(k);
            }
            return z;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean getOrDefault(int k, boolean defaultValue) {
            boolean orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean remove(int k) {
            boolean remove;
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

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        @Deprecated
        public Boolean put(Integer k, Boolean v) {
            Boolean put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Boolean get(Object k) {
            Boolean bool;
            synchronized (this.sync) {
                bool = this.function.get(k);
            }
            return bool;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object k, Boolean defaultValue) {
            Boolean orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Boolean remove(Object k) {
            Boolean remove;
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

    public static Int2BooleanFunction synchronize(Int2BooleanFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Int2BooleanFunction synchronize(Int2BooleanFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractInt2BooleanFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Int2BooleanFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Int2BooleanFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2BooleanFunction, p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.AbstractInt2BooleanFunction, p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public void defaultReturnValue(boolean defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap
        public boolean containsKey(int k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean put(int k, boolean v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean get(int k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean getOrDefault(int k, boolean defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean remove(int k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        @Deprecated
        public Boolean put(Integer k, Boolean v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Boolean get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object k, Boolean defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Boolean remove(Object k) {
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

    public static Int2BooleanFunction unmodifiable(Int2BooleanFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Int2BooleanFunction {
        protected final java.util.function.Function<? super Integer, ? extends Boolean> function;

        protected PrimitiveFunction(java.util.function.Function<? super Integer, ? extends Boolean> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.ints.Int2BooleanMap
        public boolean containsKey(int key) {
            return this.function.apply(Integer.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Integer) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean get(int key) {
            Boolean v = (Boolean) this.function.apply(Integer.valueOf(key));
            return v == null ? defaultReturnValue() : v.booleanValue();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        public boolean getOrDefault(int key, boolean defaultValue) {
            Boolean v = (Boolean) this.function.apply(Integer.valueOf(key));
            return v == null ? defaultValue : v.booleanValue();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Boolean get(Object key) {
            if (key == null) {
                return null;
            }
            return (Boolean) this.function.apply((Integer) key);
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        @Deprecated
        public Boolean getOrDefault(Object key, Boolean defaultValue) {
            Boolean v;
            if (!(key == null || (v = (Boolean) this.function.apply((Integer) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
        @Deprecated
        public Boolean put(Integer key, Boolean value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Int2BooleanFunction primitive(java.util.function.Function<? super Integer, ? extends Boolean> f) {
        Objects.requireNonNull(f);
        if (f instanceof Int2BooleanFunction) {
            return (Int2BooleanFunction) f;
        }
        if (!(f instanceof IntPredicate)) {
            return new PrimitiveFunction(f);
        }
        IntPredicate intPredicate = (IntPredicate) f;
        Objects.requireNonNull(intPredicate);
        return this::test;
    }
}
