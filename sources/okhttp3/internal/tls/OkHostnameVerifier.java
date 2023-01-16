package okhttp3.internal.tls;

import dev.morphia.mapping.Mapper;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.hostnames;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;

/* compiled from: OkHostnameVerifier.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\f\u0010\u0017\u001a\u00020\b*\u00020\bH\u0002J\f\u0010\u0018\u001a\u00020\u000e*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u0019"}, m373d2 = {"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", "host", "session", "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", "pattern", "verifyIpAddress", "ipAddress", "asciiToLowercase", "isAscii", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/tls/OkHostnameVerifier.class */
public final class OkHostnameVerifier implements HostnameVerifier {
    @NotNull
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;

    private OkHostnameVerifier() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String host, @NotNull SSLSession session) {
        boolean z;
        Certificate certificate;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        if (!isAscii(host)) {
            return false;
        }
        try {
            certificate = session.getPeerCertificates()[0];
        } catch (SSLException e) {
            z = false;
        }
        if (certificate == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        }
        z = verify(host, (X509Certificate) certificate);
        return z;
    }

    public final boolean verify(@NotNull String host, @NotNull X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyIpAddress(String ipAddress, X509Certificate certificate) {
        String canonicalIpAddress = hostnames.toCanonicalHost(ipAddress);
        Iterable<String> $this$any$iv = getSubjectAltNames(certificate, 7);
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (String it : $this$any$iv) {
            if (Intrinsics.areEqual(canonicalIpAddress, hostnames.toCanonicalHost(it))) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyHostname(String hostname, X509Certificate certificate) {
        String hostname2 = asciiToLowercase(hostname);
        Iterable<String> $this$any$iv = getSubjectAltNames(certificate, 2);
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (String it : $this$any$iv) {
            if (INSTANCE.verifyHostname(hostname2, it)) {
                return true;
            }
        }
        return false;
    }

    private final String asciiToLowercase(String $this$asciiToLowercase) {
        if (!isAscii($this$asciiToLowercase)) {
            return $this$asciiToLowercase;
        }
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "US");
        String lowerCase = $this$asciiToLowercase.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final boolean isAscii(String $this$isAscii) {
        return $this$isAscii.length() == ((int) Utf8.size$default($this$isAscii, 0, 0, 3, null));
    }

    private final boolean verifyHostname(String hostname, String pattern) {
        String hostname2 = hostname;
        String pattern2 = pattern;
        String str = hostname2;
        if ((str == null || str.length() == 0) || StringsKt.startsWith$default(hostname2, Mapper.IGNORED_FIELDNAME, false, 2, (Object) null) || StringsKt.endsWith$default(hostname2, CallerDataConverter.DEFAULT_RANGE_DELIMITER, false, 2, (Object) null)) {
            return false;
        }
        String str2 = pattern2;
        if ((str2 == null || str2.length() == 0) || StringsKt.startsWith$default(pattern2, Mapper.IGNORED_FIELDNAME, false, 2, (Object) null) || StringsKt.endsWith$default(pattern2, CallerDataConverter.DEFAULT_RANGE_DELIMITER, false, 2, (Object) null)) {
            return false;
        }
        if (!StringsKt.endsWith$default(hostname2, Mapper.IGNORED_FIELDNAME, false, 2, (Object) null)) {
            hostname2 = Intrinsics.stringPlus(hostname2, Mapper.IGNORED_FIELDNAME);
        }
        if (!StringsKt.endsWith$default(pattern2, Mapper.IGNORED_FIELDNAME, false, 2, (Object) null)) {
            pattern2 = Intrinsics.stringPlus(pattern2, Mapper.IGNORED_FIELDNAME);
        }
        String pattern3 = asciiToLowercase(pattern2);
        if (!StringsKt.contains$default((CharSequence) pattern3, (CharSequence) "*", false, 2, (Object) null)) {
            return Intrinsics.areEqual(hostname2, pattern3);
        }
        if (!StringsKt.startsWith$default(pattern3, "*.", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) pattern3, '*', 1, false, 4, (Object) null) != -1 || hostname2.length() < pattern3.length() || Intrinsics.areEqual("*.", pattern3)) {
            return false;
        }
        String suffix = pattern3.substring(1);
        Intrinsics.checkNotNullExpressionValue(suffix, "this as java.lang.String).substring(startIndex)");
        if (!StringsKt.endsWith$default(hostname2, suffix, false, 2, (Object) null)) {
            return false;
        }
        int suffixStartIndexInHostname = hostname2.length() - suffix.length();
        if (suffixStartIndexInHostname <= 0 || StringsKt.lastIndexOf$default((CharSequence) hostname2, '.', suffixStartIndexInHostname - 1, false, 4, (Object) null) == -1) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<String> allSubjectAltNames(@NotNull X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return CollectionsKt.plus((Collection) getSubjectAltNames(certificate, 7), (Iterable) getSubjectAltNames(certificate, 2));
    }

    private final List<String> getSubjectAltNames(X509Certificate certificate, int type) {
        Object altName;
        try {
            Collection subjectAltNames = certificate.getSubjectAlternativeNames();
            if (subjectAltNames == null) {
                return CollectionsKt.emptyList();
            }
            List result = new ArrayList();
            for (List subjectAltName : subjectAltNames) {
                if (subjectAltName != null && subjectAltName.size() >= 2 && Intrinsics.areEqual(subjectAltName.get(0), Integer.valueOf(type)) && (altName = subjectAltName.get(1)) != null) {
                    result.add((String) altName);
                }
            }
            return result;
        } catch (CertificateParsingException e) {
            return CollectionsKt.emptyList();
        }
    }
}
