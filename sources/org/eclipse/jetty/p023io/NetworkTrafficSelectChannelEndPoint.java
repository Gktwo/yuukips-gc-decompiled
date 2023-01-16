package org.eclipse.jetty.p023io;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import org.eclipse.jetty.util.thread.Scheduler;

@Deprecated
/* renamed from: org.eclipse.jetty.io.NetworkTrafficSelectChannelEndPoint */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/NetworkTrafficSelectChannelEndPoint.class */
public class NetworkTrafficSelectChannelEndPoint extends NetworkTrafficSocketChannelEndPoint {
    public NetworkTrafficSelectChannelEndPoint(SocketChannel channel, ManagedSelector selectSet, SelectionKey key, Scheduler scheduler, long idleTimeout, List<NetworkTrafficListener> listeners) {
        super(channel, selectSet, key, scheduler, idleTimeout, listeners);
    }
}
