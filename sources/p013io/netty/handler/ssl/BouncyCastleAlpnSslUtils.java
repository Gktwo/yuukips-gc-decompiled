package p013io.netty.handler.ssl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.SuppressJava6Requirement;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* access modifiers changed from: package-private */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
/* renamed from: io.netty.handler.ssl.BouncyCastleAlpnSslUtils */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/BouncyCastleAlpnSslUtils.class */
public final class BouncyCastleAlpnSslUtils {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(BouncyCastleAlpnSslUtils.class);
    private static final Class BC_SSL_PARAMETERS;
    private static final Method SET_PARAMETERS;
    private static final Method SET_APPLICATION_PROTOCOLS;
    private static final Method GET_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL;
    private static final Method SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Class BC_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method BC_APPLICATION_PROTOCOL_SELECTOR_SELECT;

    static {
        final Class bcApplicationProtocolSelector;
        Method bcApplicationProtocolSelectorSelect;
        Method getHandshakeApplicationProtocolSelector;
        Method setHandshakeApplicationProtocolSelector;
        Method getHandshakeApplicationProtocol;
        Method getApplicationProtocol;
        Method setApplicationProtocols;
        Method setParameters;
        final Class bcSslParameters;
        try {
            final Class bcSslEngine = Class.forName("org.bouncycastle.jsse.BCSSLEngine");
            bcSslParameters = Class.forName("org.bouncycastle.jsse.BCSSLParameters");
            Object bcSslParametersInstance = bcSslParameters.newInstance();
            bcApplicationProtocolSelector = Class.forName("org.bouncycastle.jsse.BCApplicationProtocolSelector");
            bcApplicationProtocolSelectorSelect = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.1
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return bcApplicationProtocolSelector.getMethod("select", Object.class, List.class);
                }
            });
            SSLEngine engine = SslUtils.getSSLContext("BCJSSE").createSSLEngine();
            setParameters = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.2
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return bcSslEngine.getMethod("setParameters", bcSslParameters);
                }
            });
            setParameters.invoke(engine, bcSslParametersInstance);
            setApplicationProtocols = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.3
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return bcSslParameters.getMethod("setApplicationProtocols", String[].class);
                }
            });
            setApplicationProtocols.invoke(bcSslParametersInstance, EmptyArrays.EMPTY_STRINGS);
            getApplicationProtocol = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.4
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return bcSslEngine.getMethod("getApplicationProtocol", new Class[0]);
                }
            });
            getApplicationProtocol.invoke(engine, new Object[0]);
            getHandshakeApplicationProtocol = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.5
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return bcSslEngine.getMethod("getHandshakeApplicationProtocol", new Class[0]);
                }
            });
            getHandshakeApplicationProtocol.invoke(engine, new Object[0]);
            setHandshakeApplicationProtocolSelector = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.6
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return bcSslEngine.getMethod("setBCHandshakeApplicationProtocolSelector", bcApplicationProtocolSelector);
                }
            });
            getHandshakeApplicationProtocolSelector = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.7
                @Override // java.security.PrivilegedExceptionAction
                public Method run() throws Exception {
                    return bcSslEngine.getMethod("getBCHandshakeApplicationProtocolSelector", new Class[0]);
                }
            });
            getHandshakeApplicationProtocolSelector.invoke(engine, new Object[0]);
        } catch (Throwable t) {
            logger.error("Unable to initialize BouncyCastleAlpnSslUtils.", t);
            bcSslParameters = null;
            setParameters = null;
            setApplicationProtocols = null;
            getApplicationProtocol = null;
            getHandshakeApplicationProtocol = null;
            setHandshakeApplicationProtocolSelector = null;
            getHandshakeApplicationProtocolSelector = null;
            bcApplicationProtocolSelectorSelect = null;
            bcApplicationProtocolSelector = null;
        }
        BC_SSL_PARAMETERS = bcSslParameters;
        SET_PARAMETERS = setParameters;
        SET_APPLICATION_PROTOCOLS = setApplicationProtocols;
        GET_APPLICATION_PROTOCOL = getApplicationProtocol;
        GET_HANDSHAKE_APPLICATION_PROTOCOL = getHandshakeApplicationProtocol;
        SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = setHandshakeApplicationProtocolSelector;
        GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = getHandshakeApplicationProtocolSelector;
        BC_APPLICATION_PROTOCOL_SELECTOR_SELECT = bcApplicationProtocolSelectorSelect;
        BC_APPLICATION_PROTOCOL_SELECTOR = bcApplicationProtocolSelector;
    }

    private BouncyCastleAlpnSslUtils() {
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
    public static void setApplicationProtocols(SSLEngine engine, List<String> supportedProtocols) {
        SSLParameters parameters = engine.getSSLParameters();
        String[] protocolArray = (String[]) supportedProtocols.toArray(EmptyArrays.EMPTY_STRINGS);
        try {
            Object bcSslParameters = BC_SSL_PARAMETERS.newInstance();
            SET_APPLICATION_PROTOCOLS.invoke(bcSslParameters, protocolArray);
            SET_PARAMETERS.invoke(engine, bcSslParameters);
            engine.setSSLParameters(parameters);
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
    public static void setHandshakeApplicationProtocolSelector(SSLEngine engine, final BiFunction<SSLEngine, List<String>, String> selector) {
        try {
            SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(engine, Proxy.newProxyInstance(BouncyCastleAlpnSslUtils.class.getClassLoader(), new Class[]{BC_APPLICATION_PROTOCOL_SELECTOR}, new InvocationHandler() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.8
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().equals("select")) {
                        try {
                            return selector.apply((SSLEngine) args[0], (List) args[1]);
                        } catch (ClassCastException e) {
                            throw new RuntimeException("BCApplicationProtocolSelector select method parameter of invalid type.", e);
                        }
                    } else {
                        throw new UnsupportedOperationException(String.format("Method '%s' not supported.", method.getName()));
                    }
                }
            }));
        } catch (UnsupportedOperationException ex) {
            throw ex;
        } catch (Exception ex2) {
            throw new IllegalStateException(ex2);
        }
    }

    /* access modifiers changed from: package-private */
    public static BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector(SSLEngine engine) {
        try {
            final Object selector = GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(engine, new Object[0]);
            return new BiFunction<SSLEngine, List<String>, String>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.9
                public String apply(SSLEngine sslEngine, List<String> strings) {
                    try {
                        return (String) BouncyCastleAlpnSslUtils.BC_APPLICATION_PROTOCOL_SELECTOR_SELECT.invoke(selector, sslEngine, strings);
                    } catch (Exception e) {
                        throw new RuntimeException("Could not call getHandshakeApplicationProtocolSelector", e);
                    }
                }
            };
        } catch (UnsupportedOperationException ex) {
            throw ex;
        } catch (Exception ex2) {
            throw new IllegalStateException(ex2);
        }
    }
}
