package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.eclipse.jetty.util.security.Constraint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: Handshake.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��H\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018�� &2\u00020\u0001:\u0001&B9\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b!J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\"J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b#J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\u0017H\u0016R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\fR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078GX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, m373d2 = {"Lokhttp3/Handshake;", "", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "localCertificates", "", "Ljava/security/cert/Certificate;", "peerCertificatesFn", "Lkotlin/Function0;", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "()Lokhttp3/CipherSuite;", "()Ljava/util/List;", "localPrincipal", "Ljava/security/Principal;", "()Ljava/security/Principal;", "peerCertificates", "peerCertificates$delegate", "Lkotlin/Lazy;", "peerPrincipal", "()Lokhttp3/TlsVersion;", "name", "", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "-deprecated_cipherSuite", "equals", "", "other", "hashCode", "", "-deprecated_localCertificates", "-deprecated_localPrincipal", "-deprecated_peerCertificates", "-deprecated_peerPrincipal", "-deprecated_tlsVersion", Printer.TO_STRING, "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/Handshake.class */
public final class Handshake {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final TlsVersion tlsVersion;
    @NotNull
    private final CipherSuite cipherSuite;
    @NotNull
    private final List<Certificate> localCertificates;
    @NotNull
    private final Lazy peerCertificates$delegate;

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @NotNull
    public static final Handshake get(@NotNull SSLSession $this$get) throws IOException {
        return Companion.get($this$get);
    }

