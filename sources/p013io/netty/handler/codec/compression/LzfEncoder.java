package p013io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkEncoder;
import com.ning.compress.lzf.LZFChunk;
import com.ning.compress.lzf.LZFEncoder;
import com.ning.compress.lzf.util.ChunkEncoderFactory;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToByteEncoder;

/* renamed from: io.netty.handler.codec.compression.LzfEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/LzfEncoder.class */
public class LzfEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_BLOCK_TO_COMPRESS = 16;
    private final int compressThreshold;
    private final ChunkEncoder encoder;
    private final BufferRecycler recycler;

    public LzfEncoder() {
        this(false);
    }

    public LzfEncoder(boolean safeInstance) {
        this(safeInstance, 65535);
    }

    public LzfEncoder(boolean safeInstance, int totalLength) {
        this(safeInstance, totalLength, 16);
    }

    public LzfEncoder(int totalLength) {
        this(false, totalLength);
    }

    public LzfEncoder(boolean safeInstance, int totalLength, int compressThreshold) {
        super(false);
        ChunkEncoder chunkEncoder;
        if (totalLength < 16 || totalLength > 65535) {
            throw new IllegalArgumentException("totalLength: " + totalLength + " (expected: 16-65535)");
        } else if (compressThreshold < 16) {
            throw new IllegalArgumentException("compressThreshold:" + compressThreshold + " expected >=16");
        } else {
            this.compressThreshold = compressThreshold;
            if (safeInstance) {
                chunkEncoder = ChunkEncoderFactory.safeNonAllocatingInstance(totalLength);
            } else {
                chunkEncoder = ChunkEncoderFactory.optimalNonAllocatingInstance(totalLength);
            }
            this.encoder = chunkEncoder;
            this.recycler = BufferRecycler.instance();
        }
    }

    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
        int inputPtr;
        byte[] input;
        int outputPtr;
        byte[] output;
        int outputLength;
        int length = in.readableBytes();
        int idx = in.readerIndex();
        if (in.hasArray()) {
            input = in.array();
            inputPtr = in.arrayOffset() + idx;
        } else {
            input = this.recycler.allocInputBuffer(length);
            in.getBytes(idx, input, 0, length);
            inputPtr = 0;
        }
        int maxOutputLength = LZFEncoder.estimateMaxWorkspaceSize(length) + 1;
        out.ensureWritable(maxOutputLength);
        if (out.hasArray()) {
            output = out.array();
            outputPtr = out.arrayOffset() + out.writerIndex();
        } else {
            output = new byte[maxOutputLength];
            outputPtr = 0;
        }
        if (length >= this.compressThreshold) {
            outputLength = encodeCompress(input, inputPtr, length, output, outputPtr);
        } else {
            outputLength = encodeNonCompress(input, inputPtr, length, output, outputPtr);
        }
        if (out.hasArray()) {
            out.writerIndex(out.writerIndex() + outputLength);
        } else {
            out.writeBytes(output, 0, outputLength);
        }
        in.skipBytes(length);
        if (!in.hasArray()) {
            this.recycler.releaseInputBuffer(input);
        }
    }

    private int encodeCompress(byte[] input, int inputPtr, int length, byte[] output, int outputPtr) {
        return LZFEncoder.appendEncoded(this.encoder, input, inputPtr, length, output, outputPtr) - outputPtr;
    }

    private static int lzfEncodeNonCompress(byte[] input, int inputPtr, int length, byte[] output, int outputPtr) {
        int chunkLen = Math.min(65535, length);
        int outputPtr2 = LZFChunk.appendNonCompressed(input, inputPtr, chunkLen, output, outputPtr);
        int left = length - chunkLen;
        if (left < 1) {
            return outputPtr2;
        }
        int inputPtr2 = inputPtr + chunkLen;
        do {
            int chunkLen2 = Math.min(left, 65535);
            outputPtr2 = LZFChunk.appendNonCompressed(input, inputPtr2, chunkLen2, output, outputPtr2);
            inputPtr2 += chunkLen2;
            left -= chunkLen2;
        } while (left > 0);
        return outputPtr2;
    }

    private static int encodeNonCompress(byte[] input, int inputPtr, int length, byte[] output, int outputPtr) {
        return lzfEncodeNonCompress(input, inputPtr, length, output, outputPtr) - outputPtr;
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        this.encoder.close();
        handlerRemoved(ctx);
    }
}
