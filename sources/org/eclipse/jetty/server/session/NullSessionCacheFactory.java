package org.eclipse.jetty.server.session;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/NullSessionCacheFactory.class */
public class NullSessionCacheFactory extends AbstractSessionCacheFactory {
    private static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");

    @Override // org.eclipse.jetty.server.session.AbstractSessionCacheFactory
    public int getEvictionPolicy() {
        return 0;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCacheFactory
    public void setEvictionPolicy(int evictionPolicy) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Ignoring eviction policy setting for NullSessionCaches", new Object[0]);
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCacheFactory
    public boolean isSaveOnInactiveEvict() {
        return false;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCacheFactory
    public void setSaveOnInactiveEvict(boolean saveOnInactiveEvict) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Ignoring eviction policy setting for NullSessionCaches", new Object[0]);
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCacheFactory
    public boolean isInvalidateOnShutdown() {
        return false;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCacheFactory
    public void setInvalidateOnShutdown(boolean invalidateOnShutdown) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Ignoring invalidateOnShutdown setting for NullSessionCaches", new Object[0]);
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCacheFactory
    public SessionCache newSessionCache(SessionHandler handler) {
        return new NullSessionCache(handler);
    }
}
