package p013io.netty.handler.codec.compression;

import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.codec.compression.Bzip2BitWriter */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2BitWriter.class */
final class Bzip2BitWriter {
    private long bitBuffer;
    private int bitCount;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeBits(p013io.netty.buffer.ByteBuf r8, int r9, long r10) {
        /*
            r7 = this;
            r0 = r9
            if (r0 < 0) goto L_0x000a
            r0 = r9
            r1 = 32
            if (r0 <= r1) goto L_0x002a
        L_0x000a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "count: "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r9
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " (expected: 0-32)"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x002a:
            r0 = r7
            int r0 = r0.bitCount
            r12 = r0
            r0 = r7
            long r0 = r0.bitBuffer
            r1 = r10
            r2 = 64
            r3 = r9
            int r2 = r2 - r3
            long r1 = r1 << r2
            r2 = r12
            long r1 = r1 >>> r2
            long r0 = r0 | r1
            r13 = r0
            r0 = r12
            r1 = r9
            int r0 = r0 + r1
            r12 = r0
            r0 = r12
            r1 = 32
            if (r0 < r1) goto L_0x0062
            r0 = r8
            r1 = r13
            r2 = 32
            long r1 = r1 >>> r2
            int r1 = (int) r1
            io.netty.buffer.ByteBuf r0 = r0.writeInt(r1)
            r0 = r13
            r1 = 32
            long r0 = r0 << r1
            r13 = r0
            int r12 = r12 + -32
        L_0x0062:
            r0 = r7
            r1 = r13
            r0.bitBuffer = r1
            r0 = r7
            r1 = r12
            r0.bitCount = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.Bzip2BitWriter.writeBits(io.netty.buffer.ByteBuf, int, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeBoolean(p013io.netty.buffer.ByteBuf r8, boolean r9) {
        /*
            r7 = this;
            r0 = r7
            int r0 = r0.bitCount
            r1 = 1
            int r0 = r0 + r1
            r10 = r0
            r0 = r7
            long r0 = r0.bitBuffer
            r1 = r9
            if (r1 == 0) goto L_0x0018
            r1 = 1
            r2 = 64
            r3 = r10
            int r2 = r2 - r3
            long r1 = r1 << r2
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            long r0 = r0 | r1
            r11 = r0
            r0 = r10
            r1 = 32
            if (r0 != r1) goto L_0x0032
            r0 = r8
            r1 = r11
            r2 = 32
            long r1 = r1 >>> r2
            int r1 = (int) r1
            io.netty.buffer.ByteBuf r0 = r0.writeInt(r1)
            r0 = 0
            r11 = r0
            r0 = 0
            r10 = r0
        L_0x0032:
            r0 = r7
            r1 = r11
            r0.bitBuffer = r1
            r0 = r7
            r1 = r10
            r0.bitCount = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.Bzip2BitWriter.writeBoolean(io.netty.buffer.ByteBuf, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public void writeUnary(ByteBuf out, int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value: " + value + " (expected 0 or more)");
        }
        while (true) {
            value--;
            if (value > 0) {
                writeBoolean(out, true);
            } else {
                writeBoolean(out, false);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void writeInt(ByteBuf out, int value) {
        writeBits(out, 32, (long) value);
    }

    /* access modifiers changed from: package-private */
    public void flush(ByteBuf out) {
        int bitCount = this.bitCount;
        if (bitCount > 0) {
            long bitBuffer = this.bitBuffer;
            int shiftToRight = 64 - bitCount;
            if (bitCount <= 8) {
                out.writeByte((int) ((bitBuffer >>> shiftToRight) << (8 - bitCount)));
            } else if (bitCount <= 16) {
                out.writeShort((int) ((bitBuffer >>> shiftToRight) << (16 - bitCount)));
            } else if (bitCount <= 24) {
                out.writeMedium((int) ((bitBuffer >>> shiftToRight) << (24 - bitCount)));
            } else {
                out.writeInt((int) ((bitBuffer >>> shiftToRight) << (32 - bitCount)));
            }
        }
    }
}
