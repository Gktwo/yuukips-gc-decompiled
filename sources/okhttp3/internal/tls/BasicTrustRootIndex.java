package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BasicTrustRootIndex.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��8\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0010\b\n��\u0018��2\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u0007X\u0004¢\u0006\u0002\n��¨\u0006\u0012"}, m373d2 = {"Lokhttp3/internal/tls/BasicTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "caCerts", "", "Ljava/security/cert/X509Certificate;", "([Ljava/security/cert/X509Certificate;)V", "subjectToCaCerts", "", "Ljavax/security/auth/x500/X500Principal;", "", "equals", "", "other", "", "findByIssuerAndSignature", "cert", "hashCode", "", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/tls/BasicTrustRootIndex.class */
public final class BasicTrustRootIndex implements TrustRootIndex {
    @NotNull
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(@NotNull X509Certificate... caCerts) {
        LinkedHashSet linkedHashSet;
        Intrinsics.checkNotNullParameter(caCerts, "caCerts");
        Map map = new LinkedHashMap();
        int i = 0;
        int length = caCerts.length;
        while (i < length) {
            X509Certificate caCert = caCerts[i];
            i++;
            X500Principal subjectX500Principal = caCert.getSubjectX500Principal();
            Intrinsics.checkNotNullExpressionValue(subjectX500Principal, "caCert.subjectX500Principal");
            Object value$iv = map.get(subjectX500Principal);
            if (value$iv == null) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                map.put(subjectX500Principal, linkedHashSet2);
                linkedHashSet = linkedHashSet2;
            } else {
                linkedHashSet = value$iv;
            }
            ((Set) linkedHashSet).add(caCert);
        }
        this.subjectToCaCerts = map;
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    @Nullable
    public X509Certificate findByIssuerAndSignature(@NotNull X509Certificate cert) {
        Object obj;
        Intrinsics.checkNotNullParameter(cert, "cert");
        Iterable subjectCaCerts = (Set) this.subjectToCaCerts.get(cert.getIssuerX500Principal());
        if (subjectCaCerts == null) {
            return null;
        }
        Iterator<T> it = subjectCaCerts.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            Object element$iv = it.next();
            X509Certificate it2 = (X509Certificate) element$iv;
            boolean z = false;
            try {
                cert.verify(it2.getPublicKey());
                z = true;
                continue;
            } catch (Exception e) {
                continue;
            }
            if (z) {
                obj = element$iv;
                break;
            }
        }
        return (X509Certificate) obj;
    }

    public boolean equals(@Nullable Object other) {
        return other == this || ((other instanceof BasicTrustRootIndex) && Intrinsics.areEqual(((BasicTrustRootIndex) other).subjectToCaCerts, this.subjectToCaCerts));
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
