package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/base/Suppliers.class */
public final class Suppliers {

    /* loaded from: grasscutter.jar:com/google/common/base/Suppliers$SupplierFunction.class */
    private interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    private Suppliers() {
    }

    public static <F, T> Supplier<T> compose(Function<? super F, T> function, Supplier<F> supplier) {
        return new SupplierComposition(function, supplier);
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Suppliers$SupplierComposition.class */
    private static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        final Function<? super F, T> function;
        final Supplier<F> supplier;
        private static final long serialVersionUID = 0;

        SupplierComposition(Function<? super F, T> function, Supplier<F> supplier) {
            this.function = (Function) Preconditions.checkNotNull(function);
            this.supplier = (Supplier) Preconditions.checkNotNull(supplier);
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: F, ? super F */
        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public T get() {
            return this.function.apply((F) this.supplier.get());
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof SupplierComposition)) {
                return false;
            }
            SupplierComposition<?, ?> that = (SupplierComposition) obj;
            return this.function.equals(that.function) && this.supplier.equals(that.supplier);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Objects.hashCode(this.function, this.supplier);
        }

        @Override // java.lang.Object
        public String toString() {
            return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
        }
    }

    public static <T> Supplier<T> memoize(Supplier<T> delegate) {
        if ((delegate instanceof NonSerializableMemoizingSupplier) || (delegate instanceof MemoizingSupplier)) {
            return delegate;
        }
        return delegate instanceof Serializable ? new MemoizingSupplier(delegate) : new NonSerializableMemoizingSupplier(delegate);
    }

    @VisibleForTesting
    /* loaded from: grasscutter.jar:com/google/common/base/Suppliers$MemoizingSupplier.class */
    static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        final Supplier<T> delegate;
        volatile transient boolean initialized;
        transient T value;
        private static final long serialVersionUID = 0;

        MemoizingSupplier(Supplier<T> delegate) {
            this.delegate = (Supplier) Preconditions.checkNotNull(delegate);
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t = this.delegate.get();
                        this.value = t;
                        this.initialized = true;
                        return t;
                    }
                }
            }
            return this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            return "Suppliers.memoize(" + (this.initialized ? "<supplier that returned " + this.value + ">" : this.delegate) + ")";
        }
    }

    @VisibleForTesting
    /* loaded from: grasscutter.jar:com/google/common/base/Suppliers$NonSerializableMemoizingSupplier.class */
    static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {
        volatile Supplier<T> delegate;
        volatile boolean initialized;
        T value;

        NonSerializableMemoizingSupplier(Supplier<T> delegate) {
            this.delegate = (Supplier) Preconditions.checkNotNull(delegate);
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t = this.delegate.get();
                        this.value = t;
                        this.initialized = true;
                        this.delegate = null;
                        return t;
                    }
                }
            }
            return this.value;
        }

        @Override // java.lang.Object
        public String toString() {
            Supplier<T> delegate = this.delegate;
            return "Suppliers.memoize(" + (delegate == null ? "<supplier that returned " + this.value + ">" : delegate) + ")";
        }
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> delegate, long duration, TimeUnit unit) {
        return new ExpiringMemoizingSupplier(delegate, duration, unit);
    }

    @VisibleForTesting
    /* loaded from: grasscutter.jar:com/google/common/base/Suppliers$ExpiringMemoizingSupplier.class */
    static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        final Supplier<T> delegate;
        final long durationNanos;
        volatile transient T value;
        volatile transient long expirationNanos;
        private static final long serialVersionUID = 0;

        ExpiringMemoizingSupplier(Supplier<T> delegate, long duration, TimeUnit unit) {
            this.delegate = (Supplier) Preconditions.checkNotNull(delegate);
            this.durationNanos = unit.toNanos(duration);
            Preconditions.checkArgument(duration > 0, "duration (%s %s) must be > 0", duration, unit);
        }

        /* JADX WARN: Type inference failed for: r0v18, types: [long] */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T get() {
            /*
                r6 = this;
                r0 = r6
                long r0 = r0.expirationNanos
                r7 = r0
                long r0 = com.google.common.base.Platform.systemNanoTime()
                r9 = r0
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0017
                r0 = r9
                r1 = r7
                long r0 = r0 - r1
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 < 0) goto L_0x0060
            L_0x0017:
                r0 = r6
                r1 = r0
                r11 = r1
                monitor-enter(r0)
                r0 = r7
                r1 = r6
                long r1 = r1.expirationNanos     // Catch: all -> 0x0058
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0052
                r0 = r6
                com.google.common.base.Supplier<T> r0 = r0.delegate     // Catch: all -> 0x0058
                java.lang.Object r0 = r0.get()     // Catch: all -> 0x0058
                r12 = r0
                r0 = r6
                r1 = r12
                r0.value = r1     // Catch: all -> 0x0058
                r0 = r9
                r1 = r6
                long r1 = r1.durationNanos     // Catch: all -> 0x0058
                long r0 = r0 + r1
                r7 = r0
                r0 = r6
                r1 = r7
                r2 = 0
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 != 0) goto L_0x0048
                r1 = 1
                goto L_0x0049
            L_0x0048:
                r1 = r7
            L_0x0049:
                r0.expirationNanos = r1     // Catch: all -> 0x0058
                r0 = r12
                r1 = r11
                monitor-exit(r1)     // Catch: all -> 0x0058
                return r0
            L_0x0052:
                r0 = r11
                monitor-exit(r0)     // Catch: all -> 0x0058
                goto L_0x0060
            L_0x0058:
                r13 = move-exception
                r0 = r11
                monitor-exit(r0)     // Catch: all -> 0x0058
                r0 = r13
                throw r0
            L_0x0060:
                r0 = r6
                T r0 = r0.value
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Suppliers.ExpiringMemoizingSupplier.get():java.lang.Object");
        }

        @Override // java.lang.Object
        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
        }
    }

    public static <T> Supplier<T> ofInstance(T instance) {
        return new SupplierOfInstance(instance);
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Suppliers$SupplierOfInstance.class */
    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        final T instance;
        private static final long serialVersionUID = 0;

        SupplierOfInstance(T instance) {
            this.instance = instance;
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public T get() {
            return this.instance;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return Objects.equal(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Objects.hashCode(this.instance);
        }

        @Override // java.lang.Object
        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> delegate) {
        return new ThreadSafeSupplier(delegate);
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Suppliers$ThreadSafeSupplier.class */
    private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        final Supplier<T> delegate;
        private static final long serialVersionUID = 0;

        ThreadSafeSupplier(Supplier<T> delegate) {
            this.delegate = (Supplier) Preconditions.checkNotNull(delegate);
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public T get() {
            T t;
            synchronized (this.delegate) {
                t = this.delegate.get();
            }
            return t;
        }

        @Override // java.lang.Object
        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
        }
    }

    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return SupplierFunctionImpl.INSTANCE;
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Suppliers$SupplierFunctionImpl.class */
    private enum SupplierFunctionImpl implements SupplierFunction<Object> {
        INSTANCE;

        public Object apply(Supplier<Object> input) {
            return input.get();
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }
}
