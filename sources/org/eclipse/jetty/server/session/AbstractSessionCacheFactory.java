package org.eclipse.jetty.server.session;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/AbstractSessionCacheFactory.class */
public abstract class AbstractSessionCacheFactory implements SessionCacheFactory {
    int _evictionPolicy;
    boolean _saveOnInactiveEvict;
    boolean _saveOnCreate;
    boolean _removeUnloadableSessions;
    boolean _flushOnResponseCommit;
    boolean _invalidateOnShutdown;

    public abstract SessionCache newSessionCache(SessionHandler sessionHandler);

    public boolean isInvalidateOnShutdown() {
        return this._invalidateOnShutdown;
    }

    public void setInvalidateOnShutdown(boolean invalidateOnShutdown) {
        this._invalidateOnShutdown = invalidateOnShutdown;
    }

    public boolean isFlushOnResponseCommit() {
        return this._flushOnResponseCommit;
    }

    public void setFlushOnResponseCommit(boolean flushOnResponseCommit) {
        this._flushOnResponseCommit = flushOnResponseCommit;
    }

    public boolean isSaveOnCreate() {
        return this._saveOnCreate;
    }

    public void setSaveOnCreate(boolean saveOnCreate) {
        this._saveOnCreate = saveOnCreate;
    }

    public boolean isRemoveUnloadableSessions() {
        return this._removeUnloadableSessions;
    }

    public void setRemoveUnloadableSessions(boolean removeUnloadableSessions) {
        this._removeUnloadableSessions = removeUnloadableSessions;
    }

    public int getEvictionPolicy() {
        return this._evictionPolicy;
    }

    public void setEvictionPolicy(int evictionPolicy) {
        this._evictionPolicy = evictionPolicy;
    }

    public boolean isSaveOnInactiveEvict() {
        return this._saveOnInactiveEvict;
    }

    public void setSaveOnInactiveEvict(boolean saveOnInactiveEvict) {
        this._saveOnInactiveEvict = saveOnInactiveEvict;
    }

    @Override // org.eclipse.jetty.server.session.SessionCacheFactory
    public SessionCache getSessionCache(SessionHandler handler) {
        SessionCache cache = newSessionCache(handler);
        cache.setEvictionPolicy(getEvictionPolicy());
        cache.setSaveOnInactiveEviction(isSaveOnInactiveEvict());
        cache.setSaveOnCreate(isSaveOnCreate());
        cache.setRemoveUnloadableSessions(isRemoveUnloadableSessions());
        cache.setFlushOnResponseCommit(isFlushOnResponseCommit());
        cache.setInvalidateOnShutdown(isInvalidateOnShutdown());
        return cache;
    }
}
