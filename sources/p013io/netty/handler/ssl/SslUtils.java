package p013io.netty.handler.ssl;

import dev.morphia.mapping.Mapper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.base64.Base64;
import p013io.netty.handler.codec.base64.Base64Dialect;
import p013io.netty.util.NetUtil;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.SslUtils */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslUtils.class */
public final class SslUtils {
    static final int GMSSL_PROTOCOL_VERSION = 257;
    static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
    static final int SSL_CONTENT_TYPE_CHANGE_CIPHER_SPEC = 20;
    static final int SSL_CONTENT_TYPE_ALERT = 21;
    static final int SSL_CONTENT_TYPE_HANDSHAKE = 22;
    static final int SSL_CONTENT_TYPE_APPLICATION_DATA = 23;
    static final int SSL_CONTENT_TYPE_EXTENSION_HEARTBEAT = 24;
    static final int SSL_RECORD_HEADER_LENGTH = 5;
    static final int NOT_ENOUGH_DATA = -1;
    static final int NOT_ENCRYPTED = -2;
    static final String[] DEFAULT_CIPHER_SUITES;
    static final String[] DEFAULT_TLSV13_CIPHER_SUITES;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SslUtils.class);
    static final Set<String> TLSV13_CIPHERS = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(Ciphers.TLS_AES_256_GCM_SHA384, Ciphers.TLS_CHACHA20_POLY1305_SHA256, Ciphers.TLS_AES_128_GCM_SHA256, "TLS_AES_128_CCM_8_SHA256", "TLS_AES_128_CCM_SHA256")));
    static final String[] TLSV13_CIPHER_SUITES = {Ciphers.TLS_AES_128_GCM_SHA256, Ciphers.TLS_AES_256_GCM_SHA384};
    private static final boolean TLSV1_3_JDK_SUPPORTED = isTLSv13SupportedByJDK0(null);
    private static final boolean TLSV1_3_JDK_DEFAULT_ENABLED = isTLSv13EnabledByJDK0(null);

    static {
        if (TLSV1_3_JDK_SUPPORTED) {
            DEFAULT_TLSV13_CIPHER_SUITES = TLSV13_CIPHER_SUITES;
        } else {
            DEFAULT_TLSV13_CIPHER_SUITES = EmptyArrays.EMPTY_STRINGS;
        }
        Set<String> defaultCiphers = new LinkedHashSet<>();
        defaultCiphers.add(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384);
        defaultCiphers.add(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256);
        defaultCiphers.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256);
        defaultCiphers.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384);
        defaultCiphers.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
        defaultCiphers.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
        defaultCiphers.add(Ciphers.TLS_RSA_WITH_AES_128_GCM_SHA256);
        defaultCiphers.add(Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA);
        defaultCiphers.add(Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA);
        Collections.addAll(defaultCiphers, DEFAULT_TLSV13_CIPHER_SUITES);
        DEFAULT_CIPHER_SUITES = (String[]) defaultCiphers.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    /* access modifiers changed from: package-private */
    public static boolean isTLSv13SupportedByJDK(Provider provider) {
        if (provider == null) {
            return TLSV1_3_JDK_SUPPORTED;
        }
        return isTLSv13SupportedByJDK0(provider);
    }

    private static boolean isTLSv13SupportedByJDK0(Provider provider) {
        try {
            return arrayContains(newInitContext(provider).getSupportedSSLParameters().getProtocols(), SslProtocols.TLS_v1_3);
        } catch (Throwable cause) {
            logger.debug("Unable to detect if JDK SSLEngine with provider {} supports TLSv1.3, assuming no", provider, cause);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean isTLSv13EnabledByJDK(Provider provider) {
        if (provider == null) {
            return TLSV1_3_JDK_DEFAULT_ENABLED;
        }
        return isTLSv13EnabledByJDK0(provider);
    }

    private static boolean isTLSv13EnabledByJDK0(Provider provider) {
        try {
            return arrayContains(newInitContext(provider).getDefaultSSLParameters().getProtocols(), SslProtocols.TLS_v1_3);
        } catch (Throwable cause) {
            logger.debug("Unable to detect if JDK SSLEngine with provider {} enables TLSv1.3 by default, assuming no", provider, cause);
            return false;
        }
    }

    private static SSLContext newInitContext(Provider provider) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext context;
        if (provider == null) {
            context = SSLContext.getInstance("TLS");
        } else {
            context = SSLContext.getInstance("TLS", provider);
        }
        context.init(null, new TrustManager[0], null);
        return context;
    }

    /* access modifiers changed from: package-private */
    public static SSLContext getSSLContext(String provider) throws NoSuchAlgorithmException, KeyManagementException, NoSuchProviderException {
        SSLContext context;
        if (StringUtil.isNullOrEmpty(provider)) {
            context = SSLContext.getInstance(getTlsVersion());
        } else {
            context = SSLContext.getInstance(getTlsVersion(), provider);
        }
        context.init(null, new TrustManager[0], null);
        return context;
    }

    private static String getTlsVersion() {
        return TLSV1_3_JDK_SUPPORTED ? SslProtocols.TLS_v1_3 : SslProtocols.TLS_v1_2;
    }

    static boolean arrayContains(String[] array, String value) {
        for (String v : array) {
            if (value.equals(v)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public static void addIfSupported(Set<String> supported, List<String> enabled, String... names) {
        for (String n : names) {
            if (supported.contains(n)) {
                enabled.add(n);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static void useFallbackCiphersIfDefaultIsEmpty(List<String> defaultCiphers, Iterable<String> fallbackCiphers) {
        if (defaultCiphers.isEmpty()) {
            for (String cipher : fallbackCiphers) {
                if (!cipher.startsWith("SSL_") && !cipher.contains("_RC4_")) {
                    defaultCiphers.add(cipher);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static void useFallbackCiphersIfDefaultIsEmpty(List<String> defaultCiphers, String... fallbackCiphers) {
        useFallbackCiphersIfDefaultIsEmpty(defaultCiphers, Arrays.asList(fallbackCiphers));
    }

    /* access modifiers changed from: package-private */
    public static SSLHandshakeException toSSLHandshakeException(Throwable e) {
        if (e instanceof SSLHandshakeException) {
            return (SSLHandshakeException) e;
        }
        return (SSLHandshakeException) new SSLHandshakeException(e.getMessage()).initCause(e);
    }

    /* access modifiers changed from: package-private */
    public static int getEncryptedPacketLength(ByteBuf buffer, int offset) {
        boolean tls;
        int packetLength = 0;
        switch (buffer.getUnsignedByte(offset)) {
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                tls = true;
                break;
            default:
                tls = false;
                break;
        }
        if (tls) {
            if (buffer.getUnsignedByte(offset + 1) == 3 || buffer.getShort(offset + 1) == 257) {
                packetLength = unsignedShortBE(buffer, offset + 3) + 5;
                if (packetLength <= 5) {
                    tls = false;
                }
            } else {
                tls = false;
            }
        }
        if (!tls) {
            int headerLength = (buffer.getUnsignedByte(offset) & 128) != 0 ? 2 : 3;
            int majorVersion = buffer.getUnsignedByte(offset + headerLength + 1);
            if (majorVersion != 2 && majorVersion != 3) {
                return -2;
            }
            packetLength = headerLength == 2 ? (shortBE(buffer, offset) & Short.MAX_VALUE) + 2 : (shortBE(buffer, offset) & 16383) + 3;
            if (packetLength <= headerLength) {
                return -1;
            }
        }
        return packetLength;
    }

    private static int unsignedShortBE(ByteBuf buffer, int offset) {
        int value = buffer.getUnsignedShort(offset);
        if (buffer.order() == ByteOrder.LITTLE_ENDIAN) {
            value = Integer.reverseBytes(value) >>> 16;
        }
        return value;
    }

    private static short shortBE(ByteBuf buffer, int offset) {
        short value = buffer.getShort(offset);
        if (buffer.order() == ByteOrder.LITTLE_ENDIAN) {
            value = Short.reverseBytes(value);
        }
        return value;
    }

    private static short unsignedByte(byte b) {
        return (short) (b & 255);
    }

    private static int unsignedShortBE(ByteBuffer buffer, int offset) {
        return shortBE(buffer, offset) & 65535;
    }

    private static short shortBE(ByteBuffer buffer, int offset) {
        return buffer.order() == ByteOrder.BIG_ENDIAN ? buffer.getShort(offset) : ByteBufUtil.swapShort(buffer.getShort(offset));
    }

    /* access modifiers changed from: package-private */
    public static int getEncryptedPacketLength(ByteBuffer[] buffers, int offset) {
        ByteBuffer buffer = buffers[offset];
        if (buffer.remaining() >= 5) {
            return getEncryptedPacketLength(buffer);
        }
        ByteBuffer tmp = ByteBuffer.allocate(5);
        do {
            offset++;
            ByteBuffer buffer2 = buffers[offset].duplicate();
            if (buffer2.remaining() > tmp.remaining()) {
                buffer2.limit(buffer2.position() + tmp.remaining());
            }
            tmp.put(buffer2);
        } while (tmp.hasRemaining());
        tmp.flip();
        return getEncryptedPacketLength(tmp);
    }

    private static int getEncryptedPacketLength(ByteBuffer buffer) {
        boolean tls;
        int packetLength = 0;
        int pos = buffer.position();
        switch (unsignedByte(buffer.get(pos))) {
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                tls = true;
                break;
            default:
                tls = false;
                break;
        }
        if (tls) {
            if (unsignedByte(buffer.get(pos + 1)) == 3 || buffer.getShort(pos + 1) == 257) {
                packetLength = unsignedShortBE(buffer, pos + 3) + 5;
                if (packetLength <= 5) {
                    tls = false;
                }
            } else {
                tls = false;
            }
        }
        if (!tls) {
            int headerLength = (unsignedByte(buffer.get(pos)) & 128) != 0 ? 2 : 3;
            int majorVersion = unsignedByte(buffer.get(pos + headerLength + 1));
            if (majorVersion != 2 && majorVersion != 3) {
                return -2;
            }
            packetLength = headerLength == 2 ? (shortBE(buffer, pos) & Short.MAX_VALUE) + 2 : (shortBE(buffer, pos) & 16383) + 3;
            if (packetLength <= headerLength) {
                return -1;
            }
        }
        return packetLength;
    }

    /* access modifiers changed from: package-private */
    public static void handleHandshakeFailure(ChannelHandlerContext ctx, Throwable cause, boolean notify) {
        ctx.flush();
        if (notify) {
            ctx.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(cause));
        }
        ctx.close();
    }

    /* access modifiers changed from: package-private */
    public static void zeroout(ByteBuf buffer) {
        if (!buffer.isReadOnly()) {
            buffer.setZero(0, buffer.capacity());
        }
    }

    /* access modifiers changed from: package-private */
    public static void zerooutAndRelease(ByteBuf buffer) {
        zeroout(buffer);
        buffer.release();
    }

    /* access modifiers changed from: package-private */
    public static ByteBuf toBase64(ByteBufAllocator allocator, ByteBuf src) {
        ByteBuf dst = Base64.encode(src, src.readerIndex(), src.readableBytes(), true, Base64Dialect.STANDARD, allocator);
        src.readerIndex(src.writerIndex());
        return dst;
    }

    /* access modifiers changed from: package-private */
    public static boolean isValidHostNameForSNI(String hostname) {
        return hostname != null && hostname.indexOf(46) > 0 && !hostname.endsWith(Mapper.IGNORED_FIELDNAME) && !hostname.startsWith("/") && !NetUtil.isValidIpV4Address(hostname) && !NetUtil.isValidIpV6Address(hostname);
    }

    /* access modifiers changed from: package-private */
    public static boolean isTLSv13Cipher(String cipher) {
        return TLSV13_CIPHERS.contains(cipher);
    }

    private SslUtils() {
    }
}
