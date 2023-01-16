package org.eclipse.jetty.xml;

import java.net.MalformedURLException;
import java.net.URL;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlParser;

/* loaded from: grasscutter.jar:org/eclipse/jetty/xml/ConfigurationProcessor.class */
public interface ConfigurationProcessor {
    @Deprecated
    void init(URL url, XmlParser.Node node, XmlConfiguration xmlConfiguration);

    Object configure(Object obj) throws Exception;

    Object configure() throws Exception;

    default void init(Resource resource, XmlParser.Node root, XmlConfiguration configuration) {
        try {
            init(resource.getURI().toURL(), root, configuration);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Unable to convert Resource to URL", e);
        }
    }
}
