package p013io.netty.channel;

import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.ChannelMetadata */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelMetadata.class */
public final class ChannelMetadata {
    private final boolean hasDisconnect;
    private final int defaultMaxMessagesPerRead;

    public ChannelMetadata(boolean hasDisconnect) {
        this(hasDisconnect, 1);
    }

    public ChannelMetadata(boolean hasDisconnect, int defaultMaxMessagesPerRead) {
        ObjectUtil.checkPositive(defaultMaxMessagesPerRead, "defaultMaxMessagesPerRead");
        this.hasDisconnect = hasDisconnect;
        this.defaultMaxMessagesPerRead = defaultMaxMessagesPerRead;
    }

    public boolean hasDisconnect() {
        return this.hasDisconnect;
    }

    public int defaultMaxMessagesPerRead() {
        return this.defaultMaxMessagesPerRead;
    }
}
