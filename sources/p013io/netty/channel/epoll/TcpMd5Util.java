package p013io.netty.channel.epoll;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import p013io.netty.util.internal.ObjectUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.epoll.TcpMd5Util */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/TcpMd5Util.class */
public final class TcpMd5Util {
    /* access modifiers changed from: package-private */
    public static Collection<InetAddress> newTcpMd5Sigs(AbstractEpollChannel channel, Collection<InetAddress> current, Map<InetAddress, byte[]> newKeys) throws IOException {
        ObjectUtil.checkNotNull(channel, "channel");
        ObjectUtil.checkNotNull(current, "current");
        ObjectUtil.checkNotNull(newKeys, "newKeys");
        for (Map.Entry<InetAddress, byte[]> e : newKeys.entrySet()) {
            byte[] key = e.getValue();
            ObjectUtil.checkNotNullWithIAE(e.getKey(), "e.getKey");
            ObjectUtil.checkNonEmpty(key, e.getKey().toString());
            if (key.length > Native.TCP_MD5SIG_MAXKEYLEN) {
                throw new IllegalArgumentException("newKeys[" + e.getKey() + "] has a key with invalid length; should not exceed the maximum length (" + Native.TCP_MD5SIG_MAXKEYLEN + ')');
            }
        }
        for (InetAddress addr : current) {
            if (!newKeys.containsKey(addr)) {
                channel.socket.setTcpMd5Sig(addr, null);
            }
        }
        if (newKeys.isEmpty()) {
            return Collections.emptySet();
        }
        Collection<InetAddress> addresses = new ArrayList<>(newKeys.size());
        for (Map.Entry<InetAddress, byte[]> e2 : newKeys.entrySet()) {
            channel.socket.setTcpMd5Sig(e2.getKey(), e2.getValue());
            addresses.add(e2.getKey());
        }
        return addresses;
    }

    private TcpMd5Util() {
    }
}
