package org.eclipse.jetty.server.session;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/DefaultSessionCacheFactory.class */
public class DefaultSessionCacheFactory extends AbstractSessionCacheFactory {
    @Override // org.eclipse.jetty.server.session.AbstractSessionCacheFactory
    public SessionCache newSessionCache(SessionHandler handler) {
        return new DefaultSessionCache(handler);
    }
}
