package p013io.netty.handler.ssl.util;

import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import p013io.javalin.http.sse.EmitterKt;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.buffer.Unpooled;
import p013io.netty.util.concurrent.FastThreadLocal;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.handler.ssl.util.FingerprintTrustManagerFactory */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/util/FingerprintTrustManagerFactory.class */
public final class FingerprintTrustManagerFactory extends SimpleTrustManagerFactory {
    private static final Pattern FINGERPRINT_PATTERN = Pattern.compile("^[0-9a-fA-F:]+$");
    private static final Pattern FINGERPRINT_STRIP_PATTERN = Pattern.compile(EmitterKt.COMMENT_PREFIX);
    private final FastThreadLocal<MessageDigest> tlmd;

    /* renamed from: tm */
    private final TrustManager f991tm;
    private final byte[][] fingerprints;

    public static FingerprintTrustManagerFactoryBuilder builder(String algorithm) {
        return new FingerprintTrustManagerFactoryBuilder(algorithm);
    }

    @Deprecated
    public FingerprintTrustManagerFactory(Iterable<String> fingerprints) {
        this("SHA1", toFingerprintArray(fingerprints));
    }

    @Deprecated
    public FingerprintTrustManagerFactory(String... fingerprints) {
        this("SHA1", toFingerprintArray(Arrays.asList(fingerprints)));
    }

    @Deprecated
    public FingerprintTrustManagerFactory(byte[]... fingerprints) {
        this("SHA1", fingerprints);
    }

    /* access modifiers changed from: package-private */
    public FingerprintTrustManagerFactory(final String algorithm, byte[][] fingerprints) {
        byte[] f;
        this.f991tm = new X509TrustManager() { // from class: io.netty.handler.ssl.util.FingerprintTrustManagerFactory.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String s) throws CertificateException {
                checkTrusted("client", chain);
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String s) throws CertificateException {
                checkTrusted("server", chain);
            }

            private void checkTrusted(String type, X509Certificate[] chain) throws CertificateException {
                X509Certificate cert = chain[0];
                byte[] fingerprint = fingerprint(cert);
                boolean found = false;
                byte[][] bArr = FingerprintTrustManagerFactory.this.fingerprints;
                int length = bArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (Arrays.equals(fingerprint, bArr[i])) {
                        found = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!found) {
                    throw new CertificateException(type + " certificate with unknown fingerprint: " + cert.getSubjectDN());
                }
            }

            private byte[] fingerprint(X509Certificate cert) throws CertificateEncodingException {
                MessageDigest md = (MessageDigest) FingerprintTrustManagerFactory.this.tlmd.get();
                md.reset();
                return md.digest(cert.getEncoded());
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return EmptyArrays.EMPTY_X509_CERTIFICATES;
            }
        };
        ObjectUtil.checkNotNull(algorithm, "algorithm");
        ObjectUtil.checkNotNull(fingerprints, "fingerprints");
        if (fingerprints.length == 0) {
            throw new IllegalArgumentException("No fingerprints provided");
        }
        try {
            int hashLength = MessageDigest.getInstance(algorithm).getDigestLength();
            ArrayList arrayList = new ArrayList(fingerprints.length);
            int length = fingerprints.length;
            int i = 0;
            while (i < length && (f = fingerprints[i]) != null) {
                if (f.length != hashLength) {
                    throw new IllegalArgumentException(String.format("malformed fingerprint (length is %d but expected %d): %s", Integer.valueOf(f.length), Integer.valueOf(hashLength), ByteBufUtil.hexDump(Unpooled.wrappedBuffer(f))));
                }
                arrayList.add(f.clone());
                i++;
            }
            this.tlmd = new FastThreadLocal<MessageDigest>() { // from class: io.netty.handler.ssl.util.FingerprintTrustManagerFactory.2
                /* access modifiers changed from: protected */
                @Override // p013io.netty.util.concurrent.FastThreadLocal
                public MessageDigest initialValue() {
                    try {
                        return MessageDigest.getInstance(algorithm);
                    } catch (NoSuchAlgorithmException e) {
                        throw new IllegalArgumentException(String.format("Unsupported hash algorithm: %s", algorithm), e);
                    }
                }
            };
            this.fingerprints = (byte[][]) arrayList.toArray(new byte[0]);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(String.format("Unsupported hash algorithm: %s", algorithm), e);
        }
    }

    /* access modifiers changed from: package-private */
    public static byte[][] toFingerprintArray(Iterable<String> fingerprints) {
        String f;
        ObjectUtil.checkNotNull(fingerprints, "fingerprints");
        List<byte[]> list = new ArrayList<>();
        Iterator<String> it = fingerprints.iterator();
        while (it.hasNext() && (f = it.next()) != null) {
            if (!FINGERPRINT_PATTERN.matcher(f).matches()) {
                throw new IllegalArgumentException("malformed fingerprint: " + f);
            }
            list.add(StringUtil.decodeHexDump(FINGERPRINT_STRIP_PATTERN.matcher(f).replaceAll("")));
        }
        return (byte[][]) list.toArray(new byte[0]);
    }

    @Override // p013io.netty.handler.ssl.util.SimpleTrustManagerFactory
    protected void engineInit(KeyStore keyStore) throws Exception {
    }

    @Override // p013io.netty.handler.ssl.util.SimpleTrustManagerFactory
    protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception {
    }

    @Override // p013io.netty.handler.ssl.util.SimpleTrustManagerFactory
    protected TrustManager[] engineGetTrustManagers() {
        return new TrustManager[]{this.f991tm};
    }
}
