package okhttp3;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: ConnectionSpec.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��F\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018�� $2\u00020\u0001:\u0002#$B7\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H��¢\u0006\u0002\b\u0017J\u0015\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007¢\u0006\u0002\b\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0015J\u0018\u0010\u001f\u001a\u00020��2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b J\u0015\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bH\u0007¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\rR\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\u000fR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006%"}, m373d2 = {"Lokhttp3/ConnectionSpec;", "", "isTls", "", "supportsTlsExtensions", "cipherSuitesAsString", "", "", "tlsVersionsAsString", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "cipherSuites", "", "Lokhttp3/CipherSuite;", "()Ljava/util/List;", "[Ljava/lang/String;", "()Z", "tlsVersions", "Lokhttp3/TlsVersion;", "apply", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "apply$okhttp", "-deprecated_cipherSuites", "equals", "other", "hashCode", "", "isCompatible", "socket", "supportedSpec", "-deprecated_supportsTlsExtensions", "-deprecated_tlsVersions", Printer.TO_STRING, "Builder", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/ConnectionSpec.class */
public final class ConnectionSpec {
    private final boolean isTls;
    private final boolean supportsTlsExtensions;
    @Nullable
    private final String[] cipherSuitesAsString;
    @Nullable
    private final String[] tlsVersionsAsString;
    @JvmField
    @NotNull
    public static final ConnectionSpec RESTRICTED_TLS;
    @JvmField
    @NotNull
    public static final ConnectionSpec MODERN_TLS;
    @JvmField
    @NotNull
    public static final ConnectionSpec COMPATIBLE_TLS;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final CipherSuite[] RESTRICTED_CIPHER_SUITES = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};
    @NotNull
    private static final CipherSuite[] APPROVED_CIPHER_SUITES = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    @JvmField
    @NotNull
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();

    public ConnectionSpec(boolean isTls, boolean supportsTlsExtensions, @Nullable String[] cipherSuitesAsString, @Nullable String[] tlsVersionsAsString) {
        this.isTls = isTls;
        this.supportsTlsExtensions = supportsTlsExtensions;
        this.cipherSuitesAsString = cipherSuitesAsString;
        this.tlsVersionsAsString = tlsVersionsAsString;
    }

    @JvmName(name = "isTls")
    public final boolean isTls() {
        return this.isTls;
    }

    @JvmName(name = "supportsTlsExtensions")
    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    @JvmName(name = "cipherSuites")
    @Nullable
    public final List<CipherSuite> cipherSuites() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr == null) {
            return null;
        }
        Collection destination$iv$iv = new ArrayList(strArr.length);
        for (String str : strArr) {
            destination$iv$iv.add(CipherSuite.Companion.forJavaName(str));
        }
        return CollectionsKt.toList((List) destination$iv$iv);
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuites", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_cipherSuites")
    @Nullable
    /* renamed from: -deprecated_cipherSuites  reason: not valid java name */
    public final List<CipherSuite> m9172deprecated_cipherSuites() {
        return cipherSuites();
    }

    @JvmName(name = "tlsVersions")
    @Nullable
    public final List<TlsVersion> tlsVersions() {
        String[] strArr = this.tlsVersionsAsString;
        if (strArr == null) {
            return null;
        }
        Collection destination$iv$iv = new ArrayList(strArr.length);
        for (String str : strArr) {
            destination$iv$iv.add(TlsVersion.Companion.forJavaName(str));
        }
        return CollectionsKt.toList((List) destination$iv$iv);
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersions", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_tlsVersions")
    @Nullable
    /* renamed from: -deprecated_tlsVersions  reason: not valid java name */
    public final List<TlsVersion> m9173deprecated_tlsVersions() {
        return tlsVersions();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "supportsTlsExtensions", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_supportsTlsExtensions")
    /* renamed from: -deprecated_supportsTlsExtensions  reason: not valid java name */
    public final boolean m9174deprecated_supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public final void apply$okhttp(@NotNull SSLSocket sslSocket, boolean isFallback) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        ConnectionSpec specToApply = supportedSpec(sslSocket, isFallback);
        if (specToApply.tlsVersions() != null) {
            sslSocket.setEnabledProtocols(specToApply.tlsVersionsAsString);
        }
        if (specToApply.cipherSuites() != null) {
            sslSocket.setEnabledCipherSuites(specToApply.cipherSuitesAsString);
        }
    }

    private final ConnectionSpec supportedSpec(SSLSocket sslSocket, boolean isFallback) {
        String[] strArr;
        String[] tlsVersionsIntersection;
        if (this.cipherSuitesAsString != null) {
            String[] enabledCipherSuites = sslSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            strArr = Util.intersect(enabledCipherSuites, this.cipherSuitesAsString, CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        } else {
            strArr = sslSocket.getEnabledCipherSuites();
        }
        String[] cipherSuitesIntersection = strArr;
        if (this.tlsVersionsAsString != null) {
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = Util.intersect(enabledProtocols, this.tlsVersionsAsString, ComparisonsKt.naturalOrder());
        } else {
            tlsVersionsIntersection = sslSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "supportedCipherSuites");
        int indexOfFallbackScsv = Util.indexOf(supportedCipherSuites, "TLS_FALLBACK_SCSV", CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        if (isFallback && indexOfFallbackScsv != -1) {
            Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[indexOfFallbackScsv];
            Intrinsics.checkNotNullExpressionValue(str, "supportedCipherSuites[indexOfFallbackScsv]");
            cipherSuitesIntersection = Util.concat(cipherSuitesIntersection, str);
        }
        Builder builder = new Builder(this);
        Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
        Builder cipherSuites = builder.cipherSuites((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        return cipherSuites.tlsVersions((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).build();
    }

    public final boolean isCompatible(@NotNull SSLSocket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.isTls) {
            return false;
        }
        if (this.tlsVersionsAsString != null && !Util.hasIntersection(this.tlsVersionsAsString, socket.getEnabledProtocols(), ComparisonsKt.naturalOrder())) {
            return false;
        }
        if (this.cipherSuitesAsString == null || Util.hasIntersection(this.cipherSuitesAsString, socket.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp())) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof ConnectionSpec)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (this.isTls != ((ConnectionSpec) other).isTls) {
            return false;
        }
        if (this.isTls) {
            return Arrays.equals(this.cipherSuitesAsString, ((ConnectionSpec) other).cipherSuitesAsString) && Arrays.equals(this.tlsVersionsAsString, ((ConnectionSpec) other).tlsVersionsAsString) && this.supportsTlsExtensions == ((ConnectionSpec) other).supportsTlsExtensions;
        }
        return true;
    }

    public int hashCode() {
        int result = 17;
        if (this.isTls) {
            int i = 31 * 17;
            String[] strArr = this.cipherSuitesAsString;
            int hashCode = 31 * (i + (strArr == null ? 0 : Arrays.hashCode(strArr)));
            String[] strArr2 = this.tlsVersionsAsString;
            result = (31 * (hashCode + (strArr2 == null ? 0 : Arrays.hashCode(strArr2)))) + (this.supportsTlsExtensions ? 0 : 1);
        }
        return result;
    }

    @NotNull
    public String toString() {
        return !this.isTls ? "ConnectionSpec()" : "ConnectionSpec(cipherSuites=" + ((Object) Objects.toString(cipherSuites(), "[all enabled]")) + ", tlsVersions=" + ((Object) Objects.toString(tlsVersions(), "[all enabled]")) + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }

    /* compiled from: ConnectionSpec.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0019\u001a\u00020��J\u0006\u0010\u001a\u001a\u00020��J\u0006\u0010\u001b\u001a\u00020\u0006J\u001f\u0010\b\u001a\u00020��2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u001cJ\u001f\u0010\b\u001a\u00020��2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\t\"\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u0010\u001a\u00020��2\u0006\u0010\u0010\u001a\u00020\u0003H\u0007J\u001f\u0010\u0016\u001a\u00020��2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u0016\u001a\u00020��2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\t\"\u00020\u001f¢\u0006\u0002\u0010 R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0004R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006!"}, m373d2 = {"Lokhttp3/ConnectionSpec$Builder;", "", "tls", "", "(Z)V", "connectionSpec", "Lokhttp3/ConnectionSpec;", "(Lokhttp3/ConnectionSpec;)V", "cipherSuites", "", "", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "supportsTlsExtensions", "getSupportsTlsExtensions$okhttp", "()Z", "setSupportsTlsExtensions$okhttp", "getTls$okhttp", "setTls$okhttp", "tlsVersions", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "allEnabledCipherSuites", "allEnabledTlsVersions", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/CipherSuite;", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/TlsVersion;", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/ConnectionSpec$Builder.class */
    public static final class Builder {
        private boolean tls;
        @Nullable
        private String[] cipherSuites;
        @Nullable
        private String[] tlsVersions;
        private boolean supportsTlsExtensions;

        public final boolean getTls$okhttp() {
            return this.tls;
        }

        public final void setTls$okhttp(boolean z) {
            this.tls = z;
        }

        @Nullable
        public final String[] getCipherSuites$okhttp() {
            return this.cipherSuites;
        }

        public final void setCipherSuites$okhttp(@Nullable String[] strArr) {
            this.cipherSuites = strArr;
        }

        @Nullable
        public final String[] getTlsVersions$okhttp() {
            return this.tlsVersions;
        }

        public final void setTlsVersions$okhttp(@Nullable String[] strArr) {
            this.tlsVersions = strArr;
        }

        public final boolean getSupportsTlsExtensions$okhttp() {
            return this.supportsTlsExtensions;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean z) {
            this.supportsTlsExtensions = z;
        }

        public Builder(boolean tls) {
            this.tls = tls;
        }

        public Builder(@NotNull ConnectionSpec connectionSpec) {
            Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
            this.tls = connectionSpec.isTls();
            this.cipherSuites = connectionSpec.cipherSuitesAsString;
            this.tlsVersions = connectionSpec.tlsVersionsAsString;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions();
        }

        @NotNull
        public final Builder allEnabledCipherSuites() {
            Builder $this$allEnabledCipherSuites_u24lambda_u2d1 = this;
            if (!$this$allEnabledCipherSuites_u24lambda_u2d1.getTls$okhttp()) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            $this$allEnabledCipherSuites_u24lambda_u2d1.setCipherSuites$okhttp(null);
            return this;
        }

        @NotNull
        public final Builder cipherSuites(@NotNull CipherSuite... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            Builder $this$cipherSuites_u24lambda_u2d4 = this;
            if (!$this$cipherSuites_u24lambda_u2d4.getTls$okhttp()) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            Collection destination$iv$iv = new ArrayList(cipherSuites.length);
            for (CipherSuite cipherSuite : cipherSuites) {
                destination$iv$iv.add(cipherSuite.javaName());
            }
            Object[] array = ((List) destination$iv$iv).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            String[] strings = (String[]) array;
            return $this$cipherSuites_u24lambda_u2d4.cipherSuites((String[]) Arrays.copyOf(strings, strings.length));
        }

        @NotNull
        public final Builder cipherSuites(@NotNull String... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            Builder $this$cipherSuites_u24lambda_u2d7 = this;
            if (!$this$cipherSuites_u24lambda_u2d7.getTls$okhttp()) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(cipherSuites.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            $this$cipherSuites_u24lambda_u2d7.setCipherSuites$okhttp((String[]) cipherSuites.clone());
            return this;
        }

        @NotNull
        public final Builder allEnabledTlsVersions() {
            Builder $this$allEnabledTlsVersions_u24lambda_u2d9 = this;
            if (!$this$allEnabledTlsVersions_u24lambda_u2d9.getTls$okhttp()) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            $this$allEnabledTlsVersions_u24lambda_u2d9.setTlsVersions$okhttp(null);
            return this;
        }

        @NotNull
        public final Builder tlsVersions(@NotNull TlsVersion... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            Builder $this$tlsVersions_u24lambda_u2d12 = this;
            if (!$this$tlsVersions_u24lambda_u2d12.getTls$okhttp()) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            Collection destination$iv$iv = new ArrayList(tlsVersions.length);
            for (TlsVersion tlsVersion : tlsVersions) {
                destination$iv$iv.add(tlsVersion.javaName());
            }
            Object[] array = ((List) destination$iv$iv).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            String[] strings = (String[]) array;
            return $this$tlsVersions_u24lambda_u2d12.tlsVersions((String[]) Arrays.copyOf(strings, strings.length));
        }

        @NotNull
        public final Builder tlsVersions(@NotNull String... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            Builder $this$tlsVersions_u24lambda_u2d15 = this;
            if (!$this$tlsVersions_u24lambda_u2d15.getTls$okhttp()) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(tlsVersions.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            $this$tlsVersions_u24lambda_u2d15.setTlsVersions$okhttp((String[]) tlsVersions.clone());
            return this;
        }

        @Deprecated(message = "since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        @NotNull
        public final Builder supportsTlsExtensions(boolean supportsTlsExtensions) {
            Builder $this$supportsTlsExtensions_u24lambda_u2d17 = this;
            if (!$this$supportsTlsExtensions_u24lambda_u2d17.getTls$okhttp()) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            $this$supportsTlsExtensions_u24lambda_u2d17.setSupportsTlsExtensions$okhttp(supportsTlsExtensions);
            return this;
        }

        @NotNull
        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }
    }

    /* compiled from: ConnectionSpec.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\n\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n��R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\f\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n��¨\u0006\r"}, m373d2 = {"Lokhttp3/ConnectionSpec$Companion;", "", "()V", "APPROVED_CIPHER_SUITES", "", "Lokhttp3/CipherSuite;", "[Lokhttp3/CipherSuite;", "CLEARTEXT", "Lokhttp3/ConnectionSpec;", "COMPATIBLE_TLS", "MODERN_TLS", "RESTRICTED_CIPHER_SUITES", "RESTRICTED_TLS", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/ConnectionSpec$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Builder builder = new Builder(true);
        CipherSuite[] cipherSuiteArr = RESTRICTED_CIPHER_SUITES;
        RESTRICTED_TLS = builder.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, cipherSuiteArr.length)).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
        Builder builder2 = new Builder(true);
        CipherSuite[] cipherSuiteArr2 = APPROVED_CIPHER_SUITES;
        MODERN_TLS = builder2.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length)).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
        Builder builder3 = new Builder(true);
        CipherSuite[] cipherSuiteArr3 = APPROVED_CIPHER_SUITES;
        COMPATIBLE_TLS = builder3.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr3, cipherSuiteArr3.length)).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    }
}
