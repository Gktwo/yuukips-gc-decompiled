package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: StatusLine.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018�� \n2\u00020\u0001:\u0001\nB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u000b"}, m373d2 = {"Lokhttp3/internal/http/StatusLine;", "", "protocol", "Lokhttp3/Protocol;", "code", "", SendMailJob.PROP_MESSAGE, "", "(Lokhttp3/Protocol;ILjava/lang/String;)V", Printer.TO_STRING, "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http/StatusLine.class */
public final class StatusLine {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final Protocol protocol;
    @JvmField
    public final int code;
    @JvmField
    @NotNull
    public final String message;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_CONTINUE = 100;

    public StatusLine(@NotNull Protocol protocol, int code, @NotNull String message) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        this.protocol = protocol;
        this.code = code;
        this.message = message;
    }

    @NotNull
    public String toString() {
        StringBuilder $this$toString_u24lambda_u2d0 = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            $this$toString_u24lambda_u2d0.append("HTTP/1.0");
        } else {
            $this$toString_u24lambda_u2d0.append("HTTP/1.1");
        }
        $this$toString_u24lambda_u2d0.append(' ').append(this.code);
        $this$toString_u24lambda_u2d0.append(' ').append(this.message);
        String sb = $this$toString_u24lambda_u2d0.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    /* compiled from: StatusLine.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u000f"}, m373d2 = {"Lokhttp3/internal/http/StatusLine$Companion;", "", "()V", "HTTP_CONTINUE", "", "HTTP_MISDIRECTED_REQUEST", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", BeanUtil.PREFIX_GETTER_GET, "Lokhttp3/internal/http/StatusLine;", "response", "Lokhttp3/Response;", "parse", "statusLine", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http/StatusLine$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final StatusLine get(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        @NotNull
        public final StatusLine parse(@NotNull String statusLine) throws IOException {
            Protocol protocol;
            int codeStart;
            Protocol protocol2;
            Intrinsics.checkNotNullParameter(statusLine, "statusLine");
            if (StringsKt.startsWith$default(statusLine, "HTTP/1.", false, 2, (Object) null)) {
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
                }
                codeStart = 9;
                switch (statusLine.charAt(7) - '0') {
                    case 0:
                        protocol2 = Protocol.HTTP_1_0;
                        break;
                    case 1:
                        protocol2 = Protocol.HTTP_1_1;
                        break;
                    default:
                        throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
                }
                protocol = protocol2;
            } else if (StringsKt.startsWith$default(statusLine, "ICY ", false, 2, (Object) null)) {
                protocol = Protocol.HTTP_1_0;
                codeStart = 4;
            } else {
                throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
            }
            if (statusLine.length() < codeStart + 3) {
                throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
            }
            try {
                String substring = statusLine.substring(codeStart, codeStart + 3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                int code = Integer.parseInt(substring);
                String message = "";
                if (statusLine.length() > codeStart + 3) {
                    if (statusLine.charAt(codeStart + 3) != ' ') {
                        throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
                    }
                    String substring2 = statusLine.substring(codeStart + 4);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    message = substring2;
                }
                return new StatusLine(protocol, code, message);
            } catch (NumberFormatException e) {
                throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
            }
        }
    }
}
