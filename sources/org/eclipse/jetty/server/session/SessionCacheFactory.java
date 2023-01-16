package org.eclipse.jetty.server.session;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/SessionCacheFactory.class */
public interface SessionCacheFactory {
    SessionCache getSessionCache(SessionHandler sessionHandler);
}
