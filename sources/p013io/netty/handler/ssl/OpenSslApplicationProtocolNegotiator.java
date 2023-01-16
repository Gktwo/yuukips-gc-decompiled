package p013io.netty.handler.ssl;

import p013io.netty.handler.ssl.ApplicationProtocolConfig;

@Deprecated
/* renamed from: io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslApplicationProtocolNegotiator.class */
public interface OpenSslApplicationProtocolNegotiator extends ApplicationProtocolNegotiator {
    ApplicationProtocolConfig.Protocol protocol();

    ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior();

    ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior();
}
