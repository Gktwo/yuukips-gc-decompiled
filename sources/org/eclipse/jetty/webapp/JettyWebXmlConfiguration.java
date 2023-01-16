package org.eclipse.jetty.webapp;

import java.io.IOException;
import java.util.Map;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlConfiguration;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/JettyWebXmlConfiguration.class */
public class JettyWebXmlConfiguration extends AbstractConfiguration {
    private static final Logger LOG = Log.getLogger(JettyWebXmlConfiguration.class);
    @Deprecated
    public static final String PROPERTY_THIS_WEB_INF_URL = "this.web-inf.url";
    public static final String PROPERTY_WEB_INF_URI = "web-inf.uri";
    public static final String PROPERTY_WEB_INF = "web-inf";
    public static final String XML_CONFIGURATION = "org.eclipse.jetty.webapp.JettyWebXmlConfiguration";
    public static final String JETTY_WEB_XML = "jetty-web.xml";

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void configure(WebAppContext context) throws Exception {
        if (context.isStarted()) {
            LOG.debug("Cannot configure webapp after it is started", new Object[0]);
            return;
        }
        LOG.debug("Configuring web-jetty.xml", new Object[0]);
        Resource webInf = context.getWebInf();
        if (webInf != null && webInf.isDirectory()) {
            Resource jetty = webInf.addPath("jetty8-web.xml");
            if (!jetty.exists()) {
                jetty = webInf.addPath(JETTY_WEB_XML);
            }
            if (!jetty.exists()) {
                jetty = webInf.addPath("web-jetty.xml");
            }
            if (jetty.exists()) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Configure: " + jetty, new Object[0]);
                }
                Object xmlAttr = context.getAttribute(XML_CONFIGURATION);
                context.removeAttribute(XML_CONFIGURATION);
                XmlConfiguration jetty_config = xmlAttr instanceof XmlConfiguration ? (XmlConfiguration) xmlAttr : new XmlConfiguration(jetty.getURI().toURL());
                setupXmlConfiguration(context, jetty_config, webInf);
                try {
                    WebAppClassLoader.runWithServerClassAccess(() -> {
                        jetty_config.configure(context);
                        return null;
                    });
                } catch (Exception e) {
                    LOG.warn("Error applying {}", jetty);
                    throw e;
                }
            }
        }
    }

    private void setupXmlConfiguration(WebAppContext context, XmlConfiguration jettyConfig, Resource webInf) throws IOException {
        jettyConfig.setJettyStandardIdsAndProperties(context.getServer(), null);
        Map<String, String> props = jettyConfig.getProperties();
        props.put(PROPERTY_THIS_WEB_INF_URL, webInf.getURI().toString());
        props.put(PROPERTY_WEB_INF_URI, XmlConfiguration.normalizeURI(webInf.getURI().toString()));
        props.put(PROPERTY_WEB_INF, webInf.toString());
    }
}
