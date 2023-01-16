package p013io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* renamed from: io.netty.channel.unix.NativeInetAddress */
/* loaded from: grasscutter.jar:io/netty/channel/unix/NativeInetAddress.class */
public final class NativeInetAddress {
    private static final byte[] IPV4_MAPPED_IPV6_PREFIX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1};
    final byte[] address;
    final int scopeId;

    public static NativeInetAddress newInstance(InetAddress addr) {
        byte[] bytes = addr.getAddress();
        if (addr instanceof Inet6Address) {
            return new NativeInetAddress(bytes, ((Inet6Address) addr).getScopeId());
        }
        return new NativeInetAddress(ipv4MappedIpv6Address(bytes));
    }

    public NativeInetAddress(byte[] address, int scopeId) {
        this.address = address;
        this.scopeId = scopeId;
    }

    public NativeInetAddress(byte[] address) {
        this(address, 0);
    }

    public byte[] address() {
        return this.address;
    }

    public int scopeId() {
        return this.scopeId;
    }

    public static byte[] ipv4MappedIpv6Address(byte[] ipv4) {
        byte[] address = new byte[16];
        copyIpv4MappedIpv6Address(ipv4, address);
        return address;
    }

    public static void copyIpv4MappedIpv6Address(byte[] ipv4, byte[] ipv6) {
        System.arraycopy(IPV4_MAPPED_IPV6_PREFIX, 0, ipv6, 0, IPV4_MAPPED_IPV6_PREFIX.length);
        System.arraycopy(ipv4, 0, ipv6, 12, ipv4.length);
    }

    public static InetSocketAddress address(byte[] addr, int offset, int len) {
        InetAddress address;
        int port = decodeInt(addr, (offset + len) - 4);
        try {
            switch (len) {
                case 8:
                    byte[] ipv4 = new byte[4];
                    System.arraycopy(addr, offset, ipv4, 0, 4);
                    address = InetAddress.getByAddress(ipv4);
                    break;
                case 24:
                    byte[] ipv6 = new byte[16];
                    System.arraycopy(addr, offset, ipv6, 0, 16);
                    address = Inet6Address.getByAddress((String) null, ipv6, decodeInt(addr, (offset + len) - 8));
                    break;
                default:
                    throw new Error();
            }
            return new InetSocketAddress(address, port);
        } catch (UnknownHostException e) {
            throw new Error("Should never happen", e);
        }
    }

    static int decodeInt(byte[] addr, int index) {
        return ((addr[index] & 255) << 24) | ((addr[index + 1] & 255) << 16) | ((addr[index + 2] & 255) << 8) | (addr[index + 3] & 255);
    }
}