    @JvmStatic
    @NotNull
    public static final Handshake get(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> list, @NotNull List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<? extends java.security.cert.Certificate> */
    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> list, @NotNull Function0<? extends List<? extends Certificate>> function0) {
        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
        Intrinsics.checkNotNullParameter(list, "localCertificates");
        Intrinsics.checkNotNullParameter(function0, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = list;
        this.peerCertificates$delegate = LazyKt.lazy(new Function0<List<? extends Certificate>>(function0) { // from class: okhttp3.Handshake$peerCertificates$2
            final /* synthetic */ Function0<List<Certificate>> $peerCertificatesFn;

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function0<? extends java.util.List<? extends java.security.cert.Certificate>> */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: package-private */
            {
                this.$peerCertificatesFn = r4;
            }

            /* Return type fixed from 'java.util.List<java.security.cert.Certificate>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends Certificate> invoke() {
                List<Certificate> list2;
                try {
                    list2 = this.$peerCertificatesFn.invoke();
                } catch (SSLPeerUnverifiedException e) {
                    list2 = CollectionsKt.emptyList();
                }
                return list2;
            }
        });
    }

    @JvmName(name = "tlsVersion")
    @NotNull
    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    @JvmName(name = "cipherSuite")
    @NotNull
    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    @JvmName(name = "localCertificates")
    @NotNull
    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    @JvmName(name = "peerCertificates")
    @NotNull
    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersion", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_tlsVersion")
    @NotNull
    /* renamed from: -deprecated_tlsVersion  reason: not valid java name */
    public final TlsVersion m9192deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuite", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_cipherSuite")
    @NotNull
    /* renamed from: -deprecated_cipherSuite  reason: not valid java name */
    public final CipherSuite m9193deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "peerCertificates", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_peerCertificates")
    @NotNull
    /* renamed from: -deprecated_peerCertificates  reason: not valid java name */
    public final List<Certificate> m9194deprecated_peerCertificates() {
        return peerCertificates();
    }

    @JvmName(name = "peerPrincipal")
    @Nullable
    public final Principal peerPrincipal() {
        Object firstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) peerCertificates());
        X509Certificate x509Certificate = firstOrNull instanceof X509Certificate ? (X509Certificate) firstOrNull : null;
        return x509Certificate == null ? null : x509Certificate.getSubjectX500Principal();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "peerPrincipal", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_peerPrincipal")
    @Nullable
    /* renamed from: -deprecated_peerPrincipal  reason: not valid java name */
    public final Principal m9195deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "localCertificates", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_localCertificates")
    @NotNull
    /* renamed from: -deprecated_localCertificates  reason: not valid java name */
    public final List<Certificate> m9196deprecated_localCertificates() {
        return this.localCertificates;
    }

    @JvmName(name = "localPrincipal")
    @Nullable
    public final Principal localPrincipal() {
        Object firstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) this.localCertificates);
        X509Certificate x509Certificate = firstOrNull instanceof X509Certificate ? (X509Certificate) firstOrNull : null;
        return x509Certificate == null ? null : x509Certificate.getSubjectX500Principal();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "localPrincipal", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_localPrincipal")
    @Nullable
    /* renamed from: -deprecated_localPrincipal  reason: not valid java name */
    public final Principal m9197deprecated_localPrincipal() {
        return localPrincipal();
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof Handshake) && ((Handshake) other).tlsVersion == this.tlsVersion && Intrinsics.areEqual(((Handshake) other).cipherSuite, this.cipherSuite) && Intrinsics.areEqual(((Handshake) other).peerCertificates(), peerCertificates()) && Intrinsics.areEqual(((Handshake) other).localCertificates, this.localCertificates);
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * 17) + this.tlsVersion.hashCode())) + this.cipherSuite.hashCode())) + peerCertificates().hashCode())) + this.localCertificates.hashCode();
    }

    @NotNull
    public String toString() {
        Iterable<Certificate> $this$map$iv = peerCertificates();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Certificate it : $this$map$iv) {
            destination$iv$iv.add(getName(it));
        }
        StringBuilder append = new StringBuilder().append("Handshake{tlsVersion=").append(this.tlsVersion).append(" cipherSuite=").append(this.cipherSuite).append(" peerCertificates=").append(((List) destination$iv$iv).toString()).append(" localCertificates=");
        Iterable<Certificate> $this$map$iv2 = this.localCertificates;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Certificate it2 : $this$map$iv2) {
            destination$iv$iv2.add(getName(it2));
        }
        return append.append((List) destination$iv$iv2).append('}').toString();
    }

    private final String getName(Certificate $this$name) {
        if ($this$name instanceof X509Certificate) {
            return ((X509Certificate) $this$name).getSubjectDN().toString();
        }
        String type = $this$name.getType();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        return type;
    }

    /* compiled from: Handshake.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��:\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\u0011\u0010\u0010\u001a\u00020\u0004*\u00020\u0006H\u0007¢\u0006\u0002\b\u0003J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, m373d2 = {"Lokhttp3/Handshake$Companion;", "", "()V", BeanUtil.PREFIX_GETTER_GET, "Lokhttp3/Handshake;", "sslSession", "Ljavax/net/ssl/SSLSession;", "-deprecated_get", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "peerCertificates", "", "Ljava/security/cert/Certificate;", "localCertificates", "handshake", "toImmutableList", "", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Handshake$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @NotNull
        public final Handshake get(@NotNull SSLSession $this$handshake) throws IOException {
            List peerCertificatesCopy;
            Intrinsics.checkNotNullParameter($this$handshake, "<this>");
            String cipherSuiteString = $this$handshake.getCipherSuite();
            if (cipherSuiteString == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            if (Intrinsics.areEqual(cipherSuiteString, "TLS_NULL_WITH_NULL_NULL") ? true : Intrinsics.areEqual(cipherSuiteString, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException(Intrinsics.stringPlus("cipherSuite == ", cipherSuiteString));
            }
            CipherSuite cipherSuite = CipherSuite.Companion.forJavaName(cipherSuiteString);
            String tlsVersionString = $this$handshake.getProtocol();
            if (tlsVersionString == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            } else if (Intrinsics.areEqual(Constraint.NONE, tlsVersionString)) {
                throw new IOException("tlsVersion == NONE");
            } else {
                TlsVersion tlsVersion = TlsVersion.Companion.forJavaName(tlsVersionString);
                try {
                    peerCertificatesCopy = toImmutableList($this$handshake.getPeerCertificates());
                } catch (SSLPeerUnverifiedException e) {
                    peerCertificatesCopy = CollectionsKt.emptyList();
                }
                return new Handshake(tlsVersion, cipherSuite, toImmutableList($this$handshake.getLocalCertificates()), new Handshake$Companion$handshake$1(peerCertificatesCopy));
            }
        }

        private final List<Certificate> toImmutableList(Certificate[] $this$toImmutableList) {
            if ($this$toImmutableList != null) {
                return Util.immutableListOf(Arrays.copyOf($this$toImmutableList, $this$toImmutableList.length));
            }
            return CollectionsKt.emptyList();
        }

        @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sslSession.handshake()", imports = {}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_get")
        @NotNull
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final Handshake m9199deprecated_get(@NotNull SSLSession sslSession) throws IOException {
            Intrinsics.checkNotNullParameter(sslSession, "sslSession");
            return get(sslSession);
        }

        @JvmStatic
        @NotNull
        public final Handshake get(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> list, @NotNull List<? extends Certificate> list2) {
            Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
            Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
            Intrinsics.checkNotNullParameter(list, "peerCertificates");
            Intrinsics.checkNotNullParameter(list2, "localCertificates");
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(list2), new Handshake$Companion$get$1(Util.toImmutableList(list)));
        }
    }
}
