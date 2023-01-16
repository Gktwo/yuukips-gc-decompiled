package p013io.netty.handler.codec.marshalling;

import java.io.IOException;
import org.jboss.marshalling.ByteInput;
import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.codec.marshalling.ChannelBufferByteInput */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/ChannelBufferByteInput.class */
class ChannelBufferByteInput implements ByteInput {
    private final ByteBuf buffer;

    /* access modifiers changed from: package-private */
    public ChannelBufferByteInput(ByteBuf buffer) {
        this.buffer = buffer;
    }

    public void close() throws IOException {
    }

    public int available() throws IOException {
        return this.buffer.readableBytes();
    }

    public int read() throws IOException {
        if (this.buffer.isReadable()) {
            return this.buffer.readByte() & 255;
        }
        return -1;
    }

    public int read(byte[] array) throws IOException {
        return read(array, 0, array.length);
    }

    public int read(byte[] dst, int dstIndex, int length) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }
        int length2 = Math.min(available, length);
        this.buffer.readBytes(dst, dstIndex, length2);
        return length2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long skip(long r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = r6
            io.netty.buffer.ByteBuf r0 = r0.buffer
            int r0 = r0.readableBytes()
            r9 = r0
            r0 = r9
            long r0 = (long) r0
            r1 = r7
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            r0 = r9
            long r0 = (long) r0
            r7 = r0
        L_0x0012:
            r0 = r6
            io.netty.buffer.ByteBuf r0 = r0.buffer
            r1 = r6
            io.netty.buffer.ByteBuf r1 = r1.buffer
            int r1 = r1.readerIndex()
            long r1 = (long) r1
            r2 = r7
            long r1 = r1 + r2
            int r1 = (int) r1
            io.netty.buffer.ByteBuf r0 = r0.readerIndex(r1)
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.marshalling.ChannelBufferByteInput.skip(long):long");
    }
}
