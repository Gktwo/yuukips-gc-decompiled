package okhttp3.internal.p021ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebSocketReader.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018��2\u00020\u0001:\u0001&B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001fJ\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n��R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0016\u001a\u00020\rX\u0004¢\u0006\u0002\n��R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n��R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u001c\u0010\u001d¨\u0006'"}, m373d2 = {"Lokhttp3/internal/ws/WebSocketReader;", "Ljava/io/Closeable;", "isClient", "", "source", "Lokio/BufferedSource;", "frameCallback", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "perMessageDeflate", "noContextTakeover", "(ZLokio/BufferedSource;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "closed", "controlFrameBuffer", "Lokio/Buffer;", "frameLength", "", "isControlFrame", "isFinalFrame", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "maskKey", "", "messageFrameBuffer", "messageInflater", "Lokhttp3/internal/ws/MessageInflater;", "opcode", "", "readingCompressedMessage", "getSource", "()Lokio/BufferedSource;", "close", "", "processNextFrame", "readControlFrame", "readHeader", "readMessage", "readMessageFrame", "readUntilNonControlFrame", "FrameCallback", "okhttp"})
/* renamed from: okhttp3.internal.ws.WebSocketReader */
/* loaded from: grasscutter.jar:okhttp3/internal/ws/WebSocketReader.class */
public final class WebSocketReader implements Closeable {
    private final boolean isClient;
    @NotNull
    private final BufferedSource source;
    @NotNull
    private final FrameCallback frameCallback;
    private final boolean perMessageDeflate;
    private final boolean noContextTakeover;
    private boolean closed;
    private int opcode;
    private long frameLength;
    private boolean isFinalFrame;
    private boolean isControlFrame;
    private boolean readingCompressedMessage;
    @NotNull
    private final Buffer controlFrameBuffer = new Buffer();
    @NotNull
    private final Buffer messageFrameBuffer = new Buffer();
    @Nullable
    private MessageInflater messageInflater;
    @Nullable
    private final byte[] maskKey;
    @Nullable
    private final Buffer.UnsafeCursor maskCursor;

    /* compiled from: WebSocketReader.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018��2\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&¨\u0006\u000f"}, m373d2 = {"Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "", "onReadClose", "", "code", "", "reason", "", "onReadMessage", "text", "bytes", "Lokio/ByteString;", "onReadPing", "payload", "onReadPong", "okhttp"})
    /* renamed from: okhttp3.internal.ws.WebSocketReader$FrameCallback */
    /* loaded from: grasscutter.jar:okhttp3/internal/ws/WebSocketReader$FrameCallback.class */
    public interface FrameCallback {
        void onReadMessage(@NotNull String str) throws IOException;

        void onReadMessage(@NotNull ByteString byteString) throws IOException;

        void onReadPing(@NotNull ByteString byteString);

        void onReadPong(@NotNull ByteString byteString);

        void onReadClose(int i, @NotNull String str);
    }

