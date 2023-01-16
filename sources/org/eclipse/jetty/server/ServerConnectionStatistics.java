package org.eclipse.jetty.server;

import org.eclipse.jetty.p023io.ConnectionStatistics;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ServerConnectionStatistics.class */
public class ServerConnectionStatistics extends ConnectionStatistics {
    public static void addToAllConnectors(Server server) {
        for (Connector connector : server.getConnectors()) {
            connector.addBean(new ConnectionStatistics());
        }
    }
}
