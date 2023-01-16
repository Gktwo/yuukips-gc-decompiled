package p013io.netty.channel.kqueue;

import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.unix.UnixChannelOption;

/* renamed from: io.netty.channel.kqueue.KQueueChannelOption */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueChannelOption.class */
public final class KQueueChannelOption<T> extends UnixChannelOption<T> {
    public static final ChannelOption<Integer> SO_SNDLOWAT = valueOf(KQueueChannelOption.class, "SO_SNDLOWAT");
    public static final ChannelOption<Boolean> TCP_NOPUSH = valueOf(KQueueChannelOption.class, "TCP_NOPUSH");
    public static final ChannelOption<AcceptFilter> SO_ACCEPTFILTER = valueOf(KQueueChannelOption.class, "SO_ACCEPTFILTER");
    public static final ChannelOption<Boolean> RCV_ALLOC_TRANSPORT_PROVIDES_GUESS = valueOf(KQueueChannelOption.class, "RCV_ALLOC_TRANSPORT_PROVIDES_GUESS");

    private KQueueChannelOption() {
    }
}
