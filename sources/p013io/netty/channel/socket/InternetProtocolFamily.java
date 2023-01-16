package p013io.netty.channel.socket;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import p013io.netty.util.NetUtil;

/* renamed from: io.netty.channel.socket.InternetProtocolFamily */
/* loaded from: grasscutter.jar:io/netty/channel/socket/InternetProtocolFamily.class */
public enum InternetProtocolFamily {
    IPv4(Inet4Address.class, 1),
    IPv6(Inet6Address.class, 2);
    
    private final Class<? extends InetAddress> addressType;
    private final int addressNumber;

    InternetProtocolFamily(Class cls, int addressNumber) {
        this.addressType = cls;
        this.addressNumber = addressNumber;
    }

    public Class<? extends InetAddress> addressType() {
        return this.addressType;
    }

    public int addressNumber() {
        return this.addressNumber;
    }

    public InetAddress localhost() {
        switch (this) {
            case IPv4:
                return NetUtil.LOCALHOST4;
            case IPv6:
                return NetUtil.LOCALHOST6;
            default:
                throw new IllegalStateException("Unsupported family " + this);
        }
    }

    /* renamed from: of */
    public static InternetProtocolFamily m1177of(InetAddress address) {
        if (address instanceof Inet4Address) {
            return IPv4;
        }
        if (address instanceof Inet6Address) {
            return IPv6;
        }
        throw new IllegalArgumentException("address " + address + " not supported");
    }
}
