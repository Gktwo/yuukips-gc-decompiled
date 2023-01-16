package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.Library;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.bytebuddy.utility.JavaConstant;
import p013io.javalin.http.sse.EmitterKt;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.UnpooledByteBufAllocator;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.ReferenceCounted;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.NativeLibraryLoader;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.ssl.OpenSsl */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSsl.class */
public final class OpenSsl {
    private static final InternalLogger logger;
    private static final Throwable UNAVAILABILITY_CAUSE;
    static final List<String> DEFAULT_CIPHERS;
    static final Set<String> AVAILABLE_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_OPENSSL_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_JAVA_CIPHER_SUITES;
    private static final boolean SUPPORTS_KEYMANAGER_FACTORY;
    private static final boolean USE_KEYMANAGER_FACTORY;
    private static final boolean SUPPORTS_OCSP;
    private static final boolean TLSV13_SUPPORTED;
    private static final boolean IS_BORINGSSL;
    static final Set<String> SUPPORTED_PROTOCOLS_SET;
    static final String[] EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
    static final String EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING;
    static final String[] NAMED_GROUPS;
    private static final String[] DEFAULT_NAMED_GROUPS;
    private static final String CERT = "-----BEGIN CERTIFICATE-----\nMIICrjCCAZagAwIBAgIIdSvQPv1QAZQwDQYJKoZIhvcNAQELBQAwFjEUMBIGA1UEAxMLZXhhbXBs\nZS5jb20wIBcNMTgwNDA2MjIwNjU5WhgPOTk5OTEyMzEyMzU5NTlaMBYxFDASBgNVBAMTC2V4YW1w\nbGUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAggbWsmDQ6zNzRZ5AW8E3eoGl\nqWvOBDb5Fs1oBRrVQHuYmVAoaqwDzXYJ0LOwa293AgWEQ1jpcbZ2hpoYQzqEZBTLnFhMrhRFlH6K\nbJND8Y33kZ/iSVBBDuGbdSbJShlM+4WwQ9IAso4MZ4vW3S1iv5fGGpLgbtXRmBf/RU8omN0Gijlv\nWlLWHWijLN8xQtySFuBQ7ssW8RcKAary3pUm6UUQB+Co6lnfti0Tzag8PgjhAJq2Z3wbsGRnP2YS\nvYoaK6qzmHXRYlp/PxrjBAZAmkLJs4YTm/XFF+fkeYx4i9zqHbyone5yerRibsHaXZWLnUL+rFoe\nMdKvr0VS3sGmhQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQADQi441pKmXf9FvUV5EHU4v8nJT9Iq\nyqwsKwXnr7AsUlDGHBD7jGrjAXnG5rGxuNKBQ35wRxJATKrUtyaquFUL6H8O6aGQehiFTk6zmPbe\n12Gu44vqqTgIUxnv3JQJiox8S2hMxsSddpeCmSdvmalvD6WG4NthH6B9ZaBEiep1+0s0RUaBYn73\nI7CCUaAtbjfR6pcJjrFk5ei7uwdQZFSJtkP2z8r7zfeANJddAKFlkaMWn7u+OIVuB4XPooWicObk\nNAHFtP65bocUYnDpTVdiyvn8DdqyZ/EO8n1bBKBzuSLplk2msW4pdgaFgY7Vw/0wzcFXfUXmL1uy\nG8sQD/wx\n-----END CERTIFICATE-----";
    private static final String KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCBtayYNDrM3NFnkBbwTd6gaWp\na84ENvkWzWgFGtVAe5iZUChqrAPNdgnQs7Brb3cCBYRDWOlxtnaGmhhDOoRkFMucWEyuFEWUfops\nk0PxjfeRn+JJUEEO4Zt1JslKGUz7hbBD0gCyjgxni9bdLWK/l8YakuBu1dGYF/9FTyiY3QaKOW9a\nUtYdaKMs3zFC3JIW4FDuyxbxFwoBqvLelSbpRRAH4KjqWd+2LRPNqDw+COEAmrZnfBuwZGc/ZhK9\nihorqrOYddFiWn8/GuMEBkCaQsmzhhOb9cUX5+R5jHiL3OodvKid7nJ6tGJuwdpdlYudQv6sWh4x\n0q+vRVLewaaFAgMBAAECggEAP8tPJvFtTxhNJAkCloHz0D0vpDHqQBMgntlkgayqmBqLwhyb18pR\ni0qwgh7HHc7wWqOOQuSqlEnrWRrdcI6TSe8R/sErzfTQNoznKWIPYcI/hskk4sdnQ//Yn9/Jvnsv\nU/BBjOTJxtD+sQbhAl80JcA3R+5sArURQkfzzHOL/YMqzAsn5hTzp7HZCxUqBk3KaHRxV7NefeOE\nxlZuWSmxYWfbFIs4kx19/1t7h8CHQWezw+G60G2VBtSBBxDnhBWvqG6R/wpzJ3nEhPLLY9T+XIHe\nipzdMOOOUZorfIg7M+pyYPji+ZIZxIpY5OjrOzXHciAjRtr5Y7l99K1CG1LguQKBgQDrQfIMxxtZ\nvxU/1cRmUV9l7pt5bjV5R6byXq178LxPKVYNjdZ840Q0/OpZEVqaT1xKVi35ohP1QfNjxPLlHD+K\niDAR9z6zkwjIrbwPCnb5kuXy4lpwPcmmmkva25fI7qlpHtbcuQdoBdCfr/KkKaUCMPyY89LCXgEw\n5KTDj64UywKBgQCNfbO+eZLGzhiHhtNJurresCsIGWlInv322gL8CSfBMYl6eNfUTZvUDdFhPISL\nUljKWzXDrjw0ujFSPR0XhUGtiq89H+HUTuPPYv25gVXO+HTgBFZEPl4PpA+BUsSVZy0NddneyqLk\n42Wey9omY9Q8WsdNQS5cbUvy0uG6WFoX7wKBgQDZ1jpW8pa0x2bZsQsm4vo+3G5CRnZlUp+XlWt2\ndDcp5dC0xD1zbs1dc0NcLeGDOTDv9FSl7hok42iHXXq8AygjEm/QcuwwQ1nC2HxmQP5holAiUs4D\nWHM8PWs3wFYPzE459EBoKTxeaeP/uWAn+he8q7d5uWvSZlEcANs/6e77eQKBgD21Ar0hfFfj7mK8\n9E0FeRZBsqK3omkfnhcYgZC11Xa2SgT1yvs2Va2n0RcdM5kncr3eBZav2GYOhhAdwyBM55XuE/sO\neokDVutNeuZ6d5fqV96TRaRBpvgfTvvRwxZ9hvKF4Vz+9wfn/JvCwANaKmegF6ejs7pvmF3whq2k\ndrZVAoGAX5YxQ5XMTD0QbMAl7/6qp6S58xNoVdfCkmkj1ZLKaHKIjS/benkKGlySVQVPexPfnkZx\np/Vv9yyphBoudiTBS9Uog66ueLYZqpgxlM/6OhYg86Gm3U2ycvMxYjBM1NFiyze21AqAhI+HX+Ot\nmraV2/guSgDgZAhukRZzeQ2RucI=\n-----END PRIVATE KEY-----";
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !OpenSsl.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(OpenSsl.class);
        DEFAULT_NAMED_GROUPS = new String[]{"x25519", "secp256r1", "secp384r1", "secp521r1"};
        Throwable cause = null;
        if (SystemPropertyUtil.getBoolean("io.netty.handler.ssl.noOpenSsl", false)) {
            cause = new UnsupportedOperationException("OpenSSL was explicit disabled with -Dio.netty.handler.ssl.noOpenSsl=true");
            logger.debug("netty-tcnative explicit disabled; " + OpenSslEngine.class.getSimpleName() + " will be unavailable.", cause);
        } else {
            try {
                Class.forName("io.netty.internal.tcnative.SSLContext", false, PlatformDependent.getClassLoader(OpenSsl.class));
            } catch (ClassNotFoundException t) {
                cause = t;
                logger.debug("netty-tcnative not in the classpath; " + OpenSslEngine.class.getSimpleName() + " will be unavailable.");
            }
            if (cause == null) {
                try {
                    loadTcNative();
                } catch (Throwable t2) {
                    cause = t2;
                    logger.debug("Failed to load netty-tcnative; " + OpenSslEngine.class.getSimpleName() + " will be unavailable, unless the application has already loaded the symbols by some other means. See https://netty.io/wiki/forked-tomcat-native.html for more information.", t2);
                }
                try {
                    String engine = SystemPropertyUtil.get("io.netty.handler.ssl.openssl.engine", null);
                    if (engine == null) {
                        logger.debug("Initialize netty-tcnative using engine: 'default'");
                    } else {
                        logger.debug("Initialize netty-tcnative using engine: '{}'", engine);
                    }
                    initializeTcNative(engine);
                    cause = null;
                } catch (Throwable t3) {
                    if (cause == null) {
                        cause = t3;
                    }
                    logger.debug("Failed to initialize netty-tcnative; " + OpenSslEngine.class.getSimpleName() + " will be unavailable. See https://netty.io/wiki/forked-tomcat-native.html for more information.", t3);
                }
            }
        }
        UNAVAILABILITY_CAUSE = cause;
        if (cause == null) {
            logger.debug("netty-tcnative using native library: {}", SSL.versionString());
            List<String> defaultCiphers = new ArrayList<>();
            Set<String> availableOpenSslCipherSuites = new LinkedHashSet<>(128);
            boolean supportsKeyManagerFactory = false;
            boolean useKeyManagerFactory = false;
            boolean tlsv13Supported = false;
            String[] namedGroups = DEFAULT_NAMED_GROUPS;
            String[] defaultConvertedNamedGroups = new String[namedGroups.length];
            for (int i = 0; i < namedGroups.length; i++) {
                defaultConvertedNamedGroups[i] = GroupsConverter.toOpenSsl(namedGroups[i]);
            }
            IS_BORINGSSL = "BoringSSL".equals(versionString());
            if (IS_BORINGSSL) {
                EXTRA_SUPPORTED_TLS_1_3_CIPHERS = new String[]{Ciphers.TLS_AES_128_GCM_SHA256, Ciphers.TLS_AES_256_GCM_SHA384, Ciphers.TLS_CHACHA20_POLY1305_SHA256};
                StringBuilder ciphersBuilder = new StringBuilder(128);
                for (String cipher : EXTRA_SUPPORTED_TLS_1_3_CIPHERS) {
                    ciphersBuilder.append(cipher).append(EmitterKt.COMMENT_PREFIX);
                }
                ciphersBuilder.setLength(ciphersBuilder.length() - 1);
                EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = ciphersBuilder.toString();
            } else {
                EXTRA_SUPPORTED_TLS_1_3_CIPHERS = EmptyArrays.EMPTY_STRINGS;
                EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = "";
            }
            try {
                long sslCtx = SSLContext.make(63, 1);
                if (SslProvider.isTlsv13Supported(SslProvider.JDK)) {
                    StringBuilder tlsv13Ciphers = new StringBuilder();
                    for (String cipher2 : SslUtils.TLSV13_CIPHERS) {
                        try {
                            String converted = CipherSuiteConverter.toOpenSsl(cipher2, IS_BORINGSSL);
                            if (converted != null) {
                                tlsv13Ciphers.append(converted).append(':');
                            }
                        } catch (Exception e) {
                            tlsv13Supported = false;
                        }
                    }
                    if (tlsv13Ciphers.length() == 0) {
                        tlsv13Supported = false;
                    } else {
                        tlsv13Ciphers.setLength(tlsv13Ciphers.length() - 1);
                        SSLContext.setCipherSuite(sslCtx, tlsv13Ciphers.toString(), true);
                        tlsv13Supported = true;
                    }
                }
                SSLContext.setCipherSuite(sslCtx, "ALL", false);
                long ssl = SSL.newSSL(sslCtx, true);
                String[] ciphers = SSL.getCiphers(ssl);
                for (String c : ciphers) {
                    try {
                        if (c != null && !c.isEmpty() && !availableOpenSslCipherSuites.contains(c) && (tlsv13Supported || !SslUtils.isTLSv13Cipher(c))) {
                            availableOpenSslCipherSuites.add(c);
                        }
                    } catch (Throwable th) {
                        SSL.freeSSL(ssl);
                        if (0 != 0) {
                            SSL.freeBIO(0);
                        }
                        if (0 != 0) {
                            SSL.freeBIO(0);
                        }
                        if (0 != 0) {
                            SSL.freeX509Chain(0);
                        }
                        if (0 != 0) {
                            SSL.freePrivateKey(0);
                        }
                        throw th;
                    }
                }
                if (IS_BORINGSSL) {
                    Collections.addAll(availableOpenSslCipherSuites, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                    Collections.addAll(availableOpenSslCipherSuites, "AEAD-AES128-GCM-SHA256", "AEAD-AES256-GCM-SHA384", "AEAD-CHACHA20-POLY1305-SHA256");
                }
                PemEncoded privateKey = PemPrivateKey.valueOf(KEY.getBytes(CharsetUtil.US_ASCII));
                SSLContext.setCertificateCallback(sslCtx, (CertificateCallback) null);
                long certBio = ReferenceCountedOpenSslContext.toBIO(ByteBufAllocator.DEFAULT, selfSignedCertificate());
                long cert = SSL.parseX509Chain(certBio);
                long keyBio = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, privateKey.retain());
                long key = SSL.parsePrivateKey(keyBio, (String) null);
                SSL.setKeyMaterial(ssl, cert, key);
                supportsKeyManagerFactory = true;
                boolean propertySet = SystemPropertyUtil.contains("io.netty.handler.ssl.openssl.useKeyManagerFactory");
                if (!IS_BORINGSSL) {
                    try {
                        useKeyManagerFactory = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useKeyManagerFactory", true);
                        if (propertySet) {
                            logger.info("System property 'io.netty.handler.ssl.openssl.useKeyManagerFactory' is deprecated and so will be ignored in the future");
                        }
                    } catch (Error e2) {
                        logger.debug("KeyManagerFactory not supported.");
                        privateKey.release();
                    } catch (Throwable th2) {
                        privateKey.release();
                        throw th2;
                    }
                } else {
                    useKeyManagerFactory = true;
                    if (propertySet) {
                        logger.info("System property 'io.netty.handler.ssl.openssl.useKeyManagerFactory' is deprecated and will be ignored when using BoringSSL");
                    }
                }
                privateKey.release();
                SSL.freeSSL(ssl);
                if (certBio != 0) {
                    SSL.freeBIO(certBio);
                }
                if (keyBio != 0) {
                    SSL.freeBIO(keyBio);
                }
                if (cert != 0) {
                    SSL.freeX509Chain(cert);
                }
                if (key != 0) {
                    SSL.freePrivateKey(key);
                }
                String groups = SystemPropertyUtil.get("jdk.tls.namedGroups", null);
                if (groups != null) {
                    String[] nGroups = groups.split(",");
                    Set<String> supportedNamedGroups = new LinkedHashSet<>(nGroups.length);
                    Set<String> supportedConvertedNamedGroups = new LinkedHashSet<>(nGroups.length);
                    Set<String> unsupportedNamedGroups = new LinkedHashSet<>();
                    for (String namedGroup : nGroups) {
                        String converted2 = GroupsConverter.toOpenSsl(namedGroup);
                        if (SSLContext.setCurvesList(sslCtx, new String[]{converted2})) {
                            supportedConvertedNamedGroups.add(converted2);
                            supportedNamedGroups.add(namedGroup);
                        } else {
                            unsupportedNamedGroups.add(namedGroup);
                        }
                    }
                    if (supportedNamedGroups.isEmpty()) {
                        namedGroups = defaultConvertedNamedGroups;
                        logger.info("All configured namedGroups are not supported: {}. Use default: {}.", Arrays.toString(unsupportedNamedGroups.toArray(EmptyArrays.EMPTY_STRINGS)), Arrays.toString(DEFAULT_NAMED_GROUPS));
                    } else {
                        String[] groupArray = (String[]) supportedNamedGroups.toArray(EmptyArrays.EMPTY_STRINGS);
                        if (unsupportedNamedGroups.isEmpty()) {
                            logger.info("Using configured namedGroups -D 'jdk.tls.namedGroup': {} ", Arrays.toString(groupArray));
                        } else {
                            logger.info("Using supported configured namedGroups: {}. Unsupported namedGroups: {}. ", Arrays.toString(groupArray), Arrays.toString(unsupportedNamedGroups.toArray(EmptyArrays.EMPTY_STRINGS)));
                        }
                        namedGroups = (String[]) supportedConvertedNamedGroups.toArray(EmptyArrays.EMPTY_STRINGS);
                    }
                } else {
                    namedGroups = defaultConvertedNamedGroups;
                }
                SSLContext.free(sslCtx);
            } catch (Exception e3) {
                logger.warn("Failed to get the list of available OpenSSL cipher suites.", (Throwable) e3);
            }
            NAMED_GROUPS = namedGroups;
            AVAILABLE_OPENSSL_CIPHER_SUITES = Collections.unmodifiableSet(availableOpenSslCipherSuites);
            Set<String> availableJavaCipherSuites = new LinkedHashSet<>(AVAILABLE_OPENSSL_CIPHER_SUITES.size() * 2);
            for (String cipher3 : AVAILABLE_OPENSSL_CIPHER_SUITES) {
                if (!SslUtils.isTLSv13Cipher(cipher3)) {
                    availableJavaCipherSuites.add(CipherSuiteConverter.toJava(cipher3, "TLS"));
                    availableJavaCipherSuites.add(CipherSuiteConverter.toJava(cipher3, p001ch.qos.logback.core.net.ssl.SSL.DEFAULT_PROTOCOL));
                } else {
                    availableJavaCipherSuites.add(cipher3);
                }
            }
            SslUtils.addIfSupported(availableJavaCipherSuites, defaultCiphers, SslUtils.DEFAULT_CIPHER_SUITES);
            SslUtils.addIfSupported(availableJavaCipherSuites, defaultCiphers, SslUtils.TLSV13_CIPHER_SUITES);
            SslUtils.addIfSupported(availableJavaCipherSuites, defaultCiphers, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
            SslUtils.useFallbackCiphersIfDefaultIsEmpty(defaultCiphers, availableJavaCipherSuites);
            DEFAULT_CIPHERS = Collections.unmodifiableList(defaultCiphers);
            AVAILABLE_JAVA_CIPHER_SUITES = Collections.unmodifiableSet(availableJavaCipherSuites);
            Set<String> availableCipherSuites = new LinkedHashSet<>(AVAILABLE_OPENSSL_CIPHER_SUITES.size() + AVAILABLE_JAVA_CIPHER_SUITES.size());
            availableCipherSuites.addAll(AVAILABLE_OPENSSL_CIPHER_SUITES);
            availableCipherSuites.addAll(AVAILABLE_JAVA_CIPHER_SUITES);
            AVAILABLE_CIPHER_SUITES = availableCipherSuites;
            SUPPORTS_KEYMANAGER_FACTORY = supportsKeyManagerFactory;
            USE_KEYMANAGER_FACTORY = useKeyManagerFactory;
            Set<String> protocols = new LinkedHashSet<>(6);
            protocols.add(SslProtocols.SSL_v2_HELLO);
            if (doesSupportProtocol(1, SSL.SSL_OP_NO_SSLv2)) {
                protocols.add(SslProtocols.SSL_v2);
            }
            if (doesSupportProtocol(2, SSL.SSL_OP_NO_SSLv3)) {
                protocols.add(SslProtocols.SSL_v3);
            }
            if (doesSupportProtocol(4, SSL.SSL_OP_NO_TLSv1)) {
                protocols.add(SslProtocols.TLS_v1);
            }
            if (doesSupportProtocol(8, SSL.SSL_OP_NO_TLSv1_1)) {
                protocols.add(SslProtocols.TLS_v1_1);
            }
            if (doesSupportProtocol(16, SSL.SSL_OP_NO_TLSv1_2)) {
                protocols.add(SslProtocols.TLS_v1_2);
            }
            if (!tlsv13Supported || !doesSupportProtocol(32, SSL.SSL_OP_NO_TLSv1_3)) {
                TLSV13_SUPPORTED = false;
            } else {
                protocols.add(SslProtocols.TLS_v1_3);
                TLSV13_SUPPORTED = true;
            }
            SUPPORTED_PROTOCOLS_SET = Collections.unmodifiableSet(protocols);
            SUPPORTS_OCSP = doesSupportOcsp();
            if (logger.isDebugEnabled()) {
                logger.debug("Supported protocols (OpenSSL): {} ", SUPPORTED_PROTOCOLS_SET);
                logger.debug("Default cipher suites (OpenSSL): {}", DEFAULT_CIPHERS);
                return;
            }
            return;
        }
        DEFAULT_CIPHERS = Collections.emptyList();
        AVAILABLE_OPENSSL_CIPHER_SUITES = Collections.emptySet();
        AVAILABLE_JAVA_CIPHER_SUITES = Collections.emptySet();
        AVAILABLE_CIPHER_SUITES = Collections.emptySet();
        SUPPORTS_KEYMANAGER_FACTORY = false;
        USE_KEYMANAGER_FACTORY = false;
        SUPPORTED_PROTOCOLS_SET = Collections.emptySet();
        SUPPORTS_OCSP = false;
        TLSV13_SUPPORTED = false;
        IS_BORINGSSL = false;
        EXTRA_SUPPORTED_TLS_1_3_CIPHERS = EmptyArrays.EMPTY_STRINGS;
        EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = "";
        NAMED_GROUPS = DEFAULT_NAMED_GROUPS;
    }

