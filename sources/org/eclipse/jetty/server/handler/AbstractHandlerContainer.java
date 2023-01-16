package org.eclipse.jetty.server.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.Graceful;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/AbstractHandlerContainer.class */
public abstract class AbstractHandlerContainer extends AbstractHandler implements HandlerContainer {
    private static final Logger LOG = Log.getLogger(AbstractHandlerContainer.class);

    @Override // org.eclipse.jetty.server.HandlerContainer
    public Handler[] getChildHandlers() {
        List<Handler> list = new ArrayList<>();
        expandChildren(list, null);
        return (Handler[]) list.toArray(new Handler[list.size()]);
    }

    @Override // org.eclipse.jetty.server.HandlerContainer
    public Handler[] getChildHandlersByClass(Class<?> byclass) {
        List<Handler> list = new ArrayList<>();
        expandChildren(list, byclass);
        return (Handler[]) list.toArray(new Handler[list.size()]);
    }

    @Override // org.eclipse.jetty.server.HandlerContainer
    public <T extends Handler> T getChildHandlerByClass(Class<T> byclass) {
        List<Handler> list = new ArrayList<>();
        expandChildren(list, byclass);
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }

    protected void expandChildren(List<Handler> list, Class<?> byClass) {
    }

    protected void expandHandler(Handler handler, List<Handler> list, Class<?> byClass) {
        if (handler != null) {
            if (byClass == null || byClass.isAssignableFrom(handler.getClass())) {
                list.add(handler);
            }
            if (handler instanceof AbstractHandlerContainer) {
                ((AbstractHandlerContainer) handler).expandChildren(list, byClass);
            } else if (handler instanceof HandlerContainer) {
                HandlerContainer container = (HandlerContainer) handler;
                list.addAll(Arrays.asList(byClass == null ? container.getChildHandlers() : container.getChildHandlersByClass(byClass)));
            }
        }
    }

    public static <T extends HandlerContainer> T findContainerOf(HandlerContainer root, Class<T> type, Handler handler) {
        Handler[] branches;
        if (root == null || handler == null || (branches = root.getChildHandlersByClass(type)) == null) {
            return null;
        }
        for (Handler h : branches) {
            T container = (T) ((HandlerContainer) h);
            Handler[] candidates = container.getChildHandlersByClass(handler.getClass());
            if (candidates != null) {
                for (Handler c : candidates) {
                    if (c == handler) {
                        return container;
                    }
                }
                continue;
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void setServer(Server server) {
        if (server != getServer()) {
            if (isStarted()) {
                throw new IllegalStateException(AbstractLifeCycle.STARTED);
            }
            setServer(server);
            Handler[] handlers = getHandlers();
            if (handlers != null) {
                for (Handler h : handlers) {
                    h.setServer(server);
                }
            }
        }
    }

    protected void doShutdown(List<Future<Void>> futures) throws MultiException {
        MultiException mex = null;
        Handler[] gracefuls = getChildHandlersByClass(Graceful.class);
        if (futures == null) {
            futures = new ArrayList(gracefuls.length);
        }
        for (Handler graceful : gracefuls) {
            futures.add(((Graceful) graceful).shutdown());
        }
        long stopTimeout = getStopTimeout();
        if (stopTimeout > 0) {
            long stopBy = System.currentTimeMillis() + stopTimeout;
            if (LOG.isDebugEnabled()) {
                LOG.debug("Graceful shutdown {} by ", this, new Date(stopBy));
            }
            for (Future<Void> future : futures) {
                try {
                    if (!future.isDone()) {
                        future.get(Math.max(1L, stopBy - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
                    }
                } catch (Exception e) {
                    if ((future instanceof Callback) && !future.isDone()) {
                        ((Callback) future).failed(e);
                    }
                    if (mex == null) {
                        mex = new MultiException();
                    }
                    mex.add(e);
                }
            }
        }
        for (Future<Void> future2 : futures) {
            if (!future2.isDone()) {
                future2.cancel(true);
            }
        }
        if (mex != null) {
            mex.ifExceptionThrowMulti();
        }
    }
}
