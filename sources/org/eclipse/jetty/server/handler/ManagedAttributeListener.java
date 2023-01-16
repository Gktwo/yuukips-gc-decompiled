package org.eclipse.jetty.server.handler;

import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ManagedAttributeListener.class */
public class ManagedAttributeListener implements ServletContextListener, ServletContextAttributeListener {
    private static final Logger LOG = Log.getLogger(ManagedAttributeListener.class);
    final Set<String> _managedAttributes = new HashSet();
    final ContextHandler _context;

    public ManagedAttributeListener(ContextHandler context, String... managedAttributes) {
        this._context = context;
        for (String attr : managedAttributes) {
            this._managedAttributes.add(attr);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("managedAttributes {}", this._managedAttributes);
        }
    }

    @Override // javax.servlet.ServletContextAttributeListener
    public void attributeReplaced(ServletContextAttributeEvent event) {
        if (this._managedAttributes.contains(event.getName())) {
            updateBean(event.getName(), event.getValue(), event.getServletContext().getAttribute(event.getName()));
        }
    }

    @Override // javax.servlet.ServletContextAttributeListener
    public void attributeRemoved(ServletContextAttributeEvent event) {
        if (this._managedAttributes.contains(event.getName())) {
            updateBean(event.getName(), event.getValue(), null);
        }
    }

    @Override // javax.servlet.ServletContextAttributeListener
    public void attributeAdded(ServletContextAttributeEvent event) {
        if (this._managedAttributes.contains(event.getName())) {
            updateBean(event.getName(), null, event.getValue());
        }
    }

    @Override // javax.servlet.ServletContextListener
    public void contextInitialized(ServletContextEvent event) {
        for (String name : this._context.getServletContext().getAttributeNameSet()) {
            if (this._managedAttributes.contains(name)) {
                updateBean(name, null, event.getServletContext().getAttribute(name));
            }
        }
    }

    @Override // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent event) {
        for (String name : this._context.getServletContext().getAttributeNameSet()) {
            if (this._managedAttributes.contains(name)) {
                updateBean(name, event.getServletContext().getAttribute(name), null);
            }
        }
    }

    protected void updateBean(String name, Object oldBean, Object newBean) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("update {} {}->{} on {}", name, oldBean, newBean, this._context);
        }
        this._context.updateBean(oldBean, newBean, false);
    }
}
