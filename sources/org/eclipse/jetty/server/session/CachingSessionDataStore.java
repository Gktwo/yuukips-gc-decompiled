package org.eclipse.jetty.server.session;

import java.util.Set;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/CachingSessionDataStore.class */
public class CachingSessionDataStore extends ContainerLifeCycle implements SessionDataStore {
    private static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    protected SessionDataStore _store;
    protected SessionDataMap _cache;

    public CachingSessionDataStore(SessionDataMap cache, SessionDataStore store) {
        this._cache = cache;
        addBean((Object) this._cache, true);
        this._store = store;
        addBean((Object) this._store, true);
    }

    public SessionDataStore getSessionStore() {
        return this._store;
    }

    public SessionDataMap getSessionDataMap() {
        return this._cache;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataMap
    public SessionData load(String id) throws Exception {
        SessionData d = null;
        try {
            d = this._cache.load(id);
        } catch (Exception e) {
            LOG.warn(e);
        }
        if (d != null) {
            return d;
        }
        return this._store.load(id);
    }

    @Override // org.eclipse.jetty.server.session.SessionDataMap
    public boolean delete(String id) throws Exception {
        boolean deleted = this._store.delete(id);
        this._cache.delete(id);
        return deleted;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    public Set<String> getExpired(Set<String> candidates) {
        return this._store.getExpired(candidates);
    }

    @Override // org.eclipse.jetty.server.session.SessionDataMap
    public void store(String id, SessionData data) throws Exception {
        long lastSaved = data.getLastSaved();
        this._store.store(id, data);
        if (data.getLastSaved() != lastSaved) {
            this._cache.store(id, data);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    public boolean isPassivating() {
        return this._store.isPassivating();
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    public boolean exists(String id) throws Exception {
        try {
            if (this._cache.load(id) != null) {
                return true;
            }
        } catch (Exception e) {
            LOG.warn(e);
        }
        return this._store.exists(id);
    }

    @Override // org.eclipse.jetty.server.session.SessionDataMap
    public void initialize(SessionContext context) throws Exception {
        this._store.initialize(context);
        this._cache.initialize(context);
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    public SessionData newSessionData(String id, long created, long accessed, long lastAccessed, long maxInactiveMs) {
        return this._store.newSessionData(id, created, accessed, lastAccessed, maxInactiveMs);
    }
}
