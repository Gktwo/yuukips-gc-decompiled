package org.eclipse.jetty.client;

import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.Pool;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/RandomConnectionPool.class */
public class RandomConnectionPool extends MultiplexConnectionPool {
    public RandomConnectionPool(HttpDestination destination, int maxConnections, Callback requester, int maxMultiplex) {
        super(destination, Pool.StrategyType.RANDOM, maxConnections, false, requester, maxMultiplex);
    }
}
