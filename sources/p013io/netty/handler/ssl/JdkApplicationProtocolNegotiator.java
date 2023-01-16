package p013io.netty.handler.ssl;

import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLEngine;
import p013io.netty.buffer.ByteBufAllocator;

@Deprecated
/* renamed from: io.netty.handler.ssl.JdkApplicationProtocolNegotiator */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkApplicationProtocolNegotiator.class */
public interface JdkApplicationProtocolNegotiator extends ApplicationProtocolNegotiator {

    /* renamed from: io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelectionListener */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkApplicationProtocolNegotiator$ProtocolSelectionListener.class */
    public interface ProtocolSelectionListener {
        void unsupported();

        void selected(String str) throws Exception;
    }

    /* renamed from: io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkApplicationProtocolNegotiator$ProtocolSelectionListenerFactory.class */
    public interface ProtocolSelectionListenerFactory {
        ProtocolSelectionListener newListener(SSLEngine sSLEngine, List<String> list);
    }

    /* renamed from: io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelector */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkApplicationProtocolNegotiator$ProtocolSelector.class */
    public interface ProtocolSelector {
        void unsupported();

        String select(List<String> list) throws Exception;
    }

    /* renamed from: io.netty.handler.ssl.JdkApplicationProtocolNegotiator$ProtocolSelectorFactory */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkApplicationProtocolNegotiator$ProtocolSelectorFactory.class */
    public interface ProtocolSelectorFactory {
        ProtocolSelector newSelector(SSLEngine sSLEngine, Set<String> set);
    }

    /* renamed from: io.netty.handler.ssl.JdkApplicationProtocolNegotiator$SslEngineWrapperFactory */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkApplicationProtocolNegotiator$SslEngineWrapperFactory.class */
    public interface SslEngineWrapperFactory {
        SSLEngine wrapSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z);
    }

    SslEngineWrapperFactory wrapperFactory();

    ProtocolSelectorFactory protocolSelectorFactory();

    ProtocolSelectionListenerFactory protocolListenerFactory();

    /* renamed from: io.netty.handler.ssl.JdkApplicationProtocolNegotiator$AllocatorAwareSslEngineWrapperFactory */
    /* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkApplicationProtocolNegotiator$AllocatorAwareSslEngineWrapperFactory.class */
    public static abstract class AllocatorAwareSslEngineWrapperFactory implements SslEngineWrapperFactory {
        /* access modifiers changed from: package-private */
        public abstract SSLEngine wrapSslEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z);

        @Override // p013io.netty.handler.ssl.JdkApplicationProtocolNegotiator.SslEngineWrapperFactory
        public final SSLEngine wrapSslEngine(SSLEngine engine, JdkApplicationProtocolNegotiator applicationNegotiator, boolean isServer) {
            return wrapSslEngine(engine, ByteBufAllocator.DEFAULT, applicationNegotiator, isServer);
        }
    }
}
