package org.eclipse.jetty.websocket.common;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.LifeCycle;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/SessionTracker.class */
public class SessionTracker extends AbstractLifeCycle implements WebSocketSessionListener, Dumpable {
    private final Set<WebSocketSession> sessions = Collections.newSetFromMap(new ConcurrentHashMap());

    public Set<WebSocketSession> getSessions() {
        return Collections.unmodifiableSet(new HashSet(this.sessions));
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketSessionListener
    public void onSessionCreated(WebSocketSession session) {
        LifeCycle.start(session);
        this.sessions.add(session);
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketSessionListener
    public void onSessionClosed(WebSocketSession session) {
        this.sessions.remove(session);
        LifeCycle.stop(session);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        for (WebSocketSession session : this.sessions) {
            LifeCycle.stop(session);
        }
        doStop();
    }

    @ManagedAttribute("Total number of active WebSocket Sessions")
    public int getNumSessions() {
        return this.sessions.size();
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, this, this.sessions);
    }
}
