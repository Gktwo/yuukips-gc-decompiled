package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/AsyncDelayHandler.class */
public class AsyncDelayHandler extends HandlerWrapper {
    public static final String AHW_ATTR = "o.e.j.s.h.AsyncHandlerWrapper";

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (isStarted() && this._handler != null) {
            DispatcherType ctype = baseRequest.getDispatcherType();
            DispatcherType dtype = (DispatcherType) baseRequest.getAttribute(AHW_ATTR);
            Object asyncContextPath = null;
            Object asyncPathInfo = null;
            Object asyncQueryString = null;
            Object asyncRequestUri = null;
            Object asyncServletPath = null;
            boolean restart = false;
            if (dtype != null) {
                baseRequest.setAttribute(AHW_ATTR, null);
                baseRequest.setDispatcherType(dtype);
                restart = true;
                asyncContextPath = baseRequest.getAttribute(AsyncContext.ASYNC_CONTEXT_PATH);
                baseRequest.setAttribute(AsyncContext.ASYNC_CONTEXT_PATH, null);
                asyncPathInfo = baseRequest.getAttribute(AsyncContext.ASYNC_PATH_INFO);
                baseRequest.setAttribute(AsyncContext.ASYNC_PATH_INFO, null);
                asyncQueryString = baseRequest.getAttribute(AsyncContext.ASYNC_QUERY_STRING);
                baseRequest.setAttribute(AsyncContext.ASYNC_QUERY_STRING, null);
                asyncRequestUri = baseRequest.getAttribute(AsyncContext.ASYNC_REQUEST_URI);
                baseRequest.setAttribute(AsyncContext.ASYNC_REQUEST_URI, null);
                asyncServletPath = baseRequest.getAttribute(AsyncContext.ASYNC_SERVLET_PATH);
                baseRequest.setAttribute(AsyncContext.ASYNC_SERVLET_PATH, null);
            }
            if (!startHandling(baseRequest, restart)) {
                AsyncContext context = baseRequest.startAsync();
                baseRequest.setAttribute(AHW_ATTR, ctype);
                delayHandling(baseRequest, context);
                return;
            }
            try {
                this._handler.handle(target, baseRequest, request, response);
                if (restart) {
                    baseRequest.setDispatcherType(ctype);
                    baseRequest.setAttribute(AsyncContext.ASYNC_CONTEXT_PATH, asyncContextPath);
                    baseRequest.setAttribute(AsyncContext.ASYNC_PATH_INFO, asyncPathInfo);
                    baseRequest.setAttribute(AsyncContext.ASYNC_QUERY_STRING, asyncQueryString);
                    baseRequest.setAttribute(AsyncContext.ASYNC_REQUEST_URI, asyncRequestUri);
                    baseRequest.setAttribute(AsyncContext.ASYNC_SERVLET_PATH, asyncServletPath);
                }
                endHandling(baseRequest);
            } catch (Throwable th) {
                if (restart) {
                    baseRequest.setDispatcherType(ctype);
                    baseRequest.setAttribute(AsyncContext.ASYNC_CONTEXT_PATH, asyncContextPath);
                    baseRequest.setAttribute(AsyncContext.ASYNC_PATH_INFO, asyncPathInfo);
                    baseRequest.setAttribute(AsyncContext.ASYNC_QUERY_STRING, asyncQueryString);
                    baseRequest.setAttribute(AsyncContext.ASYNC_REQUEST_URI, asyncRequestUri);
                    baseRequest.setAttribute(AsyncContext.ASYNC_SERVLET_PATH, asyncServletPath);
                }
                endHandling(baseRequest);
                throw th;
            }
        }
    }

    protected boolean startHandling(Request request, boolean restart) {
        return true;
    }

    protected void delayHandling(Request request, AsyncContext context) {
        context.dispatch();
    }

    protected void endHandling(Request request) {
    }
}
