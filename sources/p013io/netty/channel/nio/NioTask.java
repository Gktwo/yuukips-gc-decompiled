package p013io.netty.channel.nio;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* renamed from: io.netty.channel.nio.NioTask */
/* loaded from: grasscutter.jar:io/netty/channel/nio/NioTask.class */
public interface NioTask<C extends SelectableChannel> {
    void channelReady(C c, SelectionKey selectionKey) throws Exception;

    void channelUnregistered(C c, Throwable th) throws Exception;
}
