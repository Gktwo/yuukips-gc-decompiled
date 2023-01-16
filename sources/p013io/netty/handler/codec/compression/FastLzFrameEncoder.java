package p013io.netty.handler.codec.compression;

import java.util.zip.Adler32;
import java.util.zip.Checksum;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToByteEncoder;

/* renamed from: io.netty.handler.codec.compression.FastLzFrameEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/FastLzFrameEncoder.class */
public class FastLzFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private final int level;
    private final ByteBufChecksum checksum;

    public FastLzFrameEncoder() {
        this(0, null);
    }

    public FastLzFrameEncoder(int level) {
        this(level, null);
    }

    public FastLzFrameEncoder(boolean validateChecksums) {
        this(0, validateChecksums ? new Adler32() : null);
    }

    public FastLzFrameEncoder(int level, Checksum checksum) {
        if (level == 0 || level == 1 || level == 2) {
            this.level = level;
            this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
            return;
        }
        throw new IllegalArgumentException(String.format("level: %d (expected: %d or %d or %d)", Integer.valueOf(level), 0, 1, 2));
    }

    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
        int chunkLength;
        byte blockType;
        ByteBufChecksum checksum = this.checksum;
        while (in.isReadable()) {
            int idx = in.readerIndex();
            int length = Math.min(in.readableBytes(), 65535);
            int outputIdx = out.writerIndex();
            out.setMedium(outputIdx, 4607066);
            int outputOffset = outputIdx + 4 + (checksum != null ? 4 : 0);
            if (length < 32) {
                blockType = 0;
                out.ensureWritable(outputOffset + 2 + length);
                int outputPtr = outputOffset + 2;
                if (checksum != null) {
                    checksum.reset();
                    checksum.update(in, idx, length);
                    out.setInt(outputIdx + 4, (int) checksum.getValue());
                }
                out.setBytes(outputPtr, in, idx, length);
                chunkLength = length;
            } else {
                if (checksum != null) {
                    checksum.reset();
                    checksum.update(in, idx, length);
                    out.setInt(outputIdx + 4, (int) checksum.getValue());
                }
                out.ensureWritable(outputOffset + 4 + FastLz.calculateOutputBufferLength(length));
                int compressedLength = FastLz.compress(in, in.readerIndex(), length, out, outputOffset + 4, this.level);
                if (compressedLength < length) {
                    blockType = 1;
                    chunkLength = compressedLength;
                    out.setShort(outputOffset, chunkLength);
                    outputOffset += 2;
                } else {
                    blockType = 0;
                    out.setBytes(outputOffset + 2, in, idx, length);
                    chunkLength = length;
                }
            }
            out.setShort(outputOffset, length);
            out.setByte(outputIdx + 3, blockType | (checksum != null ? (byte) 16 : 0));
            out.writerIndex(outputOffset + 2 + chunkLength);
            in.skipBytes(length);
        }
    }
}
