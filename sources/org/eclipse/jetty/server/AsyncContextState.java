package org.eclipse.jetty.server;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.eclipse.jetty.server.handler.ContextHandler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AsyncContextState.class */
public class AsyncContextState implements AsyncContext {
    private final HttpChannel _channel;
    volatile HttpChannelState _state;

    public AsyncContextState(HttpChannelState state) {
        this._state = state;
        this._channel = this._state.getHttpChannel();
    }

    public HttpChannel getHttpChannel() {
        return this._channel;
    }

    HttpChannelState state() {
        HttpChannelState state = this._state;
        if (state != null) {
            return state;
        }
        throw new IllegalStateException("AsyncContext completed and/or Request lifecycle recycled");
    }

    @Override // javax.servlet.AsyncContext
    public void addListener(AsyncListener listener, ServletRequest request, ServletResponse response) {
        state().addListener(new WrappedAsyncListener(listener, request, response));
    }

    @Override // javax.servlet.AsyncContext
    public void addListener(AsyncListener listener) {
        state().addListener(listener);
    }

    @Override // javax.servlet.AsyncContext
    public void complete() {
        state().complete();
    }

    @Override // javax.servlet.AsyncContext
    public <T extends AsyncListener> T createListener(Class<T> clazz) throws ServletException {
        ContextHandler contextHandler = state().getContextHandler();
        if (contextHandler != null) {
            return (T) ((AsyncListener) contextHandler.getServletContext().createListener(clazz));
        }
        try {
            return clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override // javax.servlet.AsyncContext
    public void dispatch() {
        state().dispatch(null, null);
    }

    @Override // javax.servlet.AsyncContext
    public void dispatch(String path) {
        state().dispatch(null, path);
    }

    @Override // javax.servlet.AsyncContext
    public void dispatch(ServletContext context, String path) {
        state().dispatch(context, path);
    }

    @Override // javax.servlet.AsyncContext
    public ServletRequest getRequest() {
        return state().getAsyncContextEvent().getSuppliedRequest();
    }

    @Override // javax.servlet.AsyncContext
    public ServletResponse getResponse() {
        return state().getAsyncContextEvent().getSuppliedResponse();
    }

    @Override // javax.servlet.AsyncContext
    public long getTimeout() {
        return state().getTimeout();
    }

    @Override // javax.servlet.AsyncContext
    public boolean hasOriginalRequestAndResponse() {
        HttpChannel channel = state().getHttpChannel();
        return channel.getRequest() == getRequest() && channel.getResponse() == getResponse();
    }

    @Override // javax.servlet.AsyncContext
    public void setTimeout(long arg0) {
        state().setTimeout(arg0);
    }

    @Override // javax.servlet.AsyncContext
    public void start(final Runnable task) {
        final HttpChannel channel = state().getHttpChannel();
        channel.execute(new Runnable() { // from class: org.eclipse.jetty.server.AsyncContextState.1
            @Override // java.lang.Runnable
            public void run() {
                ContextHandler.Context context = AsyncContextState.this.state().getAsyncContextEvent().getContext();
                if (context == null) {
                    task.run();
                } else {
                    context.getContextHandler().handle(channel.getRequest(), task);
                }
            }
        });
    }

    public void reset() {
        this._state = null;
    }

    public HttpChannelState getHttpChannelState() {
        return state();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/AsyncContextState$WrappedAsyncListener.class */
    public static class WrappedAsyncListener implements AsyncListener {
        private final AsyncListener _listener;
        private final ServletRequest _request;
        private final ServletResponse _response;

        public WrappedAsyncListener(AsyncListener listener, ServletRequest request, ServletResponse response) {
            this._listener = listener;
            this._request = request;
            this._response = response;
        }

        public AsyncListener getListener() {
            return this._listener;
        }

        @Override // javax.servlet.AsyncListener
        public void onTimeout(AsyncEvent event) throws IOException {
            this._listener.onTimeout(new AsyncEvent(event.getAsyncContext(), this._request, this._response, event.getThrowable()));
        }

        @Override // javax.servlet.AsyncListener
        public void onStartAsync(AsyncEvent event) throws IOException {
            this._listener.onStartAsync(new AsyncEvent(event.getAsyncContext(), this._request, this._response, event.getThrowable()));
        }

        @Override // javax.servlet.AsyncListener
        public void onError(AsyncEvent event) throws IOException {
            this._listener.onError(new AsyncEvent(event.getAsyncContext(), this._request, this._response, event.getThrowable()));
        }

        @Override // javax.servlet.AsyncListener
        public void onComplete(AsyncEvent event) throws IOException {
            this._listener.onComplete(new AsyncEvent(event.getAsyncContext(), this._request, this._response, event.getThrowable()));
        }
    }
}
