package p013io.netty.handler.codec.compression;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.MessageToByteEncoder;

/* renamed from: io.netty.handler.codec.compression.SnappyFrameEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/SnappyFrameEncoder.class */
public class SnappyFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_COMPRESSIBLE_LENGTH = 18;
    private static final byte[] STREAM_START = {-1, 6, 0, 0, 115, 78, 97, 80, 112, 89};
    private final Snappy snappy = new Snappy();
    private boolean started;

    /* access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) throws Exception {
        if (in.isReadable()) {
            if (!this.started) {
                this.started = true;
                out.writeBytes(STREAM_START);
            }
            int dataLength = in.readableBytes();
            if (dataLength > 18) {
                while (true) {
                    int lengthIdx = out.writerIndex() + 1;
                    if (dataLength < 18) {
                        writeUnencodedChunk(in.readSlice(dataLength), out, dataLength);
                        return;
                    }
                    out.writeInt(0);
                    if (dataLength > 32767) {
                        ByteBuf slice = in.readSlice(32767);
                        calculateAndWriteChecksum(slice, out);
                        this.snappy.encode(slice, out, 32767);
                        setChunkLength(out, lengthIdx);
                        dataLength -= 32767;
                    } else {
                        ByteBuf slice2 = in.readSlice(dataLength);
                        calculateAndWriteChecksum(slice2, out);
                        this.snappy.encode(slice2, out, dataLength);
                        setChunkLength(out, lengthIdx);
                        return;
                    }
                }
            } else {
                writeUnencodedChunk(in, out, dataLength);
            }
        }
    }

    private static void writeUnencodedChunk(ByteBuf in, ByteBuf out, int dataLength) {
        out.writeByte(1);
        writeChunkLength(out, dataLength + 4);
        calculateAndWriteChecksum(in, out);
        out.writeBytes(in, dataLength);
    }

    private static void setChunkLength(ByteBuf out, int lengthIdx) {
        int chunkLength = (out.writerIndex() - lengthIdx) - 3;
        if ((chunkLength >>> 24) != 0) {
            throw new CompressionException("compressed data too large: " + chunkLength);
        }
        out.setMediumLE(lengthIdx, chunkLength);
    }

    private static void writeChunkLength(ByteBuf out, int chunkLength) {
        out.writeMediumLE(chunkLength);
    }

    private static void calculateAndWriteChecksum(ByteBuf slice, ByteBuf out) {
        out.writeIntLE(Snappy.calculateChecksum(slice));
    }
}
