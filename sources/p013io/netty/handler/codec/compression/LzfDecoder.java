package p013io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkDecoder;
import com.ning.compress.lzf.util.ChunkDecoderFactory;
import p013io.netty.handler.codec.ByteToMessageDecoder;

/* renamed from: io.netty.handler.codec.compression.LzfDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/LzfDecoder.class */
public class LzfDecoder extends ByteToMessageDecoder {
    private State currentState;
    private static final short MAGIC_NUMBER = 23126;
    private ChunkDecoder decoder;
    private BufferRecycler recycler;
    private int chunkLength;
    private int originalLength;
    private boolean isCompressed;

    /* renamed from: io.netty.handler.codec.compression.LzfDecoder$State */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/LzfDecoder$State.class */
    private enum State {
        INIT_BLOCK,
        INIT_ORIGINAL_LENGTH,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public LzfDecoder() {
        this(false);
    }

    public LzfDecoder(boolean safeInstance) {
        ChunkDecoder chunkDecoder;
        this.currentState = State.INIT_BLOCK;
        if (safeInstance) {
            chunkDecoder = ChunkDecoderFactory.safeInstance();
        } else {
            chunkDecoder = ChunkDecoderFactory.optimalInstance();
        }
        this.decoder = chunkDecoder;
        this.recycler = BufferRecycler.instance();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f9 A[Catch: Exception -> 0x0274, TryCatch #2 {Exception -> 0x0274, blocks: (B:2:0x0000, B:3:0x000b, B:4:0x0028, B:7:0x0033, B:9:0x0041, B:10:0x004a, B:11:0x004b, B:12:0x0053, B:13:0x006c, B:14:0x007b, B:15:0x008a, B:16:0x00b0, B:17:0x00b1, B:19:0x00c2, B:20:0x00e4, B:24:0x00ee, B:27:0x00f9, B:29:0x010a, B:30:0x012c, B:31:0x012d, B:32:0x0134, B:35:0x0146, B:37:0x0153, B:39:0x0160, B:40:0x0172, B:41:0x018c, B:43:0x01a5, B:44:0x01bc, B:49:0x01f5, B:52:0x0215, B:53:0x022e, B:55:0x0235, B:59:0x0246, B:60:0x0253, B:61:0x025d, B:62:0x0269, B:63:0x0270), top: B:69:0x0000 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0146 A[Catch: Exception -> 0x0274, TryCatch #2 {Exception -> 0x0274, blocks: (B:2:0x0000, B:3:0x000b, B:4:0x0028, B:7:0x0033, B:9:0x0041, B:10:0x004a, B:11:0x004b, B:12:0x0053, B:13:0x006c, B:14:0x007b, B:15:0x008a, B:16:0x00b0, B:17:0x00b1, B:19:0x00c2, B:20:0x00e4, B:24:0x00ee, B:27:0x00f9, B:29:0x010a, B:30:0x012c, B:31:0x012d, B:32:0x0134, B:35:0x0146, B:37:0x0153, B:39:0x0160, B:40:0x0172, B:41:0x018c, B:43:0x01a5, B:44:0x01bc, B:49:0x01f5, B:52:0x0215, B:53:0x022e, B:55:0x0235, B:59:0x0246, B:60:0x0253, B:61:0x025d, B:62:0x0269, B:63:0x0270), top: B:69:0x0000 }] */
    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void decode(p013io.netty.channel.ChannelHandlerContext r9, p013io.netty.buffer.ByteBuf r10, java.util.List<java.lang.Object> r11) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 651
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.LzfDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
