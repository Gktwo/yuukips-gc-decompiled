package p013io.netty.handler.stream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.stream.ChunkedFile */
/* loaded from: grasscutter.jar:io/netty/handler/stream/ChunkedFile.class */
public class ChunkedFile implements ChunkedInput<ByteBuf> {
    private final RandomAccessFile file;
    private final long startOffset;
    private final long endOffset;
    private final int chunkSize;
    private long offset;

    public ChunkedFile(File file) throws IOException {
        this(file, 8192);
    }

    public ChunkedFile(File file, int chunkSize) throws IOException {
        this(new RandomAccessFile(file, "r"), chunkSize);
    }

    public ChunkedFile(RandomAccessFile file) throws IOException {
        this(file, 8192);
    }

    public ChunkedFile(RandomAccessFile file, int chunkSize) throws IOException {
        this(file, 0, file.length(), chunkSize);
    }

    public ChunkedFile(RandomAccessFile file, long offset, long length, int chunkSize) throws IOException {
        ObjectUtil.checkNotNull(file, Action.FILE_ATTRIBUTE);
        ObjectUtil.checkPositiveOrZero(offset, "offset");
        ObjectUtil.checkPositiveOrZero(length, "length");
        ObjectUtil.checkPositive(chunkSize, "chunkSize");
        this.file = file;
        this.startOffset = offset;
        this.offset = offset;
        this.endOffset = offset + length;
        this.chunkSize = chunkSize;
        file.seek(offset);
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
        return this.offset >= this.endOffset || !this.file.getChannel().isOpen();
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.file.close();
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
        ByteBuf buf = allocator.heapBuffer(chunkSize);
        boolean release = true;
        try {
            this.file.readFully(buf.array(), buf.arrayOffset(), chunkSize);
            buf.writerIndex(chunkSize);
            this.offset = offset + ((long) chunkSize);
            release = false;
            if (0 != 0) {
                buf.release();
            }
            return buf;
        } catch (Throwable th) {
            if (release) {
                buf.release();
            }
            throw th;
        }
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
