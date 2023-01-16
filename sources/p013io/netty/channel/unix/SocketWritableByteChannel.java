package p013io.netty.channel.unix;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.buffer.Unpooled;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.unix.SocketWritableByteChannel */
/* loaded from: grasscutter.jar:io/netty/channel/unix/SocketWritableByteChannel.class */
public abstract class SocketWritableByteChannel implements WritableByteChannel {

    /* renamed from: fd */
    private final FileDescriptor f991fd;

    protected abstract ByteBufAllocator alloc();

    /* access modifiers changed from: protected */
    public SocketWritableByteChannel(FileDescriptor fd) {
        this.f991fd = (FileDescriptor) ObjectUtil.checkNotNull(fd, "fd");
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer src) throws IOException {
        int written;
        int position = src.position();
        int limit = src.limit();
        if (src.isDirect()) {
            written = this.f991fd.write(src, position, src.limit());
        } else {
            int readableBytes = limit - position;
            ByteBuf buffer = null;
            try {
                if (readableBytes == 0) {
                    buffer = Unpooled.EMPTY_BUFFER;
                } else {
                    ByteBufAllocator alloc = alloc();
                    if (alloc.isDirectBufferPooled()) {
                        buffer = alloc.directBuffer(readableBytes);
                    } else {
                        buffer = ByteBufUtil.threadLocalDirectBuffer();
                        if (buffer == null) {
                            buffer = Unpooled.directBuffer(readableBytes);
                        }
                    }
                }
                buffer.writeBytes(src.duplicate());
                ByteBuffer nioBuffer = buffer.internalNioBuffer(buffer.readerIndex(), readableBytes);
                written = this.f991fd.write(nioBuffer, nioBuffer.position(), nioBuffer.limit());
                if (buffer != null) {
                    buffer.release();
                }
            } catch (Throwable th) {
                if (buffer != null) {
                    buffer.release();
                }
                throw th;
            }
        }
        if (written > 0) {
            src.position(position + written);
        }
        return written;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.f991fd.isOpen();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        this.f991fd.close();
    }
}
