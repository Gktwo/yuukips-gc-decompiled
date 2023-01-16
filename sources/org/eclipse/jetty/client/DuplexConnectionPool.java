package org.eclipse.jetty.client;

import org.eclipse.jetty.client.api.Connection;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.Pool;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/DuplexConnectionPool.class */
public class DuplexConnectionPool extends AbstractConnectionPool {
    public DuplexConnectionPool(HttpDestination destination, int maxConnections, Callback requester) {
        this(destination, maxConnections, false, requester);
    }

    public DuplexConnectionPool(HttpDestination destination, int maxConnections, boolean cache, Callback requester) {
        super(destination, Pool.StrategyType.FIRST, maxConnections, cache, requester);
    }

    @Deprecated
    public DuplexConnectionPool(HttpDestination destination, Pool<Connection> pool, Callback requester) {
        super(destination, pool, requester);
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
