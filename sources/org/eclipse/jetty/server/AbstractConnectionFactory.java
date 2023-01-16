package org.eclipse.jetty.server;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.util.ArrayUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.ssl.SslContextFactory;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AbstractConnectionFactory.class */
public abstract class AbstractConnectionFactory extends ContainerLifeCycle implements ConnectionFactory {
    private final String _protocol;
    private final List<String> _protocols;
    private int _inputbufferSize = 8192;

    /* access modifiers changed from: protected */
    public AbstractConnectionFactory(String protocol) {
        this._protocol = protocol;
        this._protocols = Collections.unmodifiableList(Arrays.asList(protocol));
    }

    protected AbstractConnectionFactory(String... protocols) {
        this._protocol = protocols[0];
        this._protocols = Collections.unmodifiableList(Arrays.asList(protocols));
    }

    @Override // org.eclipse.jetty.server.ConnectionFactory
    @ManagedAttribute(value = "The protocol name", readonly = true)
    public String getProtocol() {
        return this._protocol;
    }

    @Override // org.eclipse.jetty.server.ConnectionFactory
    public List<String> getProtocols() {
        return this._protocols;
    }

    @ManagedAttribute("The buffer size used to read from the network")
    public int getInputBufferSize() {
        return this._inputbufferSize;
    }

    public void setInputBufferSize(int size) {
        this._inputbufferSize = size;
    }

    protected String findNextProtocol(Connector connector) {
        return findNextProtocol(connector, getProtocol());
    }

    /* access modifiers changed from: protected */
    public static String findNextProtocol(Connector connector, String currentProtocol) {
        String nextProtocol = null;
        Iterator<String> it = connector.getProtocols().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (currentProtocol.equalsIgnoreCase(it.next())) {
                nextProtocol = it.hasNext() ? it.next() : null;
            }
        }
        return nextProtocol;
    }

    /* access modifiers changed from: protected */
    public AbstractConnection configure(AbstractConnection connection, Connector connector, EndPoint endPoint) {
        connection.setInputBufferSize(getInputBufferSize());
        if (connector instanceof ContainerLifeCycle) {
            for (Connection.Listener listener : ((ContainerLifeCycle) connector).getBeans(Connection.Listener.class)) {
                connection.addListener(listener);
            }
        }
        for (Connection.Listener listener2 : getBeans(Connection.Listener.class)) {
            connection.addListener(listener2);
        }
        return connection;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), getProtocols());
    }

    public static ConnectionFactory[] getFactories(SslContextFactory sslContextFactory, ConnectionFactory... factories) {
        ConnectionFactory[] factories2 = (ConnectionFactory[]) ArrayUtil.removeNulls(factories);
        if (sslContextFactory == null) {
            return factories2;
        }
        for (ConnectionFactory factory : factories2) {
            if (factory instanceof HttpConfiguration.ConnectionFactory) {
                HttpConfiguration config = ((HttpConfiguration.ConnectionFactory) factory).getHttpConfiguration();
                if (config.getCustomizer(SecureRequestCustomizer.class) == null) {
                    config.addCustomizer(new SecureRequestCustomizer());
                }
            }
        }
        return (ConnectionFactory[]) ArrayUtil.prependToArray(new SslConnectionFactory(sslContextFactory, factories2[0].getProtocol()), factories2, ConnectionFactory.class);
    }
}
