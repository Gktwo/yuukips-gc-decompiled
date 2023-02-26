package org.eclipse.jetty.client;

import org.eclipse.jetty.client.ConnectionPool;
import org.eclipse.jetty.client.api.Connection;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.Pool;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/MultiplexConnectionPool.class */
public class MultiplexConnectionPool extends AbstractConnectionPool {
    public MultiplexConnectionPool(HttpDestination destination, int maxConnections, Callback requester, int maxMultiplex) {
        this(destination, maxConnections, false, requester, maxMultiplex);
    }

    public MultiplexConnectionPool(HttpDestination destination, int maxConnections, boolean cache, Callback requester, int maxMultiplex) {
        this(destination, Pool.StrategyType.FIRST, maxConnections, cache, requester, maxMultiplex);
    }

    public MultiplexConnectionPool(HttpDestination destination, Pool.StrategyType strategy, int maxConnections, boolean cache, Callback requester, int maxMultiplex) {
        super(destination, new Pool<Connection>(strategy, maxConnections, cache) { // from class: org.eclipse.jetty.client.MultiplexConnectionPool.1
            /* access modifiers changed from: protected */
            public int getMaxMultiplex(Connection connection) {
                int multiplex;
                if (connection instanceof ConnectionPool.Multiplexable) {
                    multiplex = ((ConnectionPool.Multiplexable) connection).getMaxMultiplex();
                } else {
                    multiplex = getMaxMultiplex((C55951) connection);
                }
                if (multiplex > 0) {
                    return multiplex;
                }
                return 1;
            }
        }, requester);
        setMaxMultiplex(maxMultiplex);
    }

    @Deprecated
    public MultiplexConnectionPool(HttpDestination destination, Pool<Connection> pool, Callback requester, int maxMultiplex) {
        super(destination, pool, requester);
        setMaxMultiplex(maxMultiplex);
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool
    @ManagedAttribute("The multiplexing factor of connections")
    public int getMaxMultiplex() {
        return getMaxMultiplex();
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool
    public void setMaxMultiplex(int maxMultiplex) {
        setMaxMultiplex(maxMultiplex);
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool
    @ManagedAttribute("The maximum amount of times a connection is used before it gets closed")
    public int getMaxUsageCount() {
        return getMaxUsageCount();
    }

    @Override // org.eclipse.jetty.client.AbstractConnectionPool
    public void setMaxUsageCount(int maxUsageCount) {
        setMaxUsageCount(maxUsageCount);
    }
}
