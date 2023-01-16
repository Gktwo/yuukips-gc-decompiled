package okhttp3.internal.p021ws;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.action.Action;

/* compiled from: WebSocketProtocol.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020$J\u000e\u0010%\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n��R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0015\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0016\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0017\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0018\u001a\u00020\u000fXT¢\u0006\u0002\n��R\u000e\u0010\u0019\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u001a\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u001b\u001a\u00020\u000fXT¢\u0006\u0002\n��¨\u0006&"}, m373d2 = {"Lokhttp3/internal/ws/WebSocketProtocol;", "", "()V", "ACCEPT_MAGIC", "", "B0_FLAG_FIN", "", "B0_FLAG_RSV1", "B0_FLAG_RSV2", "B0_FLAG_RSV3", "B0_MASK_OPCODE", "B1_FLAG_MASK", "B1_MASK_LENGTH", "CLOSE_CLIENT_GOING_AWAY", "CLOSE_MESSAGE_MAX", "", "CLOSE_NO_STATUS_CODE", "OPCODE_BINARY", "OPCODE_CONTINUATION", "OPCODE_CONTROL_CLOSE", "OPCODE_CONTROL_PING", "OPCODE_CONTROL_PONG", "OPCODE_FLAG_CONTROL", "OPCODE_TEXT", "PAYLOAD_BYTE_MAX", "PAYLOAD_LONG", "PAYLOAD_SHORT", "PAYLOAD_SHORT_MAX", "acceptHeader", Action.KEY_ATTRIBUTE, "closeCodeExceptionMessage", "code", "toggleMask", "", "cursor", "Lokio/Buffer$UnsafeCursor;", "", "validateCloseCode", "okhttp"})
/* renamed from: okhttp3.internal.ws.WebSocketProtocol */
/* loaded from: grasscutter.jar:okhttp3/internal/ws/WebSocketProtocol.class */
public final class WebSocketProtocol {
    @NotNull
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    @NotNull
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_TEXT = 1;
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;
    public static final int PAYLOAD_LONG = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final int CLOSE_NO_STATUS_CODE = 1005;

    private WebSocketProtocol() {
    }

    public final void toggleMask(@NotNull Buffer.UnsafeCursor cursor, @NotNull byte[] key) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        int keyIndex = 0;
        int keyLength = key.length;
        do {
            byte[] buffer = cursor.data;
            int i = cursor.start;
            int end = cursor.end;
            if (buffer != null) {
                while (i < end) {
                    int keyIndex2 = keyIndex % keyLength;
                    buffer[i] = (byte) (buffer[i] ^ key[keyIndex2]);
                    i++;
                    keyIndex = keyIndex2 + 1;
                }
            }
        } while (cursor.next() != -1);
    }

    @Nullable
    public final String closeCodeExceptionMessage(int code) {
        if (code < 1000 || code >= 5000) {
            return Intrinsics.stringPlus("Code must be in range [1000,5000): ", Integer.valueOf(code));
        }
        if (!(1004 <= code ? code < 1007 : false)) {
            if (!(1015 <= code ? code < 3000 : false)) {
                return null;
            }
        }
        return "Code " + code + " is reserved and may not be used.";
    }

    public final void validateCloseCode(int code) {
        String message = closeCodeExceptionMessage(code);
        if (!(message == null)) {
            Intrinsics.checkNotNull(message);
            throw new IllegalArgumentException(message.toString());
        }
    }

    @NotNull
    public final String acceptHeader(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return ByteString.Companion.encodeUtf8(Intrinsics.stringPlus(key, ACCEPT_MAGIC)).sha1().base64();
    }
}
