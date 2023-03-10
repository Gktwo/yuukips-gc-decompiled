package com.google.common.hash;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/common/hash/LongAddables.class */
public final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER;

    LongAddables() {
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.hash.LongAddables.1
                @Override // com.google.common.base.Supplier, java.util.function.Supplier
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable th) {
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.hash.LongAddables.2
                @Override // com.google.common.base.Supplier, java.util.function.Supplier
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        SUPPLIER = supplier;
    }

    public static LongAddable create() {
        return SUPPLIER.get();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/hash/LongAddables$PureJavaLongAddable.class */
    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.hash.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.hash.LongAddable
        public void add(long x) {
            getAndAdd(x);
        }

        @Override // com.google.common.hash.LongAddable
        public long sum() {
            return get();
        }
    }
}
