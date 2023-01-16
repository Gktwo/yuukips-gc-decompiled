package okhttp3.internal.p021ws;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: WebSocketExtensions.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018�� \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003JN\u0010\u0013\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u001d"}, m373d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "noContextTakeover", "clientOriginated", Printer.TO_STRING, "", "Companion", "okhttp"})
/* renamed from: okhttp3.internal.ws.WebSocketExtensions */
/* loaded from: grasscutter.jar:okhttp3/internal/ws/WebSocketExtensions.class */
public final class WebSocketExtensions {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    public final boolean perMessageDeflate;
    @JvmField
    @Nullable
    public final Integer clientMaxWindowBits;
    @JvmField
    public final boolean clientNoContextTakeover;
    @JvmField
    @Nullable
    public final Integer serverMaxWindowBits;
    @JvmField
    public final boolean serverNoContextTakeover;
    @JvmField
    public final boolean unknownValues;
    @NotNull
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    @Nullable
    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    @Nullable
    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    @NotNull
    public final WebSocketExtensions copy(boolean perMessageDeflate, @Nullable Integer clientMaxWindowBits, boolean clientNoContextTakeover, @Nullable Integer serverMaxWindowBits, boolean serverNoContextTakeover, boolean unknownValues) {
        return new WebSocketExtensions(perMessageDeflate, clientMaxWindowBits, clientNoContextTakeover, serverMaxWindowBits, serverNoContextTakeover, unknownValues);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webSocketExtensions.perMessageDeflate;
        }
        if ((i & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        if ((i & 4) != 0) {
            z2 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((i & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((i & 16) != 0) {
            z3 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((i & 32) != 0) {
            z4 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z, num, z2, num2, z3, z4);
    }

    @NotNull
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public int hashCode() {
        boolean z = this.perMessageDeflate;
        if (z) {
            z = true;
        }
        int result = z ? 1 : 0;
        int result2 = z ? 1 : 0;
        int result3 = z ? 1 : 0;
        int hashCode = ((result * 31) + (this.clientMaxWindowBits == null ? 0 : this.clientMaxWindowBits.hashCode())) * 31;
        boolean z2 = this.clientNoContextTakeover;
        if (z2) {
            z2 = true;
        }
        int i = z2 ? 1 : 0;
        int i2 = z2 ? 1 : 0;
        int i3 = z2 ? 1 : 0;
        int hashCode2 = (((hashCode + i) * 31) + (this.serverMaxWindowBits == null ? 0 : this.serverMaxWindowBits.hashCode())) * 31;
        boolean z3 = this.serverNoContextTakeover;
        if (z3) {
            z3 = true;
        }
        int i4 = z3 ? 1 : 0;
        int i5 = z3 ? 1 : 0;
        int i6 = z3 ? 1 : 0;
        int i7 = (hashCode2 + i4) * 31;
        boolean z4 = this.unknownValues;
        if (z4) {
            z4 = true;
        }
        int i8 = z4 ? 1 : 0;
        int i9 = z4 ? 1 : 0;
        int i10 = z4 ? 1 : 0;
        return i7 + i8;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) other;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.areEqual(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.areEqual(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public WebSocketExtensions(boolean perMessageDeflate, @Nullable Integer clientMaxWindowBits, boolean clientNoContextTakeover, @Nullable Integer serverMaxWindowBits, boolean serverNoContextTakeover, boolean unknownValues) {
        this.perMessageDeflate = perMessageDeflate;
        this.clientMaxWindowBits = clientMaxWindowBits;
        this.clientNoContextTakeover = clientNoContextTakeover;
        this.serverMaxWindowBits = serverMaxWindowBits;
        this.serverNoContextTakeover = serverNoContextTakeover;
        this.unknownValues = unknownValues;
    }

    public /* synthetic */ WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
    }

    public final boolean noContextTakeover(boolean clientOriginated) {
        if (clientOriginated) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    /* compiled from: WebSocketExtensions.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\t"}, m373d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"})
    /* renamed from: okhttp3.internal.ws.WebSocketExtensions$Companion */
    /* loaded from: grasscutter.jar:okhttp3/internal/ws/WebSocketExtensions$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final WebSocketExtensions parse(@NotNull Headers responseHeaders) throws IOException {
            String value;
            Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
            boolean compressionEnabled = false;
            Integer clientMaxWindowBits = null;
            boolean clientNoContextTakeover = false;
            Integer serverMaxWindowBits = null;
            boolean serverNoContextTakeover = false;
            boolean unexpectedValues = false;
            int i = 0;
            int size = responseHeaders.size();
            while (i < size) {
                i++;
                if (StringsKt.equals(responseHeaders.name(i), "Sec-WebSocket-Extensions", true)) {
                    String header = responseHeaders.value(i);
                    int pos = 0;
                    while (pos < header.length()) {
                        int extensionEnd = Util.delimiterOffset$default(header, ',', pos, 0, 4, (Object) null);
                        int extensionTokenEnd = Util.delimiterOffset(header, ';', pos, extensionEnd);
                        String extensionToken = Util.trimSubstring(header, pos, extensionTokenEnd);
                        pos = extensionTokenEnd + 1;
                        if (StringsKt.equals(extensionToken, "permessage-deflate", true)) {
                            if (compressionEnabled) {
                                unexpectedValues = true;
                            }
                            compressionEnabled = true;
                            while (pos < extensionEnd) {
                                int parameterEnd = Util.delimiterOffset(header, ';', pos, extensionEnd);
                                int equals = Util.delimiterOffset(header, '=', pos, parameterEnd);
                                String name = Util.trimSubstring(header, pos, equals);
                                if (equals < parameterEnd) {
                                    value = StringsKt.removeSurrounding(Util.trimSubstring(header, equals + 1, parameterEnd), (CharSequence) "\"");
                                } else {
                                    value = null;
                                }
                                pos = parameterEnd + 1;
                                if (StringsKt.equals(name, "client_max_window_bits", true)) {
                                    if (clientMaxWindowBits != null) {
                                        unexpectedValues = true;
                                    }
                                    clientMaxWindowBits = value == null ? null : StringsKt.toIntOrNull(value);
                                    if (clientMaxWindowBits == null) {
                                        unexpectedValues = true;
                                    }
                                } else if (StringsKt.equals(name, "client_no_context_takeover", true)) {
                                    if (clientNoContextTakeover) {
                                        unexpectedValues = true;
                                    }
                                    if (value != null) {
                                        unexpectedValues = true;
                                    }
                                    clientNoContextTakeover = true;
                                } else if (StringsKt.equals(name, "server_max_window_bits", true)) {
                                    if (serverMaxWindowBits != null) {
                                        unexpectedValues = true;
                                    }
                                    serverMaxWindowBits = value == null ? null : StringsKt.toIntOrNull(value);
                                    if (serverMaxWindowBits == null) {
                                        unexpectedValues = true;
                                    }
                                } else if (StringsKt.equals(name, "server_no_context_takeover", true)) {
                                    if (serverNoContextTakeover) {
                                        unexpectedValues = true;
                                    }
                                    if (value != null) {
                                        unexpectedValues = true;
                                    }
                                    serverNoContextTakeover = true;
                                } else {
                                    unexpectedValues = true;
                                }
                            }
                        } else {
                            unexpectedValues = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(compressionEnabled, clientMaxWindowBits, clientNoContextTakeover, serverMaxWindowBits, serverNoContextTakeover, unexpectedValues);
        }
    }
}
