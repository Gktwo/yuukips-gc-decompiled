package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.List;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* renamed from: org.eclipse.jetty.io.NetworkTrafficSocketChannelEndPoint */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/NetworkTrafficSocketChannelEndPoint.class */
public class NetworkTrafficSocketChannelEndPoint extends SocketChannelEndPoint {
    private static final Logger LOG = Log.getLogger(NetworkTrafficSocketChannelEndPoint.class);
    private final List<NetworkTrafficListener> listeners;

    public NetworkTrafficSocketChannelEndPoint(SelectableChannel channel, ManagedSelector selectSet, SelectionKey key, Scheduler scheduler, long idleTimeout, List<NetworkTrafficListener> listeners) {
        super(channel, selectSet, key, scheduler);
        setIdleTimeout(idleTimeout);
        this.listeners = listeners;
    }

    @Override // org.eclipse.jetty.p023io.ChannelEndPoint, org.eclipse.jetty.p023io.EndPoint
    public int fill(ByteBuffer buffer) throws IOException {
        int read = fill(buffer);
        notifyIncoming(buffer, read);
        return read;
    }

    @Override // org.eclipse.jetty.p023io.ChannelEndPoint, org.eclipse.jetty.p023io.EndPoint
    public boolean flush(ByteBuffer... buffers) throws IOException {
        boolean flushed = true;
        for (ByteBuffer b : buffers) {
            if (b.hasRemaining()) {
                int position = b.position();
                ByteBuffer view = b.slice();
                flushed = flush(b);
                view.limit(view.position() + (b.position() - position));
                notifyOutgoing(view);
                if (!flushed) {
                    break;
                }
            }
        }
        return flushed;
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint, org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
    public void onOpen() {
        onOpen();
        if (!(this.listeners == null || this.listeners.isEmpty())) {
            for (NetworkTrafficListener listener : this.listeners) {
                try {
                    listener.opened(getSocket());
                } catch (Exception x) {
                    LOG.warn(x);
                }
            }
        }
    }

    @Override // org.eclipse.jetty.p023io.ChannelEndPoint, org.eclipse.jetty.p023io.AbstractEndPoint, org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
    public void onClose() {
        onClose();
        if (!(this.listeners == null || this.listeners.isEmpty())) {
            for (NetworkTrafficListener listener : this.listeners) {
                try {
                    listener.closed(getSocket());
                } catch (Exception x) {
                    LOG.warn(x);
                }
            }
        }
    }

    public void notifyIncoming(ByteBuffer buffer, int read) {
        if (!(this.listeners == null || this.listeners.isEmpty() || read <= 0)) {
            for (NetworkTrafficListener listener : this.listeners) {
                try {
                    listener.incoming(getSocket(), buffer.asReadOnlyBuffer());
                } catch (Exception x) {
                    LOG.warn(x);
                }
            }
        }
    }

    public void notifyOutgoing(ByteBuffer view) {
        if (!(this.listeners == null || this.listeners.isEmpty() || !view.hasRemaining())) {
            Socket socket = getSocket();
            for (NetworkTrafficListener listener : this.listeners) {
                try {
                    listener.outgoing(socket, view);
                } catch (Exception x) {
                    LOG.warn(x);
                }
            }
        }
    }
}
