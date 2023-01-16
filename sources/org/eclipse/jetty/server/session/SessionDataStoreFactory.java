package org.eclipse.jetty.server.session;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/SessionDataStoreFactory.class */
public interface SessionDataStoreFactory {
    SessionDataStore getSessionDataStore(SessionHandler sessionHandler) throws Exception;
}
