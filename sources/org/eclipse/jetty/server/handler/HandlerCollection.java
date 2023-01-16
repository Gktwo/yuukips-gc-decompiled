package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.ArrayUtil;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;

@ManagedObject("Handler of multiple handlers")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/HandlerCollection.class */
public class HandlerCollection extends AbstractHandlerContainer {
    private final boolean _mutableWhenRunning;
    protected final AtomicReference<Handlers> _handlers;

    public HandlerCollection() {
        this(false, new Handler[0]);
    }

    public HandlerCollection(Handler... handlers) {
        this(false, handlers);
    }

    public HandlerCollection(boolean mutableWhenRunning, Handler... handlers) {
        this._handlers = new AtomicReference<>();
        this._mutableWhenRunning = mutableWhenRunning;
        if (handlers.length > 0) {
            setHandlers(handlers);
        }
    }

    @Override // org.eclipse.jetty.server.HandlerContainer
    @ManagedAttribute(value = "Wrapped handlers", readonly = true)
    public Handler[] getHandlers() {
        Handlers handlers = this._handlers.get();
        if (handlers == null) {
            return null;
        }
        return handlers._handlers;
    }

    public void setHandlers(Handler[] handlers) {
        if (this._mutableWhenRunning || !isStarted()) {
            do {
            } while (!updateHandlers(this._handlers.get(), newHandlers(handlers)));
            return;
        }
        throw new IllegalStateException(AbstractLifeCycle.STARTED);
    }

    protected Handlers newHandlers(Handler[] handlers) {
        if (handlers == null || handlers.length == 0) {
            return null;
        }
        return new Handlers(handlers);
    }

    protected boolean updateHandlers(Handlers old, Handlers handlers) {
        if (handlers != null) {
            Handler[] handlerArr = handlers._handlers;
            for (Handler handler : handlerArr) {
                if (handler == this || ((handler instanceof HandlerContainer) && Arrays.asList(((HandlerContainer) handler).getChildHandlers()).contains(this))) {
                    throw new IllegalStateException("setHandler loop");
                }
            }
            Handler[] handlerArr2 = handlers._handlers;
            for (Handler handler2 : handlerArr2) {
                if (handler2.getServer() != getServer()) {
                    handler2.setServer(getServer());
                }
            }
        }
        if (!this._handlers.compareAndSet(old, handlers)) {
            return false;
        }
        updateBeans(old == null ? null : old._handlers, handlers == null ? null : handlers._handlers);
        return true;
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Handlers handlers;
        if (isStarted() && (handlers = this._handlers.get()) != null) {
            MultiException mex = null;
            for (Handler handler : handlers._handlers) {
                try {
                    handler.handle(target, baseRequest, request, response);
                } catch (IOException | RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    if (mex == null) {
                        mex = new MultiException();
                    }
                    mex.add(e2);
                }
            }
            if (mex == null) {
                return;
            }
            if (mex.size() == 1) {
                throw new ServletException(mex.getThrowable(0));
            }
            throw new ServletException(mex);
        }
    }

    public void addHandler(Handler handler) {
        Handlers old;
        do {
            old = this._handlers.get();
        } while (!updateHandlers(old, newHandlers((Handler[]) ArrayUtil.addToArray(old == null ? null : (Handler[]) ArrayUtil.removeFromArray(old._handlers, handler), handler, Handler.class))));
    }

    public void prependHandler(Handler handler) {
        Handlers old;
        do {
            old = this._handlers.get();
        } while (!updateHandlers(old, newHandlers((Handler[]) ArrayUtil.prependToArray(handler, old == null ? null : old._handlers, Handler.class))));
    }

    public void removeHandler(Handler handler) {
        Handlers old;
        do {
            old = this._handlers.get();
            if (old == null || old._handlers.length == 0) {
                return;
            }
        } while (!updateHandlers(old, newHandlers((Handler[]) ArrayUtil.removeFromArray(old._handlers, handler))));
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandlerContainer
    protected void expandChildren(List<Handler> list, Class<?> byClass) {
        Handler[] handlers = getHandlers();
        if (handlers != null) {
            for (Handler h : handlers) {
                expandHandler(h, list, byClass);
            }
        }
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        if (!isStopped()) {
            throw new IllegalStateException("!STOPPED");
        }
        Handler[] children = getChildHandlers();
        setHandlers(null);
        for (Handler child : children) {
            child.destroy();
        }
        destroy();
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/HandlerCollection$Handlers.class */
    public static class Handlers {
        private final Handler[] _handlers;

        /* access modifiers changed from: protected */
        public Handlers(Handler[] handlers) {
            this._handlers = handlers;
        }

        public Handler[] getHandlers() {
            return this._handlers;
        }
    }
}
