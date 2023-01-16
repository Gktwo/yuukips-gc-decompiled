package p013io.netty.channel;

import java.io.Serializable;

/* renamed from: io.netty.channel.ChannelId */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelId.class */
public interface ChannelId extends Serializable, Comparable<ChannelId> {
    String asShortText();

    String asLongText();
}
