package org.eclipse.jetty.client;

import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.Pool;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/RoundRobinConnectionPool.class */
public class RoundRobinConnectionPool extends MultiplexConnectionPool {
    public RoundRobinConnectionPool(HttpDestination destination, int maxConnections, Callback requester) {
        this(destination, maxConnections, requester, 1);
    }

    public RoundRobinConnectionPool(HttpDestination destination, int maxConnections, Callback requester, int maxMultiplex) {
        super(destination, Pool.StrategyType.ROUND_ROBIN, maxConnections, false, requester, maxMultiplex);
        setMaximizeConnections(true);
    }
}
