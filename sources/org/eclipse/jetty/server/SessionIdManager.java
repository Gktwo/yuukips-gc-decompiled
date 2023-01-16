package org.eclipse.jetty.server;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.server.session.HouseKeeper;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.util.component.LifeCycle;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/SessionIdManager.class */
public interface SessionIdManager extends LifeCycle {
    boolean isIdInUse(String str);

    void expireAll(String str);

    void invalidateAll(String str);

    String newSessionId(HttpServletRequest httpServletRequest, long j);

    String getWorkerName();

    String getId(String str);

    String getExtendedId(String str, HttpServletRequest httpServletRequest);

    String renewSessionId(String str, String str2, HttpServletRequest httpServletRequest);

    Set<SessionHandler> getSessionHandlers();

    void setSessionHouseKeeper(HouseKeeper houseKeeper);

    HouseKeeper getSessionHouseKeeper();
}
