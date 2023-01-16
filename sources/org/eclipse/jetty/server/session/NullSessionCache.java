package org.eclipse.jetty.server.session;

import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/NullSessionCache.class */
public class NullSessionCache extends AbstractSessionCache {
    public NullSessionCache(SessionHandler handler) {
        super(handler);
        setEvictionPolicy(0);
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void shutdown() {
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache, org.eclipse.jetty.server.session.SessionCache
    public Session newSession(SessionData data) {
        return new Session(getSessionHandler(), data);
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    public Session newSession(HttpServletRequest request, SessionData data) {
        return new Session(getSessionHandler(), request, data);
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    public Session doGet(String id) {
        return null;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    public Session doPutIfAbsent(String id, Session session) {
        return null;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    public boolean doReplace(String id, Session oldValue, Session newValue) {
        return true;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    public Session doDelete(String id) {
        return null;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache, org.eclipse.jetty.server.session.SessionCache
    public void setEvictionPolicy(int evictionTimeout) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Ignoring eviction setting: {}", (long) evictionTimeout);
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    protected Session doComputeIfAbsent(String id, Function<String, Session> mappingFunction) {
        return mappingFunction.apply(id);
    }
}
