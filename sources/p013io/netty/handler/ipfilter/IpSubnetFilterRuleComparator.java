package p013io.netty.handler.ipfilter;

import java.net.InetSocketAddress;
import java.util.Comparator;

/* renamed from: io.netty.handler.ipfilter.IpSubnetFilterRuleComparator */
/* loaded from: grasscutter.jar:io/netty/handler/ipfilter/IpSubnetFilterRuleComparator.class */
final class IpSubnetFilterRuleComparator implements Comparator<Object> {
    static final IpSubnetFilterRuleComparator INSTANCE = new IpSubnetFilterRuleComparator();

    private IpSubnetFilterRuleComparator() {
    }

    @Override // java.util.Comparator
    public int compare(Object o1, Object o2) {
        return ((IpSubnetFilterRule) o1).compareTo((InetSocketAddress) o2);
    }
}
