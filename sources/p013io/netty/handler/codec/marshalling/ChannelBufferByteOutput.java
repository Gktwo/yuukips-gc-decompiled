package p013io.netty.handler.codec.marshalling;

import java.io.IOException;
import org.jboss.marshalling.ByteOutput;
import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.codec.marshalling.ChannelBufferByteOutput */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/ChannelBufferByteOutput.class */
class ChannelBufferByteOutput implements ByteOutput {
    private final ByteBuf buffer;

    /* access modifiers changed from: package-private */
    public ChannelBufferByteOutput(ByteBuf buffer) {
        this.buffer = buffer;
    }

    public void close() throws IOException {
    }

    public void flush() throws IOException {
    }

    public void write(int b) throws IOException {
        this.buffer.writeByte(b);
    }

    public void write(byte[] bytes) throws IOException {
        this.buffer.writeBytes(bytes);
    }

    public void write(byte[] bytes, int srcIndex, int length) throws IOException {
        this.buffer.writeBytes(bytes, srcIndex, length);
    }

    ByteBuf getBuffer() {
        return this.buffer;
    }
}
