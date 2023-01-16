package p013io.netty.bootstrap;

import java.util.Map;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.EventLoopGroup;
import p013io.netty.channel.ServerChannel;
import p013io.netty.util.AttributeKey;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.bootstrap.ServerBootstrapConfig */
/* loaded from: grasscutter.jar:io/netty/bootstrap/ServerBootstrapConfig.class */
public final class ServerBootstrapConfig extends AbstractBootstrapConfig<ServerBootstrap, ServerChannel> {
    /* access modifiers changed from: package-private */
    public ServerBootstrapConfig(ServerBootstrap bootstrap) {
        super(bootstrap);
    }

    public EventLoopGroup childGroup() {
        return ((ServerBootstrap) this.bootstrap).childGroup();
    }

    public ChannelHandler childHandler() {
        return ((ServerBootstrap) this.bootstrap).childHandler();
    }

    public Map<ChannelOption<?>, Object> childOptions() {
        return ((ServerBootstrap) this.bootstrap).childOptions();
    }

    public Map<AttributeKey<?>, Object> childAttrs() {
        return ((ServerBootstrap) this.bootstrap).childAttrs();
    }

    @Override // p013io.netty.bootstrap.AbstractBootstrapConfig
    public String toString() {
        StringBuilder buf = new StringBuilder(toString());
        buf.setLength(buf.length() - 1);
        buf.append(", ");
        EventLoopGroup childGroup = childGroup();
        if (childGroup != null) {
            buf.append("childGroup: ");
            buf.append(StringUtil.simpleClassName(childGroup));
            buf.append(", ");
        }
        Map<ChannelOption<?>, Object> childOptions = childOptions();
        if (!childOptions.isEmpty()) {
            buf.append("childOptions: ");
            buf.append(childOptions);
            buf.append(", ");
        }
        Map<AttributeKey<?>, Object> childAttrs = childAttrs();
        if (!childAttrs.isEmpty()) {
            buf.append("childAttrs: ");
            buf.append(childAttrs);
            buf.append(", ");
        }
        ChannelHandler childHandler = childHandler();
        if (childHandler != null) {
            buf.append("childHandler: ");
            buf.append(childHandler);
            buf.append(", ");
        }
        if (buf.charAt(buf.length() - 1) == '(') {
            buf.append(')');
        } else {
            buf.setCharAt(buf.length() - 2, ')');
            buf.setLength(buf.length() - 1);
        }
        return buf.toString();
    }
}
