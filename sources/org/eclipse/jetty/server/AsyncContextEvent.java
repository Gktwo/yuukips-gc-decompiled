package org.eclipse.jetty.server;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.thread.Scheduler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AsyncContextEvent.class */
public class AsyncContextEvent extends AsyncEvent implements Runnable {
    private final ContextHandler.Context _context;
    private final AsyncContextState _asyncContext;
    private final HttpChannelState _state;
    private ServletContext _dispatchContext;
    private String _dispatchPath;
    private volatile Scheduler.Task _timeoutTask;
    private Throwable _throwable;

    public AsyncContextEvent(ContextHandler.Context context, AsyncContextState asyncContext, HttpChannelState state, Request baseRequest, ServletRequest request, ServletResponse response) {
        super(null, request, response, null);
        this._context = context;
        this._asyncContext = asyncContext;
        this._state = state;
        baseRequest.setAsyncAttributes();
    }

    public ServletContext getSuspendedContext() {
        return this._context;
    }

    public ContextHandler.Context getContext() {
        return this._context;
    }

    public ServletContext getDispatchContext() {
        return this._dispatchContext;
    }

    public ServletContext getServletContext() {
        return this._dispatchContext == null ? this._context : this._dispatchContext;
    }

    public String getPath() {
        return this._dispatchPath;
    }

    public void setTimeoutTask(Scheduler.Task task) {
        this._timeoutTask = task;
    }

    public boolean hasTimeoutTask() {
        return this._timeoutTask != null;
    }

    public void cancelTimeoutTask() {
        Scheduler.Task task = this._timeoutTask;
        this._timeoutTask = null;
        if (task != null) {
            task.cancel();
        }
    }

    @Override // javax.servlet.AsyncEvent
    public AsyncContext getAsyncContext() {
        return this._asyncContext;
    }

    @Override // javax.servlet.AsyncEvent
    public Throwable getThrowable() {
        return this._throwable;
    }

    public void setDispatchContext(ServletContext context) {
        this._dispatchContext = context;
    }

    public void setDispatchPath(String path) {
        this._dispatchPath = path;
    }

    public void completed() {
        this._timeoutTask = null;
        this._asyncContext.reset();
    }

    public HttpChannelState getHttpChannelState() {
        return this._state;
    }

    @Override // java.lang.Runnable
    public void run() {
        Scheduler.Task task = this._timeoutTask;
        this._timeoutTask = null;
        if (task != null) {
            this._state.timeout();
        }
    }

    public void addThrowable(Throwable e) {
        if (this._throwable == null) {
            this._throwable = e;
        } else if (e != this._throwable) {
            this._throwable.addSuppressed(e);
        }
    }
}
