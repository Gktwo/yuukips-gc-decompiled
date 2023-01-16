package p013io.netty.channel.socket.nio;

import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.Channel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.util.internal.SuppressJava6Requirement;

@SuppressJava6Requirement(reason = "Usage explicit by the user")
/* renamed from: io.netty.channel.socket.nio.NioChannelOption */
/* loaded from: grasscutter.jar:io/netty/channel/socket/nio/NioChannelOption.class */
public final class NioChannelOption<T> extends ChannelOption<T> {
    private final SocketOption<T> option;

    private NioChannelOption(SocketOption<T> option) {
        super(option.name());
        this.option = option;
    }

    /* renamed from: of */
    public static <T> ChannelOption<T> m1176of(SocketOption<T> option) {
        return new NioChannelOption(option);
    }

    /* access modifiers changed from: package-private */
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <T> boolean setOption(Channel jdkChannel, NioChannelOption<T> option, T value) {
        NetworkChannel channel = (NetworkChannel) jdkChannel;
        if (!channel.supportedOptions().contains(((NioChannelOption) option).option)) {
            return false;
        }
        if ((channel instanceof ServerSocketChannel) && ((NioChannelOption) option).option == StandardSocketOptions.IP_TOS) {
            return false;
        }
        try {
            channel.setOption(((NioChannelOption) option).option, value);
            return true;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static <T> T getOption(Channel jdkChannel, NioChannelOption<T> option) {
        NetworkChannel channel = (NetworkChannel) jdkChannel;
        if (!channel.supportedOptions().contains(((NioChannelOption) option).option)) {
            return null;
        }
        if ((channel instanceof ServerSocketChannel) && ((NioChannelOption) option).option == StandardSocketOptions.IP_TOS) {
            return null;
        }
        try {
            return (T) channel.getOption(((NioChannelOption) option).option);
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static ChannelOption[] getOptions(Channel jdkChannel) {
        NetworkChannel channel = (NetworkChannel) jdkChannel;
        Set<SocketOption<?>> supportedOpts = channel.supportedOptions();
        if (channel instanceof ServerSocketChannel) {
            List<ChannelOption<?>> extraOpts = new ArrayList<>(supportedOpts.size());
            for (SocketOption<?> opt : supportedOpts) {
                if (opt != StandardSocketOptions.IP_TOS) {
                    extraOpts.add(new NioChannelOption<>(opt));
                }
            }
            return (ChannelOption[]) extraOpts.toArray(new ChannelOption[0]);
        }
        ChannelOption<?>[] extraOpts2 = new ChannelOption[supportedOpts.size()];
        int i = 0;
        for (SocketOption<?> opt2 : supportedOpts) {
            i++;
            extraOpts2[i] = new NioChannelOption<>(opt2);
        }
        return extraOpts2;
    }
}
