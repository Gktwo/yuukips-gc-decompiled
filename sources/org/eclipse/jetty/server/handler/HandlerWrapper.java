package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;

@ManagedObject("Handler wrapping another Handler")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/HandlerWrapper.class */
public class HandlerWrapper extends AbstractHandlerContainer {
    protected Handler _handler;

    @ManagedAttribute(value = "Wrapped Handler", readonly = true)
    public Handler getHandler() {
        return this._handler;
    }

    @Override // org.eclipse.jetty.server.HandlerContainer
    public Handler[] getHandlers() {
        return this._handler == null ? new Handler[0] : new Handler[]{this._handler};
    }

    public void setHandler(Handler handler) {
        if (isStarted()) {
            throw new IllegalStateException(AbstractLifeCycle.STARTED);
        } else if (handler == this || ((handler instanceof HandlerContainer) && Arrays.asList(((HandlerContainer) handler).getChildHandlers()).contains(this))) {
            throw new IllegalStateException("setHandler loop");
        } else {
            if (handler != null) {
                handler.setServer(getServer());
            }
            Handler old = this._handler;
            this._handler = handler;
            updateBean(old, this._handler, true);
        }
    }

    public void insertHandler(HandlerWrapper wrapper) {
        if (wrapper == null) {
            throw new IllegalArgumentException();
        }
        HandlerWrapper tail = wrapper;
        while (tail.getHandler() instanceof HandlerWrapper) {
            tail = (HandlerWrapper) tail.getHandler();
        }
        if (tail.getHandler() != null) {
            throw new IllegalArgumentException("bad tail of inserted wrapper chain");
        }
        Handler next = getHandler();
        setHandler(wrapper);
        tail.setHandler(next);
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Handler handler = this._handler;
        if (handler != null) {
            handler.handle(target, baseRequest, request, response);
        }
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandlerContainer
    protected void expandChildren(List<Handler> list, Class<?> byClass) {
        expandHandler(this._handler, list, byClass);
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
