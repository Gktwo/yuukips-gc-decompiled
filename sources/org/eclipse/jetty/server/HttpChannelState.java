package org.eclipse.jetty.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.servlet.AsyncListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.p023io.QuietException;
import org.eclipse.jetty.server.AsyncContextState;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelState.class */
public class HttpChannelState {
    private static final Logger LOG = Log.getLogger(HttpChannelState.class);
    private static final long DEFAULT_TIMEOUT = Long.getLong("org.eclipse.jetty.server.HttpChannelState.DEFAULT_TIMEOUT", 30000).longValue();
    private final HttpChannel _channel;
    private List<AsyncListener> _asyncListeners;
    private boolean _sendError;
    private boolean _asyncWritePossible;
    private AsyncContextEvent _event;
    private Thread _onTimeoutThread;
    private State _state = State.IDLE;
    private RequestState _requestState = RequestState.BLOCKING;
    private OutputState _outputState = OutputState.OPEN;
    private InputState _inputState = InputState.IDLE;
    private boolean _initial = true;
    private long _timeoutMs = DEFAULT_TIMEOUT;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelState$Action.class */
    public enum Action {
        DISPATCH,
        ASYNC_DISPATCH,
        SEND_ERROR,
        ASYNC_ERROR,
        ASYNC_TIMEOUT,
        WRITE_CALLBACK,
        READ_REGISTER,
        READ_PRODUCE,
        READ_CALLBACK,
        COMPLETE,
        TERMINATED,
        WAIT
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelState$InputState.class */
    public enum InputState {
        IDLE,
        REGISTER,
        REGISTERED,
        POSSIBLE,
        PRODUCING,
        READY
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelState$OutputState.class */
    public enum OutputState {
        OPEN,
        COMMITTED,
        COMPLETED,
        ABORTED
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelState$RequestState.class */
    public enum RequestState {
        BLOCKING,
        ASYNC,
        DISPATCH,
        EXPIRE,
        EXPIRING,
        COMPLETE,
        COMPLETING,
        COMPLETED
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelState$State.class */
    public enum State {
        IDLE,
        HANDLING,
        WAITING,
        WOKEN,
        UPGRADED
    }

    /* access modifiers changed from: protected */
    public HttpChannelState(HttpChannel channel) {
        this._channel = channel;
    }

    public State getState() {
        State state;
        synchronized (this) {
            state = this._state;
        }
        return state;
    }

    public void addListener(AsyncListener listener) {
        synchronized (this) {
            if (this._asyncListeners == null) {
                this._asyncListeners = new ArrayList();
            }
            this._asyncListeners.add(listener);
        }
    }

