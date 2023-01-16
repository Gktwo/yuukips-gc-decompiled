package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.Request;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/IdleTimeoutHandler.class */
public class IdleTimeoutHandler extends HandlerWrapper {
    private long _idleTimeoutMs = 1000;
    private boolean _applyToAsync = false;

    public boolean isApplyToAsync() {
        return this._applyToAsync;
    }

    public void setApplyToAsync(boolean applyToAsync) {
        this._applyToAsync = applyToAsync;
    }

    public long getIdleTimeoutMs() {
        return this._idleTimeoutMs;
    }

    public void setIdleTimeoutMs(long idleTimeoutMs) {
        this._idleTimeoutMs = idleTimeoutMs;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final HttpChannel channel = baseRequest.getHttpChannel();
        final long idle_timeout = baseRequest.getHttpChannel().getIdleTimeout();
        channel.setIdleTimeout(this._idleTimeoutMs);
        try {
            handle(target, baseRequest, request, response);
            if (!this._applyToAsync || !request.isAsyncStarted()) {
                channel.setIdleTimeout(idle_timeout);
            } else {
                request.getAsyncContext().addListener(new AsyncListener() { // from class: org.eclipse.jetty.server.handler.IdleTimeoutHandler.1
                    @Override // javax.servlet.AsyncListener
                    public void onTimeout(AsyncEvent event) throws IOException {
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onStartAsync(AsyncEvent event) throws IOException {
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onError(AsyncEvent event) throws IOException {
                        channel.setIdleTimeout(idle_timeout);
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onComplete(AsyncEvent event) throws IOException {
                        channel.setIdleTimeout(idle_timeout);
                    }
                });
            }
        } catch (Throwable th) {
            if (!this._applyToAsync || !request.isAsyncStarted()) {
                channel.setIdleTimeout(idle_timeout);
            } else {
                request.getAsyncContext().addListener(new AsyncListener() { // from class: org.eclipse.jetty.server.handler.IdleTimeoutHandler.1
                    @Override // javax.servlet.AsyncListener
                    public void onTimeout(AsyncEvent event) throws IOException {
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onStartAsync(AsyncEvent event) throws IOException {
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onError(AsyncEvent event) throws IOException {
                        channel.setIdleTimeout(idle_timeout);
                    }

                    @Override // javax.servlet.AsyncListener
                    public void onComplete(AsyncEvent event) throws IOException {
                        channel.setIdleTimeout(idle_timeout);
                    }
                });
            }
            throw th;
        }
    }
}
