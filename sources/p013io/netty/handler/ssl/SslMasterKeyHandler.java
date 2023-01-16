package p013io.netty.handler.ssl;

import java.lang.reflect.Field;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelInboundHandlerAdapter;
import p013io.netty.util.internal.ReflectionUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.ssl.SslMasterKeyHandler */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslMasterKeyHandler.class */
public abstract class SslMasterKeyHandler extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SslMasterKeyHandler.class);
    private static final Class<?> SSL_SESSIONIMPL_CLASS;
    private static final Field SSL_SESSIONIMPL_MASTER_SECRET_FIELD;
    public static final String SYSTEM_PROP_KEY = "io.netty.ssl.masterKeyHandler";
    private static final Throwable UNAVAILABILITY_CAUSE;

    protected abstract void accept(SecretKey secretKey, SSLSession sSLSession);

    static {
        Throwable cause;
        Class<?> clazz = null;
        Field field = null;
        try {
            clazz = Class.forName("sun.security.ssl.SSLSessionImpl");
            field = clazz.getDeclaredField("masterSecret");
            cause = ReflectionUtil.trySetAccessible(field, true);
        } catch (Throwable e) {
            cause = e;
            if (logger.isTraceEnabled()) {
                logger.debug("sun.security.ssl.SSLSessionImpl is unavailable.", e);
            } else {
                logger.debug("sun.security.ssl.SSLSessionImpl is unavailable: {}", e.getMessage());
            }
        }
        UNAVAILABILITY_CAUSE = cause;
        SSL_SESSIONIMPL_CLASS = clazz;
        SSL_SESSIONIMPL_MASTER_SECRET_FIELD = field;
    }

    protected SslMasterKeyHandler() {
    }

    public static void ensureSunSslEngineAvailability() {
        if (UNAVAILABILITY_CAUSE != null) {
            throw new IllegalStateException("Failed to find SSLSessionImpl on classpath", UNAVAILABILITY_CAUSE);
        }
    }

    public static Throwable sunSslEngineUnavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    public static boolean isSunSslEngineAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public final void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt == SslHandshakeCompletionEvent.SUCCESS && masterKeyHandlerEnabled()) {
            SSLEngine engine = ((SslHandler) ctx.pipeline().get(SslHandler.class)).engine();
            SSLSession sslSession = engine.getSession();
            if (isSunSslEngineAvailable() && sslSession.getClass().equals(SSL_SESSIONIMPL_CLASS)) {
                try {
                    accept((SecretKey) SSL_SESSIONIMPL_MASTER_SECRET_FIELD.get(sslSession), sslSession);
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException("Failed to access the field 'masterSecret' via reflection.", e);
                }
            } else if (OpenSsl.isAvailable() && (engine instanceof ReferenceCountedOpenSslEngine)) {
                accept(((ReferenceCountedOpenSslEngine) engine).masterKey(), sslSession);
            }
        }
        ctx.fireUserEventTriggered(evt);
    }

    protected boolean masterKeyHandlerEnabled() {
        return SystemPropertyUtil.getBoolean(SYSTEM_PROP_KEY, false);
    }

    public static SslMasterKeyHandler newWireSharkSslMasterKeyHandler() {
        return new WiresharkSslMasterKeyHandler();
    }

    /* renamed from: io.netty.handler.ssl.SslMasterKeyHandler$WiresharkSslMasterKeyHandler */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/SslMasterKeyHandler$WiresharkSslMasterKeyHandler.class */
    private static final class WiresharkSslMasterKeyHandler extends SslMasterKeyHandler {
        private static final InternalLogger wireshark_logger = InternalLoggerFactory.getInstance("io.netty.wireshark");

        private WiresharkSslMasterKeyHandler() {
        }

        @Override // p013io.netty.handler.ssl.SslMasterKeyHandler
        protected void accept(SecretKey masterKey, SSLSession session) {
            if (masterKey.getEncoded().length != 48) {
                throw new IllegalArgumentException("An invalid length master key was provided.");
            }
            wireshark_logger.warn("RSA Session-ID:{} Master-Key:{}", ByteBufUtil.hexDump(session.getId()).toLowerCase(), ByteBufUtil.hexDump(masterKey.getEncoded()).toLowerCase());
        }
    }
}
