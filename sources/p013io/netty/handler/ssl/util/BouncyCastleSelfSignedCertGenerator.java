package p013io.netty.handler.ssl.util;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

/* renamed from: io.netty.handler.ssl.util.BouncyCastleSelfSignedCertGenerator */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/BouncyCastleSelfSignedCertGenerator.class */
final class BouncyCastleSelfSignedCertGenerator {
    private static final Provider PROVIDER = new BouncyCastleProvider();

    /* access modifiers changed from: package-private */
    public static String[] generate(String fqdn, KeyPair keypair, SecureRandom random, Date notBefore, Date notAfter, String algorithm) throws Exception {
        PrivateKey key = keypair.getPrivate();
        X500Name owner = new X500Name("CN=" + fqdn);
        X509Certificate cert = new JcaX509CertificateConverter().setProvider(PROVIDER).getCertificate(new JcaX509v3CertificateBuilder(owner, new BigInteger(64, random), notBefore, notAfter, owner, keypair.getPublic()).build(new JcaContentSignerBuilder(algorithm.equalsIgnoreCase("EC") ? "SHA256withECDSA" : "SHA256WithRSAEncryption").build(key)));
        cert.verify(keypair.getPublic());
        return SelfSignedCertificate.newSelfSignedCertificate(fqdn, key, cert);
    }

    private BouncyCastleSelfSignedCertGenerator() {
    }
}
