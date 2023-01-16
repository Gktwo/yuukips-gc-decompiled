package p013io.netty.handler.codec.compression;

import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.codec.compression.FastLz */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/FastLz.class */
final class FastLz {
    private static final int MAX_DISTANCE = 8191;
    private static final int MAX_FARDISTANCE = 73725;
    private static final int HASH_LOG = 13;
    private static final int HASH_SIZE = 8192;
    private static final int HASH_MASK = 8191;
    private static final int MAX_COPY = 32;
    private static final int MAX_LEN = 264;
    private static final int MIN_RECOMENDED_LENGTH_FOR_LEVEL_2 = 65536;
    static final int MAGIC_NUMBER = 4607066;
    static final byte BLOCK_TYPE_NON_COMPRESSED = 0;
    static final byte BLOCK_TYPE_COMPRESSED = 1;
    static final byte BLOCK_WITHOUT_CHECKSUM = 0;
    static final byte BLOCK_WITH_CHECKSUM = 16;
    static final int OPTIONS_OFFSET = 3;
    static final int CHECKSUM_OFFSET = 4;
    static final int MAX_CHUNK_LENGTH = 65535;
    static final int MIN_LENGTH_TO_COMPRESSION = 32;
    static final int LEVEL_AUTO = 0;
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;

    /* access modifiers changed from: package-private */
    public static int calculateOutputBufferLength(int inputLength) {
        return Math.max((int) (((double) inputLength) * 1.06d), 66);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:141:0x027e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:163:0x02f3 */
    /* JADX DEBUG: Multi-variable search result rejected for r24v1, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r24v6, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r24v10 */
    /* JADX WARN: Type inference failed for: r24v11 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01c4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int compress(p013io.netty.buffer.ByteBuf r8, int r9, int r10, p013io.netty.buffer.ByteBuf r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 1618
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.FastLz.compress(io.netty.buffer.ByteBuf, int, int, io.netty.buffer.ByteBuf, int, int):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x00c5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x02cb */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r0v37, types: [long] */
    /* JADX WARN: Type inference failed for: r17v5, types: [long] */
    /* JADX WARN: Type inference failed for: r17v6, types: [long] */
    /* JADX WARN: Type inference failed for: r0v51, types: [long] */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r0v81, types: [long] */
    /* JADX WARN: Type inference failed for: r0v95, types: [long] */
    /* JADX WARN: Type inference failed for: r0v124, types: [long] */
    /* JADX WARN: Type inference failed for: r0v127, types: [long] */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v14 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int decompress(p013io.netty.buffer.ByteBuf r8, int r9, int r10, p013io.netty.buffer.ByteBuf r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 723
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.FastLz.decompress(io.netty.buffer.ByteBuf, int, int, io.netty.buffer.ByteBuf, int, int):int");
    }

    private static int hashFunction(ByteBuf p, int offset) {
        int v = readU16(p, offset);
        return (v ^ (readU16(p, offset + 1) ^ (v >> 3))) & 8191;
    }

    private static int readU16(ByteBuf data, int offset) {
        if (offset + 1 >= data.readableBytes()) {
            return data.getUnsignedByte(offset);
        }
        return (data.getUnsignedByte(offset + 1) << 8) | data.getUnsignedByte(offset);
    }

    private FastLz() {
    }
}
