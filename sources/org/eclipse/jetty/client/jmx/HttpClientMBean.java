package org.eclipse.jetty.client.jmx;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.jmx.ObjectMBean;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/jmx/HttpClientMBean.class */
public class HttpClientMBean extends ObjectMBean {
    public HttpClientMBean(Object managedObject) {
        super(managedObject);
    }

    public String getObjectContextBasis() {
        return ((HttpClient) getManagedObject()).getName();
    }
}
