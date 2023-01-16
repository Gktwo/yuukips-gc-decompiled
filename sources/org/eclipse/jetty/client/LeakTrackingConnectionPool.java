package org.eclipse.jetty.client;

import org.eclipse.jetty.client.api.Connection;
import org.eclipse.jetty.client.api.Destination;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.LeakDetector;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/LeakTrackingConnectionPool.class */
public class LeakTrackingConnectionPool extends DuplexConnectionPool {
    private static final Logger LOG = Log.getLogger(LeakTrackingConnectionPool.class);
    private final LeakDetector<Connection> leakDetector = new LeakDetector<Connection>() { // from class: org.eclipse.jetty.client.LeakTrackingConnectionPool.1
        @Override // org.eclipse.jetty.util.LeakDetector
        protected void leaked(LeakDetector<Connection>.LeakInfo leakInfo) {
            LeakTrackingConnectionPool.this.leaked(leakInfo);
        }
    };

    public LeakTrackingConnectionPool(Destination destination, int maxConnections, Callback requester) {
        super((HttpDestination) destination, maxConnections, requester);
        addBean(this.leakDetector);
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool, org.eclipse.jetty.client.ConnectionPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        LifeCycle.stop(this);
        close();
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool
    protected void acquired(Connection connection) {
        if (!this.leakDetector.acquired(connection)) {
            LOG.info("Connection {}@{} not tracked", connection, this.leakDetector.mo34id(connection));
        }
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool
    protected void released(Connection connection) {
        if (!this.leakDetector.released(connection)) {
            LOG.info("Connection {}@{} released but not acquired", connection, this.leakDetector.mo34id(connection));
        }
    }

    protected void leaked(LeakDetector.LeakInfo leakInfo) {
        LOG.info("Connection " + leakInfo.getResourceDescription() + " leaked at:", leakInfo.getStackFrames());
    }
}
