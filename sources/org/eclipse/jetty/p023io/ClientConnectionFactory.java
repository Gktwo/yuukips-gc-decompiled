package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.util.component.ContainerLifeCycle;

/* renamed from: org.eclipse.jetty.io.ClientConnectionFactory */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ClientConnectionFactory.class */
public interface ClientConnectionFactory {
    public static final String CONNECTOR_CONTEXT_KEY = "client.connector";

    /* renamed from: org.eclipse.jetty.io.ClientConnectionFactory$Decorator */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ClientConnectionFactory$Decorator.class */
    public interface Decorator {
        ClientConnectionFactory apply(ClientConnectionFactory clientConnectionFactory);
    }

    Connection newConnection(EndPoint endPoint, Map<String, Object> map) throws IOException;

    default Connection customize(Connection connection, Map<String, Object> context) {
        Collection beans = ((ContainerLifeCycle) context.get(CONNECTOR_CONTEXT_KEY)).getBeans(Connection.Listener.class);
        Objects.requireNonNull(connection);
        beans.forEach(this::addListener);
        return connection;
    }
}
