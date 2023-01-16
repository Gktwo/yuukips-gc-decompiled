package p013io.netty.handler.codec.compression;

import java.nio.ByteBuffer;
import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.codec.compression.CompressionUtil */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/CompressionUtil.class */
final class CompressionUtil {
    private CompressionUtil() {
    }

    /* access modifiers changed from: package-private */
    public static void checkChecksum(ByteBufChecksum checksum, ByteBuf uncompressed, int currentChecksum) {
        checksum.reset();
        checksum.update(uncompressed, uncompressed.readerIndex(), uncompressed.readableBytes());
        int checksumResult = (int) checksum.getValue();
        if (checksumResult != currentChecksum) {
            throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", Integer.valueOf(checksumResult), Integer.valueOf(currentChecksum)));
        }
    }

    /* access modifiers changed from: package-private */
    public static ByteBuffer safeNioBuffer(ByteBuf buffer) {
        return buffer.nioBufferCount() == 1 ? buffer.internalNioBuffer(buffer.readerIndex(), buffer.readableBytes()) : buffer.nioBuffer();
    }

    /* access modifiers changed from: package-private */
    public static ByteBuffer safeNioBuffer(ByteBuf buffer, int index, int length) {
        return buffer.nioBufferCount() == 1 ? buffer.internalNioBuffer(index, length) : buffer.nioBuffer(index, length);
    }
}
