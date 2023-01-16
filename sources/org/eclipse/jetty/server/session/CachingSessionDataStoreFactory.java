package org.eclipse.jetty.server.session;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/CachingSessionDataStoreFactory.class */
public class CachingSessionDataStoreFactory extends AbstractSessionDataStoreFactory {
    protected SessionDataStoreFactory _sessionStoreFactory;
    protected SessionDataMapFactory _mapFactory;

    public SessionDataMapFactory getMapFactory() {
        return this._mapFactory;
    }

    public void setSessionDataMapFactory(SessionDataMapFactory mapFactory) {
        this._mapFactory = mapFactory;
    }

    public void setSessionStoreFactory(SessionDataStoreFactory factory) {
        this._sessionStoreFactory = factory;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStoreFactory
    public SessionDataStore getSessionDataStore(SessionHandler handler) throws Exception {
        return new CachingSessionDataStore(this._mapFactory.getSessionDataMap(), this._sessionStoreFactory.getSessionDataStore(handler));
    }
}
