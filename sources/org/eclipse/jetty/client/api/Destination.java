package org.eclipse.jetty.client.api;

import org.eclipse.jetty.util.Promise;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Destination.class */
public interface Destination {
    String getScheme();

    String getHost();

    int getPort();

    void newConnection(Promise<Connection> promise);
}
