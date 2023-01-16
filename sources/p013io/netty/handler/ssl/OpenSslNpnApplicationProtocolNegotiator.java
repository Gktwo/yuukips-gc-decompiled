package p013io.netty.handler.ssl;

import java.util.List;
import p013io.netty.handler.ssl.ApplicationProtocolConfig;
import p013io.netty.util.internal.ObjectUtil;

@Deprecated
/* renamed from: io.netty.handler.ssl.OpenSslNpnApplicationProtocolNegotiator */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslNpnApplicationProtocolNegotiator.class */
public final class OpenSslNpnApplicationProtocolNegotiator implements OpenSslApplicationProtocolNegotiator {
    private final List<String> protocols;

    public OpenSslNpnApplicationProtocolNegotiator(Iterable<String> protocols) {
        this.protocols = (List) ObjectUtil.checkNotNull(ApplicationProtocolUtil.toList(protocols), "protocols");
    }

    public OpenSslNpnApplicationProtocolNegotiator(String... protocols) {
        this.protocols = (List) ObjectUtil.checkNotNull(ApplicationProtocolUtil.toList(protocols), "protocols");
    }

    @Override // p013io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.Protocol protocol() {
        return ApplicationProtocolConfig.Protocol.NPN;
    }

    @Override // p013io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List<String> protocols() {
        return this.protocols;
    }

    @Override // p013io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior() {
        return ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
    }

    @Override // p013io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
    public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
        return ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
    }
}
