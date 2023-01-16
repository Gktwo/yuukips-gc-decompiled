package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p013io.netty.handler.ssl.ApplicationProtocolNames;

/* compiled from: Protocol.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n��\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018�� \f2\b\u0012\u0004\u0012\u00020��0\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, m373d2 = {"Lokhttp3/Protocol;", "", "protocol", "", "(Ljava/lang/String;ILjava/lang/String;)V", Printer.TO_STRING, "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/Protocol.class */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1(ApplicationProtocolNames.HTTP_1_1),
    SPDY_3(ApplicationProtocolNames.SPDY_3_1),
    HTTP_2(ApplicationProtocolNames.HTTP_2),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String protocol;

    @JvmStatic
    @NotNull
    public static final Protocol get(@NotNull String protocol) throws IOException {
        return Companion.get(protocol);
    }

    Protocol(String protocol) {
        this.protocol = protocol;
    }

    @Override // java.lang.Enum, java.lang.Object
    @NotNull
    public String toString() {
        return this.protocol;
    }

    /* compiled from: Protocol.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m373d2 = {"Lokhttp3/Protocol$Companion;", "", "()V", BeanUtil.PREFIX_GETTER_GET, "Lokhttp3/Protocol;", "protocol", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Protocol$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Protocol get(@NotNull String protocol) throws IOException {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            if (Intrinsics.areEqual(protocol, Protocol.HTTP_1_0.protocol)) {
                return Protocol.HTTP_1_0;
            }
            if (Intrinsics.areEqual(protocol, Protocol.HTTP_1_1.protocol)) {
                return Protocol.HTTP_1_1;
            }
            if (Intrinsics.areEqual(protocol, Protocol.H2_PRIOR_KNOWLEDGE.protocol)) {
                return Protocol.H2_PRIOR_KNOWLEDGE;
            }
            if (Intrinsics.areEqual(protocol, Protocol.HTTP_2.protocol)) {
                return Protocol.HTTP_2;
            }
            if (Intrinsics.areEqual(protocol, Protocol.SPDY_3.protocol)) {
                return Protocol.SPDY_3;
            }
            if (Intrinsics.areEqual(protocol, Protocol.QUIC.protocol)) {
                return Protocol.QUIC;
            }
            throw new IOException(Intrinsics.stringPlus("Unexpected protocol: ", protocol));
        }
    }
}
