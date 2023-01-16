package org.eclipse.jetty.server.session;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Locker;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/AbstractSessionCache.class */
public abstract class AbstractSessionCache extends ContainerLifeCycle implements SessionCache {
    static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    protected SessionDataStore _sessionDataStore;
    protected final SessionHandler _handler;
    protected SessionContext _context;
    protected int _evictionPolicy = -1;
    protected boolean _saveOnCreate = false;
    protected boolean _saveOnInactiveEviction;
    protected boolean _removeUnloadableSessions;
    protected boolean _flushOnResponseCommit;
    protected boolean _invalidateOnShutdown;

    @Override // org.eclipse.jetty.server.session.SessionCache
    public abstract Session newSession(SessionData sessionData);

    public abstract Session newSession(HttpServletRequest httpServletRequest, SessionData sessionData);

    protected abstract Session doGet(String str);

    protected abstract Session doPutIfAbsent(String str, Session session);

    protected abstract Session doComputeIfAbsent(String str, Function<String, Session> function);

    protected abstract boolean doReplace(String str, Session session, Session session2);

    public abstract Session doDelete(String str);

    public AbstractSessionCache(SessionHandler handler) {
        this._handler = handler;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public SessionHandler getSessionHandler() {
        return this._handler;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void initialize(SessionContext context) {
        if (isStarted()) {
            throw new IllegalStateException("Context set after session store started");
        }
        this._context = context;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._sessionDataStore == null) {
            throw new IllegalStateException("No session data store configured");
        } else if (this._handler == null) {
            throw new IllegalStateException("No session manager");
        } else if (this._context == null) {
            throw new IllegalStateException("No ContextId");
        } else {
            this._sessionDataStore.initialize(this._context);
            doStart();
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._sessionDataStore.stop();
        doStop();
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public SessionDataStore getSessionDataStore() {
        return this._sessionDataStore;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void setSessionDataStore(SessionDataStore sessionStore) {
        updateBean(this._sessionDataStore, sessionStore);
        this._sessionDataStore = sessionStore;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    @ManagedAttribute(value = "session eviction policy", readonly = true)
    public int getEvictionPolicy() {
        return this._evictionPolicy;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void setEvictionPolicy(int evictionTimeout) {
        this._evictionPolicy = evictionTimeout;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    @ManagedAttribute(value = "immediately save new sessions", readonly = true)
    public boolean isSaveOnCreate() {
        return this._saveOnCreate;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void setSaveOnCreate(boolean saveOnCreate) {
        this._saveOnCreate = saveOnCreate;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    @ManagedAttribute(value = "delete unreadable stored sessions", readonly = true)
    public boolean isRemoveUnloadableSessions() {
        return this._removeUnloadableSessions;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void setRemoveUnloadableSessions(boolean removeUnloadableSessions) {
        this._removeUnloadableSessions = removeUnloadableSessions;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void setFlushOnResponseCommit(boolean flushOnResponseCommit) {
        this._flushOnResponseCommit = flushOnResponseCommit;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public boolean isFlushOnResponseCommit() {
        return this._flushOnResponseCommit;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public Session get(String id) throws Exception {
        return getAndEnter(id, true);
    }

    protected Session getAndEnter(String id, boolean enter) throws Exception {
        AtomicReference<Exception> exception = new AtomicReference<>();
        Session session = doComputeIfAbsent(id, k -> {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Session {} not found locally in {}, attempting to load", id, this);
            }
            try {
                Session s = loadSession(exception);
                if (s != null) {
                    Locker.Lock lock = s.lock();
                    s.setResident(true);
                    if (lock != null) {
                        lock.close();
                    }
                } else if (LOG.isDebugEnabled()) {
                    LOG.debug("Session {} not loaded by store", id);
                }
                return s;
            } catch (Exception e) {
                id.set(e);
                return null;
            }
        });
        Exception ex = exception.get();
        if (ex != null) {
            throw ex;
        }
        if (session != null) {
            Locker.Lock lock = session.lock();
            try {
                if (!session.isResident()) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Non-resident session {} in cache", id);
                    }
                    if (lock != null) {
                        lock.close();
                    }
                    return null;
                }
                if (enter) {
                    session.use();
                }
                if (lock != null) {
                    lock.close();
                }
            } catch (Throwable th) {
                if (lock != null) {
                    try {
                        lock.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return session;
    }

    private Session loadSession(String id) throws Exception {
        if (this._sessionDataStore == null) {
            return null;
        }
        try {
            SessionData data = this._sessionDataStore.load(id);
            if (data == null) {
                return null;
            }
            data.setLastNode(this._context.getWorkerName());
            return newSession(data);
        } catch (UnreadableSessionDataException e) {
            if (isRemoveUnloadableSessions()) {
                this._sessionDataStore.delete(id);
            }
            throw e;
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void add(String id, Session session) throws Exception {
        if (id == null || session == null) {
            throw new IllegalArgumentException("Add key=" + id + " session=" + (session == null ? "null" : session.getId()));
        }
        Locker.Lock lock = session.lock();
        try {
            if (session.getSessionHandler() == null) {
                throw new IllegalStateException("Session " + id + " is not managed");
            } else if (!session.isValid()) {
                throw new IllegalStateException("Session " + id + " is not valid");
            } else if (doPutIfAbsent(id, session) == null) {
                session.setResident(true);
                session.use();
                if (lock != null) {
                    lock.close();
                }
            } else {
                throw new IllegalStateException("Session " + id + " already in cache");
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void commit(Session session) throws Exception {
        if (session != null) {
            Locker.Lock lock = session.lock();
            try {
                if (session.isValid() && session.getSessionData().isDirty() && this._flushOnResponseCommit) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Flush session {} on response commit", session);
                    }
                    if (!this._sessionDataStore.isPassivating()) {
                        this._sessionDataStore.store(session.getId(), session.getSessionData());
                    } else {
                        session.willPassivate();
                        this._sessionDataStore.store(session.getId(), session.getSessionData());
                        session.didActivate();
                    }
                }
                if (lock != null) {
                    lock.close();
                }
            } catch (Throwable th) {
                if (lock != null) {
                    try {
                        lock.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    @Deprecated
    public void put(String id, Session session) throws Exception {
        release(id, session);
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void release(String id, Session session) throws Exception {
        if (id == null || session == null) {
            throw new IllegalArgumentException("Put key=" + id + " session=" + (session == null ? "null" : session.getId()));
        }
        Locker.Lock lock = session.lock();
        try {
            if (session.getSessionHandler() == null) {
                throw new IllegalStateException("Session " + id + " is not managed");
            } else if (!session.isInvalid()) {
                session.complete();
                if (session.getRequests() <= 0) {
                    session.setIdChanged(false);
                    if (!this._sessionDataStore.isPassivating()) {
                        this._sessionDataStore.store(id, session.getSessionData());
                        if (getEvictionPolicy() == 0) {
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Eviction on request exit id={}", id);
                            }
                            doDelete(session.getId());
                            session.setResident(false);
                        } else {
                            session.setResident(true);
                            doPutIfAbsent(id, session);
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Non passivating SessionDataStore, session in SessionCache only id={}", id);
                            }
                        }
                    } else {
                        session.willPassivate();
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Session passivating id={}", id);
                        }
                        this._sessionDataStore.store(id, session.getSessionData());
                        if (getEvictionPolicy() == 0) {
                            doDelete(id);
                            session.setResident(false);
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Evicted on request exit id={}", id);
                            }
                        } else {
                            session.didActivate();
                            session.setResident(true);
                            doPutIfAbsent(id, session);
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Session reactivated id={}", id);
                            }
                        }
                    }
                } else {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Req count={} for id={}", Long.valueOf(session.getRequests()), id);
                    }
                    session.setResident(true);
                    doPutIfAbsent(id, session);
                }
                if (lock != null) {
                    lock.close();
                }
            } else if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public boolean exists(String id) throws Exception {
        Session s = doGet(id);
        if (s == null) {
            return this._sessionDataStore.exists(id);
        }
        Locker.Lock lock = s.lock();
        try {
            boolean isValid = s.isValid();
            if (lock != null) {
                lock.close();
            }
            return isValid;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public boolean contains(String id) throws Exception {
        return doGet(id) != null;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public Session delete(String id) throws Exception {
        Session session = getAndEnter(id, false);
        if (this._sessionDataStore != null) {
            boolean dsdel = this._sessionDataStore.delete(id);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Session {} deleted in session data store {}", id, Boolean.valueOf(dsdel));
            }
        }
        if (session != null) {
            session.setResident(false);
        }
        return doDelete(id);
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public Set<String> checkExpiration(Set<String> candidates) {
        if (!isStarted()) {
            return Collections.emptySet();
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} checking expiration on {}", this, candidates);
        }
        Set<String> allCandidates = this._sessionDataStore.getExpired(candidates);
        Set<String> sessionsInUse = new HashSet<>();
        if (allCandidates != null) {
            for (String c : allCandidates) {
                Session s = doGet(c);
                if (s != null && s.getRequests() > 0) {
                    sessionsInUse.add(c);
                }
            }
            try {
                allCandidates.removeAll(sessionsInUse);
            } catch (UnsupportedOperationException e) {
                Set<String> tmp = new HashSet<>(allCandidates);
                tmp.removeAll(sessionsInUse);
                allCandidates = tmp;
            }
        }
        return allCandidates;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void checkInactiveSession(Session session) {
        if (session != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Checking for idle {}", session.getId());
            }
            Locker.Lock s = session.lock();
            try {
                if (getEvictionPolicy() > 0 && session.isIdleLongerThan(getEvictionPolicy()) && session.isValid() && session.isResident() && session.getRequests() <= 0) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Evicting idle session {}", session.getId());
                    }
                    try {
                        if (isSaveOnInactiveEviction() && this._sessionDataStore != null) {
                            if (this._sessionDataStore.isPassivating()) {
                                session.willPassivate();
                            }
                            session.getSessionData().setDirty(true);
                            this._sessionDataStore.store(session.getId(), session.getSessionData());
                        }
                        doDelete(session.getId());
                        session.setResident(false);
                    } catch (Exception e) {
                        LOG.warn("Passivation of idle session {} failed", session.getId());
                        LOG.warn(e);
                    }
                }
                if (s != null) {
                    s.close();
                }
            } catch (Throwable th) {
                if (s != null) {
                    try {
                        s.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public Session renewSessionId(String oldId, String newId, String oldExtendedId, String newExtendedId) throws Exception {
        if (StringUtil.isBlank(oldId)) {
            throw new IllegalArgumentException("Old session id is null");
        } else if (StringUtil.isBlank(newId)) {
            throw new IllegalArgumentException("New session id is null");
        } else {
            Session session = getAndEnter(oldId, true);
            renewSessionId(session, newId, newExtendedId);
            return session;
        }
    }

    protected void renewSessionId(Session session, String newId, String newExtendedId) throws Exception {
        if (session != null) {
            Locker.Lock lock = session.lock();
            try {
                String oldId = session.getId();
                session.checkValidForWrite();
                session.getSessionData().setId(newId);
                session.getSessionData().setLastSaved(0);
                session.getSessionData().setDirty(true);
                session.setExtendedId(newExtendedId);
                session.setIdChanged(true);
                doPutIfAbsent(newId, session);
                doDelete(oldId);
                if (this._sessionDataStore != null) {
                    this._sessionDataStore.delete(oldId);
                    this._sessionDataStore.store(newId, session.getSessionData());
                }
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Session id {} swapped for new id {}", oldId, newId);
                }
                if (lock != null) {
                    lock.close();
                }
            } catch (Throwable th) {
                if (lock != null) {
                    try {
                        lock.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void setSaveOnInactiveEviction(boolean saveOnEvict) {
        this._saveOnInactiveEviction = saveOnEvict;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void setInvalidateOnShutdown(boolean invalidateOnShutdown) {
        this._invalidateOnShutdown = invalidateOnShutdown;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public boolean isInvalidateOnShutdown() {
        return this._invalidateOnShutdown;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    @ManagedAttribute(value = "save sessions before evicting from cache", readonly = true)
    public boolean isSaveOnInactiveEviction() {
        return this._saveOnInactiveEviction;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public Session newSession(HttpServletRequest request, String id, long time, long maxInactiveMs) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Creating new session id=" + id, new Object[0]);
        }
        Session session = newSession(request, this._sessionDataStore.newSessionData(id, time, time, time, maxInactiveMs));
        session.getSessionData().setLastNode(this._context.getWorkerName());
        try {
            if (isSaveOnCreate() && this._sessionDataStore != null) {
                this._sessionDataStore.store(id, session.getSessionData());
            }
        } catch (Exception e) {
            LOG.warn("Save of new session {} failed", id);
            LOG.warn(e);
        }
        return session;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x[evict=%d,removeUnloadable=%b,saveOnCreate=%b,saveOnInactiveEvict=%b]", getClass().getName(), Integer.valueOf(hashCode()), Integer.valueOf(this._evictionPolicy), Boolean.valueOf(this._removeUnloadableSessions), Boolean.valueOf(this._saveOnCreate), Boolean.valueOf(this._saveOnInactiveEviction));
    }
}
