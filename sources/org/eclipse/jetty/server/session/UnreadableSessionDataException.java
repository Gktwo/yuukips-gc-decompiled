package org.eclipse.jetty.server.session;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/UnreadableSessionDataException.class */
public class UnreadableSessionDataException extends Exception {
    private static final long serialVersionUID = 1806303483488966566L;
    private String _id;
    private SessionContext _sessionContext;

    public String getId() {
        return this._id;
    }

    public SessionContext getSessionContext() {
        return this._sessionContext;
    }

    public UnreadableSessionDataException(String id, SessionContext sessionContext, Throwable t) {
        super("Unreadable session " + id + " for " + sessionContext, t);
        this._sessionContext = sessionContext;
        this._id = id;
    }
}
