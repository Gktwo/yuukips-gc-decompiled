package p013io.netty.handler.ssl;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SuppressJava6Requirement;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* access modifiers changed from: package-private */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
/* renamed from: io.netty.handler.ssl.JdkAlpnSslUtils */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkAlpnSslUtils.class */
public final class JdkAlpnSslUtils {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(JdkAlpnSslUtils.class);
    private static final Method SET_APPLICATION_PROTOCOLS;
    private static final Method GET_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL;
    private static final Method SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;

    static {
        Method getHandshakeApplicationProtocolSelector;
        Method setHandshakeApplicationProtocolSelector;
        Method setApplicationProtocols;
        Method getApplicationProtocol;
        Method getHandshakeApplicationProtocol;
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, null);
            SSLEngine engine = context.createSSLEngine();
            getHandshakeApplicationProtocol = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.JdkAlpnSslUtils.1
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("getHandshakeApplicationProtocol", new Class[0]);
                }
            });
            getHandshakeApplicationProtocol.invoke(engine, new Object[0]);
            getApplicationProtocol = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.JdkAlpnSslUtils.2
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
                }
            });
            getApplicationProtocol.invoke(engine, new Object[0]);
            setApplicationProtocols = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.JdkAlpnSslUtils.3
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                }
            });
            setApplicationProtocols.invoke(engine.getSSLParameters(), EmptyArrays.EMPTY_STRINGS);
            setHandshakeApplicationProtocolSelector = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.JdkAlpnSslUtils.4
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("setHandshakeApplicationProtocolSelector", BiFunction.class);
                }
            });
            setHandshakeApplicationProtocolSelector.invoke(engine, new BiFunction<SSLEngine, List<String>, String>() { // from class: io.netty.handler.ssl.JdkAlpnSslUtils.5
                public String apply(SSLEngine sslEngine, List<String> strings) {
                    return null;
                }
            });
            getHandshakeApplicationProtocolSelector = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.JdkAlpnSslUtils.6
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return SSLEngine.class.getMethod("getHandshakeApplicationProtocolSelector", new Class[0]);
                }
            });
            getHandshakeApplicationProtocolSelector.invoke(engine, new Object[0]);
        } catch (Throwable t) {
            int version = PlatformDependent.javaVersion();
            if (version >= 9) {
                logger.error("Unable to initialize JdkAlpnSslUtils, but the detected java version was: {}", Integer.valueOf(version), t);
            }
            getHandshakeApplicationProtocol = null;
            getApplicationProtocol = null;
            setApplicationProtocols = null;
            setHandshakeApplicationProtocolSelector = null;
            getHandshakeApplicationProtocolSelector = null;
        }
        GET_HANDSHAKE_APPLICATION_PROTOCOL = getHandshakeApplicationProtocol;
        GET_APPLICATION_PROTOCOL = getApplicationProtocol;
        SET_APPLICATION_PROTOCOLS = setApplicationProtocols;
        SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = setHandshakeApplicationProtocolSelector;
        GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = getHandshakeApplicationProtocolSelector;
    }

    private JdkAlpnSslUtils() {
    }

    /* access modifiers changed from: package-private */
    public static boolean supportsAlpn() {
        return GET_APPLICATION_PROTOCOL != null;
    }

    /* access modifiers changed from: package-private */
    public static String getApplicationProtocol(SSLEngine sslEngine) {
        try {
            return (String) GET_APPLICATION_PROTOCOL.invoke(sslEngine, new Object[0]);
        } catch (UnsupportedOperationException ex) {
            throw ex;
        } catch (Exception ex2) {
            throw new IllegalStateException(ex2);
        }
    }

    /* access modifiers changed from: package-private */
    public static String getHandshakeApplicationProtocol(SSLEngine sslEngine) {
        try {
            return (String) GET_HANDSHAKE_APPLICATION_PROTOCOL.invoke(sslEngine, new Object[0]);
        } catch (UnsupportedOperationException ex) {
            throw ex;
        } catch (Exception ex2) {
            throw new IllegalStateException(ex2);
        }
    }

    /* access modifiers changed from: package-private */
    public static void setApplicationProtocols(SSLEngine engine, List<String> supportedProtocols) {
        SSLParameters parameters = engine.getSSLParameters();
        try {
            SET_APPLICATION_PROTOCOLS.invoke(parameters, (String[]) supportedProtocols.toArray(EmptyArrays.EMPTY_STRINGS));
            engine.setSSLParameters(parameters);
        } catch (UnsupportedOperationException ex) {
            throw ex;
        } catch (Exception ex2) {
            throw new IllegalStateException(ex2);
        }
    }

    /* access modifiers changed from: package-private */
    public static void setHandshakeApplicationProtocolSelector(SSLEngine engine, BiFunction<SSLEngine, List<String>, String> selector) {
        try {
            SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(engine, selector);
        } catch (UnsupportedOperationException ex) {
            throw ex;
        } catch (Exception ex2) {
            throw new IllegalStateException(ex2);
        }
    }

    /* access modifiers changed from: package-private */
    public static BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector(SSLEngine engine) {
        try {
            return (BiFunction) GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(engine, new Object[0]);
        } catch (UnsupportedOperationException ex) {
            throw ex;
        } catch (Exception ex2) {
            throw new IllegalStateException(ex2);
        }
    }
}
