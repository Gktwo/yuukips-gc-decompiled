package p013io.netty.channel.socket;

import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelPromise;

/* renamed from: io.netty.channel.socket.DuplexChannel */
/* loaded from: grasscutter.jar:io/netty/channel/socket/DuplexChannel.class */
public interface DuplexChannel extends Channel {
    boolean isInputShutdown();

    ChannelFuture shutdownInput();

    ChannelFuture shutdownInput(ChannelPromise channelPromise);

    boolean isOutputShutdown();

    ChannelFuture shutdownOutput();

    ChannelFuture shutdownOutput(ChannelPromise channelPromise);

    boolean isShutdown();

    ChannelFuture shutdown();

    ChannelFuture shutdown(ChannelPromise channelPromise);
}
