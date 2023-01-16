package com.fasterxml.jackson.core.sym;

import java.util.Arrays;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/sym/NameN.class */
public final class NameN extends Name {

    /* renamed from: q1 */
    private final int f228q1;

    /* renamed from: q2 */
    private final int f229q2;

    /* renamed from: q3 */
    private final int f230q3;

    /* renamed from: q4 */
    private final int f231q4;
    private final int qlen;

    /* renamed from: q */
    private final int[] f232q;

    NameN(String name, int hash, int q1, int q2, int q3, int q4, int[] quads, int quadLen) {
        super(name, hash);
        this.f228q1 = q1;
        this.f229q2 = q2;
        this.f230q3 = q3;
        this.f231q4 = q4;
        this.f232q = quads;
        this.qlen = quadLen;
    }

    public static NameN construct(String name, int hash, int[] q, int qlen) {
        int[] buf;
        if (qlen < 4) {
            throw new IllegalArgumentException();
        }
        int q1 = q[0];
        int q2 = q[1];
        int q3 = q[2];
        int q4 = q[3];
        if (qlen - 4 > 0) {
            buf = Arrays.copyOfRange(q, 4, qlen);
        } else {
            buf = null;
        }
        return new NameN(name, hash, q1, q2, q3, q4, buf, qlen);
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2, int quad3) {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.fasterxml.jackson.core.sym.Name
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(int[] r5, int r6) {
        /*
            r4 = this;
            r0 = r6
            r1 = r4
            int r1 = r1.qlen
            if (r0 == r1) goto L_0x000a
            r0 = 0
            return r0
        L_0x000a:
            r0 = r5
            r1 = 0
            r0 = r0[r1]
            r1 = r4
            int r1 = r1.f228q1
            if (r0 == r1) goto L_0x0016
            r0 = 0
            return r0
        L_0x0016:
            r0 = r5
            r1 = 1
            r0 = r0[r1]
            r1 = r4
            int r1 = r1.f229q2
            if (r0 == r1) goto L_0x0022
            r0 = 0
            return r0
        L_0x0022:
            r0 = r5
            r1 = 2
            r0 = r0[r1]
            r1 = r4
            int r1 = r1.f230q3
            if (r0 == r1) goto L_0x002e
            r0 = 0
            return r0
        L_0x002e:
            r0 = r5
            r1 = 3
            r0 = r0[r1]
            r1 = r4
            int r1 = r1.f231q4
            if (r0 == r1) goto L_0x003a
            r0 = 0
            return r0
        L_0x003a:
            r0 = r6
            switch(r0) {
                case 4: goto L_0x009c;
                case 5: goto L_0x008e;
                case 6: goto L_0x0080;
                case 7: goto L_0x0071;
                case 8: goto L_0x0062;
                default: goto L_0x005c;
            }
        L_0x005c:
            r0 = r4
            r1 = r5
            boolean r0 = r0._equals2(r1)
            return r0
        L_0x0062:
            r0 = r5
            r1 = 7
            r0 = r0[r1]
            r1 = r4
            int[] r1 = r1.f232q
            r2 = 3
            r1 = r1[r2]
            if (r0 == r1) goto L_0x0071
            r0 = 0
            return r0
        L_0x0071:
            r0 = r5
            r1 = 6
            r0 = r0[r1]
            r1 = r4
            int[] r1 = r1.f232q
            r2 = 2
            r1 = r1[r2]
            if (r0 == r1) goto L_0x0080
            r0 = 0
            return r0
        L_0x0080:
            r0 = r5
            r1 = 5
            r0 = r0[r1]
            r1 = r4
            int[] r1 = r1.f232q
            r2 = 1
            r1 = r1[r2]
            if (r0 == r1) goto L_0x008e
            r0 = 0
            return r0
        L_0x008e:
            r0 = r5
            r1 = 4
            r0 = r0[r1]
            r1 = r4
            int[] r1 = r1.f232q
            r2 = 0
            r1 = r1[r2]
            if (r0 == r1) goto L_0x009c
            r0 = 0
            return r0
        L_0x009c:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.sym.NameN.equals(int[], int):boolean");
    }

    private final boolean _equals2(int[] quads) {
        int end = this.qlen - 4;
        for (int i = 0; i < end; i++) {
            if (quads[i + 4] != this.f232q[i]) {
                return false;
            }
        }
        return true;
    }
}
