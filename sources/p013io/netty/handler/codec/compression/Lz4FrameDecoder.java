package p013io.netty.handler.codec.compression;

import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import p013io.netty.handler.codec.ByteToMessageDecoder;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.compression.Lz4FrameDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Lz4FrameDecoder.class */
public class Lz4FrameDecoder extends ByteToMessageDecoder {
    private State currentState;
    private LZ4FastDecompressor decompressor;
    private ByteBufChecksum checksum;
    private int blockType;
    private int compressedLength;
    private int decompressedLength;
    private int currentChecksum;

    /* renamed from: io.netty.handler.codec.compression.Lz4FrameDecoder$State */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Lz4FrameDecoder$State.class */
    private enum State {
        INIT_BLOCK,
        DECOMPRESS_DATA,
        FINISHED,
        CORRUPTED
    }

    public Lz4FrameDecoder() {
        this(false);
    }

    public Lz4FrameDecoder(boolean validateChecksums) {
        this(LZ4Factory.fastestInstance(), validateChecksums);
    }

    public Lz4FrameDecoder(LZ4Factory factory, boolean validateChecksums) {
        this(factory, validateChecksums ? new Lz4XXHash32(-1756908916) : null);
    }

    public Lz4FrameDecoder(LZ4Factory factory, Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        this.decompressor = ((LZ4Factory) ObjectUtil.checkNotNull(factory, "factory")).fastDecompressor();
        this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0193 A[Catch: Exception -> 0x0295, TryCatch #2 {Exception -> 0x0295, blocks: (B:2:0x0000, B:3:0x000b, B:4:0x0028, B:7:0x0034, B:9:0x0043, B:10:0x004c, B:11:0x004d, B:15:0x007a, B:16:0x009a, B:17:0x009b, B:21:0x00b6, B:22:0x00d6, B:35:0x00f9, B:36:0x0119, B:37:0x011a, B:43:0x0132, B:44:0x013b, B:45:0x013c, B:46:0x0150, B:47:0x016f, B:50:0x0193, B:52:0x019e, B:56:0x0228, B:57:0x0229, B:59:0x0235, B:62:0x0256, B:65:0x026a, B:67:0x027e, B:68:0x028a, B:69:0x0291), top: B:76:0x0000 }] */
    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void decode(p013io.netty.channel.ChannelHandlerContext r9, p013io.netty.buffer.ByteBuf r10, java.util.List<java.lang.Object> r11) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 674
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.Lz4FrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public boolean isClosed() {
        return this.currentState == State.FINISHED;
    }
}
