package p013io.netty.handler.ssl.util;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.Date;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.netty.util.internal.SuppressJava6Requirement;
import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

/* renamed from: io.netty.handler.ssl.util.OpenJdkSelfSignedCertGenerator */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/OpenJdkSelfSignedCertGenerator.class */
final class OpenJdkSelfSignedCertGenerator {
    /* access modifiers changed from: package-private */
    @SuppressJava6Requirement(reason = "Usage guarded by dependency check")
    public static String[] generate(String fqdn, KeyPair keypair, SecureRandom random, Date notBefore, Date notAfter, String algorithm) throws Exception {
        PrivateKey key = keypair.getPrivate();
        X509CertInfo info = new X509CertInfo();
        X500Name owner = new X500Name("CN=" + fqdn);
        info.set("version", new CertificateVersion(2));
        info.set("serialNumber", new CertificateSerialNumber(new BigInteger(64, random)));
        try {
            info.set(SendMailJob.PROP_SUBJECT, new CertificateSubjectName(owner));
        } catch (CertificateException e) {
            info.set(SendMailJob.PROP_SUBJECT, owner);
        }
        try {
            info.set("issuer", new CertificateIssuerName(owner));
        } catch (CertificateException e2) {
            info.set("issuer", owner);
        }
        info.set("validity", new CertificateValidity(notBefore, notAfter));
        info.set(Action.KEY_ATTRIBUTE, new CertificateX509Key(keypair.getPublic()));
        info.set("algorithmID", new CertificateAlgorithmId(AlgorithmId.get("1.2.840.113549.1.1.11")));
        X509CertImpl cert = new X509CertImpl(info);
        cert.sign(key, algorithm.equalsIgnoreCase("EC") ? "SHA256withECDSA" : "SHA256withRSA");
        info.set("algorithmID.algorithm", cert.get("x509.algorithm"));
        X509CertImpl cert2 = new X509CertImpl(info);
        cert2.sign(key, algorithm.equalsIgnoreCase("EC") ? "SHA256withECDSA" : "SHA256withRSA");
        cert2.verify(keypair.getPublic());
        return SelfSignedCertificate.newSelfSignedCertificate(fqdn, key, cert2);
    }

    private OpenJdkSelfSignedCertGenerator() {
    }
}
