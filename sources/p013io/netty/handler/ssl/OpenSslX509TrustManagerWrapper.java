package p013io.netty.handler.ssl;

import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivilegedAction;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SuppressJava6Requirement;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
/* renamed from: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslX509TrustManagerWrapper.class */
final class OpenSslX509TrustManagerWrapper {
    private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(OpenSslX509TrustManagerWrapper.class);
    private static final TrustManagerWrapper WRAPPER;

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$TrustManagerWrapper */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslX509TrustManagerWrapper$TrustManagerWrapper.class */
    public interface TrustManagerWrapper {
        X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final SSLContext context;
        TrustManagerWrapper wrapper = new TrustManagerWrapper() { // from class: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.1
            @Override // p013io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.TrustManagerWrapper
            public X509TrustManager wrapIfNeeded(X509TrustManager manager) {
                return manager;
            }
        };
        Throwable cause = null;
        if (PlatformDependent.getUnsafeUnavailabilityCause() == null) {
            try {
                context = newSSLContext();
                context.init(null, new TrustManager[]{new X509TrustManager() { // from class: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.2
                    @Override // javax.net.ssl.X509TrustManager
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                        throw new CertificateException();
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                        throw new CertificateException();
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public X509Certificate[] getAcceptedIssuers() {
                        return EmptyArrays.EMPTY_X509_CERTIFICATES;
                    }
                }}, null);
            } catch (Throwable error) {
                context = null;
                cause = error;
            }
            if (cause != null) {
                LOGGER.debug("Unable to access wrapped TrustManager", cause);
            } else {
                Object maybeWrapper = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.3
                    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0052
                        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                        */
                    @Override // java.security.PrivilegedAction
                    public java.lang.Object run() {
                        /*
                            r7 = this;
                            java.lang.Class<javax.net.ssl.SSLContext> r0 = javax.net.ssl.SSLContext.class
                            java.lang.String r1 = "contextSpi"
                            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b
                            r8 = r0
                            r0 = r8
                            long r0 = p013io.netty.util.internal.PlatformDependent.objectFieldOffset(r0)     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b
                            r9 = r0
                            r0 = r7
                            javax.net.ssl.SSLContext r0 = r11     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b
                            r1 = r9
                            java.lang.Object r0 = p013io.netty.util.internal.PlatformDependent.getObject(r0, r1)     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b
                            r11 = r0
                            r0 = r11
                            if (r0 == 0) goto L_0x0060
                            r0 = r11
                            java.lang.Class r0 = r0.getClass()     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b
                            r12 = r0
                        L_0x0023:
                            r0 = r12
                            java.lang.String r1 = "trustManager"
                            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b, NoSuchFieldException -> 0x0052
                            r13 = r0
                            r0 = r13
                            long r0 = p013io.netty.util.internal.PlatformDependent.objectFieldOffset(r0)     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b, NoSuchFieldException -> 0x0052
                            r14 = r0
                            r0 = r11
                            r1 = r14
                            java.lang.Object r0 = p013io.netty.util.internal.PlatformDependent.getObject(r0, r1)     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b, NoSuchFieldException -> 0x0052
                            r16 = r0
                            r0 = r16
                            boolean r0 = r0 instanceof javax.net.ssl.X509ExtendedTrustManager     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b, NoSuchFieldException -> 0x0052
                            if (r0 == 0) goto L_0x004f
                            io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$UnsafeTrustManagerWrapper r0 = new io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$UnsafeTrustManagerWrapper     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b, NoSuchFieldException -> 0x0052
                            r1 = r0
                            r2 = r9
                            r3 = r14
                            r1.<init>(r2, r3)     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b, NoSuchFieldException -> 0x0052
                            return r0
                        L_0x004f:
                            goto L_0x0054
                        L_0x0052:
                            r13 = move-exception
                        L_0x0054:
                            r0 = r12
                            java.lang.Class r0 = r0.getSuperclass()     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b
                            r12 = r0
                            r0 = r12
                            if (r0 != 0) goto L_0x0023
                        L_0x0060:
                            java.lang.NoSuchFieldException r0 = new java.lang.NoSuchFieldException     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b
                            r1 = r0
                            r1.<init>()     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b
                            throw r0     // Catch: NoSuchFieldException -> 0x0068, SecurityException -> 0x006b
                        L_0x0068:
                            r8 = move-exception
                            r0 = r8
                            return r0
                        L_0x006b:
                            r8 = move-exception
                            r0 = r8
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.C30263.run():java.lang.Object");
                    }
                });
                if (maybeWrapper instanceof Throwable) {
                    LOGGER.debug("Unable to access wrapped TrustManager", (Throwable) maybeWrapper);
                } else {
                    wrapper = (TrustManagerWrapper) maybeWrapper;
                }
            }
        } else {
            LOGGER.debug("Unable to access wrapped TrustManager", (Throwable) null);
        }
        WRAPPER = wrapper;
    }

    private OpenSslX509TrustManagerWrapper() {
    }

    /* access modifiers changed from: package-private */
    public static X509TrustManager wrapIfNeeded(X509TrustManager trustManager) {
        return WRAPPER.wrapIfNeeded(trustManager);
    }

    /* access modifiers changed from: private */
    public static SSLContext newSSLContext() throws NoSuchAlgorithmException, NoSuchProviderException {
        return SSLContext.getInstance("TLS", "SunJSSE");
    }

    /* renamed from: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$UnsafeTrustManagerWrapper */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslX509TrustManagerWrapper$UnsafeTrustManagerWrapper.class */
    private static final class UnsafeTrustManagerWrapper implements TrustManagerWrapper {
        private final long spiOffset;
        private final long tmOffset;

        UnsafeTrustManagerWrapper(long spiOffset, long tmOffset) {
            this.spiOffset = spiOffset;
            this.tmOffset = tmOffset;
        }

        @Override // p013io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.TrustManagerWrapper
        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        public X509TrustManager wrapIfNeeded(X509TrustManager manager) {
            if (!(manager instanceof X509ExtendedTrustManager)) {
                try {
                    SSLContext ctx = OpenSslX509TrustManagerWrapper.newSSLContext();
                    ctx.init(null, new TrustManager[]{manager}, null);
                    Object spi = PlatformDependent.getObject(ctx, this.spiOffset);
                    if (spi != null) {
                        Object tm = PlatformDependent.getObject(spi, this.tmOffset);
                        if (tm instanceof X509ExtendedTrustManager) {
                            return (X509TrustManager) tm;
                        }
                    }
                } catch (KeyManagementException e) {
                    PlatformDependent.throwException(e);
                } catch (NoSuchAlgorithmException e2) {
                    PlatformDependent.throwException(e2);
                } catch (NoSuchProviderException e3) {
                    PlatformDependent.throwException(e3);
                }
            }
            return manager;
        }
    }
}
