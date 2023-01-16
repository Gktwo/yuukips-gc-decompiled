package org.eclipse.jetty.websocket.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.pathmap.MatchedResource;
import org.eclipse.jetty.http.pathmap.PathSpec;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.MappedByteBufferPool;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/WebSocketUpgradeHandlerWrapper.class */
public class WebSocketUpgradeHandlerWrapper extends HandlerWrapper implements MappedWebSocketCreator {
    private NativeWebSocketConfiguration configuration;

    public WebSocketUpgradeHandlerWrapper(ServletContextHandler context) {
        this(context, new MappedByteBufferPool());
    }

    public WebSocketUpgradeHandlerWrapper(ServletContextHandler context, ByteBufferPool bufferPool) {
        this.configuration = new NativeWebSocketConfiguration(new WebSocketServerFactory(context.getServletContext(), bufferPool));
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public void addMapping(PathSpec spec, WebSocketCreator creator) {
        this.configuration.addMapping(spec, creator);
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    @Deprecated
    public void addMapping(org.eclipse.jetty.websocket.server.pathmap.PathSpec spec, WebSocketCreator creator) {
        this.configuration.addMapping(spec, creator);
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public void addMapping(String spec, WebSocketCreator creator) {
        this.configuration.addMapping(spec, creator);
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public boolean removeMapping(String spec) {
        return this.configuration.removeMapping(spec);
    }

    @Override // org.eclipse.jetty.websocket.server.MappedWebSocketCreator
    public WebSocketCreator getMapping(String target) {
        return this.configuration.getMapping(target);
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (this.configuration.getFactory().isUpgradeRequest(request, response)) {
            MatchedResource<WebSocketCreator> resource = this.configuration.getMatched(target);
            if (resource == null) {
                response.sendError(404, "No websocket endpoint matching path: " + target);
                return;
            }
            WebSocketCreator creator = resource.getResource();
            request.setAttribute(PathSpec.class.getName(), resource);
            if (this.configuration.getFactory().acceptWebSocket(creator, request, response) || response.isCommitted()) {
                return;
            }
        }
        handle(target, baseRequest, request, response);
    }
}