    /* access modifiers changed from: package-private */
    public static String checkTls13Ciphers(InternalLogger logger2, String ciphers) {
        if (IS_BORINGSSL && !ciphers.isEmpty()) {
            if ($assertionsDisabled || EXTRA_SUPPORTED_TLS_1_3_CIPHERS.length > 0) {
                Set<String> boringsslTlsv13Ciphers = new HashSet<>(EXTRA_SUPPORTED_TLS_1_3_CIPHERS.length);
                Collections.addAll(boringsslTlsv13Ciphers, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                boolean ciphersNotMatch = false;
                String[] split = ciphers.split(EmitterKt.COMMENT_PREFIX);
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String cipher = split[i];
                    if (boringsslTlsv13Ciphers.isEmpty()) {
                        ciphersNotMatch = true;
                        break;
                    }
                    if (!(boringsslTlsv13Ciphers.remove(cipher) || boringsslTlsv13Ciphers.remove(CipherSuiteConverter.toJava(cipher, "TLS")))) {
                        ciphersNotMatch = true;
                        break;
                    }
                    i++;
                }
                if (ciphersNotMatch || (!boringsslTlsv13Ciphers.isEmpty())) {
                    if (logger2.isInfoEnabled()) {
                        StringBuilder javaCiphers = new StringBuilder(128);
                        for (String cipher2 : ciphers.split(EmitterKt.COMMENT_PREFIX)) {
                            javaCiphers.append(CipherSuiteConverter.toJava(cipher2, "TLS")).append(EmitterKt.COMMENT_PREFIX);
                        }
                        javaCiphers.setLength(javaCiphers.length() - 1);
                        logger2.info("BoringSSL doesn't allow to enable or disable TLSv1.3 ciphers explicitly. Provided TLSv1.3 ciphers: '{}', default TLSv1.3 ciphers that will be used: '{}'.", javaCiphers, EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING);
                    }
                    return EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING;
                }
            } else {
                throw new AssertionError();
            }
        }
        return ciphers;
    }

