package org.eclipse.jetty.webapp;

import java.util.Map;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/FragmentConfiguration.class */
public class FragmentConfiguration extends AbstractConfiguration {
    public static final String FRAGMENT_RESOURCES = "org.eclipse.jetty.webFragments";

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void preConfigure(WebAppContext context) throws Exception {
        addWebFragments(context, context.getMetaData());
    }

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void postConfigure(WebAppContext context) throws Exception {
        context.setAttribute("org.eclipse.jetty.webFragments", null);
    }

    public void findWebFragments(WebAppContext context, MetaData metaData) throws Exception {
        addWebFragments(context, metaData);
    }

    public void addWebFragments(WebAppContext context, MetaData metaData) throws Exception {
        Map<Resource, Resource> frags = (Map) context.getAttribute("org.eclipse.jetty.webFragments");
        if (frags != null) {
            for (Map.Entry<Resource, Resource> entry : frags.entrySet()) {
                metaData.addFragment(entry.getKey(), entry.getValue());
            }
        }
    }
}
