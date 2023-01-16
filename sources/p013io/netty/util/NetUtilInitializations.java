package p013io.netty.util;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SocketUtils;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.NetUtilInitializations */
/* loaded from: grasscutter.jar:io/netty/util/NetUtilInitializations.class */
final class NetUtilInitializations {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(NetUtilInitializations.class);

    private NetUtilInitializations() {
    }

    /* access modifiers changed from: package-private */
    public static Inet4Address createLocalhost4() {
        Inet4Address localhost4 = null;
        try {
            localhost4 = (Inet4Address) InetAddress.getByAddress("localhost", new byte[]{Byte.MAX_VALUE, 0, 0, 1});
        } catch (Exception e) {
            PlatformDependent.throwException(e);
        }
        return localhost4;
    }

    /* access modifiers changed from: package-private */
    public static Inet6Address createLocalhost6() {
        Inet6Address localhost6 = null;
        try {
            localhost6 = (Inet6Address) InetAddress.getByAddress("localhost", new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
        } catch (Exception e) {
            PlatformDependent.throwException(e);
        }
        return localhost6;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0143 */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public static NetworkIfaceAndInetAddress determineLoopback(Inet4Address localhost4, Inet6Address localhost6) {
        InetAddress loopbackAddr;
        List<NetworkInterface> ifaces = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (interfaces != null) {
                while (interfaces.hasMoreElements()) {
                    NetworkInterface iface = interfaces.nextElement();
                    if (SocketUtils.addressesFromNetworkInterface(iface).hasMoreElements()) {
                        ifaces.add(iface);
                    }
                }
            }
        } catch (SocketException e) {
            logger.warn("Failed to retrieve the list of available network interfaces", (Throwable) e);
        }
        NetworkInterface loopbackIface = null;
        InetAddress loopbackAddr2 = null;
        Iterator<NetworkInterface> it = ifaces.iterator();
        loop1: while (true) {
            if (!it.hasNext()) {
                break;
            }
            NetworkInterface iface2 = it.next();
            Enumeration<InetAddress> i = SocketUtils.addressesFromNetworkInterface(iface2);
            while (i.hasMoreElements()) {
                InetAddress addr = i.nextElement();
                if (addr.isLoopbackAddress()) {
                    loopbackIface = iface2;
                    loopbackAddr2 = addr;
                    break loop1;
                }
            }
        }
        if (loopbackIface == null) {
            try {
                Iterator<NetworkInterface> it2 = ifaces.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    NetworkInterface iface3 = it2.next();
                    if (iface3.isLoopback()) {
                        Enumeration<InetAddress> i2 = SocketUtils.addressesFromNetworkInterface(iface3);
                        if (i2.hasMoreElements()) {
                            loopbackIface = iface3;
                            loopbackAddr2 = i2.nextElement();
                            break;
                        }
                    }
                }
                if (loopbackIface == null) {
                    logger.warn("Failed to find the loopback interface");
                }
            } catch (SocketException e2) {
                logger.warn("Failed to find the loopback interface", (Throwable) e2);
            }
        }
        if (loopbackIface != null) {
            logger.debug("Loopback interface: {} ({}, {})", loopbackIface.getName(), loopbackIface.getDisplayName(), loopbackAddr2.getHostAddress());
            loopbackAddr = loopbackAddr2;
        } else {
            loopbackAddr = loopbackAddr2;
            if (loopbackAddr2 == null) {
                try {
                    InetAddress loopbackAddr3 = loopbackAddr2;
                    if (NetworkInterface.getByInetAddress(localhost6) != null) {
                        logger.debug("Using hard-coded IPv6 localhost address: {}", localhost6);
                        loopbackAddr2 = localhost6;
                        loopbackAddr3 = loopbackAddr2;
                    }
                    loopbackAddr = loopbackAddr3;
                    if (loopbackAddr3 == null) {
                        logger.debug("Using hard-coded IPv4 localhost address: {}", localhost4);
                        loopbackAddr = localhost4;
                    }
                } catch (Exception e3) {
                    loopbackAddr = loopbackAddr2;
                    if (loopbackAddr2 == null) {
                        logger.debug("Using hard-coded IPv4 localhost address: {}", localhost4);
                        loopbackAddr = localhost4;
                    }
                } catch (Throwable th) {
                    if (loopbackAddr2 == null) {
                        logger.debug("Using hard-coded IPv4 localhost address: {}", localhost4);
                    }
                    throw th;
                }
            }
        }
        return new NetworkIfaceAndInetAddress(loopbackIface, loopbackAddr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.util.NetUtilInitializations$NetworkIfaceAndInetAddress */
    /* loaded from: grasscutter.jar:io/netty/util/NetUtilInitializations$NetworkIfaceAndInetAddress.class */
    public static final class NetworkIfaceAndInetAddress {
        private final NetworkInterface iface;
        private final InetAddress address;

        NetworkIfaceAndInetAddress(NetworkInterface iface, InetAddress address) {
            this.iface = iface;
            this.address = address;
        }

        public NetworkInterface iface() {
            return this.iface;
        }

        public InetAddress address() {
            return this.address;
        }
    }
}
