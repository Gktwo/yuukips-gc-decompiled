package okhttp3.internal.p021ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebSocketWriter.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0012\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\b\t\u0018��2\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020!H\u0002J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020!J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020!J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n��R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n��\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0012X\u0004¢\u0006\u0002\n��R\u000e\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u0002\n��¨\u0006*"}, m373d2 = {"Lokhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "isClient", "", "sink", "Lokio/BufferedSink;", "random", "Ljava/util/Random;", "perMessageDeflate", "noContextTakeover", "minimumDeflateSize", "", "(ZLokio/BufferedSink;Ljava/util/Random;ZZJ)V", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "maskKey", "", "messageBuffer", "Lokio/Buffer;", "messageDeflater", "Lokhttp3/internal/ws/MessageDeflater;", "getRandom", "()Ljava/util/Random;", "getSink", "()Lokio/BufferedSink;", "sinkBuffer", "writerClosed", "close", "", "writeClose", "code", "", "reason", "Lokio/ByteString;", "writeControlFrame", "opcode", "payload", "writeMessageFrame", "formatOpcode", "data", "writePing", "writePong", "okhttp"})
/* renamed from: okhttp3.internal.ws.WebSocketWriter */
/* loaded from: grasscutter.jar:okhttp3/internal/ws/WebSocketWriter.class */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    @NotNull
    private final BufferedSink sink;
    @NotNull
    private final Random random;
    private final boolean perMessageDeflate;
    private final boolean noContextTakeover;
    private final long minimumDeflateSize;
    @NotNull
    private final Buffer messageBuffer = new Buffer();
    @NotNull
    private final Buffer sinkBuffer;
    private boolean writerClosed;
    @Nullable
    private MessageDeflater messageDeflater;
    @Nullable
    private final byte[] maskKey;
    @Nullable
    private final Buffer.UnsafeCursor maskCursor;

    public WebSocketWriter(boolean isClient, @NotNull BufferedSink sink, @NotNull Random random, boolean perMessageDeflate, boolean noContextTakeover, long minimumDeflateSize) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(random, "random");
        this.isClient = isClient;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = perMessageDeflate;
        this.noContextTakeover = noContextTakeover;
        this.minimumDeflateSize = minimumDeflateSize;
        this.sinkBuffer = this.sink.getBuffer();
        this.maskKey = this.isClient ? new byte[4] : null;
        this.maskCursor = this.isClient ? new Buffer.UnsafeCursor() : null;
    }

    @NotNull
    public final BufferedSink getSink() {
        return this.sink;
    }

    @NotNull
    public final Random getRandom() {
        return this.random;
    }

    public final void writePing(@NotNull ByteString payload) throws IOException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        writeControlFrame(9, payload);
    }

    public final void writePong(@NotNull ByteString payload) throws IOException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        writeControlFrame(10, payload);
    }

    public final void writeClose(int code, @Nullable ByteString reason) throws IOException {
        ByteString payload = ByteString.EMPTY;
        if (!(code == 0 && reason == null)) {
            if (code != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(code);
            }
            Buffer $this$writeClose_u24lambda_u2d0 = new Buffer();
            $this$writeClose_u24lambda_u2d0.writeShort(code);
            if (reason != null) {
                $this$writeClose_u24lambda_u2d0.write(reason);
            }
            payload = $this$writeClose_u24lambda_u2d0.readByteString();
        }
        try {
            writeControlFrame(8, payload);
            this.writerClosed = true;
        } catch (Throwable th) {
            this.writerClosed = true;
            throw th;
        }
    }

    private final void writeControlFrame(int opcode, ByteString payload) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int length = payload.size();
        if (!(((long) length) <= 125)) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.sinkBuffer.writeByte(128 | opcode);
        if (this.isClient) {
            this.sinkBuffer.writeByte(length | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (length > 0) {
                long payloadStart = this.sinkBuffer.size();
                this.sinkBuffer.write(payload);
                Buffer buffer = this.sinkBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                Intrinsics.checkNotNull(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(payloadStart);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(length);
            this.sinkBuffer.write(payload);
        }
        this.sink.flush();
    }

    public final void writeMessageFrame(int formatOpcode, @NotNull ByteString data) throws IOException {
        MessageDeflater messageDeflater;
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.write(data);
        int b0 = formatOpcode | 128;
        if (this.perMessageDeflate && ((long) data.size()) >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater2 = this.messageDeflater;
            if (messageDeflater2 == null) {
                MessageDeflater it = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = it;
                messageDeflater = it;
            } else {
                messageDeflater = messageDeflater2;
            }
            messageDeflater.deflate(this.messageBuffer);
            b0 |= 64;
        }
        long dataSize = this.messageBuffer.size();
        this.sinkBuffer.writeByte(b0);
        int b1 = 0;
        if (this.isClient) {
            b1 = 0 | 128;
        }
        if (dataSize <= 125) {
            this.sinkBuffer.writeByte(b1 | ((int) dataSize));
        } else if (dataSize <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.writeByte(b1 | 126);
            this.sinkBuffer.writeShort((int) dataSize);
        } else {
            this.sinkBuffer.writeByte(b1 | 127);
            this.sinkBuffer.writeLong(dataSize);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (dataSize > 0) {
                Buffer buffer = this.messageBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                Intrinsics.checkNotNull(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(0);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, dataSize);
        this.sink.emit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }
}
