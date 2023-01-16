package p013io.netty.handler.stream;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.stream.ChunkedNioStream */
/* loaded from: grasscutter.jar:io/netty/handler/stream/ChunkedNioStream.class */
public class ChunkedNioStream implements ChunkedInput<ByteBuf> {

    /* renamed from: in */
    private final ReadableByteChannel f1032in;
    private final int chunkSize;
    private long offset;
    private final ByteBuffer byteBuffer;

    public ChunkedNioStream(ReadableByteChannel in) {
        this(in, 8192);
    }

    public ChunkedNioStream(ReadableByteChannel in, int chunkSize) {
        this.f1032in = (ReadableByteChannel) ObjectUtil.checkNotNull(in, "in");
        this.chunkSize = ObjectUtil.checkPositive(chunkSize, "chunkSize");
        this.byteBuffer = ByteBuffer.allocate(chunkSize);
    }

    public long transferredBytes() {
        return this.offset;
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        int b;
        if (this.byteBuffer.position() > 0) {
            return false;
        }
        if (!this.f1032in.isOpen() || (b = this.f1032in.read(this.byteBuffer)) < 0) {
            return true;
        }
        this.offset += (long) b;
        return false;
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.f1032in.close();
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext ctx) throws Exception {
        return readChunk(ctx.alloc());
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator allocator) throws Exception {
        if (isEndOfInput()) {
            return null;
        }
        int readBytes = this.byteBuffer.position();
        do {
            int localReadBytes = this.f1032in.read(this.byteBuffer);
            if (localReadBytes < 0) {
                break;
            }
            readBytes += localReadBytes;
            this.offset += (long) localReadBytes;
        } while (readBytes != this.chunkSize);
        this.byteBuffer.flip();
        boolean release = true;
        ByteBuf buffer = allocator.buffer(this.byteBuffer.remaining());
        try {
            buffer.writeBytes(this.byteBuffer);
            this.byteBuffer.clear();
            release = false;
            if (0 != 0) {
                buffer.release();
            }
            return buffer;
        } catch (Throwable th) {
            if (release) {
                buffer.release();
            }
            throw th;
        }
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public long length() {
        return -1;
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset;
    }
}
