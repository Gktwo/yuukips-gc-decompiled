package okhttp3;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.netty.handler.ssl.SslProtocols;

/* compiled from: TlsVersion.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n��\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018�� \f2\b\u0012\u0004\u0012\u00020��0\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0006R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, m373d2 = {"Lokhttp3/TlsVersion;", "", "javaName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/TlsVersion.class */
public enum TlsVersion {
    TLS_1_3(SslProtocols.TLS_v1_3),
    TLS_1_2(SslProtocols.TLS_v1_2),
    TLS_1_1(SslProtocols.TLS_v1_1),
    TLS_1_0(SslProtocols.TLS_v1),
    SSL_3_0(SslProtocols.SSL_v3);
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String javaName;

    @JvmStatic
    @NotNull
    public static final TlsVersion forJavaName(@NotNull String javaName) {
        return Companion.forJavaName(javaName);
    }

    TlsVersion(String javaName) {
        this.javaName = javaName;
    }

    @JvmName(name = "javaName")
    @NotNull
    public final String javaName() {
        return this.javaName;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "javaName", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_javaName")
    @NotNull
    /* renamed from: -deprecated_javaName  reason: not valid java name */
    public final String m9299deprecated_javaName() {
        return this.javaName;
    }

    /* compiled from: TlsVersion.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m373d2 = {"Lokhttp3/TlsVersion$Companion;", "", "()V", "forJavaName", "Lokhttp3/TlsVersion;", "javaName", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/TlsVersion$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final TlsVersion forJavaName(@NotNull String javaName) {
            Intrinsics.checkNotNullParameter(javaName, "javaName");
            switch (javaName.hashCode()) {
                case -503070503:
                    if (javaName.equals(SslProtocols.TLS_v1_1)) {
                        return TlsVersion.TLS_1_1;
                    }
                    break;
                case -503070502:
                    if (javaName.equals(SslProtocols.TLS_v1_2)) {
                        return TlsVersion.TLS_1_2;
                    }
                    break;
                case -503070501:
                    if (javaName.equals(SslProtocols.TLS_v1_3)) {
                        return TlsVersion.TLS_1_3;
                    }
                    break;
                case 79201641:
                    if (javaName.equals(SslProtocols.SSL_v3)) {
                        return TlsVersion.SSL_3_0;
                    }
                    break;
                case 79923350:
                    if (javaName.equals(SslProtocols.TLS_v1)) {
                        return TlsVersion.TLS_1_0;
                    }
                    break;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected TLS version: ", javaName));
        }
    }
}