    public boolean hasListener(AsyncListener listener) {
        synchronized (this) {
            if (this._asyncListeners == null) {
                return false;
            }
            for (AsyncListener l : this._asyncListeners) {
                if (l == listener) {
                    return true;
                }
                if ((l instanceof AsyncContextState.WrappedAsyncListener) && ((AsyncContextState.WrappedAsyncListener) l).getListener() == listener) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isSendError() {
        boolean z;
        synchronized (this) {
            z = this._sendError;
        }
        return z;
    }

    public void setTimeout(long ms) {
        synchronized (this) {
            this._timeoutMs = ms;
        }
    }

    public long getTimeout() {
        long j;
        synchronized (this) {
            j = this._timeoutMs;
        }
        return j;
    }

    public AsyncContextEvent getAsyncContextEvent() {
        AsyncContextEvent asyncContextEvent;
        synchronized (this) {
            asyncContextEvent = this._event;
        }
        return asyncContextEvent;
    }

    public String toString() {
        String stringLocked;
        synchronized (this) {
            stringLocked = toStringLocked();
        }
        return stringLocked;
    }

    private String toStringLocked() {
        return String.format("%s@%x{%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), getStatusStringLocked());
    }

    private String getStatusStringLocked() {
        Object[] objArr = new Object[8];
        objArr[0] = this._state;
        objArr[1] = this._requestState;
        objArr[2] = this._outputState;
        objArr[3] = this._inputState;
        objArr[4] = Boolean.valueOf(this._asyncWritePossible);
        objArr[5] = Boolean.valueOf(this._sendError);
        objArr[6] = Boolean.valueOf(this._initial);
        objArr[7] = Integer.valueOf(this._asyncListeners == null ? 0 : this._asyncListeners.size());
        return String.format("s=%s rs=%s os=%s is=%s awp=%b se=%b i=%b al=%d", objArr);
    }

    public String getStatusString() {
        String statusStringLocked;
        synchronized (this) {
            statusStringLocked = getStatusStringLocked();
        }
        return statusStringLocked;
    }

    public boolean commitResponse() {
        synchronized (this) {
            switch (this._outputState) {
                case OPEN:
                    this._outputState = OutputState.COMMITTED;
                    return true;
                default:
                    return false;
            }
        }
    }

    public boolean partialResponse() {
        synchronized (this) {
            switch (this._outputState) {
                case COMMITTED:
                    this._outputState = OutputState.OPEN;
                    return true;
                default:
                    return false;
            }
        }
    }

    public boolean completeResponse() {
        synchronized (this) {
            switch (this._outputState) {
                case OPEN:
                case COMMITTED:
                    this._outputState = OutputState.COMPLETED;
                    return true;
                default:
                    return false;
            }
        }
    }

    public boolean isResponseCommitted() {
        synchronized (this) {
            switch (this._outputState) {
                case OPEN:
                    return false;
                default:
                    return true;
            }
        }
    }

    public boolean isResponseCompleted() {
        boolean z;
        synchronized (this) {
            z = this._outputState == OutputState.COMPLETED;
        }
        return z;
    }

    public boolean abortResponse() {
        synchronized (this) {
            switch (this._outputState) {
                case OPEN:
                    this._channel.getResponse().setStatus(500);
                    this._outputState = OutputState.ABORTED;
                    return true;
                case ABORTED:
                    return false;
                default:
                    this._outputState = OutputState.ABORTED;
                    return true;
            }
        }
    }

    public Action handling() {
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("handling {}", toStringLocked());
            }
            switch (this._state) {
                case IDLE:
                    if (this._requestState != RequestState.BLOCKING) {
                        throw new IllegalStateException(getStatusStringLocked());
                    }
                    this._initial = true;
                    this._state = State.HANDLING;
                    return Action.DISPATCH;
                case WOKEN:
                    if (this._event == null || this._event.getThrowable() == null || this._sendError) {
                        Action action = nextAction(true);
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("nextAction(true) {} {}", action, toStringLocked());
                        }
                        return action;
                    }
                    this._state = State.HANDLING;
                    return Action.ASYNC_ERROR;
                default:
                    throw new IllegalStateException(getStatusStringLocked());
            }
        }
    }

    /* access modifiers changed from: protected */
    public Action unhandle() {
        Action action;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("unhandle {}", toStringLocked());
            }
            if (this._state != State.HANDLING) {
                throw new IllegalStateException(getStatusStringLocked());
            }
            this._initial = false;
            action = nextAction(false);
            if (LOG.isDebugEnabled()) {
                LOG.debug("nextAction(false) {} {}", action, toStringLocked());
            }
        }
        return action;
    }

