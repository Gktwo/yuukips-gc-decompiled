package p013io.netty.channel.oio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.WritableByteChannel;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.Channel;
import p013io.netty.channel.FileRegion;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.util.internal.ObjectUtil;

@Deprecated
/* renamed from: io.netty.channel.oio.OioByteStreamChannel */
/* loaded from: grasscutter.jar:io/netty/channel/oio/OioByteStreamChannel.class */
public abstract class OioByteStreamChannel extends AbstractOioByteChannel {
    private static final InputStream CLOSED_IN = new InputStream() { // from class: io.netty.channel.oio.OioByteStreamChannel.1
        @Override // java.io.InputStream
        public int read() {
            return -1;
        }
    };
    private static final OutputStream CLOSED_OUT = new OutputStream() { // from class: io.netty.channel.oio.OioByteStreamChannel.2
        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            throw new ClosedChannelException();
        }
    };

    /* renamed from: is */
    private InputStream f951is;

    /* renamed from: os */
    private OutputStream f952os;
    private WritableByteChannel outChannel;

    /* access modifiers changed from: protected */
    public OioByteStreamChannel(Channel parent) {
        super(parent);
    }

    protected final void activate(InputStream is, OutputStream os) {
        if (this.f951is != null) {
            throw new IllegalStateException("input was set already");
        } else if (this.f952os != null) {
            throw new IllegalStateException("output was set already");
        } else {
            this.f951is = (InputStream) ObjectUtil.checkNotNull(is, BeanUtil.PREFIX_GETTER_IS);
            this.f952os = (OutputStream) ObjectUtil.checkNotNull(os, "os");
            if (this.readWhenInactive) {
                eventLoop().execute(this.readTask);
                this.readWhenInactive = false;
            }
        }
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        OutputStream os;
        InputStream is = this.f951is;
        return (is == null || is == CLOSED_IN || (os = this.f952os) == null || os == CLOSED_OUT) ? false : true;
    }

    @Override // p013io.netty.channel.oio.AbstractOioByteChannel
    protected int available() {
        try {
            return this.f951is.available();
        } catch (IOException e) {
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.oio.AbstractOioByteChannel
    public int doReadBytes(ByteBuf buf) throws Exception {
        RecvByteBufAllocator.Handle allocHandle = unsafe().recvBufAllocHandle();
        allocHandle.attemptedBytesRead(Math.max(1, Math.min(available(), buf.maxWritableBytes())));
        return buf.writeBytes(this.f951is, allocHandle.attemptedBytesRead());
    }

    @Override // p013io.netty.channel.oio.AbstractOioByteChannel
    protected void doWriteBytes(ByteBuf buf) throws Exception {
        OutputStream os = this.f952os;
        if (os == null) {
            throw new NotYetConnectedException();
        }
        buf.readBytes(os, buf.readableBytes());
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    @Override // p013io.netty.channel.oio.AbstractOioByteChannel
    protected void doWriteFileRegion(FileRegion region) throws Exception {
        OutputStream os = this.f952os;
        if (os == null) {
            throw new NotYetConnectedException();
        }
        if (this.outChannel == null) {
            this.outChannel = Channels.newChannel(os);
        }
        char c = 0;
        do {
            long localWritten = region.transferTo(this.outChannel, c);
            if (localWritten == -1) {
                checkEOF(region);
                return;
            }
            c += localWritten;
        } while (c < region.count());
    }

    private static void checkEOF(FileRegion region) throws IOException {
        if (region.transferred() < region.count()) {
            throw new EOFException("Expected to be able to write " + region.count() + " bytes, but only wrote " + region.transferred());
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        InputStream is = this.f951is;
        OutputStream os = this.f952os;
        this.f951is = CLOSED_IN;
        this.f952os = CLOSED_OUT;
        if (is != null) {
            try {
                is.close();
            } catch (Throwable th) {
                if (os != null) {
                    os.close();
                }
                throw th;
            }
        }
        if (os != null) {
            os.close();
        }
    }
}
