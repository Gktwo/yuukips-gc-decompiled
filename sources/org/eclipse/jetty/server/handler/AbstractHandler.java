package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject("Jetty Handler")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/AbstractHandler.class */
public abstract class AbstractHandler extends ContainerLifeCycle implements Handler {
    private static final Logger LOG = Log.getLogger(AbstractHandler.class);
    private Server _server;

    @Override // org.eclipse.jetty.server.Handler
    public abstract void handle(String str, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException;

    @Deprecated
    protected void doError(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Object o = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        response.setStatus(o instanceof Integer ? ((Integer) o).intValue() : o != null ? Integer.parseInt(o.toString()) : 500);
        baseRequest.setHandled(true);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("starting {}", this);
        }
        if (this._server == null) {
            LOG.warn("No Server set for {}", this);
        }
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("stopping {}", this);
        }
        doStop();
    }

    @Override // org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        if (this._server != server) {
            if (isStarted()) {
                throw new IllegalStateException(AbstractLifeCycle.STARTED);
            }
            this._server = server;
        }
    }

    @Override // org.eclipse.jetty.server.Handler
    public Server getServer() {
        return this._server;
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        if (!isStopped()) {
            throw new IllegalStateException("!STOPPED");
        }
        destroy();
    }

    @Deprecated
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/AbstractHandler$ErrorDispatchHandler.class */
    public static abstract class ErrorDispatchHandler extends AbstractHandler {
        @Deprecated
        protected abstract void doNonErrorHandle(String str, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException;

        @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
        public final void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            if (baseRequest.getDispatcherType() == DispatcherType.ERROR) {
                doError(target, baseRequest, request, response);
            } else {
                doNonErrorHandle(target, baseRequest, request, response);
            }
        }
    }
}
