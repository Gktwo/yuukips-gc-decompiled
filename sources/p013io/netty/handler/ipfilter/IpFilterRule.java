package p013io.netty.handler.ipfilter;

import java.net.InetSocketAddress;

/* renamed from: io.netty.handler.ipfilter.IpFilterRule */
/* loaded from: grasscutter.jar:io/netty/handler/ipfilter/IpFilterRule.class */
public interface IpFilterRule {
    boolean matches(InetSocketAddress inetSocketAddress);

    IpFilterRuleType ruleType();
}
