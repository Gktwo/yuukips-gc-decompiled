package p013io.netty.handler.stream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.stream.ChunkedNioFile */
/* loaded from: grasscutter.jar:io/netty/handler/stream/ChunkedNioFile.class */
public class ChunkedNioFile implements ChunkedInput<ByteBuf> {

    /* renamed from: in */
    private final FileChannel f995in;
    private final long startOffset;
    private final long endOffset;
    private final int chunkSize;
    private long offset;

    public ChunkedNioFile(File in) throws IOException {
        this(new RandomAccessFile(in, "r").getChannel());
    }

    public ChunkedNioFile(File in, int chunkSize) throws IOException {
        this(new RandomAccessFile(in, "r").getChannel(), chunkSize);
    }

    public ChunkedNioFile(FileChannel in) throws IOException {
        this(in, 8192);
    }

    public ChunkedNioFile(FileChannel in, int chunkSize) throws IOException {
        this(in, 0, in.size(), chunkSize);
    }

    public ChunkedNioFile(FileChannel in, long offset, long length, int chunkSize) throws IOException {
        ObjectUtil.checkNotNull(in, "in");
        ObjectUtil.checkPositiveOrZero(offset, "offset");
        ObjectUtil.checkPositiveOrZero(length, "length");
        ObjectUtil.checkPositive(chunkSize, "chunkSize");
        if (!in.isOpen()) {
            throw new ClosedChannelException();
        }
        this.f995in = in;
        this.chunkSize = chunkSize;
        this.startOffset = offset;
        this.offset = offset;
        this.endOffset = offset + length;
    }

    public long startOffset() {
        return this.startOffset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    public long currentOffset() {
        return this.offset;
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        return this.offset >= this.endOffset || !this.f995in.isOpen();
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.f995in.close();
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext ctx) throws Exception {
        return readChunk(ctx.alloc());
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator allocator) throws Exception {
        long offset = this.offset;
        if (offset >= this.endOffset) {
            return null;
        }
        int chunkSize = (int) Math.min((long) this.chunkSize, this.endOffset - offset);
        ByteBuf buffer = allocator.buffer(chunkSize);
        boolean release = true;
        int readBytes = 0;
        while (true) {
            try {
                int localReadBytes = buffer.writeBytes(this.f995in, offset + ((long) readBytes), chunkSize - readBytes);
                if (localReadBytes < 0) {
                    break;
                }
                readBytes += localReadBytes;
                if (readBytes == chunkSize) {
                    break;
                }
            } catch (Throwable th) {
                if (release) {
                    buffer.release();
                }
                throw th;
            }
        }
        this.offset += (long) readBytes;
        release = false;
        if (0 != 0) {
            buffer.release();
        }
        return buffer;
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public long length() {
        return this.endOffset - this.startOffset;
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset - this.startOffset;
    }
}
