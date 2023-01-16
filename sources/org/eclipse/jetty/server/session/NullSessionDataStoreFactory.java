package org.eclipse.jetty.server.session;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/NullSessionDataStoreFactory.class */
public class NullSessionDataStoreFactory extends AbstractSessionDataStoreFactory {
    @Override // org.eclipse.jetty.server.session.SessionDataStoreFactory
    public SessionDataStore getSessionDataStore(SessionHandler handler) throws Exception {
        return new NullSessionDataStore();
    }
}
