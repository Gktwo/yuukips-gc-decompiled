package p013io.netty.handler.codec.compression;

import java.util.zip.CRC32;
import java.util.zip.Inflater;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.compression.JdkZlibDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/JdkZlibDecoder.class */
public class JdkZlibDecoder extends ZlibDecoder {
    private static final int FHCRC = 2;
    private static final int FEXTRA = 4;
    private static final int FNAME = 8;
    private static final int FCOMMENT = 16;
    private static final int FRESERVED = 224;
    private Inflater inflater;
    private final byte[] dictionary;
    private final ByteBufChecksum crc;
    private final boolean decompressConcatenated;
    private GzipState gzipState;
    private int flags;
    private int xlen;
    private volatile boolean finished;
    private boolean decideZlibOrNone;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.codec.compression.JdkZlibDecoder$GzipState */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/JdkZlibDecoder$GzipState.class */
    public enum GzipState {
        HEADER_START,
        HEADER_END,
        FLG_READ,
        XLEN_READ,
        SKIP_FNAME,
        SKIP_COMMENT,
        PROCESS_FHCRC,
        FOOTER_START
    }

    static {
        $assertionsDisabled = !JdkZlibDecoder.class.desiredAssertionStatus();
    }

    public JdkZlibDecoder() {
        this(ZlibWrapper.ZLIB, null, false, 0);
    }

    public JdkZlibDecoder(int maxAllocation) {
        this(ZlibWrapper.ZLIB, null, false, maxAllocation);
    }

    public JdkZlibDecoder(byte[] dictionary) {
        this(ZlibWrapper.ZLIB, dictionary, false, 0);
    }

    public JdkZlibDecoder(byte[] dictionary, int maxAllocation) {
        this(ZlibWrapper.ZLIB, dictionary, false, maxAllocation);
    }

    public JdkZlibDecoder(ZlibWrapper wrapper) {
        this(wrapper, null, false, 0);
    }

    public JdkZlibDecoder(ZlibWrapper wrapper, int maxAllocation) {
        this(wrapper, null, false, maxAllocation);
    }

    public JdkZlibDecoder(ZlibWrapper wrapper, boolean decompressConcatenated) {
        this(wrapper, null, decompressConcatenated, 0);
    }

    public JdkZlibDecoder(ZlibWrapper wrapper, boolean decompressConcatenated, int maxAllocation) {
        this(wrapper, null, decompressConcatenated, maxAllocation);
    }

    public JdkZlibDecoder(boolean decompressConcatenated) {
        this(ZlibWrapper.GZIP, null, decompressConcatenated, 0);
    }

    public JdkZlibDecoder(boolean decompressConcatenated, int maxAllocation) {
        this(ZlibWrapper.GZIP, null, decompressConcatenated, maxAllocation);
    }

    private JdkZlibDecoder(ZlibWrapper wrapper, byte[] dictionary, boolean decompressConcatenated, int maxAllocation) {
        super(maxAllocation);
        this.gzipState = GzipState.HEADER_START;
        this.flags = -1;
        this.xlen = -1;
        ObjectUtil.checkNotNull(wrapper, "wrapper");
        this.decompressConcatenated = decompressConcatenated;
        switch (wrapper) {
            case GZIP:
                this.inflater = new Inflater(true);
                this.crc = ByteBufChecksum.wrapChecksum(new CRC32());
                break;
            case NONE:
                this.inflater = new Inflater(true);
                this.crc = null;
                break;
            case ZLIB:
                this.inflater = new Inflater();
                this.crc = null;
                break;
            case ZLIB_OR_NONE:
                this.decideZlibOrNone = true;
                this.crc = null;
                break;
            default:
                throw new IllegalArgumentException("Only GZIP or ZLIB is supported, but you used " + wrapper);
        }
        this.dictionary = dictionary;
    }

    @Override // p013io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x00e7 */
    /* JADX DEBUG: Multi-variable search result rejected for r11v7, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r0v106, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r0v107, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01b4, code lost:
        r8.skipBytes(r10 - r6.inflater.getRemaining());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01c5, code lost:
        if (r12 == false) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01c8, code lost:
        r6.gzipState = p013io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.FOOTER_START;
        handleGzipFooter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01da, code lost:
        if (r11.isReadable() == false) goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01dd, code lost:
        r9.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01e9, code lost:
        r11.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x021f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        return;
     */
    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void decode(p013io.netty.channel.ChannelHandlerContext r7, p013io.netty.buffer.ByteBuf r8, java.util.List<java.lang.Object> r9) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 544
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.JdkZlibDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    private boolean handleGzipFooter(ByteBuf in) {
        if (!readGZIPFooter(in)) {
            return false;
        }
        this.finished = !this.decompressConcatenated;
        if (this.finished) {
            return false;
        }
        this.inflater.reset();
        this.crc.reset();
        this.gzipState = GzipState.HEADER_START;
        return true;
    }

    @Override // p013io.netty.handler.codec.compression.ZlibDecoder
    protected void decompressionBufferExhausted(ByteBuf buffer) {
        this.finished = true;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext ctx) throws Exception {
        handlerRemoved0(ctx);
        if (this.inflater != null) {
            this.inflater.end();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0180 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0193 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0195  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean readGZIPHeader(p013io.netty.buffer.ByteBuf r6) {
        /*
        // Method dump skipped, instructions count: 455
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.JdkZlibDecoder.readGZIPHeader(io.netty.buffer.ByteBuf):boolean");
    }

    private boolean skipIfNeeded(ByteBuf in, int flagMask) {
        if ((this.flags & flagMask) == 0) {
            return true;
        }
        while (in.isReadable()) {
            int b = in.readUnsignedByte();
            this.crc.update(b);
            if (b == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean readGZIPFooter(ByteBuf in) {
        if (in.readableBytes() < 8) {
            return false;
        }
        boolean enoughData = verifyCrc(in);
        if ($assertionsDisabled || enoughData) {
            int dataLength = 0;
            for (int i = 0; i < 4; i++) {
                dataLength |= in.readUnsignedByte() << (i * 8);
            }
            int readLength = this.inflater.getTotalOut();
            if (dataLength == readLength) {
                return true;
            }
            throw new DecompressionException("Number of bytes mismatch. Expected: " + dataLength + ", Got: " + readLength);
        }
        throw new AssertionError();
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    private boolean verifyCrc(ByteBuf in) {
        if (in.readableBytes() < 4) {
            return false;
        }
        char c = 0;
        for (int i = 0; i < 4; i++) {
            c |= ((long) in.readUnsignedByte()) << (i * 8);
        }
        long readCrc = this.crc.getValue();
        if (c == readCrc) {
            return true;
        }
        throw new DecompressionException("CRC value mismatch. Expected: " + ((long) c) + ", Got: " + readCrc);
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    private boolean verifyCrc16(ByteBuf in) {
        if (in.readableBytes() < 2) {
            return false;
        }
        long readCrc32 = this.crc.getValue();
        char c = 0;
        char c2 = 0;
        for (int i = 0; i < 2; i++) {
            c |= ((long) in.readUnsignedByte()) << (i * 8);
            c2 |= ((readCrc32 >> (i * 8)) & 255) << (i * 8);
        }
        if (c == c2) {
            return true;
        }
        throw new DecompressionException("CRC16 value mismatch. Expected: " + ((long) c) + ", Got: " + ((long) c2));
    }

    private static boolean looksLikeZlib(short cmf_flg) {
        return (cmf_flg & 30720) == 30720 && cmf_flg % 31 == 0;
    }
}
