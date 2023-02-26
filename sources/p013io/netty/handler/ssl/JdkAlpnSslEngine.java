package p013io.netty.handler.ssl;

import java.nio.ByteBuffer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* access modifiers changed from: package-private */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
/* renamed from: io.netty.handler.ssl.JdkAlpnSslEngine */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkAlpnSslEngine.class */
public class JdkAlpnSslEngine extends JdkSslEngine {
    private final JdkApplicationProtocolNegotiator.ProtocolSelectionListener selectionListener;
    private final AlpnSelector alpnSelector;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !JdkAlpnSslEngine.class.desiredAssertionStatus();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.JdkAlpnSslEngine$AlpnSelector */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkAlpnSslEngine$AlpnSelector.class */
    public final class AlpnSelector implements BiFunction<SSLEngine, List<String>, String> {
        private final JdkApplicationProtocolNegotiator.ProtocolSelector selector;
        private boolean called;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !JdkAlpnSslEngine.class.desiredAssertionStatus();
        }

        AlpnSelector(JdkApplicationProtocolNegotiator.ProtocolSelector selector) {
            this.selector = selector;
        }

        public String apply(SSLEngine sslEngine, List<String> strings) {
            if ($assertionsDisabled || !this.called) {
                this.called = true;
                try {
                    String selected = this.selector.select(strings);
                    return selected == null ? "" : selected;
                } catch (Exception e) {
                    return null;
                }
            } else {
                throw new AssertionError();
            }
        }

        void checkUnsupported() {
            if (!this.called) {
                String protocol = JdkAlpnSslEngine.this.getApplicationProtocol();
                if (!$assertionsDisabled && protocol == null) {
                    throw new AssertionError();
                } else if (protocol.isEmpty()) {
                    this.selector.unsupported();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JdkAlpnSslEngine(SSLEngine engine, JdkApplicationProtocolNegotiator applicationNegotiator, boolean isServer, BiConsumer<SSLEngine, AlpnSelector> setHandshakeApplicationProtocolSelector, BiConsumer<SSLEngine, List<String>> setApplicationProtocols) {
        super(engine);
        if (isServer) {
            this.selectionListener = null;
            this.alpnSelector = new AlpnSelector(applicationNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(applicationNegotiator.protocols())));
            setHandshakeApplicationProtocolSelector.accept(engine, this.alpnSelector);
            return;
        }
        this.selectionListener = applicationNegotiator.protocolListenerFactory().newListener(this, applicationNegotiator.protocols());
        this.alpnSelector = null;
        setApplicationProtocols.accept(engine, applicationNegotiator.protocols());
    }

    /* access modifiers changed from: package-private */
    public JdkAlpnSslEngine(SSLEngine engine, JdkApplicationProtocolNegotiator applicationNegotiator, boolean isServer) {
        this(engine, applicationNegotiator, isServer, new BiConsumer<SSLEngine, AlpnSelector>() { // from class: io.netty.handler.ssl.JdkAlpnSslEngine.1
            public void accept(SSLEngine e, AlpnSelector s) {
                JdkAlpnSslUtils.setHandshakeApplicationProtocolSelector(e, s);
            }
        }, new BiConsumer<SSLEngine, List<String>>() { // from class: io.netty.handler.ssl.JdkAlpnSslEngine.2
            public void accept(SSLEngine e, List<String> p) {
                JdkAlpnSslUtils.setApplicationProtocols(e, p);
            }
        });
    }

    private SSLEngineResult verifyProtocolSelection(SSLEngineResult result) throws SSLException {
        if (result.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
            if (this.alpnSelector == null) {
                try {
                    String protocol = getApplicationProtocol();
                    if (!$assertionsDisabled && protocol == null) {
                        throw new AssertionError();
                    } else if (protocol.isEmpty()) {
                        this.selectionListener.unsupported();
                    } else {
                        this.selectionListener.selected(protocol);
                    }
                } catch (Throwable e) {
                    throw SslUtils.toSSLHandshakeException(e);
                }
            } else if ($assertionsDisabled || this.selectionListener == null) {
                this.alpnSelector.checkUnsupported();
            } else {
                throw new AssertionError();
            }
        }
        return result;
    }

    @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        return verifyProtocolSelection(wrap(src, dst));
    }

    @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] srcs, ByteBuffer dst) throws SSLException {
        return verifyProtocolSelection(wrap(srcs, dst));
    }

    @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] srcs, int offset, int len, ByteBuffer dst) throws SSLException {
        return verifyProtocolSelection(wrap(srcs, offset, len, dst));
    }

    @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        return verifyProtocolSelection(unwrap(src, dst));
    }

    @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts) throws SSLException {
        return verifyProtocolSelection(unwrap(src, dsts));
    }

    @Override // p013io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dst, int offset, int len) throws SSLException {
        return verifyProtocolSelection(unwrap(src, dst, offset, len));
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.handler.ssl.JdkSslEngine
    public void setNegotiatedApplicationProtocol(String applicationProtocol) {
    }

    @Override // p013io.netty.handler.ssl.JdkSslEngine, p013io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        String protocol = getApplicationProtocol();
        if (protocol == null || protocol.isEmpty()) {
            return null;
        }
        return protocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return JdkAlpnSslUtils.getApplicationProtocol(getWrappedEngine());
    }

    @Override // javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return JdkAlpnSslUtils.getHandshakeApplicationProtocol(getWrappedEngine());
    }

    @Override // javax.net.ssl.SSLEngine
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> selector) {
        JdkAlpnSslUtils.setHandshakeApplicationProtocolSelector(getWrappedEngine(), selector);
    }

    @Override // javax.net.ssl.SSLEngine
    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return JdkAlpnSslUtils.getHandshakeApplicationProtocolSelector(getWrappedEngine());
    }
}
