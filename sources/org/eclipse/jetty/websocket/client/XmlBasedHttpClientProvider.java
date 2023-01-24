package org.eclipse.jetty.websocket.client;

import java.net.URL;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope;
import org.eclipse.jetty.xml.XmlConfiguration;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/XmlBasedHttpClientProvider.class */
public class XmlBasedHttpClientProvider {
    public static final Logger LOG = Log.getLogger(XmlBasedHttpClientProvider.class);

    XmlBasedHttpClientProvider() {
    }

    /* JADX INFO: finally extract failed */
    public static HttpClient get(WebSocketContainerScope scope) {
        URL resource;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null || (resource = contextClassLoader.getResource("jetty-websocket-httpclient.xml")) == null) {
            return null;
        }
        try {
            Thread.currentThread().setContextClassLoader(HttpClient.class.getClassLoader());
            HttpClient newHttpClient = newHttpClient(resource);
            Thread.currentThread().setContextClassLoader(contextClassLoader);
            return newHttpClient;
        } catch (Throwable th) {
            Thread.currentThread().setContextClassLoader(contextClassLoader);
            throw th;
        }
    }

    private static HttpClient newHttpClient(URL resource) {
        try {
            return (HttpClient) new XmlConfiguration(Resource.newResource(resource)).configure();
        } catch (Throwable t) {
            LOG.warn("Failure to load HttpClient from XML {}", resource, t);
            return null;
        }
    }
}
