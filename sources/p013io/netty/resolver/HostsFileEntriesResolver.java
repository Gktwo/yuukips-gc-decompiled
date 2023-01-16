package p013io.netty.resolver;

import java.net.InetAddress;

/* renamed from: io.netty.resolver.HostsFileEntriesResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/HostsFileEntriesResolver.class */
public interface HostsFileEntriesResolver {
    public static final HostsFileEntriesResolver DEFAULT = new DefaultHostsFileEntriesResolver();

    InetAddress address(String str, ResolvedAddressTypes resolvedAddressTypes);
}
