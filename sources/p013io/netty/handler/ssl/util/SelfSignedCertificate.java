package p013io.netty.handler.ssl.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.ssl.util.SelfSignedCertificate */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/SelfSignedCertificate.class */
public final class SelfSignedCertificate {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SelfSignedCertificate.class);
    private static final Date DEFAULT_NOT_BEFORE = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotBefore", System.currentTimeMillis() - 31536000000L));
    private static final Date DEFAULT_NOT_AFTER = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotAfter", 253402300799000L));
    private static final int DEFAULT_KEY_LENGTH_BITS = SystemPropertyUtil.getInt("io.netty.handler.ssl.util.selfSignedKeyStrength", 2048);
    private final File certificate;
    private final File privateKey;
    private final X509Certificate cert;
    private final PrivateKey key;

    public SelfSignedCertificate() throws CertificateException {
        this(DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(Date notBefore, Date notAfter) throws CertificateException {
        this("localhost", notBefore, notAfter, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(Date notBefore, Date notAfter, String algorithm, int bits) throws CertificateException {
        this("localhost", notBefore, notAfter, algorithm, bits);
    }

    public SelfSignedCertificate(String fqdn) throws CertificateException {
        this(fqdn, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(String fqdn, String algorithm, int bits) throws CertificateException {
        this(fqdn, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, algorithm, bits);
    }

    public SelfSignedCertificate(String fqdn, Date notBefore, Date notAfter) throws CertificateException {
        this(fqdn, ThreadLocalInsecureRandom.current(), DEFAULT_KEY_LENGTH_BITS, notBefore, notAfter, "RSA");
    }

    public SelfSignedCertificate(String fqdn, Date notBefore, Date notAfter, String algorithm, int bits) throws CertificateException {
        this(fqdn, ThreadLocalInsecureRandom.current(), bits, notBefore, notAfter, algorithm);
    }

    public SelfSignedCertificate(String fqdn, SecureRandom random, int bits) throws CertificateException {
        this(fqdn, random, bits, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA");
    }

    public SelfSignedCertificate(String fqdn, SecureRandom random, String algorithm, int bits) throws CertificateException {
        this(fqdn, random, bits, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, algorithm);
    }

    public SelfSignedCertificate(String fqdn, SecureRandom random, int bits, Date notBefore, Date notAfter) throws CertificateException {
        this(fqdn, random, bits, notBefore, notAfter, "RSA");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x00af */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.security.cert.CertificateFactory] */
    /* JADX WARN: Type inference failed for: r16v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v27, types: [io.netty.util.internal.logging.InternalLogger] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x017f A[ORIG_RETURN, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SelfSignedCertificate(java.lang.String r8, java.security.SecureRandom r9, int r10, java.util.Date r11, java.util.Date r12, java.lang.String r13) throws java.security.cert.CertificateException {
        /*
        // Method dump skipped, instructions count: 384
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.util.SelfSignedCertificate.<init>(java.lang.String, java.security.SecureRandom, int, java.util.Date, java.util.Date, java.lang.String):void");
    }

    public File certificate() {
        return this.certificate;
    }

    public File privateKey() {
        return this.privateKey;
    }

    public X509Certificate cert() {
        return this.cert;
    }

    public PrivateKey key() {
        return this.key;
    }

    public void delete() {
        safeDelete(this.certificate);
        safeDelete(this.privateKey);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x003b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static java.lang.String[] newSelfSignedCertificate(java.lang.String r5, java.security.PrivateKey r6, java.security.cert.X509Certificate r7) throws java.io.IOException, java.security.cert.CertificateEncodingException {
        /*
        // Method dump skipped, instructions count: 436
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.util.SelfSignedCertificate.newSelfSignedCertificate(java.lang.String, java.security.PrivateKey, java.security.cert.X509Certificate):java.lang.String[]");
    }

    private static void safeDelete(File certFile) {
        if (!certFile.delete() && logger.isWarnEnabled()) {
            logger.warn("Failed to delete a file: " + certFile);
        }
    }

    private static void safeClose(File keyFile, OutputStream keyOut) {
        try {
            keyOut.close();
        } catch (IOException e) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a file: " + keyFile, (Throwable) e);
            }
        }
    }
}
