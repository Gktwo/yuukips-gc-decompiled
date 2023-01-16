package org.eclipse.jetty.server.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import org.eclipse.jetty.util.BufferUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/resource/SeekableByteChannelRangeWriter.class */
public class SeekableByteChannelRangeWriter implements RangeWriter {
    public static final int NO_PROGRESS_LIMIT = 3;
    private final ChannelSupplier channelSupplier;
    private final int bufSize;
    private final ByteBuffer buffer;
    private SeekableByteChannel channel;
    private long pos;
    private boolean defaultSeekMode;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/resource/SeekableByteChannelRangeWriter$ChannelSupplier.class */
    public interface ChannelSupplier {
        SeekableByteChannel newSeekableByteChannel() throws IOException;
    }

    public SeekableByteChannelRangeWriter(ChannelSupplier channelSupplier) {
        this(null, channelSupplier);
    }

    public SeekableByteChannelRangeWriter(SeekableByteChannel initialChannel, ChannelSupplier channelSupplier) {
        this.defaultSeekMode = true;
        this.channel = initialChannel;
        this.channelSupplier = channelSupplier;
        this.bufSize = 65536;
        this.buffer = BufferUtil.allocate(this.bufSize);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.channel != null) {
            this.channel.close();
        }
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    @Override // org.eclipse.jetty.server.resource.RangeWriter
    public void writeTo(OutputStream outputStream, long skipTo, long length) throws IOException {
        skipTo(skipTo);
        char c = 0;
        while (c < length) {
            BufferUtil.clearToFill(this.buffer);
            this.buffer.limit((int) Math.min((long) this.bufSize, length - c));
            int readLen = this.channel.read(this.buffer);
            BufferUtil.flipToFlush(this.buffer, 0);
            BufferUtil.writeTo(this.buffer, outputStream);
            c += (long) readLen;
            this.pos += (long) readLen;
        }
    }

    private void skipTo(long skipTo) throws IOException {
        if (this.channel == null) {
            this.channel = this.channelSupplier.newSeekableByteChannel();
            this.pos = 0;
        }
        if (this.defaultSeekMode) {
            try {
                if (this.channel.position() != skipTo) {
                    this.channel.position(skipTo);
                    this.pos = skipTo;
                }
            } catch (UnsupportedOperationException e) {
                this.defaultSeekMode = false;
                fallbackSkipTo(skipTo);
            }
        } else {
            fallbackSkipTo(skipTo);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r0v34, types: [long] */
    private void fallbackSkipTo(long skipTo) throws IOException {
        if (skipTo < this.pos) {
            this.channel.close();
            this.channel = this.channelSupplier.newSeekableByteChannel();
            this.pos = 0;
        }
        if (this.pos < skipTo) {
            char c = this.pos;
            int noProgressLoopLimit = 3;
            while (noProgressLoopLimit > 0 && c < skipTo) {
                BufferUtil.clearToFill(this.buffer);
                this.buffer.limit((int) Math.min((long) this.bufSize, skipTo - c));
                long actualSkipped = (long) this.channel.read(this.buffer);
                if (actualSkipped == 0) {
                    noProgressLoopLimit--;
                } else if (actualSkipped > 0) {
                    c += actualSkipped;
                    noProgressLoopLimit = 3;
                } else {
                    throw new IOException("EOF reached before SeekableByteChannel skip destination");
                }
            }
            if (noProgressLoopLimit <= 0) {
                throw new IOException("No progress made to reach SeekableByteChannel skip position " + (skipTo - this.pos));
            }
            this.pos = skipTo;
        }
    }
}
