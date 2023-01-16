package p013io.netty.channel.embedded;

import p013io.netty.channel.ChannelId;

/* renamed from: io.netty.channel.embedded.EmbeddedChannelId */
/* loaded from: grasscutter.jar:io/netty/channel/embedded/EmbeddedChannelId.class */
final class EmbeddedChannelId implements ChannelId {
    private static final long serialVersionUID = -251711922203466130L;
    static final ChannelId INSTANCE = new EmbeddedChannelId();

    private EmbeddedChannelId() {
    }

    @Override // p013io.netty.channel.ChannelId
    public String asShortText() {
        return toString();
    }

    @Override // p013io.netty.channel.ChannelId
    public String asLongText() {
        return toString();
    }

    public int compareTo(ChannelId o) {
        if (o instanceof EmbeddedChannelId) {
            return 0;
        }
        return asLongText().compareTo(o.asLongText());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return obj instanceof EmbeddedChannelId;
    }

    @Override // java.lang.Object
    public String toString() {
        return "embedded";
    }
}
