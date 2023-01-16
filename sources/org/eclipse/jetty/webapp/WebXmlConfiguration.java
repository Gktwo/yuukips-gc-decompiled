package org.eclipse.jetty.webapp;

import java.io.IOException;
import org.eclipse.jetty.servlet.ErrorPageErrorHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/WebXmlConfiguration.class */
public class WebXmlConfiguration extends AbstractConfiguration {
    private static final Logger LOG = Log.getLogger(WebXmlConfiguration.class);

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void preConfigure(WebAppContext context) throws Exception {
        String defaultsDescriptor = context.getDefaultsDescriptor();
        if (defaultsDescriptor != null && defaultsDescriptor.length() > 0) {
            Resource dftResource = Resource.newSystemResource(defaultsDescriptor);
            if (dftResource == null) {
                dftResource = context.newResource(defaultsDescriptor);
            }
            context.getMetaData().setDefaults(dftResource);
        }
        Resource webxml = findWebXml(context);
        if (webxml != null) {
            context.getMetaData().setWebXml(webxml);
            context.getServletContext().setEffectiveMajorVersion(context.getMetaData().getWebXml().getMajorVersion());
            context.getServletContext().setEffectiveMinorVersion(context.getMetaData().getWebXml().getMinorVersion());
        }
        for (String overrideDescriptor : context.getOverrideDescriptors()) {
            if (overrideDescriptor != null && overrideDescriptor.length() > 0) {
                Resource orideResource = Resource.newSystemResource(overrideDescriptor);
                if (orideResource == null) {
                    orideResource = context.newResource(overrideDescriptor);
                }
                context.getMetaData().addOverride(orideResource);
            }
        }
    }

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void configure(WebAppContext context) throws Exception {
        if (context.isStarted()) {
            LOG.debug("Cannot configure webapp after it is started", new Object[0]);
        } else {
            context.getMetaData().addDescriptorProcessor(new StandardDescriptorProcessor());
        }
    }

    protected Resource findWebXml(WebAppContext context) throws IOException {
        String descriptor = context.getDescriptor();
        if (descriptor != null) {
            Resource web = context.newResource(descriptor);
            if (web.exists() && !web.isDirectory()) {
                return web;
            }
        }
        Resource webInf = context.getWebInf();
        if (webInf == null || !webInf.isDirectory()) {
            return null;
        }
        Resource web2 = webInf.addPath("web.xml");
        if (web2.exists()) {
            return web2;
        }
        if (!LOG.isDebugEnabled()) {
            return null;
        }
        LOG.debug("No WEB-INF/web.xml in " + context.getWar() + ". Serving files and default/dynamic servlets only", new Object[0]);
        return null;
    }

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void deconfigure(WebAppContext context) throws Exception {
        context.setWelcomeFiles(null);
        if (context.getErrorHandler() instanceof ErrorPageErrorHandler) {
            ((ErrorPageErrorHandler) context.getErrorHandler()).setErrorPages(null);
        }
    }
}