    static boolean isSessionCacheSupported() {
        return ((long) version()) >= 269484032;
    }

    static X509Certificate selfSignedCertificate() throws CertificateException {
        return (X509Certificate) SslContext.X509_CERT_FACTORY.generateCertificate(new ByteArrayInputStream(CERT.getBytes(CharsetUtil.US_ASCII)));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0011 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v3, types: [long] */
    private static boolean doesSupportOcsp() {
        boolean supportsOcsp = false;
        if (((long) version()) >= 268443648) {
            long sslCtx = -1;
            try {
                sslCtx = SSLContext.make(16, 1);
                SSLContext.enableOcsp((long) sslCtx, false);
                supportsOcsp = true;
                if (sslCtx != -1) {
                    SSLContext.free((long) sslCtx);
                }
            } catch (Exception e) {
                if ((sslCtx == true ? 1 : 0) != -1) {
                    SSLContext.free(sslCtx);
                }
            } catch (Throwable th) {
                if ((sslCtx == true ? 1 : 0) != -1) {
                    SSLContext.free(sslCtx);
                }
                throw th;
            }
        }
        return supportsOcsp;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    private static boolean doesSupportProtocol(int protocol, int opt) {
        if (opt == 0) {
            return false;
        }
        char c = 65535;
        try {
            c = SSLContext.make(protocol, 2);
            if (c != -1) {
                SSLContext.free(c);
            }
            return true;
        } catch (Exception e) {
            if (c != -1) {
                SSLContext.free(c);
            }
            return false;
        } catch (Throwable th) {
            if (c != -1) {
                SSLContext.free(c);
            }
            throw th;
        }
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    @Deprecated
    public static boolean isAlpnSupported() {
        return ((long) version()) >= 268443648;
    }

    public static boolean isOcspSupported() {
        return SUPPORTS_OCSP;
    }

    public static int version() {
        if (isAvailable()) {
            return SSL.version();
        }
        return -1;
    }

    public static String versionString() {
        if (isAvailable()) {
            return SSL.versionString();
        }
        return null;
    }

    public static void ensureAvailability() {
        if (UNAVAILABILITY_CAUSE != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(UNAVAILABILITY_CAUSE));
        }
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    @Deprecated
    public static Set<String> availableCipherSuites() {
        return availableOpenSslCipherSuites();
    }

    public static Set<String> availableOpenSslCipherSuites() {
        return AVAILABLE_OPENSSL_CIPHER_SUITES;
    }

    public static Set<String> availableJavaCipherSuites() {
        return AVAILABLE_JAVA_CIPHER_SUITES;
    }

    public static boolean isCipherSuiteAvailable(String cipherSuite) {
        String converted = CipherSuiteConverter.toOpenSsl(cipherSuite, IS_BORINGSSL);
        if (converted != null) {
            cipherSuite = converted;
        }
        return AVAILABLE_OPENSSL_CIPHER_SUITES.contains(cipherSuite);
    }

    public static boolean supportsKeyManagerFactory() {
        return SUPPORTS_KEYMANAGER_FACTORY;
    }

    @Deprecated
    public static boolean supportsHostnameValidation() {
        return isAvailable();
    }

    /* access modifiers changed from: package-private */
    public static boolean useKeyManagerFactory() {
        return USE_KEYMANAGER_FACTORY;
    }

    /* access modifiers changed from: package-private */
    public static long memoryAddress(ByteBuf buf) {
        if ($assertionsDisabled || buf.isDirect()) {
            return buf.hasMemoryAddress() ? buf.memoryAddress() : Buffer.address(buf.internalNioBuffer(0, buf.readableBytes()));
        }
        throw new AssertionError();
    }

    private OpenSsl() {
    }

    private static void loadTcNative() throws Exception {
        String os = PlatformDependent.normalizedOs();
        String arch = PlatformDependent.normalizedArch();
        Set<String> libNames = new LinkedHashSet<>(5);
        if ("linux".equals(os)) {
            Iterator<String> it = PlatformDependent.normalizedLinuxClassifiers().iterator();
            while (it.hasNext()) {
                libNames.add("netty_tcnative" + JavaConstant.Dynamic.DEFAULT_NAME + os + '_' + arch + JavaConstant.Dynamic.DEFAULT_NAME + it.next());
            }
            libNames.add("netty_tcnative" + JavaConstant.Dynamic.DEFAULT_NAME + os + '_' + arch);
            libNames.add("netty_tcnative" + JavaConstant.Dynamic.DEFAULT_NAME + os + '_' + arch + "_fedora");
        } else {
            libNames.add("netty_tcnative" + JavaConstant.Dynamic.DEFAULT_NAME + os + '_' + arch);
        }
        libNames.add("netty_tcnative" + JavaConstant.Dynamic.DEFAULT_NAME + arch);
        libNames.add("netty_tcnative");
        NativeLibraryLoader.loadFirstAvailable(PlatformDependent.getClassLoader(SSLContext.class), (String[]) libNames.toArray(new String[0]));
    }

    private static boolean initializeTcNative(String engine) throws Exception {
        return Library.initialize("provided", engine);
    }

    /* access modifiers changed from: package-private */
    public static void releaseIfNeeded(ReferenceCounted counted) {
        if (counted.refCnt() > 0) {
            ReferenceCountUtil.safeRelease(counted);
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean isTlsv13Supported() {
        return TLSV13_SUPPORTED;
    }

    /* access modifiers changed from: package-private */
    public static boolean isBoringSSL() {
        return IS_BORINGSSL;
    }
}