    private Action nextAction(boolean handling) {
        this._state = State.HANDLING;
        if (this._sendError) {
            switch (this._requestState) {
                case BLOCKING:
                case ASYNC:
                case COMPLETE:
                case DISPATCH:
                case COMPLETING:
                    this._requestState = RequestState.BLOCKING;
                    this._sendError = false;
                    return Action.SEND_ERROR;
            }
        }
        switch (this._requestState) {
            case BLOCKING:
                if (handling) {
                    throw new IllegalStateException(getStatusStringLocked());
                }
                this._requestState = RequestState.COMPLETING;
                return Action.COMPLETE;
            case ASYNC:
                switch (this._inputState) {
                    case POSSIBLE:
                        this._inputState = InputState.PRODUCING;
                        return Action.READ_PRODUCE;
                    case READY:
                        this._inputState = InputState.IDLE;
                        return Action.READ_CALLBACK;
                    case REGISTER:
                    case PRODUCING:
                        this._inputState = InputState.REGISTERED;
                        return Action.READ_REGISTER;
                    case IDLE:
                    case REGISTERED:
                        if (this._asyncWritePossible) {
                            this._asyncWritePossible = false;
                            return Action.WRITE_CALLBACK;
                        }
                        Scheduler scheduler = this._channel.getScheduler();
                        if (scheduler != null && this._timeoutMs > 0 && !this._event.hasTimeoutTask()) {
                            this._event.setTimeoutTask(scheduler.schedule(this._event, this._timeoutMs, TimeUnit.MILLISECONDS));
                        }
                        this._state = State.WAITING;
                        return Action.WAIT;
                    default:
                        throw new IllegalStateException(getStatusStringLocked());
                }
            case COMPLETE:
                this._requestState = RequestState.COMPLETING;
                return Action.COMPLETE;
            case DISPATCH:
                this._requestState = RequestState.BLOCKING;
                return Action.ASYNC_DISPATCH;
            case COMPLETING:
                this._state = State.WAITING;
                return Action.WAIT;
            case EXPIRE:
                this._requestState = RequestState.EXPIRING;
                return Action.ASYNC_TIMEOUT;
            case EXPIRING:
                if (handling) {
                    throw new IllegalStateException(getStatusStringLocked());
                }
                sendError(500, "AsyncContext timeout");
                this._requestState = RequestState.BLOCKING;
                this._sendError = false;
                return Action.SEND_ERROR;
            case COMPLETED:
                this._state = State.IDLE;
                return Action.TERMINATED;
            default:
                throw new IllegalStateException(getStatusStringLocked());
        }
    }

    public void startAsync(final AsyncContextEvent event) {
        final List<AsyncListener> lastAsyncListeners;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("startAsync {}", toStringLocked());
            }
            if (this._state == State.HANDLING && this._requestState == RequestState.BLOCKING) {
                this._requestState = RequestState.ASYNC;
                this._event = event;
                lastAsyncListeners = this._asyncListeners;
                this._asyncListeners = null;
            } else {
                throw new IllegalStateException(getStatusStringLocked());
            }
        }
        if (lastAsyncListeners != null) {
            runInContext(event, new Runnable() { // from class: org.eclipse.jetty.server.HttpChannelState.1
                @Override // java.lang.Runnable
                public void run() {
                    for (AsyncListener listener : lastAsyncListeners) {
                        try {
                            listener.onStartAsync(event);
                        } catch (Throwable e) {
                            HttpChannelState.LOG.warn(e);
                        }
                    }
                }

                @Override // java.lang.Object
                public String toString() {
                    return "startAsync";
                }
            });
        }
    }

