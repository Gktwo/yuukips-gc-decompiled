package org.eclipse.jetty.server.session;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.util.component.LifeCycle;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/SessionCache.class */
public interface SessionCache extends LifeCycle {
    public static final int NEVER_EVICT = -1;
    public static final int EVICT_ON_SESSION_EXIT = 0;
    public static final int EVICT_ON_INACTIVITY = 1;

    void initialize(SessionContext sessionContext);

    void shutdown();

    SessionHandler getSessionHandler();

    Session newSession(HttpServletRequest httpServletRequest, String str, long j, long j2);

    Session newSession(SessionData sessionData);

    void add(String str, Session session) throws Exception;

    Session get(String str) throws Exception;

    void put(String str, Session session) throws Exception;

    void release(String str, Session session) throws Exception;

    void commit(Session session) throws Exception;

    boolean contains(String str) throws Exception;

    boolean exists(String str) throws Exception;

    Session delete(String str) throws Exception;

    Set<String> checkExpiration(Set<String> set);

    void checkInactiveSession(Session session);

    void setSessionDataStore(SessionDataStore sessionDataStore);

    SessionDataStore getSessionDataStore();

    void setEvictionPolicy(int i);

    int getEvictionPolicy();

    void setSaveOnInactiveEviction(boolean z);

    boolean isSaveOnInactiveEviction();

    void setSaveOnCreate(boolean z);

    boolean isSaveOnCreate();

    void setRemoveUnloadableSessions(boolean z);

    boolean isRemoveUnloadableSessions();

    void setFlushOnResponseCommit(boolean z);

    boolean isFlushOnResponseCommit();

    void setInvalidateOnShutdown(boolean z);

    boolean isInvalidateOnShutdown();

    @Deprecated
    default Session renewSessionId(String oldId, String newId) throws Exception {
        return null;
    }

    default Session renewSessionId(String oldId, String newId, String oldExtendedId, String newExtendedId) throws Exception {
        return renewSessionId(oldId, newId);
    }
}
