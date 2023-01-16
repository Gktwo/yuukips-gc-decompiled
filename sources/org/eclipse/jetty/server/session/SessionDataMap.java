package org.eclipse.jetty.server.session;

import org.eclipse.jetty.util.component.LifeCycle;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/SessionDataMap.class */
public interface SessionDataMap extends LifeCycle {
    void initialize(SessionContext sessionContext) throws Exception;

    SessionData load(String str) throws Exception;

    void store(String str, SessionData sessionData) throws Exception;

    boolean delete(String str) throws Exception;
}
