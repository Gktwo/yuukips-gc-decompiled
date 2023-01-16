package p013io.netty.handler.stream;

import java.io.InputStream;
import java.io.PushbackInputStream;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.stream.ChunkedStream */
/* loaded from: grasscutter.jar:io/netty/handler/stream/ChunkedStream.class */
public class ChunkedStream implements ChunkedInput<ByteBuf> {
    static final int DEFAULT_CHUNK_SIZE = 8192;

    /* renamed from: in */
    private final PushbackInputStream f1033in;
    private final int chunkSize;
    private long offset;
    private boolean closed;

    public ChunkedStream(InputStream in) {
        this(in, 8192);
    }

    public ChunkedStream(InputStream in, int chunkSize) {
        ObjectUtil.checkNotNull(in, "in");
        ObjectUtil.checkPositive(chunkSize, "chunkSize");
        if (in instanceof PushbackInputStream) {
            this.f1033in = (PushbackInputStream) in;
        } else {
            this.f1033in = new PushbackInputStream(in);
        }
        this.chunkSize = chunkSize;
    }

    public long transferredBytes() {
        return this.offset;
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        if (this.closed) {
            return true;
        }
        if (this.f1033in.available() > 0) {
            return false;
        }
        int b = this.f1033in.read();
        if (b < 0) {
            return true;
        }
        this.f1033in.unread(b);
        return false;
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.closed = true;
        this.f1033in.close();
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext ctx) throws Exception {
        return readChunk(ctx.alloc());
    }

    @Override // p013io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator allocator) throws Exception {
        int chunkSize;
        if (isEndOfInput()) {
            return null;
        }
        if (this.f1033in.available() <= 0) {
            chunkSize = this.chunkSize;
        } else {
            chunkSize = Math.min(this.chunkSize, this.f1033in.available());
        }
        boolean release = true;
        ByteBuf buffer = allocator.buffer(chunkSize);
        try {
            int written = buffer.writeBytes(this.f1033in, chunkSize);
            if (written < 0) {
                return null;
            }
            this.offset += (long) written;
            release = false;
            if (0 != 0) {
                buffer.release();
            }
            return buffer;
        } finally {
            if (release) {
                buffer.release();
            }
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
