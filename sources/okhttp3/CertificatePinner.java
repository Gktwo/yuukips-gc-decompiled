package okhttp3;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.hostnames;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p013io.javalin.http.sse.EmitterKt;

/* compiled from: CertificatePinner.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��T\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\"\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018�� \"2\u00020\u0001:\u0003!\"#B!\b��\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H��¢\u0006\u0002\b\u0014J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020��2\u0006\u0010\u0005\u001a\u00020\u0006H��¢\u0006\u0002\b R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n��\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, m373d2 = {"Lokhttp3/CertificatePinner;", "", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "getPins", "()Ljava/util/Set;", "check", "", "hostname", "", "cleanedPeerCertificatesFn", "Lkotlin/Function0;", "", "Ljava/security/cert/X509Certificate;", "check$okhttp", "peerCertificates", "", "Ljava/security/cert/Certificate;", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "equals", "", "other", "findMatchingPins", "hashCode", "", "withCertificateChainCleaner", "withCertificateChainCleaner$okhttp", "Builder", "Companion", "Pin", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/CertificatePinner.class */
public final class CertificatePinner {
    @NotNull
    private final Set<Pin> pins;
    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final CertificatePinner DEFAULT = new Builder().build();

    @JvmStatic
    @NotNull
    public static final ByteString sha1Hash(@NotNull X509Certificate $this$sha1Hash) {
        return Companion.sha1Hash($this$sha1Hash);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha256Hash(@NotNull X509Certificate $this$sha256Hash) {
        return Companion.sha256Hash($this$sha256Hash);
    }

    @JvmStatic
    @NotNull
    public static final String pin(@NotNull Certificate certificate) {
        return Companion.pin(certificate);
    }

    public CertificatePinner(@NotNull Set<Pin> set, @Nullable CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i & 2) != 0 ? null : certificateChainCleaner);
    }

    @NotNull
    public final Set<Pin> getPins() {
        return this.pins;
    }

    @Nullable
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final void check(@NotNull String hostname, @NotNull List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(list, "peerCertificates");
        check$okhttp(hostname, new Function0<List<? extends X509Certificate>>(this, list, hostname) { // from class: okhttp3.CertificatePinner$check$1
            final /* synthetic */ CertificatePinner this$0;
            final /* synthetic */ List<Certificate> $peerCertificates;
            final /* synthetic */ String $hostname;

            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends java.security.cert.Certificate> */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
                this.$peerCertificates = r5;
                this.$hostname = $hostname;
            }

            /* Return type fixed from 'java.util.List<java.security.cert.X509Certificate>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends X509Certificate> invoke() {
                CertificateChainCleaner certificateChainCleaner$okhttp = this.this$0.getCertificateChainCleaner$okhttp();
                Iterable clean = certificateChainCleaner$okhttp == null ? null : certificateChainCleaner$okhttp.clean(this.$peerCertificates, this.$hostname);
                if (clean == null) {
                    clean = this.$peerCertificates;
                }
                Iterable<Certificate> $this$map$iv = clean;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Certificate it : $this$map$iv) {
                    destination$iv$iv.add((X509Certificate) it);
                }
                return (List) destination$iv$iv;
            }
        });
    }

    public final void check$okhttp(@NotNull String hostname, @NotNull Function0<? extends List<? extends X509Certificate>> function0) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(function0, "cleanedPeerCertificatesFn");
        List<Pin> pins = findMatchingPins(hostname);
        if (!pins.isEmpty()) {
            List<X509Certificate> peerCertificates = (List) function0.invoke();
            for (X509Certificate peerCertificate : peerCertificates) {
                ByteString sha1 = null;
                ByteString sha256 = null;
                for (Pin pin : pins) {
                    String hashAlgorithm = pin.getHashAlgorithm();
                    if (Intrinsics.areEqual(hashAlgorithm, "sha256")) {
                        if (sha256 == null) {
                            sha256 = Companion.sha256Hash(peerCertificate);
                        }
                        if (Intrinsics.areEqual(pin.getHash(), sha256)) {
                            return;
                        }
                    } else if (Intrinsics.areEqual(hashAlgorithm, "sha1")) {
                        if (sha1 == null) {
                            sha1 = Companion.sha1Hash(peerCertificate);
                        }
                        if (Intrinsics.areEqual(pin.getHash(), sha1)) {
                            return;
                        }
                    } else {
                        throw new AssertionError(Intrinsics.stringPlus("unsupported hashAlgorithm: ", pin.getHashAlgorithm()));
                    }
                }
            }
            StringBuilder $this$check_u24lambda_u2d0 = new StringBuilder();
            $this$check_u24lambda_u2d0.append("Certificate pinning failure!");
            $this$check_u24lambda_u2d0.append("\n  Peer certificate chain:");
            for (X509Certificate element : peerCertificates) {
                $this$check_u24lambda_u2d0.append("\n    ");
                $this$check_u24lambda_u2d0.append(Companion.pin(element));
                $this$check_u24lambda_u2d0.append(": ");
                $this$check_u24lambda_u2d0.append(element.getSubjectDN().getName());
            }
            $this$check_u24lambda_u2d0.append("\n  Pinned certificates for ");
            $this$check_u24lambda_u2d0.append(hostname);
            $this$check_u24lambda_u2d0.append(EmitterKt.COMMENT_PREFIX);
            for (Pin pin2 : pins) {
                $this$check_u24lambda_u2d0.append("\n    ");
                $this$check_u24lambda_u2d0.append(pin2);
            }
            String message = $this$check_u24lambda_u2d0.toString();
            Intrinsics.checkNotNullExpressionValue(message, "StringBuilder().apply(builderAction).toString()");
            throw new SSLPeerUnverifiedException(message);
        }
    }

    @Deprecated(message = "replaced with {@link #check(String, List)}.", replaceWith = @ReplaceWith(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void check(@NotNull String hostname, @NotNull Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
        check(hostname, ArraysKt.toList(peerCertificates));
    }

    @NotNull
    public final List<Pin> findMatchingPins(@NotNull String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Iterable $this$filterList$iv = this.pins;
        List result$iv = CollectionsKt.emptyList();
        for (Object i$iv : $this$filterList$iv) {
            if (((Pin) i$iv).matchesHostname(hostname)) {
                boolean isEmpty = result$iv.isEmpty();
                result$iv = result$iv;
                if (isEmpty) {
                    result$iv = new ArrayList();
                }
                TypeIntrinsics.asMutableList(result$iv).add(i$iv);
            }
        }
        return result$iv;
    }

    @NotNull
    public final CertificatePinner withCertificateChainCleaner$okhttp(@NotNull CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
        if (Intrinsics.areEqual(this.certificateChainCleaner, certificateChainCleaner)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof CertificatePinner) && Intrinsics.areEqual(((CertificatePinner) other).pins, this.pins) && Intrinsics.areEqual(((CertificatePinner) other).certificateChainCleaner, this.certificateChainCleaner);
    }

    public int hashCode() {
        int hashCode = 41 * ((41 * 37) + this.pins.hashCode());
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return hashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    /* compiled from: CertificatePinner.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n��\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, m373d2 = {"Lokhttp3/CertificatePinner$Pin;", "", "pattern", "", "pin", "(Ljava/lang/String;Ljava/lang/String;)V", "hash", "Lokio/ByteString;", "getHash", "()Lokio/ByteString;", "hashAlgorithm", "getHashAlgorithm", "()Ljava/lang/String;", "getPattern", "equals", "", "other", "hashCode", "", "matchesCertificate", "certificate", "Ljava/security/cert/X509Certificate;", "matchesHostname", "hostname", Printer.TO_STRING, "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/CertificatePinner$Pin.class */
    public static final class Pin {
        @NotNull
        private final String pattern;
        @NotNull
        private final String hashAlgorithm;
        @NotNull
        private final ByteString hash;

        public Pin(@NotNull String pattern, @NotNull String pin) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            Intrinsics.checkNotNullParameter(pin, "pin");
            if (!((StringsKt.startsWith$default(pattern, "*.", false, 2, (Object) null) && StringsKt.indexOf$default((CharSequence) pattern, "*", 1, false, 4, (Object) null) == -1) || (StringsKt.startsWith$default(pattern, "**.", false, 2, (Object) null) && StringsKt.indexOf$default((CharSequence) pattern, "*", 2, false, 4, (Object) null) == -1) || StringsKt.indexOf$default((CharSequence) pattern, "*", 0, false, 6, (Object) null) == -1)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected pattern: ", pattern).toString());
            }
            String canonicalHost = hostnames.toCanonicalHost(pattern);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid pattern: ", pattern));
            }
            this.pattern = canonicalHost;
            if (StringsKt.startsWith$default(pin, "sha1/", false, 2, (Object) null)) {
                this.hashAlgorithm = "sha1";
                ByteString.Companion companion = ByteString.Companion;
                String substring = pin.substring("sha1/".length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                ByteString decodeBase64 = companion.decodeBase64(substring);
                if (decodeBase64 == null) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid pin hash: ", pin));
                }
                this.hash = decodeBase64;
            } else if (StringsKt.startsWith$default(pin, "sha256/", false, 2, (Object) null)) {
                this.hashAlgorithm = "sha256";
                ByteString.Companion companion2 = ByteString.Companion;
                String substring2 = pin.substring("sha256/".length());
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                ByteString decodeBase642 = companion2.decodeBase64(substring2);
                if (decodeBase642 == null) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid pin hash: ", pin));
                }
                this.hash = decodeBase642;
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("pins must start with 'sha256/' or 'sha1/': ", pin));
            }
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        @NotNull
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @NotNull
        public final ByteString getHash() {
            return this.hash;
        }

        public final boolean matchesHostname(@NotNull String hostname) {
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            if (StringsKt.startsWith$default(this.pattern, "**.", false, 2, (Object) null)) {
                int suffixLength = this.pattern.length() - 3;
                int prefixLength = hostname.length() - suffixLength;
                return StringsKt.regionMatches$default(hostname, hostname.length() - suffixLength, this.pattern, 3, suffixLength, false, 16, (Object) null) && (prefixLength == 0 || hostname.charAt(prefixLength - 1) == '.');
            } else if (!StringsKt.startsWith$default(this.pattern, "*.", false, 2, (Object) null)) {
                return Intrinsics.areEqual(hostname, this.pattern);
            } else {
                int suffixLength2 = this.pattern.length() - 1;
                return StringsKt.regionMatches$default(hostname, hostname.length() - suffixLength2, this.pattern, 1, suffixLength2, false, 16, (Object) null) && StringsKt.lastIndexOf$default((CharSequence) hostname, '.', (hostname.length() - suffixLength2) - 1, false, 4, (Object) null) == -1;
            }
        }

        public final boolean matchesCertificate(@NotNull X509Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            String str = this.hashAlgorithm;
            if (Intrinsics.areEqual(str, "sha256")) {
                return Intrinsics.areEqual(this.hash, CertificatePinner.Companion.sha256Hash(certificate));
            }
            if (Intrinsics.areEqual(str, "sha1")) {
                return Intrinsics.areEqual(this.hash, CertificatePinner.Companion.sha1Hash(certificate));
            }
            return false;
        }

        @NotNull
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Pin) && Intrinsics.areEqual(this.pattern, ((Pin) other).pattern) && Intrinsics.areEqual(this.hashAlgorithm, ((Pin) other).hashAlgorithm) && Intrinsics.areEqual(this.hash, ((Pin) other).hash);
        }

        public int hashCode() {
            return (31 * ((31 * this.pattern.hashCode()) + this.hashAlgorithm.hashCode())) + this.hash.hashCode();
        }
    }

    /* compiled from: CertificatePinner.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u00020��2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000b\"\u00020\n¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, m373d2 = {"Lokhttp3/CertificatePinner$Builder;", "", "()V", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "getPins", "()Ljava/util/List;", BeanUtil.PREFIX_ADDER, "pattern", "", "", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lokhttp3/CertificatePinner;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/CertificatePinner$Builder.class */
    public static final class Builder {
        @NotNull
        private final List<Pin> pins = new ArrayList();

        @NotNull
        public final List<Pin> getPins() {
            return this.pins;
        }

        @NotNull
        public final Builder add(@NotNull String pattern, @NotNull String... pins) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            Intrinsics.checkNotNullParameter(pins, "pins");
            Builder $this$add_u24lambda_u2d0 = this;
            int i = 0;
            int length = pins.length;
            while (i < length) {
                String pin = pins[i];
                i++;
                $this$add_u24lambda_u2d0.getPins().add(new Pin(pattern, pin));
            }
            return this;
        }

        @NotNull
        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt.toSet(this.pins), null, 2, null);
        }
    }

    /* compiled from: CertificatePinner.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007J\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\r"}, m373d2 = {"Lokhttp3/CertificatePinner$Companion;", "", "()V", "DEFAULT", "Lokhttp3/CertificatePinner;", "pin", "", "certificate", "Ljava/security/cert/Certificate;", "sha1Hash", "Lokio/ByteString;", "Ljava/security/cert/X509Certificate;", "sha256Hash", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/CertificatePinner$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ByteString sha1Hash(@NotNull X509Certificate $this$sha1Hash) {
            Intrinsics.checkNotNullParameter($this$sha1Hash, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = $this$sha1Hash.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        @JvmStatic
        @NotNull
        public final ByteString sha256Hash(@NotNull X509Certificate $this$sha256Hash) {
            Intrinsics.checkNotNullParameter($this$sha256Hash, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = $this$sha256Hash.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }

        @JvmStatic
        @NotNull
        public final String pin(@NotNull Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return Intrinsics.stringPlus("sha256/", sha256Hash((X509Certificate) certificate).base64());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }
    }
}
