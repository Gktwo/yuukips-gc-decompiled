package p013io.netty.handler.ipfilter;

import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import p013io.netty.util.NetUtil;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.SocketUtils;

/* renamed from: io.netty.handler.ipfilter.IpSubnetFilterRule */
/* loaded from: grasscutter.jar:io/netty/handler/ipfilter/IpSubnetFilterRule.class */
public final class IpSubnetFilterRule implements IpFilterRule, Comparable<IpSubnetFilterRule> {
    private final IpFilterRule filterRule;
    private final String ipAddress;

    public IpSubnetFilterRule(String ipAddress, int cidrPrefix, IpFilterRuleType ruleType) {
        try {
            this.ipAddress = ipAddress;
            this.filterRule = selectFilterRule(SocketUtils.addressByName(ipAddress), cidrPrefix, ruleType);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("ipAddress", e);
        }
    }

    public IpSubnetFilterRule(InetAddress ipAddress, int cidrPrefix, IpFilterRuleType ruleType) {
        this.ipAddress = ipAddress.getHostAddress();
        this.filterRule = selectFilterRule(ipAddress, cidrPrefix, ruleType);
    }

    private static IpFilterRule selectFilterRule(InetAddress ipAddress, int cidrPrefix, IpFilterRuleType ruleType) {
        ObjectUtil.checkNotNull(ipAddress, "ipAddress");
        ObjectUtil.checkNotNull(ruleType, "ruleType");
        if (ipAddress instanceof Inet4Address) {
            return new Ip4SubnetFilterRule((Inet4Address) ipAddress, cidrPrefix, ruleType);
        }
        if (ipAddress instanceof Inet6Address) {
            return new Ip6SubnetFilterRule((Inet6Address) ipAddress, cidrPrefix, ruleType);
        }
        throw new IllegalArgumentException("Only IPv4 and IPv6 addresses are supported");
    }

    @Override // p013io.netty.handler.ipfilter.IpFilterRule
    public boolean matches(InetSocketAddress remoteAddress) {
        return this.filterRule.matches(remoteAddress);
    }

    @Override // p013io.netty.handler.ipfilter.IpFilterRule
    public IpFilterRuleType ruleType() {
        return this.filterRule.ruleType();
    }

    /* access modifiers changed from: package-private */
    public String getIpAddress() {
        return this.ipAddress;
    }

    /* access modifiers changed from: package-private */
    public IpFilterRule getFilterRule() {
        return this.filterRule;
    }

    public int compareTo(IpSubnetFilterRule ipSubnetFilterRule) {
        if (this.filterRule instanceof Ip4SubnetFilterRule) {
            return compareInt(((Ip4SubnetFilterRule) this.filterRule).networkAddress, ((Ip4SubnetFilterRule) ipSubnetFilterRule.filterRule).networkAddress);
        }
        return ((Ip6SubnetFilterRule) this.filterRule).networkAddress.compareTo(((Ip6SubnetFilterRule) ipSubnetFilterRule.filterRule).networkAddress);
    }

    /* access modifiers changed from: package-private */
    public int compareTo(InetSocketAddress inetSocketAddress) {
        if (this.filterRule instanceof Ip4SubnetFilterRule) {
            Ip4SubnetFilterRule ip4SubnetFilterRule = (Ip4SubnetFilterRule) this.filterRule;
            return compareInt(ip4SubnetFilterRule.networkAddress, NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()) & ip4SubnetFilterRule.subnetMask);
        }
        Ip6SubnetFilterRule ip6SubnetFilterRule = (Ip6SubnetFilterRule) this.filterRule;
        return ip6SubnetFilterRule.networkAddress.compareTo(Ip6SubnetFilterRule.ipToInt((Inet6Address) inetSocketAddress.getAddress()).and(ip6SubnetFilterRule.networkAddress));
    }

    private static int compareInt(int x, int y) {
        if (x < y) {
            return -1;
        }
        return x == y ? 0 : 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ipfilter.IpSubnetFilterRule$Ip4SubnetFilterRule */
    /* loaded from: grasscutter.jar:io/netty/handler/ipfilter/IpSubnetFilterRule$Ip4SubnetFilterRule.class */
    public static final class Ip4SubnetFilterRule implements IpFilterRule {
        private final int networkAddress;
        private final int subnetMask;
        private final IpFilterRuleType ruleType;

        private Ip4SubnetFilterRule(Inet4Address ipAddress, int cidrPrefix, IpFilterRuleType ruleType) {
            if (cidrPrefix < 0 || cidrPrefix > 32) {
                throw new IllegalArgumentException(String.format("IPv4 requires the subnet prefix to be in range of [0,32]. The prefix was: %d", Integer.valueOf(cidrPrefix)));
            }
            this.subnetMask = prefixToSubnetMask(cidrPrefix);
            this.networkAddress = NetUtil.ipv4AddressToInt(ipAddress) & this.subnetMask;
            this.ruleType = ruleType;
        }

        @Override // p013io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress remoteAddress) {
            InetAddress inetAddress = remoteAddress.getAddress();
            return (inetAddress instanceof Inet4Address) && (NetUtil.ipv4AddressToInt((Inet4Address) inetAddress) & this.subnetMask) == this.networkAddress;
        }

        @Override // p013io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private static int prefixToSubnetMask(int cidrPrefix) {
            return (int) (-1 << (32 - cidrPrefix));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ipfilter.IpSubnetFilterRule$Ip6SubnetFilterRule */
    /* loaded from: grasscutter.jar:io/netty/handler/ipfilter/IpSubnetFilterRule$Ip6SubnetFilterRule.class */
    public static final class Ip6SubnetFilterRule implements IpFilterRule {
        private static final BigInteger MINUS_ONE;
        private final BigInteger networkAddress;
        private final BigInteger subnetMask;
        private final IpFilterRuleType ruleType;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !IpSubnetFilterRule.class.desiredAssertionStatus();
            MINUS_ONE = BigInteger.valueOf(-1);
        }

        private Ip6SubnetFilterRule(Inet6Address ipAddress, int cidrPrefix, IpFilterRuleType ruleType) {
            if (cidrPrefix < 0 || cidrPrefix > 128) {
                throw new IllegalArgumentException(String.format("IPv6 requires the subnet prefix to be in range of [0,128]. The prefix was: %d", Integer.valueOf(cidrPrefix)));
            }
            this.subnetMask = prefixToSubnetMask(cidrPrefix);
            this.networkAddress = ipToInt(ipAddress).and(this.subnetMask);
            this.ruleType = ruleType;
        }

        @Override // p013io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress remoteAddress) {
            InetAddress inetAddress = remoteAddress.getAddress();
            if (!(inetAddress instanceof Inet6Address)) {
                return false;
            }
            BigInteger ipAddress = ipToInt((Inet6Address) inetAddress);
            return ipAddress.and(this.subnetMask).equals(this.subnetMask) || ipAddress.and(this.subnetMask).equals(this.networkAddress);
        }

        @Override // p013io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        /* access modifiers changed from: private */
        public static BigInteger ipToInt(Inet6Address ipAddress) {
            byte[] octets = ipAddress.getAddress();
            if ($assertionsDisabled || octets.length == 16) {
                return new BigInteger(octets);
            }
            throw new AssertionError();
        }

        private static BigInteger prefixToSubnetMask(int cidrPrefix) {
            return MINUS_ONE.shiftLeft(128 - cidrPrefix);
        }
    }
}
