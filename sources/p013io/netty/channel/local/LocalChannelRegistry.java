package p013io.netty.channel.local;

import java.net.SocketAddress;
import java.util.concurrent.ConcurrentMap;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelException;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.channel.local.LocalChannelRegistry */
/* loaded from: grasscutter.jar:io/netty/channel/local/LocalChannelRegistry.class */
final class LocalChannelRegistry {
    private static final ConcurrentMap<LocalAddress, Channel> boundChannels = PlatformDependent.newConcurrentHashMap();

    /* access modifiers changed from: package-private */
    public static LocalAddress register(Channel channel, LocalAddress oldLocalAddress, SocketAddress localAddress) {
        if (oldLocalAddress != null) {
            throw new ChannelException("already bound");
        } else if (!(localAddress instanceof LocalAddress)) {
            throw new ChannelException("unsupported address type: " + StringUtil.simpleClassName(localAddress));
        } else {
            LocalAddress addr = (LocalAddress) localAddress;
            if (LocalAddress.ANY.equals(addr)) {
                addr = new LocalAddress(channel);
            }
            Channel boundChannel = boundChannels.putIfAbsent(addr, channel);
            if (boundChannel == null) {
                return addr;
            }
            throw new ChannelException("address already in use by: " + boundChannel);
        }
    }

    /* access modifiers changed from: package-private */
    public static Channel get(SocketAddress localAddress) {
        return boundChannels.get(localAddress);
    }

    /* access modifiers changed from: package-private */
    public static void unregister(LocalAddress localAddress) {
        boundChannels.remove(localAddress);
    }

    private LocalChannelRegistry() {
    }
}
