package org.eclipse.jetty.server.session;

import java.util.Set;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/NullSessionDataStore.class */
public class NullSessionDataStore extends AbstractSessionDataStore {
    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore
    public SessionData doLoad(String id) throws Exception {
        return null;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore, org.eclipse.jetty.server.session.SessionDataStore
    public SessionData newSessionData(String id, long created, long accessed, long lastAccessed, long maxInactiveMs) {
        return new SessionData(id, this._context.getCanonicalContextPath(), this._context.getVhost(), created, accessed, lastAccessed, maxInactiveMs);
    }

    @Override // org.eclipse.jetty.server.session.SessionDataMap
    public boolean delete(String id) throws Exception {
        return true;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore
    public void doStore(String id, SessionData data, long lastSaveTime) throws Exception {
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore
    public Set<String> doGetExpired(Set<String> candidates) {
        return candidates;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    @ManagedAttribute(value = "does this store serialize sessions", readonly = true)
    public boolean isPassivating() {
        return false;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    public boolean exists(String id) {
        return false;
    }
}
