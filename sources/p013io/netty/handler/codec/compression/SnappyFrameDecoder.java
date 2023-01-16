package p013io.netty.handler.codec.compression;

import p013io.netty.handler.codec.ByteToMessageDecoder;

/* renamed from: io.netty.handler.codec.compression.SnappyFrameDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/SnappyFrameDecoder.class */
public class SnappyFrameDecoder extends ByteToMessageDecoder {
    private static final int SNAPPY_IDENTIFIER_LEN = 6;
    private static final int MAX_UNCOMPRESSED_DATA_SIZE = 65540;
    private static final int MAX_DECOMPRESSED_DATA_SIZE = 65536;
    private static final int MAX_COMPRESSED_CHUNK_SIZE = 16777215;
    private final Snappy snappy;
    private final boolean validateChecksums;
    private boolean started;
    private boolean corrupted;
    private int numBytesToSkip;

    /* renamed from: io.netty.handler.codec.compression.SnappyFrameDecoder$ChunkType */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/SnappyFrameDecoder$ChunkType.class */
    private enum ChunkType {
        STREAM_IDENTIFIER,
        COMPRESSED_DATA,
        UNCOMPRESSED_DATA,
        RESERVED_UNSKIPPABLE,
        RESERVED_SKIPPABLE
    }

    public SnappyFrameDecoder() {
        this(false);
    }

    public SnappyFrameDecoder(boolean validateChecksums) {
        this.snappy = new Snappy();
        this.validateChecksums = validateChecksums;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:69:0x027f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(p013io.netty.channel.ChannelHandlerContext r7, p013io.netty.buffer.ByteBuf r8, java.util.List<java.lang.Object> r9) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 747
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.SnappyFrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    /* renamed from: io.netty.handler.codec.compression.SnappyFrameDecoder$1 */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/SnappyFrameDecoder$1.class */
    static /* synthetic */ class C29831 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType */
        static final /* synthetic */ int[] f1010xce0a49f3 = new int[ChunkType.values().length];

        static {
            try {
                f1010xce0a49f3[ChunkType.STREAM_IDENTIFIER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1010xce0a49f3[ChunkType.RESERVED_SKIPPABLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1010xce0a49f3[ChunkType.RESERVED_UNSKIPPABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1010xce0a49f3[ChunkType.UNCOMPRESSED_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1010xce0a49f3[ChunkType.COMPRESSED_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static void checkByte(byte actual, byte expect) {
        if (actual != expect) {
            throw new DecompressionException("Unexpected stream identifier contents. Mismatched snappy protocol version?");
        }
    }

    private static ChunkType mapChunkType(byte type) {
        if (type == 0) {
            return ChunkType.COMPRESSED_DATA;
        }
        if (type == 1) {
            return ChunkType.UNCOMPRESSED_DATA;
        }
        if (type == -1) {
            return ChunkType.STREAM_IDENTIFIER;
        }
        if ((type & 128) == 128) {
            return ChunkType.RESERVED_SKIPPABLE;
        }
        return ChunkType.RESERVED_UNSKIPPABLE;
    }
}
