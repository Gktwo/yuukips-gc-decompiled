package com.esotericsoftware.asm;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/Label.class */
public class Label {
    public Object info;

    /* renamed from: a */
    int f144a;

    /* renamed from: b */
    int f145b;

    /* renamed from: c */
    int f146c;

    /* renamed from: d */
    private int f147d;

    /* renamed from: e */
    private int[] f148e;

    /* renamed from: f */
    int f149f;

    /* renamed from: g */
    int f150g;

    /* renamed from: h */
    Frame f151h;

    /* renamed from: i */
    Label f152i;

    /* renamed from: j */
    Edge f153j;

    /* renamed from: k */
    Label f154k;

    public int getOffset() {
        if ((this.f144a & 2) != 0) {
            return this.f146c;
        }
        throw new IllegalStateException("Label offset position has not been resolved yet");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1504a(MethodWriter methodWriter, ByteVector byteVector, int i, boolean z) {
        if ((this.f144a & 2) == 0) {
            if (z) {
                m1509a(-1 - i, byteVector.f34b);
                byteVector.putInt(-1);
                return;
            }
            m1509a(i, byteVector.f34b);
            byteVector.putShort(-1);
        } else if (z) {
            byteVector.putInt(this.f146c - i);
        } else {
            byteVector.putShort(this.f146c - i);
        }
    }

    /* renamed from: a */
    private void m1509a(int i, int i2) {
        if (this.f148e == null) {
            this.f148e = new int[6];
        }
        if (this.f147d >= this.f148e.length) {
            int[] iArr = new int[this.f148e.length + 6];
            System.arraycopy(this.f148e, 0, iArr, 0, this.f148e.length);
            this.f148e = iArr;
        }
        int[] iArr2 = this.f148e;
        int i3 = this.f147d;
        this.f147d = i3 + 1;
        iArr2[i3] = i;
        int[] iArr3 = this.f148e;
        int i4 = this.f147d;
        this.f147d = i4 + 1;
        iArr3[i4] = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m1505a(MethodWriter methodWriter, int i, byte[] bArr) {
        boolean z = false;
        this.f144a |= 2;
        this.f146c = i;
        int i2 = 0;
        while (i2 < this.f147d) {
            int i3 = i2 + 1;
            int i4 = this.f148e[i2];
            i2 = i3 + 1;
            int i5 = this.f148e[i3];
            if (i4 >= 0) {
                int i6 = i - i4;
                if (i6 < -32768 || i6 > 32767) {
                    int i7 = bArr[i5 - 1] & 255;
                    if (i7 <= 168) {
                        bArr[i5 - 1] = (byte) (i7 + 49);
                    } else {
                        bArr[i5 - 1] = (byte) (i7 + 20);
                    }
                    z = true;
                }
                bArr[i5] = (byte) (i6 >>> 8);
                bArr[i5 + 1] = (byte) i6;
            } else {
                int i8 = i + i4 + 1;
                int i9 = i5 + 1;
                bArr[i5] = (byte) (i8 >>> 24);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (i8 >>> 16);
                bArr[i10] = (byte) (i8 >>> 8);
                bArr[i10 + 1] = (byte) i8;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Label m1510a() {
        return this.f151h == null ? this : this.f151h.f116b;
    }

    /* renamed from: a */
    boolean m1508a(long j) {
        return ((this.f144a & 1024) == 0 || (this.f148e[(int) (j >>> 32)] & ((int) j)) == 0) ? false : true;
    }

    /* renamed from: a */
    boolean m1506a(Label label) {
        if ((this.f144a & 1024) == 0 || (label.f144a & 1024) == 0) {
            return false;
        }
        for (int i = 0; i < this.f148e.length; i++) {
            if ((this.f148e[i] & label.f148e[i]) != 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    void m1507a(long j, int i) {
        if ((this.f144a & 1024) == 0) {
            this.f144a |= 1024;
            this.f148e = new int[(i / 32) + 1];
        }
        int[] iArr = this.f148e;
        int i2 = (int) (j >>> 32);
        iArr[i2] = iArr[i2] | ((int) j);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a1  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1503b(com.esotericsoftware.asm.Label r6, long r7, int r9) {
        /*
            r5 = this;
            r0 = r5
            r10 = r0
        L_0x0003:
            r0 = r10
            if (r0 == 0) goto L_0x00e3
            r0 = r10
            r11 = r0
            r0 = r11
            com.esotericsoftware.asm.Label r0 = r0.f154k
            r10 = r0
            r0 = r11
            r1 = 0
            r0.f154k = r1
            r0 = r6
            if (r0 == 0) goto L_0x0081
            r0 = r11
            int r0 = r0.f144a
            r1 = 2048(0x800, float:2.87E-42)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x002c
            goto L_0x0003
        L_0x002c:
            r0 = r11
            r1 = r0
            int r1 = r1.f144a
            r2 = 2048(0x800, float:2.87E-42)
            r1 = r1 | r2
            r0.f144a = r1
            r0 = r11
            int r0 = r0.f144a
            r1 = 256(0x100, float:3.59E-43)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0095
            r0 = r11
            r1 = r6
            boolean r0 = r0.m1506a(r1)
            if (r0 != 0) goto L_0x0095
            com.esotericsoftware.asm.Edge r0 = new com.esotericsoftware.asm.Edge
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            r1 = r11
            int r1 = r1.f149f
            r0.f100a = r1
            r0 = r12
            r1 = r6
            com.esotericsoftware.asm.Edge r1 = r1.f153j
            com.esotericsoftware.asm.Label r1 = r1.f101b
            r0.f101b = r1
            r0 = r12
            r1 = r11
            com.esotericsoftware.asm.Edge r1 = r1.f153j
            r0.f102c = r1
            r0 = r11
            r1 = r12
            r0.f153j = r1
            goto L_0x0095
        L_0x0081:
            r0 = r11
            r1 = r7
            boolean r0 = r0.m1508a(r1)
            if (r0 == 0) goto L_0x008d
            goto L_0x0003
        L_0x008d:
            r0 = r11
            r1 = r7
            r2 = r9
            r0.m1507a(r1, r2)
        L_0x0095:
            r0 = r11
            com.esotericsoftware.asm.Edge r0 = r0.f153j
            r12 = r0
        L_0x009c:
            r0 = r12
            if (r0 == 0) goto L_0x00e0
            r0 = r11
            int r0 = r0.f144a
            r1 = 128(0x80, float:1.794E-43)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00ba
            r0 = r12
            r1 = r11
            com.esotericsoftware.asm.Edge r1 = r1.f153j
            com.esotericsoftware.asm.Edge r1 = r1.f102c
            if (r0 == r1) goto L_0x00d6
        L_0x00ba:
            r0 = r12
            com.esotericsoftware.asm.Label r0 = r0.f101b
            com.esotericsoftware.asm.Label r0 = r0.f154k
            if (r0 != 0) goto L_0x00d6
            r0 = r12
            com.esotericsoftware.asm.Label r0 = r0.f101b
            r1 = r10
            r0.f154k = r1
            r0 = r12
            com.esotericsoftware.asm.Label r0 = r0.f101b
            r10 = r0
        L_0x00d6:
            r0 = r12
            com.esotericsoftware.asm.Edge r0 = r0.f102c
            r12 = r0
            goto L_0x009c
        L_0x00e0:
            goto L_0x0003
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.esotericsoftware.asm.Label.m1503b(com.esotericsoftware.asm.Label, long, int):void");
    }

    public String toString() {
        return new StringBuffer().append("L").append(System.identityHashCode(this)).toString();
    }
}
