package org.eclipse.jetty.server.session;

import net.bytebuddy.utility.JavaConstant;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.StringUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/SessionContext.class */
public class SessionContext {
    public static final String NULL_VHOST = "0.0.0.0";
    private ContextHandler.Context _context;
    private SessionHandler _sessionHandler;
    private String _workerName;
    private String _canonicalContextPath;
    private String _vhost;

    public SessionContext(String workerName, ContextHandler.Context context) {
        if (context != null) {
            this._sessionHandler = (SessionHandler) context.getContextHandler().getChildHandlerByClass(SessionHandler.class);
        }
        this._workerName = workerName;
        this._context = context;
        this._canonicalContextPath = canonicalizeContextPath(this._context);
        this._vhost = canonicalizeVHost(this._context);
    }

    public String getWorkerName() {
        return this._workerName;
    }

    public SessionHandler getSessionHandler() {
        return this._sessionHandler;
    }

    public ContextHandler.Context getContext() {
        return this._context;
    }

    public String getCanonicalContextPath() {
        return this._canonicalContextPath;
    }

    public String getVhost() {
        return this._vhost;
    }

    public String toString() {
        return this._workerName + JavaConstant.Dynamic.DEFAULT_NAME + this._canonicalContextPath + JavaConstant.Dynamic.DEFAULT_NAME + this._vhost;
    }

    public void run(Runnable r) {
        if (this._context != null) {
            this._context.getContextHandler().handle(r);
        } else {
            r.run();
        }
    }

    private String canonicalizeContextPath(ContextHandler.Context context) {
        if (context == null) {
            return "";
        }
        return canonicalize(context.getContextPath());
    }

    private String canonicalizeVHost(ContextHandler.Context context) {
        if (context == null) {
            return "0.0.0.0";
        }
        String[] vhosts = context.getContextHandler().getVirtualHosts();
        if (vhosts == null || vhosts.length == 0 || vhosts[0] == null) {
            return "0.0.0.0";
        }
        return vhosts[0];
    }

    private String canonicalize(String path) {
        if (path == null) {
            return "";
        }
        return StringUtil.sanitizeFileSystemName(path);
    }
}
