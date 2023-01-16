package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.LongToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.longs.Long2CharFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharFunctions.class */
public final class Long2CharFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Long2CharFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractLong2CharFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char get(long k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char getOrDefault(long k, char defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharMap
        public boolean containsKey(long k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public void defaultReturnValue(char defRetValue) {
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
            return Long2CharFunctions.EMPTY_FUNCTION;
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
            return Long2CharFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharFunctions$Singleton.class */
    public static class Singleton extends AbstractLong2CharFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final long key;
        protected final char value;

        /* access modifiers changed from: protected */
        public Singleton(long key, char value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharMap
        public boolean containsKey(long k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char get(long k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char getOrDefault(long k, char defaultValue) {
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

    public static Long2CharFunction singleton(long key, char value) {
        return new Singleton(key, value);
    }

    public static Long2CharFunction singleton(Long key, Character value) {
        return new Singleton(key.longValue(), value.charValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Long2CharFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2CharFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Long2CharFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Long2CharFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, java.util.function.LongToIntFunction
        public int applyAsInt(long operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Deprecated
        public Character apply(Long key) {
            Character apply;
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

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char defaultReturnValue() {
            char defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public void defaultReturnValue(char defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharMap
        public boolean containsKey(long k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char put(long k, char v) {
            char put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char get(long k) {
            char c;
            synchronized (this.sync) {
                c = this.function.get(k);
            }
            return c;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char getOrDefault(long k, char defaultValue) {
            char orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char remove(long k) {
            char remove;
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

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        @Deprecated
        public Character put(Long k, Character v) {
            Character put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Character get(Object k) {
            Character ch;
            synchronized (this.sync) {
                ch = this.function.get(k);
            }
            return ch;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        @Deprecated
        public Character getOrDefault(Object k, Character defaultValue) {
            Character orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Character remove(Object k) {
            Character remove;
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

    public static Long2CharFunction synchronize(Long2CharFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Long2CharFunction synchronize(Long2CharFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractLong2CharFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Long2CharFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Long2CharFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.AbstractLong2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public void defaultReturnValue(char defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharMap
        public boolean containsKey(long k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char put(long k, char v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char get(long k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char getOrDefault(long k, char defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char remove(long k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        @Deprecated
        public Character put(Long k, Character v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Character get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        @Deprecated
        public Character getOrDefault(Object k, Character defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Character remove(Object k) {
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

    public static Long2CharFunction unmodifiable(Long2CharFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.longs.Long2CharFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2CharFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Long2CharFunction {
        protected final java.util.function.Function<? super Long, ? extends Character> function;

        protected PrimitiveFunction(java.util.function.Function<? super Long, ? extends Character> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.longs.Long2CharMap
        public boolean containsKey(long key) {
            return this.function.apply(Long.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Long) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char get(long key) {
            Character v = (Character) this.function.apply(Long.valueOf(key));
            return v == null ? defaultReturnValue() : v.charValue();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        public char getOrDefault(long key, char defaultValue) {
            Character v = (Character) this.function.apply(Long.valueOf(key));
            return v == null ? defaultValue : v.charValue();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Character get(Object key) {
            if (key == null) {
                return null;
            }
            return (Character) this.function.apply((Long) key);
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            Character v;
            if (!(key == null || (v = (Character) this.function.apply((Long) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.Long2CharFunction
        @Deprecated
        public Character put(Long key, Character value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Long2CharFunction primitive(java.util.function.Function<? super Long, ? extends Character> f) {
        Objects.requireNonNull(f);
        return f instanceof Long2CharFunction ? (Long2CharFunction) f : f instanceof LongToIntFunction ? key -> {
            return SafeMath.safeIntToChar(((LongToIntFunction) f).applyAsInt(key));
        } : new PrimitiveFunction(f);
    }
}
