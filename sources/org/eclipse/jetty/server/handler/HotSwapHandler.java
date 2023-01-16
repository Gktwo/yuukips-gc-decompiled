package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/HotSwapHandler.class */
public class HotSwapHandler extends AbstractHandlerContainer {
    private volatile Handler _handler;

    public Handler getHandler() {
        return this._handler;
    }

    @Override // org.eclipse.jetty.server.HandlerContainer
    public Handler[] getHandlers() {
        Handler handler = this._handler;
        return handler == null ? new Handler[0] : new Handler[]{handler};
    }

    public void setHandler(Handler handler) {
        try {
            Server server = getServer();
            if (handler != null) {
                handler.setServer(server);
            }
            updateBean(this._handler, handler, true);
            this._handler = handler;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Handler handler = this._handler;
        if (handler != null && isStarted() && handler.isStarted()) {
            handler.handle(target, baseRequest, request, response);
        }
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandlerContainer
    protected void expandChildren(List<Handler> list, Class<?> byClass) {
        Handler handler = this._handler;
        if (handler != null) {
            expandHandler(handler, list, byClass);
        }
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        if (!isStopped()) {
            throw new IllegalStateException("!STOPPED");
        }
        Handler child = getHandler();
        if (child != null) {
            setHandler(null);
            child.destroy();
        }
        destroy();
    }
}
