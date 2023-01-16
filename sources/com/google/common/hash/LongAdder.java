package com.google.common.hash;

import com.google.common.hash.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/common/hash/LongAdder.class */
public final class LongAdder extends Striped64 implements Serializable, LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    @Override // com.google.common.hash.Striped64
    /* renamed from: fn */
    final long mo1333fn(long v, long x) {
        return v + x;
    }

    @Override // com.google.common.hash.LongAddable
    public void add(long x) {
        int n;
        Striped64.Cell a;
        Striped64.Cell[] as = this.cells;
        if (as == null) {
            long b = this.base;
            if (casBase(b, b + x)) {
                return;
            }
        }
        boolean uncontended = true;
        int[] hc = (int[]) threadHashCode.get();
        if (!(hc == null || as == null || (n = as.length) < 1 || (a = as[(n - 1) & hc[0]]) == null)) {
            long v = a.value;
            boolean cas = a.cas(v, v + x);
            uncontended = cas;
            if (cas) {
                return;
            }
        }
        retryUpdate(x, hc, uncontended);
    }

    @Override // com.google.common.hash.LongAddable
    public void increment() {
        add(1);
    }

    public void decrement() {
        add(-1);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x002f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0035 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [long] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [long] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.common.hash.LongAddable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long sum() {
        /*
            r5 = this;
            r0 = r5
            long r0 = r0.base
            r6 = r0
            r0 = r5
            com.google.common.hash.Striped64$Cell[] r0 = r0.cells
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L_0x0035
            r0 = r8
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r10 = r0
        L_0x0015:
            r0 = r10
            r1 = r9
            if (r0 >= r1) goto L_0x0035
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L_0x002f
            r0 = r6
            r1 = r11
            long r1 = r1.value
            long r0 = r0 + r1
            r6 = r0
        L_0x002f:
            int r10 = r10 + 1
            goto L_0x0015
        L_0x0035:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.LongAdder.sum():long");
    }

    public void reset() {
        internalReset(0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    public long sumThenReset() {
        char c = this.base;
        Striped64.Cell[] as = this.cells;
        this.base = 0;
        if (as != null) {
            for (Striped64.Cell a : as) {
                if (a != null) {
                    c += a.value;
                    a.value = 0;
                }
            }
        }
        return c;
    }

    @Override // java.lang.Object
    public String toString() {
        return Long.toString(sum());
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) sum();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return (double) sum();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeLong(sum());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = s.readLong();
    }
}
