package org.eclipse.jetty.server.session;

import java.util.Set;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/SessionDataStore.class */
public interface SessionDataStore extends SessionDataMap {
    SessionData newSessionData(String str, long j, long j2, long j3, long j4);

    Set<String> getExpired(Set<String> set);

    boolean isPassivating();

    boolean exists(String str) throws Exception;
}
