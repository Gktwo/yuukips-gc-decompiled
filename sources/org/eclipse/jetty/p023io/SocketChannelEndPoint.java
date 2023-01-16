package org.eclipse.jetty.p023io;

import java.net.Socket;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import org.eclipse.jetty.util.thread.Scheduler;

/* renamed from: org.eclipse.jetty.io.SocketChannelEndPoint */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/SocketChannelEndPoint.class */
public class SocketChannelEndPoint extends ChannelEndPoint {
    public SocketChannelEndPoint(SelectableChannel channel, ManagedSelector selector, SelectionKey key, Scheduler scheduler) {
        this((SocketChannel) channel, selector, key, scheduler);
    }

    public SocketChannelEndPoint(SocketChannel channel, ManagedSelector selector, SelectionKey key, Scheduler scheduler) {
        super(channel, selector, key, scheduler);
    }

    public Socket getSocket() {
        return getChannel().socket();
    }
}
