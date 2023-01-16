package org.eclipse.jetty.p023io;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import org.eclipse.jetty.util.thread.Scheduler;

@Deprecated
/* renamed from: org.eclipse.jetty.io.SelectChannelEndPoint */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/SelectChannelEndPoint.class */
public class SelectChannelEndPoint extends SocketChannelEndPoint {
    public SelectChannelEndPoint(SelectableChannel channel, ManagedSelector selector, SelectionKey key, Scheduler scheduler, long idleTimeout) {
        super(channel, selector, key, scheduler);
        setIdleTimeout(idleTimeout);
    }
}