    public WebSocketReader(boolean isClient, @NotNull BufferedSource source, @NotNull FrameCallback frameCallback, boolean perMessageDeflate, boolean noContextTakeover) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(frameCallback, "frameCallback");
        this.isClient = isClient;
        this.source = source;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = perMessageDeflate;
        this.noContextTakeover = noContextTakeover;
        this.maskKey = this.isClient ? null : new byte[4];
        this.maskCursor = this.isClient ? null : new Buffer.UnsafeCursor();
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    private final void readHeader() throws IOException, ProtocolException {
        String str;
        boolean z;
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutBefore = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int b0 = Util.and(this.source.readByte(), 255);
            this.source.timeout().timeout(timeoutBefore, TimeUnit.NANOSECONDS);
            this.opcode = b0 & 15;
            this.isFinalFrame = (b0 & 128) != 0;
            this.isControlFrame = (b0 & 8) != 0;
            if (!this.isControlFrame || this.isFinalFrame) {
                boolean reservedFlag1 = (b0 & 64) != 0;
                switch (this.opcode) {
                    case 1:
                    case 2:
                        if (!reservedFlag1) {
                            z = false;
                        } else if (!this.perMessageDeflate) {
                            throw new ProtocolException("Unexpected rsv1 flag");
                        } else {
                            z = true;
                        }
                        this.readingCompressedMessage = z;
                        break;
                    default:
                        if (reservedFlag1) {
                            throw new ProtocolException("Unexpected rsv1 flag");
                        }
                        break;
                }
                if ((b0 & 32) != 0) {
                    throw new ProtocolException("Unexpected rsv2 flag");
                }
                if ((b0 & 16) != 0) {
                    throw new ProtocolException("Unexpected rsv3 flag");
                }
                int b1 = Util.and(this.source.readByte(), 255);
                boolean isMasked = (b1 & 128) != 0;
                if (isMasked == this.isClient) {
                    if (this.isClient) {
                        str = "Server-sent frames must not be masked.";
                    } else {
                        str = "Client-sent frames must be masked.";
                    }
                    throw new ProtocolException(str);
                }
                this.frameLength = (long) (b1 & 127);
                if (this.frameLength == 126) {
                    this.frameLength = (long) Util.and(this.source.readShort(), 65535);
                } else if (this.frameLength == 127) {
                    this.frameLength = this.source.readLong();
                    if (this.frameLength < 0) {
                        throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                    }
                }
                if (this.isControlFrame && this.frameLength > 125) {
                    throw new ProtocolException("Control frame must be less than 125B.");
                } else if (isMasked) {
                    BufferedSource bufferedSource = this.source;
                    byte[] bArr = this.maskKey;
                    Intrinsics.checkNotNull(bArr);
                    bufferedSource.readFully(bArr);
                }
            } else {
                throw new ProtocolException("Control frames must be final.");
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(timeoutBefore, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void readControlFrame() throws IOException {
        if (this.frameLength > 0) {
            this.source.readFully(this.controlFrameBuffer, this.frameLength);
            if (!this.isClient) {
                Buffer buffer = this.controlFrameBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                Intrinsics.checkNotNull(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(0);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                Intrinsics.checkNotNull(bArr);
                webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                int code = 1005;
                String reason = "";
                long bufferSize = this.controlFrameBuffer.size();
                if (bufferSize == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (bufferSize != 0) {
                    code = this.controlFrameBuffer.readShort();
                    reason = this.controlFrameBuffer.readUtf8();
                    String codeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(code);
                    if (codeExceptionMessage != null) {
                        throw new ProtocolException(codeExceptionMessage);
                    }
                }
                this.frameCallback.onReadClose(code, reason);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new ProtocolException(Intrinsics.stringPlus("Unknown control opcode: ", Util.toHexString(this.opcode)));
        }
    }

    private final void readMessageFrame() throws IOException {
        MessageInflater messageInflater;
        int opcode = this.opcode;
        if (opcode == 1 || opcode == 2) {
            readMessage();
            if (this.readingCompressedMessage) {
                MessageInflater messageInflater2 = this.messageInflater;
                if (messageInflater2 == null) {
                    MessageInflater it = new MessageInflater(this.noContextTakeover);
                    this.messageInflater = it;
                    messageInflater = it;
                } else {
                    messageInflater = messageInflater2;
                }
                messageInflater.inflate(this.messageFrameBuffer);
            }
            if (opcode == 1) {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
            } else {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
            }
        } else {
            throw new ProtocolException(Intrinsics.stringPlus("Unknown opcode: ", Util.toHexString(opcode)));
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            if (this.frameLength > 0) {
                this.source.readFully(this.messageFrameBuffer, this.frameLength);
                if (!this.isClient) {
                    Buffer buffer = this.messageFrameBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    Intrinsics.checkNotNull(unsafeCursor);
                    buffer.readAndWriteUnsafe(unsafeCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    Intrinsics.checkNotNull(bArr);
                    webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    throw new ProtocolException(Intrinsics.stringPlus("Expected continuation opcode. Got: ", Util.toHexString(this.opcode)));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            messageInflater.close();
        }
    }
}
