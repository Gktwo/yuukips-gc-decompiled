package p013io.netty.handler.ipfilter;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.internal.ObjectUtil;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.ipfilter.RuleBasedIpFilter */
/* loaded from: grasscutter.jar:io/netty/handler/ipfilter/RuleBasedIpFilter.class */
public class RuleBasedIpFilter extends AbstractRemoteAddressFilter<InetSocketAddress> {
    private final boolean acceptIfNotFound;
    private final List<IpFilterRule> rules;

    public RuleBasedIpFilter(IpFilterRule... rules) {
        this(true, rules);
    }

    public RuleBasedIpFilter(boolean acceptIfNotFound, IpFilterRule... rules) {
        ObjectUtil.checkNotNull(rules, "rules");
        this.acceptIfNotFound = acceptIfNotFound;
        this.rules = new ArrayList(rules.length);
        for (IpFilterRule rule : rules) {
            if (rule != null) {
                this.rules.add(rule);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean accept(ChannelHandlerContext ctx, InetSocketAddress remoteAddress) throws Exception {
        for (IpFilterRule rule : this.rules) {
            if (rule.matches(remoteAddress)) {
                return rule.ruleType() == IpFilterRuleType.ACCEPT;
            }
        }
        return this.acceptIfNotFound;
    }
}
