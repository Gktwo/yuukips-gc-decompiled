package org.eclipse.jetty.websocket.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.websocket.api.WebSocketBehavior;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.quartz.utils.C3p0PoolingConnectionProvider;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/servlet/WebSocketServlet.class */
public abstract class WebSocketServlet extends HttpServlet {
    private WebSocketServletFactory factory;

    public abstract void configure(WebSocketServletFactory webSocketServletFactory);

    @Override // javax.servlet.GenericServlet, javax.servlet.Servlet
    public void destroy() {
        try {
            getServletContext().removeAttribute(WebSocketServletFactory.class.getName());
            this.factory.stop();
            this.factory = null;
        } catch (Exception e) {
        }
    }

    @Override // javax.servlet.GenericServlet
    public void init() throws ServletException {
        try {
            WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
            String max = getInitParameter(C3p0PoolingConnectionProvider.DB_DISCARD_IDLE_CONNECTIONS_SECONDS);
            if (max != null) {
                policy.setIdleTimeout(Long.parseLong(max));
            }
            String max2 = getInitParameter("maxTextMessageSize");
            if (max2 != null) {
                policy.setMaxTextMessageSize(Integer.parseInt(max2));
            }
            String max3 = getInitParameter("maxBinaryMessageSize");
            if (max3 != null) {
                policy.setMaxBinaryMessageSize(Integer.parseInt(max3));
            }
            String max4 = getInitParameter("inputBufferSize");
            if (max4 != null) {
                policy.setInputBufferSize(Integer.parseInt(max4));
            }
            ServletContext ctx = getServletContext();
            this.factory = WebSocketServletFactory.Loader.load(ctx, policy);
            configure(this.factory);
            this.factory.start();
            ctx.setAttribute(WebSocketServletFactory.class.getName(), this.factory);
        } catch (Exception x) {
            throw new ServletException(x);
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.servlet.http.HttpServlet
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!this.factory.isUpgradeRequest(request, response) || (!this.factory.acceptWebSocket(request, response) && !response.isCommitted())) {
            service(request, response);
        }
    }
}
