package com.google.common.hash;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/hash/Striped64.class */
public abstract class Striped64 extends Number {
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    volatile transient Cell[] cells;
    volatile transient long base;
    volatile transient int busy;
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;

    /* renamed from: fn */
    abstract long mo1333fn(long j, long j2);

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/hash/Striped64$Cell.class */
    public static final class Cell {

        /* renamed from: p0 */
        volatile long f310p0;

        /* renamed from: p1 */
        volatile long f311p1;

        /* renamed from: p2 */
        volatile long f312p2;

        /* renamed from: p3 */
        volatile long f313p3;

        /* renamed from: p4 */
        volatile long f314p4;

        /* renamed from: p5 */
        volatile long f315p5;

        /* renamed from: p6 */
        volatile long f316p6;
        volatile long value;

        /* renamed from: q0 */
        volatile long f317q0;

        /* renamed from: q1 */
        volatile long f318q1;

        /* renamed from: q2 */
        volatile long f319q2;

        /* renamed from: q3 */
        volatile long f320q3;

        /* renamed from: q4 */
        volatile long f321q4;

        /* renamed from: q5 */
        volatile long f322q5;

        /* renamed from: q6 */
        volatile long f323q6;
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        Cell(long x) {
            this.value = x;
        }

        /* access modifiers changed from: package-private */
        public final boolean cas(long cmp, long val) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, cmp, val);
        }

        static {
            try {
                UNSAFE = Striped64.getUnsafe();
                valueOffset = UNSAFE.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    static {
        try {
            UNSAFE = getUnsafe();
            baseOffset = UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    final boolean casBase(long cmp, long val) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, cmp, val);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    final void retryUpdate(long x, int[] hc, boolean wasUncontended) {
        int h;
        int n;
        int m;
        if (hc == null) {
            int[] iArr = new int[1];
            hc = iArr;
            threadHashCode.set(iArr);
            int r = rng.nextInt();
            int i = r == 0 ? 1 : r;
            hc[0] = i;
            h = i;
        } else {
            h = hc[0];
        }
        boolean collide = false;
        while (true) {
            Cell[] as = this.cells;
            if (as != null && (n = as.length) > 0) {
                Cell a = as[(n - 1) & h];
                if (a == null) {
                    if (this.busy == 0) {
                        Cell r2 = new Cell(x);
                        if (this.busy == 0 && casBusy()) {
                            boolean created = false;
                            try {
                                Cell[] rs = this.cells;
                                if (rs != null && (m = rs.length) > 0) {
                                    int j = (m - 1) & h;
                                    if (rs[j] == null) {
                                        rs[j] = r2;
                                        created = true;
                                    }
                                }
                                this.busy = 0;
                                if (created) {
                                    return;
                                }
                            } finally {
                            }
                        }
                    }
                    collide = false;
                    int h2 = h ^ (h << 13);
                    int h3 = h2 ^ (h2 >>> 17);
                    h = h3 ^ (h3 << 5);
                    hc[0] = h;
                } else {
                    if (!wasUncontended) {
                        wasUncontended = true;
                    } else {
                        long v = a.value;
                        if (a.cas(v, mo1333fn(v, x))) {
                            return;
                        }
                        if (n >= NCPU || this.cells != as) {
                            collide = false;
                        } else if (!collide) {
                            collide = true;
                        } else if (this.busy == 0 && casBusy()) {
                            try {
                                if (this.cells == as) {
                                    Cell[] rs2 = new Cell[n << 1];
                                    for (int i2 = 0; i2 < n; i2++) {
                                        rs2[i2] = as[i2];
                                    }
                                    this.cells = rs2;
                                }
                                this.busy = 0;
                                collide = false;
                            } finally {
                            }
                        }
                    }
                    int h2 = h ^ (h << 13);
                    int h3 = h2 ^ (h2 >>> 17);
                    h = h3 ^ (h3 << 5);
                    hc[0] = h;
                }
            } else if (this.busy == 0 && this.cells == as && casBusy()) {
                boolean init = false;
                try {
                    if (this.cells == as) {
                        Cell[] rs3 = new Cell[2];
                        rs3[h & 1] = new Cell(x);
                        this.cells = rs3;
                        init = true;
                    }
                    this.busy = 0;
                    if (init) {
                        return;
                    }
                } finally {
                    this.busy = 0;
                }
            } else {
                long v2 = this.base;
                if (casBase(v2, mo1333fn(v2, x))) {
                    return;
                }
            }
        }
    }

    final void internalReset(long initialValue) {
        Cell[] as = this.cells;
        this.base = initialValue;
        if (as != null) {
            for (Cell a : as) {
                if (a != null) {
                    a.value = initialValue;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        } catch (SecurityException e) {
            try {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.hash.Striped64.1
                    @Override // java.security.PrivilegedExceptionAction
                    public Unsafe run() throws Exception {
                        Field[] declaredFields = Unsafe.class.getDeclaredFields();
                        for (Field f : declaredFields) {
                            f.setAccessible(true);
                            Object x = f.get(null);
                            if (Unsafe.class.isInstance(x)) {
                                return (Unsafe) Unsafe.class.cast(x);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }
    }
}
