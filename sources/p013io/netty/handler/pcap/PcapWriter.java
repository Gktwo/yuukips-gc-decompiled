package p013io.netty.handler.pcap;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.pcap.PcapWriter */
/* loaded from: grasscutter.jar:io/netty/handler/pcap/PcapWriter.class */
final class PcapWriter implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PcapWriter.class);
    private final OutputStream outputStream;
    private boolean isClosed;

    /* access modifiers changed from: package-private */
    public PcapWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /* access modifiers changed from: package-private */
    public PcapWriter(OutputStream outputStream, ByteBuf byteBuf) throws IOException {
        this.outputStream = outputStream;
        PcapHeaders.writeGlobalHeader(byteBuf);
        byteBuf.readBytes(outputStream, byteBuf.readableBytes());
    }

    /* access modifiers changed from: package-private */
    public void writePacket(ByteBuf packetHeaderBuf, ByteBuf packet) throws IOException {
        if (this.isClosed) {
            logger.debug("Pcap Write attempted on closed PcapWriter");
        }
        long timestamp = System.currentTimeMillis();
        PcapHeaders.writePacketHeader(packetHeaderBuf, (int) (timestamp / 1000), (int) ((timestamp % 1000) * 1000), packet.readableBytes(), packet.readableBytes());
        packetHeaderBuf.readBytes(this.outputStream, packetHeaderBuf.readableBytes());
        packet.readBytes(this.outputStream, packet.readableBytes());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.isClosed) {
            logger.debug("PcapWriter is already closed");
            return;
        }
        this.isClosed = true;
        this.outputStream.flush();
        this.outputStream.close();
        logger.debug("PcapWriter is now closed");
    }
}