    public void dispatch(ServletContext context, String path) {
        AsyncContextEvent event;
        boolean dispatch = false;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("dispatch {} -> {}", toStringLocked(), path);
            }
            switch (this._requestState) {
                case ASYNC:
                    break;
                case EXPIRING:
                    if (Thread.currentThread() != this._onTimeoutThread) {
                        throw new IllegalStateException(getStatusStringLocked());
                    }
                    break;
                default:
                    throw new IllegalStateException(getStatusStringLocked());
            }
            if (context != null) {
                this._event.setDispatchContext(context);
            }
            if (path != null) {
                this._event.setDispatchPath(path);
            }
            if (this._requestState == RequestState.ASYNC && this._state == State.WAITING) {
                this._state = State.WOKEN;
                dispatch = true;
            }
            this._requestState = RequestState.DISPATCH;
            event = this._event;
        }
        cancelTimeout(event);
        if (dispatch) {
            scheduleDispatch();
        }
    }

    /* access modifiers changed from: protected */
    public void timeout() {
        boolean dispatch = false;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Timeout {}", toStringLocked());
            }
            if (this._requestState == RequestState.ASYNC) {
                this._requestState = RequestState.EXPIRE;
                if (this._state == State.WAITING) {
                    this._state = State.WOKEN;
                    dispatch = true;
                }
                if (dispatch) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Dispatch after async timeout {}", this);
                    }
                    scheduleDispatch();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onTimeout() {
        final AsyncContextEvent event;
        final List<AsyncListener> listeners;
        synchronized (this) {
            try {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("onTimeout {}", toStringLocked());
                }
                if (this._requestState == RequestState.EXPIRING && this._state == State.HANDLING) {
                    event = this._event;
                    listeners = this._asyncListeners;
                    this._onTimeoutThread = Thread.currentThread();
                } else {
                    throw new IllegalStateException(toStringLocked());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (listeners != null) {
            try {
                runInContext(event, new Runnable() { // from class: org.eclipse.jetty.server.HttpChannelState.2
                    @Override // java.lang.Runnable
                    public void run() {
                        for (AsyncListener listener : listeners) {
                            try {
                                listener.onTimeout(event);
                            } catch (Throwable x) {
                                HttpChannelState.LOG.warn("{} while invoking onTimeout listener {}", x, listener, x);
                            }
                        }
                    }

                    @Override // java.lang.Object
                    public String toString() {
                        return "onTimeout";
                    }
                });
            } catch (Throwable th2) {
                synchronized (this) {
                    try {
                        this._onTimeoutThread = null;
                        throw th2;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        }
        synchronized (this) {
            try {
                this._onTimeoutThread = null;
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public void complete() {
        boolean handle = false;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("complete {}", toStringLocked());
            }
            AsyncContextEvent event = this._event;
            switch (this._requestState) {
                case ASYNC:
                    this._requestState = this._sendError ? RequestState.BLOCKING : RequestState.COMPLETE;
                    break;
                case COMPLETE:
                    return;
                case EXPIRING:
                    if (Thread.currentThread() == this._onTimeoutThread) {
                        this._requestState = this._sendError ? RequestState.BLOCKING : RequestState.COMPLETE;
                        break;
                    } else {
                        throw new IllegalStateException(getStatusStringLocked());
                    }
                default:
                    throw new IllegalStateException(getStatusStringLocked());
            }
            if (this._state == State.WAITING) {
                handle = true;
                this._state = State.WOKEN;
            }
            cancelTimeout(event);
            if (handle) {
                runInContext(event, this._channel);
            }
        }
    }

    public void asyncError(Throwable failure) {
        AsyncContextEvent event = null;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("asyncError " + toStringLocked(), failure);
            }
            if (this._state == State.WAITING && this._requestState == RequestState.ASYNC) {
                this._state = State.WOKEN;
                this._event.addThrowable(failure);
                event = this._event;
            } else {
                if (!(failure instanceof QuietException)) {
                    LOG.warn(failure.toString(), new Object[0]);
                }
                if (LOG.isDebugEnabled()) {
                    LOG.debug(failure);
                }
            }
        }
        if (event != null) {
            cancelTimeout(event);
            runInContext(event, this._channel);
        }
    }

    /* access modifiers changed from: protected */
    public void onError(Throwable th) {
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("thrownException " + getStatusStringLocked(), th);
            }
            if (this._state != State.HANDLING) {
                throw new IllegalStateException(getStatusStringLocked());
            } else if (this._sendError) {
                LOG.warn("unhandled due to prior sendError", th);
            } else {
                switch (this._requestState) {
                    case BLOCKING:
                        sendError(th);
                        return;
                    case ASYNC:
                    case COMPLETE:
                    case DISPATCH:
                        if (this._asyncListeners == null || this._asyncListeners.isEmpty()) {
                            sendError(th);
                            return;
                        }
                        AsyncContextEvent asyncEvent = this._event;
                        asyncEvent.addThrowable(th);
                        List<AsyncListener> asyncListeners = this._asyncListeners;
                        runInContext(asyncEvent, () -> {
                            Iterator it = asyncListeners.iterator();
                            while (it.hasNext()) {
                                AsyncListener listener = (AsyncListener) it.next();
                                try {
                                    listener.onError(asyncEvent);
                                } catch (Throwable x) {
                                    LOG.warn(x + " while invoking onError listener " + listener, new Object[0]);
                                    LOG.debug(x);
                                }
                            }
                        });
                        synchronized (this) {
                            if (this._requestState == RequestState.ASYNC && !this._sendError) {
                                sendError(th);
                            } else if (this._requestState != RequestState.COMPLETE) {
                                LOG.warn("unhandled in state " + this._requestState, new IllegalStateException(th));
                            }
                        }
                        return;
                    default:
                        LOG.warn("unhandled in state " + this._requestState, new IllegalStateException(th));
                        return;
                }
            }
        }
    }

    private void sendError(Throwable th) {
        String message;
        int code;
        Request request = this._channel.getRequest();
        Throwable cause = this._channel.unwrap(th, BadMessageException.class, UnavailableException.class);
        if (cause == null) {
            code = 500;
            message = th.toString();
        } else if (cause instanceof BadMessageException) {
            BadMessageException bme = (BadMessageException) cause;
            code = bme.getCode();
            message = bme.getReason();
        } else if (cause instanceof UnavailableException) {
            message = cause.toString();
            if (((UnavailableException) cause).isPermanent()) {
                code = 404;
            } else {
                code = 503;
            }
        } else {
            code = 500;
            message = null;
        }
        sendError(code, message);
        request.setAttribute(RequestDispatcher.ERROR_EXCEPTION, th);
        request.setAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE, th.getClass());
        this._requestState = RequestState.BLOCKING;
    }

    public void sendError(int code, String message) {
        Throwable cause;
        Request request = this._channel.getRequest();
        Response response = this._channel.getResponse();
        if (message == null) {
            message = HttpStatus.getMessage(code);
        }
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("sendError {}", toStringLocked());
            }
            if (this._outputState != OutputState.OPEN) {
                throw new IllegalStateException(this._outputState.toString());
            }
            switch (this._state) {
                case WOKEN:
                case HANDLING:
                case WAITING:
                    response.setStatus(code);
                    response.errorClose();
                    request.setAttribute(ErrorHandler.ERROR_CONTEXT, request.getErrorContext());
                    request.setAttribute(RequestDispatcher.ERROR_REQUEST_URI, request.getRequestURI());
                    request.setAttribute(RequestDispatcher.ERROR_SERVLET_NAME, request.getServletName());
                    request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, Integer.valueOf(code));
                    request.setAttribute(RequestDispatcher.ERROR_MESSAGE, message);
                    this._sendError = true;
                    if (!(this._event == null || (cause = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION)) == null)) {
                        this._event.addThrowable(cause);
                    }
                    break;
                default:
                    throw new IllegalStateException(getStatusStringLocked());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void completing() {
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("completing {}", toStringLocked());
            }
            switch (this._requestState) {
                case COMPLETED:
                    throw new IllegalStateException(getStatusStringLocked());
                default:
                    this._requestState = RequestState.COMPLETING;
                    break;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void completed(Throwable failure) {
        AsyncContextEvent event;
        List<AsyncListener> aListeners;
        boolean handle = false;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("completed {}", toStringLocked());
            }
            if (this._requestState != RequestState.COMPLETING) {
                throw new IllegalStateException(getStatusStringLocked());
            } else if (this._event == null) {
                this._requestState = RequestState.COMPLETED;
                aListeners = null;
                event = null;
                if (this._state == State.WAITING) {
                    this._state = State.WOKEN;
                    handle = true;
                }
            } else {
                aListeners = this._asyncListeners;
                event = this._event;
            }
        }
        this._channel.getResponse().getHttpOutput().completed(failure);
        if (event != null) {
            cancelTimeout(event);
            if (aListeners != null) {
                runInContext(event, () -> {
                    Iterator it = aListeners.iterator();
                    while (it.hasNext()) {
                        AsyncListener listener = (AsyncListener) it.next();
                        try {
                            listener.onComplete(event);
                        } catch (Throwable e) {
                            LOG.warn(e + " while invoking onComplete listener " + listener, new Object[0]);
                            LOG.debug(e);
                        }
                    }
                });
            }
            event.completed();
            synchronized (this) {
                this._requestState = RequestState.COMPLETED;
                if (this._state == State.WAITING) {
                    this._state = State.WOKEN;
                    handle = true;
                }
            }
        }
        if (handle) {
            this._channel.handle();
        }
    }

    /* access modifiers changed from: protected */
    public void recycle() {
        cancelTimeout();
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("recycle {}", toStringLocked());
            }
            switch (this._state) {
                case HANDLING:
                    throw new IllegalStateException(getStatusStringLocked());
                case UPGRADED:
                    return;
                default:
                    this._asyncListeners = null;
                    this._state = State.IDLE;
                    this._requestState = RequestState.BLOCKING;
                    this._outputState = OutputState.OPEN;
                    this._initial = true;
                    this._inputState = InputState.IDLE;
                    this._asyncWritePossible = false;
                    this._timeoutMs = DEFAULT_TIMEOUT;
                    this._event = null;
                    return;
            }
        }
    }

    public void upgrade() {
        cancelTimeout();
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("upgrade {}", toStringLocked());
            }
            switch (this._state) {
                case IDLE:
                    this._asyncListeners = null;
                    this._state = State.UPGRADED;
                    this._requestState = RequestState.BLOCKING;
                    this._initial = true;
                    this._inputState = InputState.IDLE;
                    this._asyncWritePossible = false;
                    this._timeoutMs = DEFAULT_TIMEOUT;
                    this._event = null;
                    break;
                default:
                    throw new IllegalStateException(getStatusStringLocked());
            }
        }
    }

    protected void scheduleDispatch() {
        this._channel.execute(this._channel);
    }

    protected void cancelTimeout() {
        AsyncContextEvent event;
        synchronized (this) {
            event = this._event;
        }
        cancelTimeout(event);
    }

    protected void cancelTimeout(AsyncContextEvent event) {
        if (event != null) {
            event.cancelTimeoutTask();
        }
    }

    public boolean isIdle() {
        boolean z;
        synchronized (this) {
            z = this._state == State.IDLE;
        }
        return z;
    }

    public boolean isExpired() {
        boolean z;
        synchronized (this) {
            z = this._requestState == RequestState.EXPIRE || this._requestState == RequestState.EXPIRING;
        }
        return z;
    }

    public boolean isInitial() {
        boolean z;
        synchronized (this) {
            z = this._initial;
        }
        return z;
    }

    public boolean isSuspended() {
        boolean z;
        synchronized (this) {
            z = this._state == State.WAITING || (this._state == State.HANDLING && this._requestState == RequestState.ASYNC);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean isCompleted() {
        boolean z;
        synchronized (this) {
            z = this._requestState == RequestState.COMPLETED;
        }
        return z;
    }

    public boolean isAsyncStarted() {
        synchronized (this) {
            if (this._state == State.HANDLING) {
                return this._requestState != RequestState.BLOCKING;
            }
            return this._requestState == RequestState.ASYNC || this._requestState == RequestState.EXPIRING;
        }
    }

    public boolean isAsync() {
        boolean z;
        synchronized (this) {
            z = !this._initial || this._requestState != RequestState.BLOCKING;
        }
        return z;
    }

    public Request getBaseRequest() {
        return this._channel.getRequest();
    }

    public HttpChannel getHttpChannel() {
        return this._channel;
    }

    public ContextHandler getContextHandler() {
        AsyncContextEvent event;
        synchronized (this) {
            event = this._event;
        }
        return getContextHandler(event);
    }

    ContextHandler getContextHandler(AsyncContextEvent event) {
        ContextHandler.Context context;
        if (event == null || (context = (ContextHandler.Context) event.getServletContext()) == null) {
            return null;
        }
        return context.getContextHandler();
    }

    public ServletResponse getServletResponse() {
        AsyncContextEvent event;
        synchronized (this) {
            event = this._event;
        }
        return getServletResponse(event);
    }

    public ServletResponse getServletResponse(AsyncContextEvent event) {
        if (event == null || event.getSuppliedResponse() == null) {
            return this._channel.getResponse();
        }
        return event.getSuppliedResponse();
    }

    void runInContext(AsyncContextEvent event, Runnable runnable) {
        ContextHandler contextHandler = getContextHandler(event);
        if (contextHandler == null) {
            runnable.run();
        } else {
            contextHandler.handle(this._channel.getRequest(), runnable);
        }
    }

    public Object getAttribute(String name) {
        return this._channel.getRequest().getAttribute(name);
    }

    public void removeAttribute(String name) {
        this._channel.getRequest().removeAttribute(name);
    }

    public void setAttribute(String name, Object attribute) {
        this._channel.getRequest().setAttribute(name, attribute);
    }

    public void onReadUnready() {
        boolean interested = false;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("onReadUnready {}", toStringLocked());
            }
            switch (this._inputState) {
                case READY:
                case IDLE:
                    if (this._state != State.WAITING) {
                        this._inputState = InputState.REGISTER;
                        break;
                    } else {
                        interested = true;
                        this._inputState = InputState.REGISTERED;
                        break;
                    }
            }
        }
        if (interested) {
            this._channel.onAsyncWaitForContent();
        }
    }

    public boolean onContentAdded() {
        boolean woken = false;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("onContentAdded {}", toStringLocked());
            }
            switch (this._inputState) {
                case POSSIBLE:
                    throw new IllegalStateException(toStringLocked());
                case REGISTER:
                case REGISTERED:
                    this._inputState = InputState.READY;
                    if (this._state == State.WAITING) {
                        woken = true;
                        this._state = State.WOKEN;
                        break;
                    }
                    break;
                case PRODUCING:
                    this._inputState = InputState.READY;
                    break;
            }
        }
        return woken;
    }

    public boolean onReadReady() {
        boolean woken = false;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("onReadReady {}", toStringLocked());
            }
            switch (this._inputState) {
                case IDLE:
                    this._inputState = InputState.READY;
                    if (this._state == State.WAITING) {
                        woken = true;
                        this._state = State.WOKEN;
                    }
                    break;
                default:
                    throw new IllegalStateException(toStringLocked());
            }
        }
        return woken;
    }

    public boolean onReadPossible() {
        boolean woken = false;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("onReadPossible {}", toStringLocked());
            }
            switch (this._inputState) {
                case REGISTERED:
                    this._inputState = InputState.POSSIBLE;
                    if (this._state == State.WAITING) {
                        woken = true;
                        this._state = State.WOKEN;
                    }
                    break;
                default:
                    throw new IllegalStateException(toStringLocked());
            }
        }
        return woken;
    }

    public boolean onReadEof() {
        boolean woken = false;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("onEof {}", toStringLocked());
            }
            this._inputState = InputState.READY;
            if (this._state == State.WAITING) {
                woken = true;
                this._state = State.WOKEN;
            }
        }
        return woken;
    }

    public boolean onWritePossible() {
        boolean wake = false;
        synchronized (this) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("onWritePossible {}", toStringLocked());
            }
            this._asyncWritePossible = true;
            if (this._state == State.WAITING) {
                this._state = State.WOKEN;
                wake = true;
            }
        }
        return wake;
    }
}
