package org.eclipse.jetty.server.handler.jmx;

import java.io.IOException;
import org.eclipse.jetty.jmx.ObjectMBean;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.AbstractHandlerContainer;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/jmx/AbstractHandlerMBean.class */
public class AbstractHandlerMBean extends ObjectMBean {
    private static final Logger LOG = Log.getLogger(AbstractHandlerMBean.class);

    public AbstractHandlerMBean(Object managedObject) {
        super(managedObject);
    }

    public String getObjectContextBasis() {
        AbstractHandler handler;
        Server server;
        ContextHandler context;
        if (this._managed != null) {
            String basis = null;
            if (this._managed instanceof ContextHandler) {
                ContextHandler handler2 = (ContextHandler) this._managed;
                String context2 = getContextName(handler2);
                if (context2 == null) {
                    context2 = handler2.getDisplayName();
                }
                if (context2 != null) {
                    return context2;
                }
            } else if (!(!(this._managed instanceof AbstractHandler) || (server = (handler = (AbstractHandler) this._managed).getServer()) == null || (context = (ContextHandler) AbstractHandlerContainer.findContainerOf(server, ContextHandler.class, handler)) == null)) {
                basis = getContextName(context);
            }
            if (basis != null) {
                return basis;
            }
        }
        return getObjectContextBasis();
    }

    protected String getContextName(ContextHandler context) {
        String name = null;
        if (context.getContextPath() != null && context.getContextPath().length() > 0) {
            int idx = context.getContextPath().lastIndexOf(47);
            name = idx < 0 ? context.getContextPath() : context.getContextPath().substring(idx + 1);
            if (name == null || name.length() == 0) {
                name = org.slf4j.Logger.ROOT_LOGGER_NAME;
            }
        }
        if (name == null && context.getBaseResource() != null) {
            try {
                if (context.getBaseResource().getFile() != null) {
                    name = context.getBaseResource().getFile().getName();
                }
            } catch (IOException e) {
                LOG.ignore(e);
                name = context.getBaseResource().getName();
            }
        }
        if (context.getVirtualHosts() != null && context.getVirtualHosts().length > 0) {
            name = '\"' + name + "@" + context.getVirtualHosts()[0] + '\"';
        }
        return name;
    }
}
