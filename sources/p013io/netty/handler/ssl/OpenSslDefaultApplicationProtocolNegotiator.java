package p013io.netty.handler.ssl;

import java.util.List;
import p013io.netty.handler.ssl.ApplicationProtocolConfig;
import p013io.netty.util.internal.ObjectUtil;

@Deprecated
/* renamed from: io.netty.handler.ssl.OpenSslDefaultApplicationProtocolNegotiator */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslDefaultApplicationProtocolNegotiator.class */
public final class OpenSslDefaultApplicationProtocolNegotiator implements OpenSslApplicationProtocolNegotiator {
    private final ApplicationProtocolConfig config;

    public OpenSslDefaultApplicationProtocolNegotiator(ApplicationProtocolConfig config) {
        this.config = (ApplicationProtocolConfig) ObjectUtil.checkNotNull(config, "config");
    }

    @Override // p013io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List<String> protocols() {
        return this.config.supportedProtocols();
    }

    @Override // p013io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.Protocol protocol() {
        return this.config.protocol();
    }

    @Override // p013io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior() {
        return this.config.selectorFailureBehavior();
    }

    @Override // p013io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
        return this.config.selectedListenerFailureBehavior();
    }
}
