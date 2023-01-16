package org.eclipse.jetty.websocket.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.MappedByteBufferPool;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.websocket.api.WebSocketBehavior;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/WebSocketHandler.class */
public abstract class WebSocketHandler extends HandlerWrapper {
    private final ByteBufferPool bufferPool;
    private WebSocketServletFactory webSocketFactory;

    public abstract void configure(WebSocketServletFactory webSocketServletFactory);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/WebSocketHandler$Simple.class */
    public static class Simple extends WebSocketHandler {
        private Class<?> websocketPojo;

        public Simple(Class<?> websocketClass) {
            this.websocketPojo = websocketClass;
        }

        @Override // org.eclipse.jetty.websocket.server.WebSocketHandler
        public void configure(WebSocketServletFactory factory) {
            factory.register(this.websocketPojo);
        }
    }

    public WebSocketHandler() {
        this(new MappedByteBufferPool());
    }

    public WebSocketHandler(ByteBufferPool bufferPool) {
        this.bufferPool = bufferPool;
    }

    public void configurePolicy(WebSocketPolicy policy) {
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
        configurePolicy(policy);
        this.webSocketFactory = new WebSocketServerFactory(policy, getServer().getThreadPool(), this.bufferPool);
        addBean(this.webSocketFactory);
        configure(this.webSocketFactory);
        doStart();
    }

    public WebSocketServletFactory getWebSocketFactory() {
        if (isRunning()) {
            return this.webSocketFactory;
        }
        throw new IllegalStateException("Not Started yet");
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (this.webSocketFactory.isUpgradeRequest(request, response)) {
            if (this.webSocketFactory.acceptWebSocket(request, response)) {
                baseRequest.setHandled(true);
                return;
            } else if (response.isCommitted()) {
                return;
            }
        }
        handle(target, baseRequest, request, response);
    }
}
