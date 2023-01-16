package org.eclipse.jetty.server;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.thread.Scheduler;

@ManagedObject("AbstractNetworkConnector")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AbstractNetworkConnector.class */
public abstract class AbstractNetworkConnector extends AbstractConnector implements NetworkConnector {
    private volatile String _host;
    private volatile int _port = 0;

    public AbstractNetworkConnector(Server server, Executor executor, Scheduler scheduler, ByteBufferPool pool, int acceptors, ConnectionFactory... factories) {
        super(server, executor, scheduler, pool, acceptors, factories);
    }

    public void setHost(String host) {
        this._host = host;
    }

    @Override // org.eclipse.jetty.server.NetworkConnector
    @ManagedAttribute("The network interface this connector binds to as an IP address or a hostname.  If null or 0.0.0.0, then bind to all interfaces.")
    public String getHost() {
        return this._host;
    }

    public void setPort(int port) {
        this._port = port;
    }

    @Override // org.eclipse.jetty.server.NetworkConnector
    @ManagedAttribute("Port this connector listens on. If set the 0 a random port is assigned which may be obtained with getLocalPort()")
    public int getPort() {
        return this._port;
    }

    @Override // org.eclipse.jetty.server.NetworkConnector
    public int getLocalPort() {
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        open();
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        close();
        doStop();
    }

    @Override // org.eclipse.jetty.server.NetworkConnector
    public void open() throws IOException {
    }

    @Override // org.eclipse.jetty.server.NetworkConnector, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.util.component.Graceful
    public Future<Void> shutdown() {
        close();
        return shutdown();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.AbstractConnector
    public boolean handleAcceptFailure(Throwable ex) {
        if (isOpen()) {
            return handleAcceptFailure(ex);
        }
        LOG.ignore(ex);
        return false;
    }

    @Override // org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = toString();
        objArr[1] = getHost() == null ? "0.0.0.0" : getHost();
        objArr[2] = Integer.valueOf(getLocalPort() <= 0 ? getPort() : getLocalPort());
        return String.format("%s{%s:%d}", objArr);
    }
}
