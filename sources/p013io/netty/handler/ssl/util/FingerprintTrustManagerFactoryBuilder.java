package p013io.netty.handler.ssl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.util.FingerprintTrustManagerFactoryBuilder */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/FingerprintTrustManagerFactoryBuilder.class */
public final class FingerprintTrustManagerFactoryBuilder {
    private final String algorithm;
    private final List<String> fingerprints = new ArrayList();

    /* access modifiers changed from: package-private */
    public FingerprintTrustManagerFactoryBuilder(String algorithm) {
        this.algorithm = (String) ObjectUtil.checkNotNull(algorithm, "algorithm");
    }

    public FingerprintTrustManagerFactoryBuilder fingerprints(CharSequence... fingerprints) {
        return fingerprints(Arrays.asList((Object[]) ObjectUtil.checkNotNull(fingerprints, "fingerprints")));
    }

    public FingerprintTrustManagerFactoryBuilder fingerprints(Iterable<? extends CharSequence> fingerprints) {
        ObjectUtil.checkNotNull(fingerprints, "fingerprints");
        for (CharSequence fingerprint : fingerprints) {
            ObjectUtil.checkNotNullWithIAE(fingerprint, "fingerprint");
            this.fingerprints.add(fingerprint.toString());
        }
        return this;
    }

    public FingerprintTrustManagerFactory build() {
        if (!this.fingerprints.isEmpty()) {
            return new FingerprintTrustManagerFactory(this.algorithm, FingerprintTrustManagerFactory.toFingerprintArray(this.fingerprints));
        }
        throw new IllegalStateException("No fingerprints provided");
    }
}
