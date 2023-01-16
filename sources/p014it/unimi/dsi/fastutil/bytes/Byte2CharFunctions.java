package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharFunctions */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharFunctions.class */
public final class Byte2CharFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Byte2CharFunctions() {
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharFunctions$EmptyFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharFunctions$EmptyFunction.class */
    public static class EmptyFunction extends AbstractByte2CharFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char get(byte k) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char getOrDefault(byte k, char defaultValue) {
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap
        public boolean containsKey(byte k) {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2CharFunction, p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char defaultReturnValue() {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2CharFunction, p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
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
            return Byte2CharFunctions.EMPTY_FUNCTION;
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
            return Byte2CharFunctions.EMPTY_FUNCTION;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharFunctions$Singleton */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharFunctions$Singleton.class */
    public static class Singleton extends AbstractByte2CharFunction implements Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final byte key;
        protected final char value;

        /* access modifiers changed from: protected */
        public Singleton(byte key, char value) {
            this.key = key;
            this.value = value;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap
        public boolean containsKey(byte k) {
            return this.key == k;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char get(byte k) {
            return this.key == k ? this.value : this.defRetValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char getOrDefault(byte k, char defaultValue) {
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

    public static Byte2CharFunction singleton(byte key, char value) {
        return new Singleton(key, value);
    }

    public static Byte2CharFunction singleton(Byte key, Character value) {
        return new Singleton(key.byteValue(), value.charValue());
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharFunctions$SynchronizedFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharFunctions$SynchronizedFunction.class */
    public static class SynchronizedFunction implements Byte2CharFunction, Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2CharFunction function;
        protected final Object sync;

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Byte2CharFunction f, Object sync) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = sync;
        }

        /* access modifiers changed from: protected */
        public SynchronizedFunction(Byte2CharFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
            this.sync = this;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, java.util.function.IntUnaryOperator
        @Deprecated
        public int applyAsInt(int operand) {
            int applyAsInt;
            synchronized (this.sync) {
                applyAsInt = this.function.applyAsInt(operand);
            }
            return applyAsInt;
        }

        @Deprecated
        public Character apply(Byte key) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char defaultReturnValue() {
            char defaultReturnValue;
            synchronized (this.sync) {
                defaultReturnValue = this.function.defaultReturnValue();
            }
            return defaultReturnValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public void defaultReturnValue(char defRetValue) {
            synchronized (this.sync) {
                this.function.defaultReturnValue(defRetValue);
            }
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap
        public boolean containsKey(byte k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object k) {
            boolean containsKey;
            synchronized (this.sync) {
                containsKey = this.function.containsKey(k);
            }
            return containsKey;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char put(byte k, char v) {
            char put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char get(byte k) {
            char c;
            synchronized (this.sync) {
                c = this.function.get(k);
            }
            return c;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char getOrDefault(byte k, char defaultValue) {
            char orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char remove(byte k) {
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

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        @Deprecated
        public Character put(Byte k, Character v) {
            Character put;
            synchronized (this.sync) {
                put = this.function.put(k, v);
            }
            return put;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Character get(Object k) {
            Character ch;
            synchronized (this.sync) {
                ch = this.function.get(k);
            }
            return ch;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        @Deprecated
        public Character getOrDefault(Object k, Character defaultValue) {
            Character orDefault;
            synchronized (this.sync) {
                orDefault = this.function.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Byte2CharFunction synchronize(Byte2CharFunction f) {
        return new SynchronizedFunction(f);
    }

    public static Byte2CharFunction synchronize(Byte2CharFunction f, Object sync) {
        return new SynchronizedFunction(f, sync);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharFunctions$UnmodifiableFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharFunctions$UnmodifiableFunction.class */
    public static class UnmodifiableFunction extends AbstractByte2CharFunction implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final Byte2CharFunction function;

        /* access modifiers changed from: protected */
        public UnmodifiableFunction(Byte2CharFunction f) {
            if (f == null) {
                throw new NullPointerException();
            }
            this.function = f;
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public int size() {
            return this.function.size();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2CharFunction, p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char defaultReturnValue() {
            return this.function.defaultReturnValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByte2CharFunction, p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public void defaultReturnValue(char defRetValue) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap
        public boolean containsKey(byte k) {
            return this.function.containsKey(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char put(byte k, char v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char get(byte k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char getOrDefault(byte k, char defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char remove(byte k) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        @Deprecated
        public Character put(Byte k, Character v) {
            throw new UnsupportedOperationException();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Character get(Object k) {
            return this.function.get(k);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        @Deprecated
        public Character getOrDefault(Object k, Character defaultValue) {
            return this.function.getOrDefault(k, defaultValue);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.Function
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

    public static Byte2CharFunction unmodifiable(Byte2CharFunction f) {
        return new UnmodifiableFunction(f);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2CharFunctions$PrimitiveFunction */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2CharFunctions$PrimitiveFunction.class */
    public static class PrimitiveFunction implements Byte2CharFunction {
        protected final java.util.function.Function<? super Byte, ? extends Character> function;

        protected PrimitiveFunction(java.util.function.Function<? super Byte, ? extends Character> function) {
            this.function = function;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.bytes.Byte2CharMap
        public boolean containsKey(byte key) {
            return this.function.apply(Byte.valueOf(key)) != null;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public boolean containsKey(Object key) {
            return (key == null || this.function.apply((Byte) key) == null) ? false : true;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char get(byte key) {
            Character v = (Character) this.function.apply(Byte.valueOf(key));
            return v == null ? defaultReturnValue() : v.charValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        public char getOrDefault(byte key, char defaultValue) {
            Character v = (Character) this.function.apply(Byte.valueOf(key));
            return v == null ? defaultValue : v.charValue();
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction, p014it.unimi.dsi.fastutil.Function
        @Deprecated
        public Character get(Object key) {
            if (key == null) {
                return null;
            }
            return (Character) this.function.apply((Byte) key);
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        @Deprecated
        public Character getOrDefault(Object key, Character defaultValue) {
            Character v;
            if (!(key == null || (v = (Character) this.function.apply((Byte) key)) == null)) {
                return v;
            }
            return defaultValue;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction
        @Deprecated
        public Character put(Byte key, Character value) {
            throw new UnsupportedOperationException();
        }
    }

    public static Byte2CharFunction primitive(java.util.function.Function<? super Byte, ? extends Character> f) {
        Objects.requireNonNull(f);
        return f instanceof Byte2CharFunction ? (Byte2CharFunction) f : f instanceof IntUnaryOperator ? key -> {
            return SafeMath.safeIntToChar(((IntUnaryOperator) f).applyAsInt(key));
        } : new PrimitiveFunction(f);
    }
}
