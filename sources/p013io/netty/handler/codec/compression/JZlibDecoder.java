package p013io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.SelectStrategy;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.compression.JZlibDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/JZlibDecoder.class */
public class JZlibDecoder extends ZlibDecoder {

    /* renamed from: z */
    private final Inflater f970z;
    private byte[] dictionary;
    private volatile boolean finished;

    public JZlibDecoder() {
        this(ZlibWrapper.ZLIB, 0);
    }

    public JZlibDecoder(int maxAllocation) {
        this(ZlibWrapper.ZLIB, maxAllocation);
    }

    public JZlibDecoder(ZlibWrapper wrapper) {
        this(wrapper, 0);
    }

    public JZlibDecoder(ZlibWrapper wrapper, int maxAllocation) {
        super(maxAllocation);
        this.f970z = new Inflater();
        ObjectUtil.checkNotNull(wrapper, "wrapper");
        int resultCode = this.f970z.init(ZlibUtil.convertWrapperType(wrapper));
        if (resultCode != 0) {
            ZlibUtil.fail(this.f970z, "initialization failure", resultCode);
        }
    }

    public JZlibDecoder(byte[] dictionary) {
        this(dictionary, 0);
    }

    public JZlibDecoder(byte[] dictionary, int maxAllocation) {
        super(maxAllocation);
        this.f970z = new Inflater();
        this.dictionary = (byte[]) ObjectUtil.checkNotNull(dictionary, "dictionary");
        int resultCode = this.f970z.inflateInit(JZlib.W_ZLIB);
        if (resultCode != 0) {
            ZlibUtil.fail(this.f970z, "initialization failure", resultCode);
        }
    }

    @Override // p013io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (this.finished) {
            in.skipBytes(in.readableBytes());
            return;
        }
        int inputLength = in.readableBytes();
        if (inputLength != 0) {
            try {
                this.f970z.avail_in = inputLength;
                if (in.hasArray()) {
                    this.f970z.next_in = in.array();
                    this.f970z.next_in_index = in.arrayOffset() + in.readerIndex();
                } else {
                    byte[] array = new byte[inputLength];
                    in.getBytes(in.readerIndex(), array);
                    this.f970z.next_in = array;
                    this.f970z.next_in_index = 0;
                }
                int oldNextInIndex = this.f970z.next_in_index;
                ByteBuf decompressed = prepareDecompressBuffer(ctx, null, inputLength << 1);
                while (true) {
                    decompressed = prepareDecompressBuffer(ctx, decompressed, this.f970z.avail_in << 1);
                    this.f970z.avail_out = decompressed.writableBytes();
                    this.f970z.next_out = decompressed.array();
                    this.f970z.next_out_index = decompressed.arrayOffset() + decompressed.writerIndex();
                    int oldNextOutIndex = this.f970z.next_out_index;
                    int resultCode = this.f970z.inflate(2);
                    int outputLength = this.f970z.next_out_index - oldNextOutIndex;
                    if (outputLength > 0) {
                        decompressed.writerIndex(decompressed.writerIndex() + outputLength);
                    }
                    switch (resultCode) {
                        case -5:
                            if (this.f970z.avail_in > 0) {
                                break;
                            } else {
                                break;
                            }
                        case -4:
                        case SelectStrategy.BUSY_WAIT:
                        case -2:
                        case -1:
                        default:
                            ZlibUtil.fail(this.f970z, "decompression failure", resultCode);
                            break;
                        case 0:
                            break;
                        case 1:
                            this.finished = true;
                            this.f970z.inflateEnd();
                            break;
                        case 2:
                            if (this.dictionary != null) {
                                int resultCode2 = this.f970z.inflateSetDictionary(this.dictionary, this.dictionary.length);
                                if (resultCode2 == 0) {
                                    break;
                                } else {
                                    ZlibUtil.fail(this.f970z, "failed to set the dictionary", resultCode2);
                                    break;
                                }
                            } else {
                                ZlibUtil.fail(this.f970z, "decompression failure", resultCode);
                                break;
                            }
                    }
                }
                in.skipBytes(this.f970z.next_in_index - oldNextInIndex);
                if (decompressed.isReadable()) {
                    out.add(decompressed);
                } else {
                    decompressed.release();
                }
            } finally {
                this.f970z.next_in = null;
                this.f970z.next_out = null;
            }
        }
    }

    @Override // p013io.netty.handler.codec.compression.ZlibDecoder
    protected void decompressionBufferExhausted(ByteBuf buffer) {
        this.finished = true;
    }
}
