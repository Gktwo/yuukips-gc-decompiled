package org.eclipse.jetty.server.session;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.statistic.CounterStatistic;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/DefaultSessionCache.class */
public class DefaultSessionCache extends AbstractSessionCache {
    private static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    protected ConcurrentHashMap<String, Session> _sessions = new ConcurrentHashMap<>();
    private final CounterStatistic _stats = new CounterStatistic();

    public DefaultSessionCache(SessionHandler manager) {
        super(manager);
    }

    @ManagedAttribute(value = "current sessions in cache", readonly = true)
    public long getSessionsCurrent() {
        return this._stats.getCurrent();
    }

    @ManagedAttribute(value = "max sessions in cache", readonly = true)
    public long getSessionsMax() {
        return this._stats.getMax();
    }

    @ManagedAttribute(value = "total sessions in cache", readonly = true)
    public long getSessionsTotal() {
        return this._stats.getTotal();
    }

    @ManagedOperation(value = "reset statistics", impact = "ACTION")
    public void resetStats() {
        this._stats.reset();
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    public Session doGet(String id) {
        if (id == null) {
            return null;
        }
        return this._sessions.get(id);
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    public Session doPutIfAbsent(String id, Session session) {
        Session s = this._sessions.putIfAbsent(id, session);
        if (s == null) {
            this._stats.increment();
        }
        return s;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    protected Session doComputeIfAbsent(String id, Function<String, Session> mappingFunction) {
        return this._sessions.computeIfAbsent(id, k -> {
            Session s = (Session) mappingFunction.apply(mappingFunction);
            if (s != null) {
                this._stats.increment();
            }
            return s;
        });
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    public Session doDelete(String id) {
        Session s = this._sessions.remove(id);
        if (s != null) {
            this._stats.decrement();
        }
        return s;
    }

    @Override // org.eclipse.jetty.server.session.SessionCache
    public void shutdown() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Shutdown sessions, invalidating = {}", Boolean.valueOf(isInvalidateOnShutdown()));
        }
        int loop = 100;
        while (!this._sessions.isEmpty()) {
            loop--;
            if (loop > 0) {
                for (Session session : this._sessions.values()) {
                    if (isInvalidateOnShutdown()) {
                        try {
                            session.invalidate();
                        } catch (Exception e) {
                            LOG.ignore(e);
                        }
                    } else {
                        if (this._sessionDataStore.isPassivating()) {
                            session.willPassivate();
                        }
                        try {
                            this._sessionDataStore.store(session.getId(), session.getSessionData());
                        } catch (Exception e2) {
                            LOG.warn(e2);
                        }
                        doDelete(session.getId());
                        session.setResident(false);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    public Session newSession(HttpServletRequest request, SessionData data) {
        return new Session(getSessionHandler(), request, data);
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache, org.eclipse.jetty.server.session.SessionCache
    public Session newSession(SessionData data) {
        return new Session(getSessionHandler(), data);
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionCache
    public boolean doReplace(String id, Session oldValue, Session newValue) {
        return this._sessions.replace(id, oldValue, newValue);
    }
}
