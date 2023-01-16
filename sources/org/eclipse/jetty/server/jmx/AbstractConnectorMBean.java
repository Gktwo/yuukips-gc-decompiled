package org.eclipse.jetty.server.jmx;

import org.eclipse.jetty.jmx.ObjectMBean;
import org.eclipse.jetty.server.AbstractConnector;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject("MBean Wrapper for Connectors")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/jmx/AbstractConnectorMBean.class */
public class AbstractConnectorMBean extends ObjectMBean {
    final AbstractConnector _connector;

    public AbstractConnectorMBean(Object managedObject) {
        super(managedObject);
        this._connector = (AbstractConnector) managedObject;
    }

    public String getObjectContextBasis() {
        StringBuilder buffer = new StringBuilder();
        for (ConnectionFactory f : this._connector.getConnectionFactories()) {
            String protocol = f.getProtocol();
            if (protocol != null) {
                if (buffer.length() > 0) {
                    buffer.append("|");
                }
                buffer.append(protocol);
            }
        }
        return String.format("%s@%x", buffer.toString(), Integer.valueOf(this._connector.hashCode()));
    }
}
