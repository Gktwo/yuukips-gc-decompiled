package p013io.netty.channel.unix;

import p013io.netty.channel.ChannelOption;

/* renamed from: io.netty.channel.unix.UnixChannelOption */
/* loaded from: grasscutter.jar:io/netty/channel/unix/UnixChannelOption.class */
public class UnixChannelOption<T> extends ChannelOption<T> {
    public static final ChannelOption<Boolean> SO_REUSEPORT = valueOf(UnixChannelOption.class, "SO_REUSEPORT");
    public static final ChannelOption<DomainSocketReadMode> DOMAIN_SOCKET_READ_MODE = ChannelOption.valueOf(UnixChannelOption.class, "DOMAIN_SOCKET_READ_MODE");

    /* access modifiers changed from: protected */
    public UnixChannelOption() {
        super(null);
    }

    /* access modifiers changed from: package-private */
    public UnixChannelOption(String name) {
        super(name);
    }
}
