package p014it.unimi.dsi.fastutil.chars;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2IntFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntFunctions.class */
public final class Char2IntFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Char2IntFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractChar2IntFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int get(char k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int getOrDefault(char k, int defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntMap
        public boolean containsKey(char k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntFunction
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
            return Char2IntFunctions.EMPTY_FUNCTION;
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
            return Char2IntFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntFunctions$Singleton.class */
    public static class Singleton extends AbstractChar2IntFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final char key;
        protected final int value;

        /* access modifiers changed from: protected */
        public Singleton(char key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntMap
        public boolean containsKey(char k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int get(char k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int getOrDefault(char k, int defaultValue) {
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

    public static Char2IntFunction singleton(char key, int value) {
        return new Singleton(key, value);
    }

    public static Char2IntFunction singleton(Character key, Integer value) {
        return new Singleton(key.charValue(), value.intValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Char2IntFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2IntFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Char2IntFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Char2IntFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, java.util.function.IntUnaryOperator
        @Deprecated
        public int applyAsInt(int operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Deprecated
        public Integer apply(Character key) {
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

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int defaultReturnValue() {
            int defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public void defaultReturnValue(int defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntMap
        public boolean containsKey(char k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int put(char k, int v) {
            int put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int get(char k) {
            int i;
            synchronized (this.sync) {
                i = this.function.get(k);
            }
            return i;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int getOrDefault(char k, int defaultValue) {
            int orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int remove(char k) {
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

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        @Deprecated
        public Integer put(Character k, Integer v) {
            Integer put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object k) {
            Integer num;
            synchronized (this.sync) {
                num = this.function.get(k);
            }
            return num;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        @Deprecated
        public Integer getOrDefault(Object k, Integer defaultValue) {
            Integer orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Char2IntFunction synchronize(Char2IntFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Char2IntFunction synchronize(Char2IntFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractChar2IntFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Char2IntFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Char2IntFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.AbstractChar2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public void defaultReturnValue(int defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntMap
        public boolean containsKey(char k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int put(char k, int v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int get(char k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int getOrDefault(char k, int defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int remove(char k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        @Deprecated
        public Integer put(Character k, Integer v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        @Deprecated
        public Integer getOrDefault(Object k, Integer defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Char2IntFunction unmodifiable(Char2IntFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Char2IntFunction {
        protected final java.util.function.Function<? super Character, ? extends Integer> function;

        protected PrimitiveFunction(java.util.function.Function<? super Character, ? extends Integer> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.chars.Char2IntMap
        public boolean containsKey(char key) {
            return this.function.apply(Character.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Character) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int get(char key) {
            Integer v = (Integer) this.function.apply(Character.valueOf(key));
            return v == null ? defaultReturnValue() : v.intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        public int getOrDefault(char key, int defaultValue) {
            Integer v = (Integer) this.function.apply(Character.valueOf(key));
            return v == null ? defaultValue : v.intValue();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Integer get(Object key) {
            if (key == null) {
                return null;
            }
            return (Integer) this.function.apply((Character) key);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        @Deprecated
        public Integer getOrDefault(Object key, Integer defaultValue) {
            Integer v;
            if (!(key == null || (v = (Integer) this.function.apply((Character) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
        @Deprecated
        public Integer put(Character key, Integer value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Char2IntFunction primitive(java.util.function.Function<? super Character, ? extends Integer> f) {
        Objects.requireNonNull(f);
        if (f instanceof Char2IntFunction) {
            return (Char2IntFunction) f;
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
