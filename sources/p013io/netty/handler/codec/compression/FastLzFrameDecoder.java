package p013io.netty.handler.codec.compression;

import java.util.zip.Adler32;
import java.util.zip.Checksum;
import p013io.netty.handler.codec.ByteToMessageDecoder;

/* renamed from: io.netty.handler.codec.compression.FastLzFrameDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/FastLzFrameDecoder.class */
public class FastLzFrameDecoder extends ByteToMessageDecoder {
    private State currentState;
    private final ByteBufChecksum checksum;
    private int chunkLength;
    private int originalLength;
    private boolean isCompressed;
    private boolean hasChecksum;
    private int currentChecksum;

    /* renamed from: io.netty.handler.codec.compression.FastLzFrameDecoder$State */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/FastLzFrameDecoder$State.class */
    private enum State {
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public FastLzFrameDecoder() {
        this(false);
    }

    public FastLzFrameDecoder(boolean validateChecksums) {
        this(validateChecksums ? new Adler32() : null);
    }

    public FastLzFrameDecoder(Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0 A[Catch: Exception -> 0x0228, TryCatch #2 {Exception -> 0x0228, blocks: (B:2:0x0000, B:3:0x000b, B:4:0x0028, B:7:0x0033, B:9:0x0040, B:10:0x0049, B:11:0x004a, B:15:0x005e, B:19:0x0071, B:20:0x007b, B:24:0x008c, B:28:0x0099, B:31:0x00a0, B:33:0x00a8, B:35:0x00b0, B:37:0x00c3, B:38:0x00ca, B:39:0x00ce, B:40:0x00d8, B:43:0x00ea, B:44:0x00f9, B:49:0x014d, B:51:0x015f, B:59:0x01c4, B:60:0x01c5, B:62:0x01cd, B:63:0x01d9, B:66:0x01f5, B:68:0x0211, B:69:0x021d, B:70:0x0224), top: B:76:0x0000 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ea A[Catch: Exception -> 0x0228, TryCatch #2 {Exception -> 0x0228, blocks: (B:2:0x0000, B:3:0x000b, B:4:0x0028, B:7:0x0033, B:9:0x0040, B:10:0x0049, B:11:0x004a, B:15:0x005e, B:19:0x0071, B:20:0x007b, B:24:0x008c, B:28:0x0099, B:31:0x00a0, B:33:0x00a8, B:35:0x00b0, B:37:0x00c3, B:38:0x00ca, B:39:0x00ce, B:40:0x00d8, B:43:0x00ea, B:44:0x00f9, B:49:0x014d, B:51:0x015f, B:59:0x01c4, B:60:0x01c5, B:62:0x01cd, B:63:0x01d9, B:66:0x01f5, B:68:0x0211, B:69:0x021d, B:70:0x0224), top: B:76:0x0000 }] */
    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void decode(p013io.netty.channel.ChannelHandlerContext r9, p013io.netty.buffer.ByteBuf r10, java.util.List<java.lang.Object> r11) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 565
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.FastLzFrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
